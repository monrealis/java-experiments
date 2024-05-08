package java7.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipError;
import java.util.zip.ZipOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
public class ZipTest {
	private Path temp;
	private List<Path> deleteAfterTest = new ArrayList<>();
	private Map<String, String> env = new HashMap<>();
	private FileSystem fileSystem;

	@Before
	public void before() throws IOException {
		temp = createEmptyZip();
		fileSystem = createZipFileSystem();
	}

	private FileSystem createZipFileSystem() throws IOException {
		URI uri = URI.create("jar:file:" + temp);
		return createZipFileSystem(uri);
	}

	private FileSystem createZipFileSystem(URI uri) throws IOException {
		return FileSystems.newFileSystem(uri, env, null);
	}

	private Path createEmptyZip() throws IOException {
		Path f = Files.createTempFile("test", ".zip");
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f.toFile()));
		out.putNextEntry(new ZipEntry(""));
		out.closeEntry();
		out.close();
		return f;
	}

	@After
	public void after() {
		for (Path p : deleteAfterTest) {
			assertTrue(p.toFile().delete());
		}
	}

	@Test
	public void inNewZip_rootDirectoryExists() throws IOException {
		assertEquals("/", getRoot().toString());
	}

	private Path getRoot() {
		return fileSystem.getRootDirectories().iterator().next();
	}

	@Test
	public void fileGetsAdded() throws IOException {
		assertEmpty();
		Files.copy(new ByteArrayInputStream(new byte[] { 1 }), fileSystem.getPath("/test.txt"));
		assertEquals("/test.txt", list().get(0).toString());
	}

	private void assertEmpty() throws IOException {
		assertEquals(0, list().size());
	}

	@Test
	public void dirGetsAdded() throws IOException {
		assertEmpty();
		Files.createDirectory(fileSystem.getPath("/dir.txt"));
		assertEquals("/dir.txt/", list().get(0).toString());
	}

	private List<Path> list() throws IOException {
		try (DirectoryStream<Path> paths = Files.newDirectoryStream(getRoot())) {
			List<Path> r = new ArrayList<>();
			for (Path p : paths)
				r.add(p);
			return r;
		}
	}

	@Test
	public void ifZipFileIsMissing_newZipGetsCreated() throws IOException {
		temp = new File(temp.toString() + ".zip").toPath();
		deleteAfterTest.add(temp);
		env.put("create", "true");
		createZipFileSystem();
	}

	@Test(expected = ZipError.class)
	public void ifZipFileIsEmpty_newZipDoesNotGetCreated() throws IOException {
		fileSystem.close();
		Files.delete(temp);
		Files.createFile(temp);
		env.put("create", "true");
		createZipFileSystem();
	}
}
