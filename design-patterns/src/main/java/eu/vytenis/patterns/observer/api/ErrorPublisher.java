package eu.vytenis.patterns.observer.api;

import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;

public class ErrorPublisher {
    protected List<ErrorListener> errorListeners = new ArrayList<>();

    public void addErrorListener(ErrorListener listener) {
        errorListeners.add(listener);
    }

    public void removeErrorListener(ErrorListener listener) {
        errorListeners.remove(listener);
    }

    protected void notifyErrorListeners(TransformerException e) {
        for (ErrorListener l : errorListeners) {
            l.error(e);
        }
    }
}
