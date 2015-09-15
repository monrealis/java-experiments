package eu.vytenis.patterns.other.acyclicVisitor;

public enum WebServiceType {
    Restful {
        @Override
        void accept(WebServiceTypeVisitor v) {

        }
    }, Soap {
        @Override
        void accept(WebServiceTypeVisitor v) {

        }
    };

    abstract void accept(WebServiceTypeVisitor v);
}
