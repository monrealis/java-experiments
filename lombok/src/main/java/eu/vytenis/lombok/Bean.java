package eu.vytenis.lombok;

import lombok.Getter;
import lombok.val;
import lombok.Setter;
import lombok.experimental.Accessors;

public class Bean {
    @Getter
    @Setter
    @Accessors(prefix = "f")
    private String fProperty;

    int x() {
        val x = 10;
        return x;
    }
}
