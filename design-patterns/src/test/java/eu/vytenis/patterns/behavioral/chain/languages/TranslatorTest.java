package eu.vytenis.patterns.behavioral.chain.languages;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.vytenis.patterns.behavioral.chain.api.NullTranslator;
import eu.vytenis.patterns.behavioral.chain.api.Translator;

public class TranslatorTest {
    private Translator translator = new EnglishTranslator(
            new ItalianTranslator(new FrenchTranslator(new GermanTranslator(new NullTranslator()))));

    @Test
    public void shouldTranslateWordsOfVariousLanguages() {
        assertEquals("<unknown>", translator.translate("x"));
        assertEquals("labas", translator.translate("hello"));
        assertEquals("tu", translator.translate("du"));
        assertEquals("io", translator.translate("I"));
        assertEquals("je", translator.translate("aš"));
    }
}
