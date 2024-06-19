package eu.vytenis.lombok;

import lombok.Getter;
import lombok.val;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;

@EqualsAndHashCode
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Data
public class Bean {
    @Getter
    @Accessors(prefix = "f")
    private String fProperty;
    @Delegate
    private List<String> list;
    @Singular
    private List<Object> lists;

    @SneakyThrows
    @Synchronized
    int throwSneaky() {
        val x = 10;
        new String(new byte[] {}, "U-8");
        return x;
    }

    void cleanup() throws IOException {
        @Cleanup
        FileInputStream fis = new FileInputStream(new File(""));
    }

    void f(@NonNull Integer x) {

    }
}
