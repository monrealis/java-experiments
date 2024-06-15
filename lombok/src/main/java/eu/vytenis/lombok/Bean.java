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

@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Getter
@Setter
@RequiredArgsConstructor
public class Bean {
    @Getter
    @Setter
    @Accessors(prefix = "f")
    private String fProperty;
    @Delegate
    private List<String> list;
    @Singular
    private List<Object> lists;

    @SneakyThrows
    @Synchronized
    int x() {
        val x = 10;
        new String(new byte[] {}, "UTF-8");
        return x;
    }

    void cleanup() throws IOException {
        @Cleanup
        FileInputStream fis = new FileInputStream(new File(""));
    }

    void f(@NonNull Integer x) {

    }
}
