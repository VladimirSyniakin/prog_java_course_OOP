package com.gmail.vsyniakin;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
	
	private int numberThread;
	
	public FactorialThread() {
		super();
	}

	public FactorialThread(int numberThread) {
		super();
		this.numberThread = numberThread;
	}

	@Override
	public void run() {
		System.out.println(factorianInThread(numberThread));
	}

	public BigInteger factorianInThread(int i) {
		BigInteger result = new BigInteger("" + i);
		if (i != 0) {
			for (int j = (i-1); j > 0; j--) {
				result = result.multiply(new BigInteger("" + j));
			}
		} else {
			result = new BigInteger("" + 1);
		}
		return result;
	}

	public int getNumberThread() {
		return numberThread;
	}
	public void setNumberThread(int numberThread) {
		this.numberThread = numberThread;
	}
}
