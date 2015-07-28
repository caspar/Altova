package com.altova.util;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class IOUtilsTest extends RegressionAssert {

	@Test
	public final void testReadFileListsString() {
		fail("Not yet implemented");
	}

	@Test
	public final void testReadFileListsURL() {
		fail("Not yet implemented");
	}

	@Test
	public final void testFindResource() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetSubDirs() {
		fail("Not yet implemented");
	}

	@Test
	public final void testDeleteAll() throws IOException {
		File dir1 = new File("C:\\temp\\all");
		File dir2 = new File(dir1, "sub");
		File file1 = new File(dir1, "file1.tst");
		File file2 = new File(dir2, "file2.tst");
		dir2.mkdirs();
		file1.createNewFile();
		file2.createNewFile();
		
		assertFileExists(file2);
		IOUtils.deleteAll(dir1);
		assertFileNotExists(dir1);
	}

	@Test
	public final void testGetStackTrace() {
		fail("Not yet implemented");
	}

}
