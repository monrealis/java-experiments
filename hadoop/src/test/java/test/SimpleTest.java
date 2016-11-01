package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class SimpleTest {
    @Test
    @Ignore
    public void run() throws IOException {
        Configuration c = new Configuration();
        FileSystem fs = FileSystem.get(c);
        Path p = new Path("");
        fs.open(p);
    }
}
