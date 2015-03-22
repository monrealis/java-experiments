package eu.vytenis.patterns.behavioral.state.api;

public interface State<T> {
    T invite();

    T decline();

    T accept();
}
