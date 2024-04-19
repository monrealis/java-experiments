package eu.vytenis.patterns.behavioral.chain.api;

public class NullTranslator extends Translator {
    public NullTranslator() {
        super(null);
    }

    @Override
    public String translate(String word) {
        return "<unknown>";
    }
}
