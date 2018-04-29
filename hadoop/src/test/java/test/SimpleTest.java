package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

//http://stackoverflow.com/questions/11342400/how-to-list-all-files-in-a-directory-and-its-subdirectories-in-hadoop-hdfs
public class SimpleTest {
    @Test
    public void run() throws IOException {
        Configuration c = new Configuration();
        c.set("fs.defaultFS", "hdfs://localhost:8020");
        FileSystem fs = FileSystem.get(c);
        RemoteIterator<LocatedFileStatus> it = fs.listFiles(new Path("/"), true);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
