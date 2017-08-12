package com.gmail.vsyniakin.task2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy implements Runnable {
	
	private CopyFile copyFile;
	private byte[] buffer = new byte[1024 * 1024 * 100];
	private long byteDownload = 0L;
	private int byteRead = 0;

	public Copy(CopyFile copyFile) {
		super();
		this.copyFile = copyFile;
	}

	@Override
	public void run() {
		try (FileInputStream fis = new FileInputStream (copyFile.getFile()); FileOutputStream fos = new FileOutputStream (copyFile.getFileOut(), true)){
			while (byteRead !=-1) {
				copyFile.copyStep(byteDownload);
				byteRead = fis.read(buffer);
				fos.write(buffer, 0, byteRead);
				byteDownload = byteDownload + buffer.length;
			}
		} catch (IOException e) {
			
		} catch (IndexOutOfBoundsException e) {
			
		}
	}

	public CopyFile getCopyFile() {
		return copyFile;
	}

	public void setCopyFile(CopyFile copyFile) {
		this.copyFile = copyFile;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

	public int getByteRead() {
		return byteRead;
	}

	public void setByteRead(int byteRead) {
		this.byteRead = byteRead;
	}

	public long getByteDownload() {
		return byteDownload;
	}
	
}
