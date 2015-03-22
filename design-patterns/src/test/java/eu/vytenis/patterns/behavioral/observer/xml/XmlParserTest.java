package eu.vytenis.patterns.behavioral.observer.xml;

import eu.vytenis.patterns.behavioral.observer.api.ErrorListener;
import eu.vytenis.patterns.behavioral.observer.api.ErrorPublisher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class XmlParserTest {
    public static final String VALID_XML = "<root />";
    public static final String INVALID_XML = "<root>";
    private String xml = VALID_XML;
    private ErrorListener l1 = mock(ErrorListener.class);
    private ErrorListener l2 = mock(ErrorListener.class);
    private List<ErrorListener> addListeners = new ArrayList<>(asList(l1, l2));
    private List<ErrorListener> removeListeners = new ArrayList<>();

    @Test
    public void withNoErrors_listenerNotNotified() {
        parse();
        verifyZeroInteractions(l1, l2);
    }

    @Test
    public void withErrors_listenersNotified() {
        xml = INVALID_XML;
        parse();
        verify(l1).error(any(Exception.class));
        verify(l2).error(any(Exception.class));
        verifyNoMoreInteractions(l1, l2);
    }

    @Test
    public void withErrorsAndListenerRemoved_listenerNotNotified() {
        xml = INVALID_XML;
        removeListeners.add(l2);
        parse();
        verify(l1).error(any(Exception.class));
        verifyNoMoreInteractions(l1, l2);
    }

    private void parse() {
        createParser().parse();
    }

    private XmlParser createParser() {
        XmlParser p = new XmlParser(xml);
        addListeners(p);
        removeListeners(p);
        return p;
    }

    private void addListeners(ErrorPublisher p) {
        for (ErrorListener l : addListeners) {
            p.addErrorListener(l);
        }
    }

    private void removeListeners(ErrorPublisher p) {
        for (ErrorListener l : removeListeners) {
            p.removeErrorListener(l);
        }
    }
}
