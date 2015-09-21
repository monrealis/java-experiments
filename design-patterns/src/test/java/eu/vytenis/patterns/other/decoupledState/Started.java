package eu.vytenis.patterns.other.decoupledState;

public class Started extends State {
    @Override
    public void start(StateMachine machine) {

    }

    @Override
    public void stop(StateMachine machine) {
        machine.setState(new Stopped());
    }
}
