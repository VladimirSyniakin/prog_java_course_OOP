package com.gmail.vsyniakin.task2;

import java.io.File;
import java.io.IOException;

public class CopyFile {

	private File file;
	private File fileOut;
	private File direcoryOut;
	private boolean stopRead = false;
	private boolean endCopy = false;
	private long byteDownload = 0L;

	
	public CopyFile(File file, File direcoryOut) {
		super();
		this.file = file;
		this.direcoryOut = direcoryOut;
	}
	
	public void startCopy() {
		
		if (!file.exists()&&!file.isFile()) {
			throw new IllegalArgumentException("Wrong file copy!"); 
		}
		
		if (!direcoryOut.exists()&&!direcoryOut.isDirectory()) {
			throw new IllegalArgumentException("Wrong directory copy!"); 
		}
		
		fileOut = new File(direcoryOut, file.getName());
		
		if (fileOut.exists()) {
			throw new IllegalArgumentException("File exists!");
		} else
			try {
				if (fileOut.createNewFile()){
					Copy copy = new Copy(this);
					CopyProgress copyProgress = new CopyProgress(this);
					Thread thrCopy = new Thread(copy);
					Thread thrProgress = new Thread(copyProgress);
					thrCopy.start();
					thrProgress.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	public synchronized void copyStep(long byteDownload) {
		while (stopRead) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stopRead = true;
		this.byteDownload = byteDownload;
		if (byteDownload >=file.length()) {
			endCopy = true;
		}
		notifyAll();
	}
	
	public synchronized void progressCopyFile() {
		while (!stopRead) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long progress = (100 * byteDownload / file.length());
		if (progress > 100) {
			progress = 100;
		}
		System.out.println("Progress copy: " + progress + " %");
		stopRead = false;
		notifyAll();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public File getFileOut() {
		return fileOut;
	}

	public void setFileOut(File fileOut) {
		this.fileOut = fileOut;
	}

	public File getDirecoryOut() {
		return direcoryOut;
	}

	public void setDirecoryOut(File direcoryOut) {
		this.direcoryOut = direcoryOut;
	}

	public boolean isStopRead() {
		return stopRead;
	}

	public boolean isEndCopy() {
		return endCopy;
	}
}

