package com.gmail.vsyniakin;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		// The task 1, factorial of number Thread:
		Thread[] thrArray = new Thread[100];

		for (int i = 0; i < thrArray.length; i++) {
			thrArray[i] = new Thread(new FactorialThread(i));
			thrArray[i].start();
		}
		
		// The task 2, sum array of integer with using MultiThread:
		
		int [] array = new int [100000000];
		Random rn = new Random();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(100);
		}
		
		long tStart = System.currentTimeMillis();
		SingleThreadSum singleSum = new SingleThreadSum(array, 0, array.length);
		long tEnd = System.currentTimeMillis();
		System.out.println((tEnd - tStart) + " ms" + "- single thread sum = " + singleSum.getResult());
		
		tStart = System.currentTimeMillis();
		long multiSum = MultiThreadSum.multiTreadSum(array, 50);
		tEnd = System.currentTimeMillis();
		System.out.println((tEnd - tStart) + " ms" + "- multi thread sum = " + multiSum);
	}
}
