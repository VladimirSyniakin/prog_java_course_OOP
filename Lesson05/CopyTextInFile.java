package com.gmail.vsyniakin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextInFile {

	public static void copyTextInFile(File inputFile, File outputFile) {

		try {
			if (!inputFile.exists() || !inputFile.isFile()) {
				throw new IllegalArgumentException("Null file pointer");
			}

			if (!outputFile.exists() || !outputFile.isFile()) {
				if (!outputFile.createNewFile()) {
					throw new IllegalArgumentException("Null file pointer");
				}
			}
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try (BufferedReader bfR = new BufferedReader(new FileReader(inputFile));
				BufferedWriter bfW = new BufferedWriter(new FileWriter(outputFile, true))) {
			String strLine = "";
			while ((strLine = bfR.readLine()) != null) {
				bfW.write(strLine);
				bfW.newLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void copyTextFromTwoFiles(File inputFileOne, File inputFileTwo, File outputFile) {
		copyTextInFile(inputFileOne, outputFile);
		copyTextInFile(inputFileTwo, outputFile);
	}
}
