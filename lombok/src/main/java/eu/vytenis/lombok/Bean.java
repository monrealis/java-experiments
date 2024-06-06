package eu.vytenis.lombok;

import lombok.Getter;
import lombok.val;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import lombok.*;
import lombok.experimental.Accessors;

@Builder
@AllArgsConstructor
@Data
public class Bean {
    @Getter
    @Setter
    @Accessors(prefix = "f")
    private String fProperty;

    int x() {
        val x = 10;
        return x;
    }

    void cleanup() throws IOException {
        @Cleanup
        FileInputStream fis = new FileInputStream(new File(""));
    }
}
