package eu.vytenis.patterns.other.acyclicVisitor;

public class Soap implements WebServiceType {
    @Override
    public void accept(WebServiceTypeVisitor v) {
        ((SoapVisitor) v).visit(this);
    }
}
