package com.gmail.vsyniakin;

import java.io.File;
import java.util.Random;

import com.gmail.vsyniakin.task1.FactorialThread;
import com.gmail.vsyniakin.task2.SumMultiThread;
import com.gmail.vsyniakin.task2.SumSingleThread;
import com.gmail.vsyniakin.task3.ShellSortMultiThread;
import com.gmail.vsyniakin.task3.ShellSortSingleThread;
import com.gmail.vsyniakin.task4.CopyDirectoryFiles;
import com.gmail.vsyniakin.task5.CheckDirectory;

public class Main {

	public static void main(String[] args) {

		// The task 1, factorial of number Thread:

		Thread[] thrArray = new Thread[100];

		for (int i = 0; i < thrArray.length; i++) {
			thrArray[i] = new Thread(new FactorialThread(i));
			thrArray[i].start();
		}

		// The task 2, sum array of integer with using MultiThread:

		int[] array = new int[100000000];
		Random rn = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(1000);
		}

		SumSingleThread singleSum = new SumSingleThread(array, 0, array.length);
		long tStart = System.currentTimeMillis();
		try {
			singleSum.getThr().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long tEnd = System.currentTimeMillis();
		System.out.println((tEnd - tStart) + " ms" + "- single thread sum = " + singleSum.getResult());

		tStart = System.currentTimeMillis();
		long multiSum = SumMultiThread.getResult(array, 50);
		tEnd = System.currentTimeMillis();
		System.out.println((tEnd - tStart) + " ms" + "- multi thread sum = " + multiSum);

		// The task 3, Shell sort

		int[] arraySh = new int[500000];
		for (int i = 0; i < arraySh.length; i++) {
			arraySh[i] = rn.nextInt(100);
		}
		int[] arraySh1 = arraySh.clone();

		tStart = System.currentTimeMillis();
		ShellSortSingleThread singleSort = new ShellSortSingleThread(arraySh, 0, arraySh.length);
		try {
			singleSort.getThr().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tEnd = System.currentTimeMillis();
		System.out.println((tEnd - tStart) + " ms Single Shell sort");

		tStart = System.currentTimeMillis();
		arraySh1 = ShellSortMultiThread.sortArray(arraySh1, 8);
		tEnd = System.currentTimeMillis();
		System.out.println((tEnd - tStart) + " ms Multi Shell sort");

		// The task 4, copy files in directory

		CopyDirectoryFiles copy = new CopyDirectoryFiles(
				new File("F:\\MyJavaProject\\prog.kiev.ua Homework OOP\\Lesson05\\TempInput"),
				new File("F:\\MyJavaProject\\prog.kiev.ua Homework OOP\\Lesson05\\TempOutput"));
		copy.multiCopy();

		// The task 5, check files to the directory

		CheckDirectory chDir = new CheckDirectory(
				new File("F:\\MyJavaProject\\prog.kiev.ua Homework OOP\\Lesson05\\TempOutput"));
	}
}
