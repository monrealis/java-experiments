package jackson;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlTest {
    private ObjectMapper json = new ObjectMapper();
    private ObjectMapper yaml = new ObjectMapper(new YAMLFactory());

    @Test
    public void run() throws IOException {
        System.out.println(json());
        System.out.println(yaml());
        Object o = yaml.readValue(yaml(), Object.class);
        System.out.println(o);
    }

    private String json() throws JsonProcessingException {
        return json.writeValueAsString(new Dto());
    }

    private String yaml() throws JsonProcessingException {
        return yaml.writeValueAsString(new Dto());
    }

    @SuppressWarnings({"unused", "unchecked"})
    private static class Dto {
        public int a = 5;
        public String b = "bbb";
        public List<?> c = asList("one", 5, 5.2);
    }
}
