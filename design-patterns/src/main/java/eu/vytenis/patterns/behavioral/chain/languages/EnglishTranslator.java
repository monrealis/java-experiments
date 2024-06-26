package eu.vytenis.patterns.behavioral.chain.languages;

import eu.vytenis.patterns.behavioral.chain.api.Translator;

public class EnglishTranslator extends Translator {
    public EnglishTranslator(Translator next) {
        super(next);
    }

    @Override
    public String translate(String word) {
        if (word.equals("hello"))
            return "labas";
        return super.translate(word);
    }
}
