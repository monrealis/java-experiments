package eu.vytenis.patterns.state.invitation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvitationTest {
    private Invitation invitation = new Invitation();

    @Test
    public void remainsNotInvited() {
        assertEquals(invitation.notInvited(), invitation.accept().accept().decline().accept().getState());
    }

    @Test
    public void endsUpAccepted() {
        assertEquals(invitation.accepted(), invitation.invite().accept().accept().getState());
    }

    @Test
    public void endsUpDeclined() {
        assertEquals(invitation.declined(), invitation.invite().accept().decline().getState());
    }

    @Test
    public void staysInvited() {
        assertEquals(invitation.invited(), invitation.invite().getState());
    }
}
