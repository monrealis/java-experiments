package eu.vytenis.patterns.behavioral.chain.languages;

import eu.vytenis.patterns.behavioral.chain.api.Translator;

public class FrenchTranslator extends Translator {
    public FrenchTranslator(Translator next) {
        super(next);
    }

    @Override
    public String translate(String word) {
        if (word.equals("aš"))
            return "je";
        return super.translate(word);
    }
}
