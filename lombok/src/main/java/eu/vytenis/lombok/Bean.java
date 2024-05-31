package eu.vytenis.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class Bean {
    @Getter
    @Setter
    @Accessors(fluent = false)
    private String property;
}
