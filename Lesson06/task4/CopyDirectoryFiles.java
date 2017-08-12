package com.gmail.vsyniakin.task4;


import java.io.File;

public class CopyDirectoryFiles {
	private File[] arrayFiles;
	private File inputDirectory;
	private File outputDirectory;
	private int index;

	public CopyDirectoryFiles(File inputDirectory, File outputDirectory) {
		super();
		this.inputDirectory = inputDirectory;
		this.outputDirectory = outputDirectory;
	}

	public void multiCopy() {
		filesDirectoryArray();
		Thread[] thr = new Thread[arrayFiles.length];
		for (this.index = 0; index < arrayFiles.length; this.index++) {
			thr[index] = new Thread(new CopyFile(arrayFiles [index], outputDirectory, index));
			thr[index].start();
		}
	}

	private void filesDirectoryArray() {
		if ((!this.inputDirectory.exists()) && (!this.inputDirectory.isDirectory())) {
			throw new IllegalArgumentException("Incorrect input directory");
		}
		if ((!this.outputDirectory.exists()) || (!this.outputDirectory.isDirectory())) {
			if (!this.outputDirectory.mkdir()) {
				throw new IllegalArgumentException("Incorrect output directory");
			}
		}
		this.arrayFiles = inputDirectory.listFiles();
	}
}
