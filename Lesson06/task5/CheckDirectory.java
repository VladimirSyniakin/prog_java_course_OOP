package com.gmail.vsyniakin.task5;

import java.io.File;

public class CheckDirectory implements Runnable {

	private File directory;
	private String[] firstArray;
	private String[] secondArray;
	private Thread thr = new Thread();

	public CheckDirectory() {
		super();
	}

	public CheckDirectory(File directory) {
		super();
		this.directory = directory;
		this.firstArray = filesArray(directory);
		thr = new Thread(this);
		thr.start();
	}

	@Override
	public void run() {
		secondArray = filesArray(directory);
		if (!compareFiles(firstArray, secondArray)) {
			try {
				thr.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.run();
		}
	}

	private String[] filesArray(File directory) {
		if (!directory.isDirectory()) {
			throw new IllegalArgumentException("Directory no found!");
		}
		String[] filesNameArray = directory.list();

		return filesNameArray;
	}

	private boolean compareFiles(String[] firstArray, String[] secondArray) {
		boolean check = false;
		boolean outFromCompareFiles = false;
		for (int i = 0; i < secondArray.length; i++) {
			for (int j = 0; j < firstArray.length; j++) {
				check = false;
				if (secondArray[i].equals(firstArray[j])) {
					check = true;
					break;
				}
			}
			if (!check) {
				System.out.println("File is added to the directory: " + secondArray[i]);
				outFromCompareFiles = true;
			}
		}
		for (int i = 0; i < firstArray.length; i++) {
			for (int j = 0; j < secondArray.length; j++) {
				check = false;
				if (firstArray[i].equals(secondArray[j])) {
					check = true;
					break;
				} 
			}
			if (!check) {
				System.out.println("File was deleted from the directory: " + firstArray[i]);
				check = false;
				outFromCompareFiles = true;
			}
		}
		return outFromCompareFiles;
	}

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	public String[] getFirstArray() {
		return firstArray;
	}

	public String[] getSecondArray() {
		return secondArray;
	}

	public Thread getThr() {
		return thr;
	}
}
