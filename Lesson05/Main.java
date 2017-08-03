package com.gmail.vsyniakin;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		//CopyFileOperation.copyFileIO(new File ("F:\\MyJavaProject\\prog.kiev.ua Homework OOP\\Lesson05\\TempInput"), new File ("F:\\\\MyJavaProject\\\\prog.kiev.ua Homework OOP\\\\Lesson05\\\\TempOutput"), "mp3");
		CopyTextInFile.copyTextFromTwoFiles(new File(".\\TempInput\\file one.txt"), new File(".\\TempInput\\file two.txt"), new File(".\\TempOutput\\file output.txt"));
	}

}
