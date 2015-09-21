package eu.vytenis.patterns.other.decoupledState;

public class Stopped extends State {
    @Override
    public void start(StateMachine machine) {
        machine.setState(new Started());
    }

    @Override
    public void stop(StateMachine machine) {

    }
}
