package java7;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class ExceptionsTest {
    private final IOException ioException = new IOException();
    private final SQLException sqlException = new SQLException();
    private Exception thrownException;
    private Exception caughtException;

    @Test
    public void IfNoExceptionThrown_noneCaught() {
        throwAndCatchIfNecessary();
        assertNull(caughtException);
    }

    @Test
    public void ifIoExceptionThrown_sameExceptionCaught() {
        thrownException = ioException;
        throwAndCatchIfNecessary();
        assertSame(ioException, caughtException);
    }

    @Test
    public void ifSqlExceptionThrown_sameExceptionCaught() {
        thrownException = sqlException;
        throwAndCatchIfNecessary();
        assertSame(sqlException, caughtException);
    }

    public void throwAndCatchIfNecessary() {
        try {
            throwIfNecessary();
        } catch (SQLException | IOException e) {
            caughtException = e;
        }
    }

    public void throwIfNecessary() throws SQLException, IOException {
        if (thrownException == ioException) {
            throw ioException;
        } else if (thrownException == sqlException) {
            throw sqlException;
        }
    }
}
