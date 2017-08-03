package com.gmail.vsyniakin;

public class MultiThreadSum {

	public MultiThreadSum() {
		super();
	}

	public static long multiTreadSum(int[] array, int threadNumber) {
		SingleThreadSum[] threadArray = new SingleThreadSum[threadNumber];
		int step = array.length / threadArray.length;
		long result = 0L;
		for (int i = 0; i < threadArray.length; i++) {
			int lowIndex = i * step;
			int hightIndex = ((i + 1) * step);
			if ((array.length - hightIndex) < step) {
				hightIndex = array.length;
			}
			threadArray[i] = new SingleThreadSum(array, lowIndex, hightIndex);
		}
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].getThr().join();
				result = result + threadArray[i].getResult();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
