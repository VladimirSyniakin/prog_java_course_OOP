package com.gmail.vsyniakin.task3;

public class ShellSortMultiThread {

	private static ShellSortSingleThread[] threadArrays(int[] array, int threadNumber) {
		ShellSortSingleThread[] threadArray = new ShellSortSingleThread[threadNumber];
		for (int i = 0; i < threadArray.length; i++) {
			int size = array.length / threadNumber;
			int begin = i * size;
			int end = ((i + 1) * size);
			if ((array.length - end) < size) {
				end = array.length;
			}
			threadArray[i] = new ShellSortSingleThread(array, begin, end);
		}
		return threadArray;
	}

	public static int[] sortArray(int[] array, int threadNumber) {
		ShellSortSingleThread[] threadArray = threadArrays(array, threadNumber);
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].getThr().join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int[] tempArray = new int[array.length];

		int indexArray = -1;

		for (int i = 0; i < tempArray.length; i++) {
			int minValue = Integer.MAX_VALUE;
			for (int j = 0; j < threadArray.length; j++) {
				if ((threadArray[j].getPosition() < threadArray[j].getEnd())
						&& (array[threadArray[j].getPosition()] < minValue)) {
					minValue = array[threadArray[j].getPosition()];
					indexArray = j;
				}
			}
			tempArray[i] = minValue;
			if (threadArray[indexArray].getPosition() < threadArray[indexArray].getEnd()) {
				threadArray[indexArray].setPosition((threadArray[indexArray].getPosition() + 1));
			}
		}

		return tempArray;
	}

}
