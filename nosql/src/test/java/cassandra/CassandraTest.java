package cassandra;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.junit.Ignore;
import org.junit.Test;

public class CassandraTest {
    @Test
    @Ignore
    public void run() {
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect("demo");
        session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");
        ResultSet results = session.execute("SELECT * FROM users WHERE lastname='Jones'");
        for (Row row : results) {
            System.out.format("%s %d\n", row.getString("firstname"), row.getInt("age"));
        }
        session.execute("update users set age = 36 where lastname = 'Jones'");
        results = session.execute("select * from users where lastname='Jones'");
        for (Row row : results) {
            System.out.format("%s %d\n", row.getString("firstname"), row.getInt("age"));

        }
        session.execute("DELETE FROM users WHERE lastname = 'Jones'");
        results = session.execute("SELECT * FROM users");
        for (Row row : results) {
            System.out.format("%s %d %s %s %s\n", row.getString("lastname"), row.getInt("age"), row.getString("city"), row.getString("email"), row.getString("firstname"));
        }
    }
}
