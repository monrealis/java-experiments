package eu.vytenis.patterns.state.api;

public interface State<T> {
    T invite();

    T decline();

    T accept();
}
