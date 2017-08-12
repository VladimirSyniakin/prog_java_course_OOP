package com.gmail.vsyniakin.task2;

public class CopyProgress implements Runnable {

	private CopyFile copyFile;

	public CopyProgress(CopyFile copyFile) {
		super();
		this.copyFile = copyFile;
	}

	@Override
	public void run() {
		
		while (!copyFile.isEndCopy()&&!copyFile.isStopRead()) {
			copyFile.progressCopyFile();
		}
		
	}
	
}
