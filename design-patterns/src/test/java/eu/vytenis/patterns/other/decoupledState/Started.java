package eu.vytenis.patterns.other.decoupledState;

public class Started extends State {
    public static Started started() {
        return new Started();
    }

    private Started() {
    }

    @Override
    public void start(StateMachine machine) {

    }

    @Override
    public void stop(StateMachine machine) {
        machine.setState(Stopped.stopped());
    }
}
