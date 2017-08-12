package com.gmail.vsyniakin.task4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile implements Runnable {
	
	private File file;
	private File outputDirectory;
		
	public CopyFile(File file, File outputDirectory, int index) {
		super();
		this.file = file;
		this.outputDirectory = outputDirectory;
	}
	@Override
	public void run() {
		File outputFile = new File(outputDirectory.getAbsolutePath(), file.getName());
		try (BufferedInputStream bfInp = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(outputFile))) {
			int stream;
			while ((stream = bfInp.read()) != -1) {
				bfOut.write(stream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
