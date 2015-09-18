package eu.vytenis.patterns.other.acyclicVisitor;

import org.junit.Test;

public class WebServiceTypeTest implements RestVisitor, SoapVisitor, WebServiceTypeVisitor {
    @Test
    public void run() {
        accept(new Restful());
    }

    @Test
    public void run1() {
        accept(new Soap());
    }

    private void accept(WebServiceType type) {
        type.accept(this);
    }
}
