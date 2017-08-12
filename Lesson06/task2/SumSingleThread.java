package com.gmail.vsyniakin.task2;

public class SumSingleThread implements Runnable {

	private int[] array;
	private int lowIndex;
	private int hightIndex;
	private Thread thr;
	private long result = 0L;
	
	public SumSingleThread() {
		super();
	}
	public SumSingleThread(int[] array, int lowIndex, int hightIndex) {
		super();
		this.array = array;
		this.lowIndex = lowIndex;
		this.hightIndex = hightIndex;
		thr = new Thread(this);
		thr.start();
	}

	@Override
	public void run() {
		for (int i = lowIndex; i < hightIndex; i++) {
			this.result = this.result + array[i];
		}
	}
	
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	public int getLowIndex() {
		return lowIndex;
	}
	public void setLowIndex(int lowIndex) {
		this.lowIndex = lowIndex;
	}
	public int getHightIndex() {
		return hightIndex;
	}
	public void setHightIndex(int hightIndex) {
		this.hightIndex = hightIndex;
	}
	public Thread getThr() {
		return thr;
	}
	public long getResult() {
		return result;
	}
}
