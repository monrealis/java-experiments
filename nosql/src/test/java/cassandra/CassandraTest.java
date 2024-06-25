package cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CassandraTest {
    private Cluster cluster;
    private Session session;

    @Before
    public void before() {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("demo");
    }

    @After
    public void after() {
        cluster.close();
    }

    @Test
    @Ignore
    public void executeAndPrintResult() {
        execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");
        printResults("SELECT * FROM users WHERE lastname='Jones'");
        execute("update users set age = 36 where lastname = 'Jones'");
        printResults("SELECT * FROM users WHERE lastname='Jones'");
        execute("DELETE FROM users WHERE lastname = 'Jones'");
        printResults("SELECT * FROM users");
    }

    private void printResults(String query) {
        for (Row row : execute(query))
            System.out.format("%s %d %s %s %s\n", row.getString("lastname"), row.getInt("age"), row.getString("city"),
                    row.getString("email"), row.getString("firstname"));
    }

    private ResultSet execute(String query) {
        return session.execute(query);
    }
}
