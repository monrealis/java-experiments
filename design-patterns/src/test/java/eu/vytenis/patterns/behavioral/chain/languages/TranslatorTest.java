package eu.vytenis.patterns.behavioral.chain.languages;

import eu.vytenis.patterns.behavioral.chain.api.Translator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslatorTest {
    private Translator translator = new EnglishTranslator().withNext(new GermanTranslator());

    @Test
    public void shouldTranslateEnglishAndGermanWords() {
        assertEquals("<unknown>", translator.translate("x"));
        assertEquals("labas", translator.translate("hello"));
        assertEquals("tu", translator.translate("du"));
    }
}
