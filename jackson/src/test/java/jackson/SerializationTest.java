package jackson;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void serialize() throws IOException {
        DTO dto = new DTO();
        DTO[] dtos = {dto};
        System.out.println(mapper.readValue(mapper.writeValueAsString(dto), Object.class));
        System.out.println(mapper.readValue(mapper.writeValueAsString(dtos), Object.class));
        System.out.println(mapper.convertValue(dto, Object.class));
        System.out.println(mapper.convertValue(dtos, Object.class));
    }

}

class DTO {
    public String field = "value";
}

class DTO2 {
}
