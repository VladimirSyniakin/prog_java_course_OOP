package com.gmail.vsyniakin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class CopyFileOperation {

	public static File[] searchFiles(File inputDirectory, String nameAfterPoint) {
		try {
			FilenameFilter fileNameFilter = new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith("." + nameAfterPoint);
				}
			};
			File[] arrayFileByName = inputDirectory.listFiles(fileNameFilter);
			return arrayFileByName;
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void checkDirectoryFile(File inputDirectory, File outputDirectory) {
		try {
			if ((inputDirectory == null) || (outputDirectory == null)) {
				throw new IllegalArgumentException("Null file pointer");
			}

			if ((!inputDirectory.exists()) && (!inputDirectory.isDirectory())) {
				throw new IllegalArgumentException("Incorrect input directory");
			}
			if ((!outputDirectory.exists()) && (!outputDirectory.isDirectory())) {
				if (!outputDirectory.mkdir()) {
					throw new IllegalArgumentException("Incorrect output directory");
				}
			}
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void copyFileIO(File inputDirectory, File outputDirectory, String nameAfterPoint)
			throws IOException {

		checkDirectoryFile(inputDirectory, outputDirectory);
		File[] arrayFileByName = searchFiles(inputDirectory, nameAfterPoint);

		for (int i = 0; i < arrayFileByName.length; i++) {
			File outputFile = new File(outputDirectory.getAbsolutePath(), arrayFileByName[i].getName());

			try (FileInputStream fis = new FileInputStream(arrayFileByName[i]);
					FileOutputStream fos = new FileOutputStream(outputFile)) {
				byte[] buffer = new byte[1024];
				int byteRead = 0;
				
				while ((byteRead = fis.read(buffer)) != -1) {
					fos.write(buffer);
				}
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void copyFileIOBuffered(File inputDirectory, File outputDirectory, String nameAfterPoint)
			throws IOException {

		checkDirectoryFile(inputDirectory, outputDirectory);
		File[] arrayFileByName = searchFiles(inputDirectory, nameAfterPoint);

		for (int i = 0; i < arrayFileByName.length; i++) {
			File outputFile = new File(outputDirectory.getAbsolutePath(), arrayFileByName[i].getName());

			try (BufferedInputStream bfInp = new BufferedInputStream(new FileInputStream(arrayFileByName[i]));
					BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(outputFile))) {
				int stream;
				while ((stream = bfInp.read()) != -1) {
					bfOut.write(stream);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
