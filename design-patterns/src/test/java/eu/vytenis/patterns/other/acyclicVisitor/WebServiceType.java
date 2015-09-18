package eu.vytenis.patterns.other.acyclicVisitor;

public interface WebServiceType {
    void accept(WebServiceTypeVisitor v);
}
