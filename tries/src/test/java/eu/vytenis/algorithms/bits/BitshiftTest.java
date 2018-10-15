package eu.vytenis.algorithms.bits;

import org.junit.jupiter.api.Test;

public class BitshiftTest {

    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println((Integer.MAX_VALUE + 1) / 2 << 1);
        System.out.println(Integer.MAX_VALUE << 1);
        System.out.println(-1 >>> 1);
        System.out.println(-1 >> 1);

    }

}
