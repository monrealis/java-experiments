package eu.vytenis.patterns.other.decoupledState;

public class StateMachine {
    private State state = Stopped.stopped();

    public void start() {
        state.start(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
