package eu.vytenis.patterns.behavioral.chain.languages;

import eu.vytenis.patterns.behavioral.chain.api.Translator;

public class ItalianTranslator extends Translator {
    public ItalianTranslator(Translator next) {
        super(next);
    }

    @Override
    public String translate(String word) {
        if (word.equals("I"))
            return "io";
        return super.translate(word);
    }
}
