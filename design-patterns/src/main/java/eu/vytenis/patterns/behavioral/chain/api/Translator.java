package eu.vytenis.patterns.behavioral.chain.api;

public abstract class Translator {
    private Translator next;

    public Translator(Translator next) {
        this.next = next;
    }

    public String translate(String word) {
        return next.translate(word);
    }

    public Translator withNext(Translator next) {
        this.next = next;
        return this;
    }
}
