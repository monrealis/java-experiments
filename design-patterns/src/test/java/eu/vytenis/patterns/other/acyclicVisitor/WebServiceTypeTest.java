package eu.vytenis.patterns.other.acyclicVisitor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WebServiceTypeTest implements RestfulVisitor, SoapVisitor, WebServiceTypeVisitor {
    private String actions = "";

    @Test
    public void restful() {
        accept(new Restful());
        assertEquals("R", actions);
    }

    @Test
    public void soap() {
        accept(new Soap());
        assertEquals("S", actions);
    }

    private void accept(WebServiceType type) {
        type.accept(this);
    }

    @Override
    public void visit(Restful rest) {
        actions += "R";
    }

    @Override
    public void visit(Soap soap) {
        actions += "S";
    }
}
