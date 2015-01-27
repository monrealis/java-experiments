package java7.io;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ZipTest {
    private Path temp;
    private Map<String, String> env = new HashMap<>();
    private FileSystem fileSystem;

    @Before
    public void before() throws IOException {
        temp = createEmptyZip();
        fileSystem = FileSystems.newFileSystem(URI.create("jar:file:" + temp), env, null);
    }

    private Path createEmptyZip() throws IOException {
        Path f = Files.createTempFile("test", ".zip");
        ZipOutputStream out = new ZipOutputStream(
                new FileOutputStream(f.toFile()));
        out.putNextEntry(new ZipEntry(""));
        out.closeEntry();
        out.close();
        return f;
    }

    @After
    public void after() {
        temp.toFile().delete();
    }

    @Test
    public void rootDirectoryExists() throws IOException {
        assertEquals("/", getRoot().toString());
    }

    private Path getRoot() {
        return fileSystem.getRootDirectories().iterator().next();
    }

    @Test
    public void fileGetsAdded() throws IOException {
        assertEmpty();
        Files.copy(new ByteArrayInputStream(new byte[]{1}), fileSystem.getPath("/test.txt"));
        assertEquals("/test.txt", list().findAny().get().toString());
    }

    private void assertEmpty() throws IOException {
        assertEquals(0, list().count());
    }

    @Test
    public void dirGetsCreated() throws IOException {
        assertEmpty();
        Files.createDirectory(fileSystem.getPath("/dir.txt"));
        assertEquals("/dir.txt/", list().findAny().get().toString());
    }

    private Stream<Path> list() throws IOException {
        return Files.list(getRoot());
    }
}
