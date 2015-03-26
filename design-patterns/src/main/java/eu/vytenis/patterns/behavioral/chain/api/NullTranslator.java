package eu.vytenis.patterns.behavioral.chain.api;

public class NullTranslator extends Translator {
    @Override
    public String translate(String word) {
        return "<unknown>";
    }

    @Override
    protected NullTranslator createNext() {
        return this;
    }
}
