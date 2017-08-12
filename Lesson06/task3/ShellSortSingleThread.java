package com.gmail.vsyniakin.task3;

public class ShellSortSingleThread implements Runnable {
	private int[] array;
	private int begin;
	private int end;
	private int position;
	private Thread thr;

	public ShellSortSingleThread(int[] array, int begin, int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		this.position = begin;
		thr = new Thread(this);
		thr.start();
	}
	
	@Override
	public void run() {
		for (int d = ((end - begin) / 2); d > 0; d = d / 2) {
			int temp;
			for (int i = begin; i < end; i++) {
				temp = array[i];
				int j = i;
				while ((j - d) >= begin && array[j - d] > temp) {
					array[j] = array[j - d];
					j = j - d;
				}
				array[j] = temp;
			}
			if (d == 1) {
				d = 0;
			}
		}
	}
	
	
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Thread getThr() {
		return thr;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
