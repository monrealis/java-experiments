package eu.vytenis.patterns.behavioral.chain.languages;

import eu.vytenis.patterns.behavioral.chain.api.Translator;

public class GermanTranslator extends Translator {
    @Override
    public String translate(String word) {
        if (word.equals("du"))
            return "tu";
        return super.translate(word);
    }
}
