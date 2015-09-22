package eu.vytenis.patterns.other.decoupledState;

public class Stopped extends State {
    public static Stopped stopped() {
        return new Stopped();
    }

    private Stopped() {
    }

    @Override
    public void start(StateMachine machine) {
        machine.setState(Started.started());
    }

    @Override
    public void stop(StateMachine machine) {

    }
}
