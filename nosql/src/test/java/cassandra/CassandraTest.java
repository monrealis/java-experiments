package cassandra;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.junit.Ignore;
import org.junit.Test;

public class CassandraTest {
    @Test
    @Ignore
    public void run() {
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect("demo");
    }
}
