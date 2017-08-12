package com.gmail.vsyniakin.task2;

public class SumMultiThread {

	public SumMultiThread() {
		super();
	}

	private static SumSingleThread [] multiTread(int[] array, int threadNumber) {
		SumSingleThread[] threadArray = new SumSingleThread[threadNumber];
		int step = array.length / threadArray.length;
		
		for (int i = 0; i < threadArray.length; i++) {
			int lowIndex = i * step;
			int hightIndex = ((i + 1) * step);
			if ((array.length - hightIndex) < step) {
				hightIndex = array.length;
			}
			threadArray[i] = new SumSingleThread(array, lowIndex, hightIndex);
		}
		return threadArray;
	}

	public static long getResult (int[] array, int threadNumber) {
		SumSingleThread[] threadArray = SumMultiThread.multiTread(array, threadNumber);
		long result = 0L;
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].getThr().join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result = result + threadArray[i].getResult();
		}
		return result;
	} 
	
}
