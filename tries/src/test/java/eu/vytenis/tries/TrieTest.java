package eu.vytenis.tries;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TrieTest {
    private Set<String> hash = new HashSet<>();
    private Set<String> tree = new TreeSet<>();
    private Set<String> hashPrefixes = new HashSet<>();
    private Set<String> treePrefixes = new TreeSet<>();
    private List<String> words = loadWords();

    @Test
    public void measureSize() throws IOException {
        fill(words, hash);
        fill(words, tree);
        fillPrefixes(words, hashPrefixes);
        fillPrefixes(words, treePrefixes);

        printSerializedSize(hash);
        printSerializedSize(tree);
        printSerializedSize(hashPrefixes);
        printSerializedSize(treePrefixes);
    }

    private List<String> loadWords() {
        try {
            return Files.readAllLines(Paths.get("linux.words"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void buildTrie() throws IOException {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }
        root.addWord("");
        System.out.println(root.contains(""));
        System.out.println(root.containsTerminal(""));
        System.out.println(root.contains("book"));
        System.out.println(root.containsTerminal("book"));
        System.out.println(root.contains("boo"));
        System.out.println(root.containsTerminal("boo"));
        System.out.println(root.contains("booke"));
        System.out.println(root.containsTerminal("booke"));
        System.out.println(root.contains("bookeeeee"));
        System.out.println(root.containsTerminal("bookeeeee"));

    }

    private void printSerializedSize(Object o) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(o);
        System.out.println(bos.size() / 1024 / 1024);
    }

    private void fill(List<String> words, Set<String> set) {
        for (String word : words)
            set.add(word);
    }

    private void fillPrefixes(List<String> words, Set<String> set) {
        for (String word : words)
            for (int i = 1; i < word.length(); ++i)
                set.add(word.substring(0, i));
    }

    private static class TrieNode implements Serializable {
        private Map<Character, TrieNode> children;
        private boolean terminal;

        public TrieNode() {
        }

        public void addWord(String word) {
            if (word.equals("")) {
                terminal = true;
                return;
            }
            child(word.charAt(0)).addWord(word.substring(1));
        }

        private TrieNode child(char c) {
            if (children == null)
                children = new HashMap<>();
            TrieNode n = children.get(c);
            if (n == null) {
                n = new TrieNode();
                children.put(c, n);
            }
            return n;
        }

        private TrieNode existingChild(char c) {
            if (children == null)
                return null;
            return children.get(c);
        }

        public boolean containsTerminal(String word) {
            if (word.equals(""))
                return terminal;
            if (existingChild(word.charAt(0)) == null)
                return false;
            return existingChild(word.charAt(0)).containsTerminal(word.substring(1));
        }

        public boolean contains(String word) {
            if (word.equals(""))
                return true;
            if (existingChild(word.charAt(0)) == null)
                return false;
            return existingChild(word.charAt(0)).contains(word.substring(1));
        }
    }
}
