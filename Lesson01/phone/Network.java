package com.gmail.vsyniakin.phone;

public class Network {
	private int [] arrayNumber;
	private int i = 0;
	
	public Network() {
		super();
		arrayNumber = new int [100]; // создание сети по умолчанию на 100 номеров
	}
	
	public Network(int[] arrayNumber) {
		super();
		this.arrayNumber = arrayNumber;
	}
		
	public int[] getArrayNumber() {
		return arrayNumber;
	}
	public void setArrayNumber(int[] arrayNumber) {
		this.arrayNumber = arrayNumber;
	}

	// добавление нового номера
	public void setNumber(int number) {
		if (i < arrayNumber.length) {
			arrayNumber [i] = number;
			i++;			
		} else {
			System.out.println("Network is full!");
		}
	}
	
	// поиск номера в сети
	public boolean findNumberInNetwork (int number) {
		for (int j = 0; j < i; j++) {
			if (arrayNumber [j] == number) {
				return true;
			}
		}
		return false;
	}
	
	
	

}
