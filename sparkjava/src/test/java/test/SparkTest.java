package test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import static org.junit.Assert.assertEquals;

public class SparkTest {
    @BeforeClass
    public static void beforeClass() {
        Spark.port(8080);
        Spark.get("/hi", new Route() {
            public Object handle(Request request, Response response) {
                return "Hi from " + request.pathInfo();
            }
        });
    }

    @Test
    public void run() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(new HttpGet("http://localhost:8080/hi"));
        System.out.println(response.getStatusLine());
        System.out.println(EntityUtils.toString(response.getEntity()));
        assertEquals(200, response.getStatusLine().getStatusCode());
    }
}
