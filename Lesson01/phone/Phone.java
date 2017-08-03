package com.gmail.vsyniakin.phone;

public class Phone {
	private int number;
	private Network myNetwork;
	
	public Phone() {
		super();
	}

	public Phone(int phoneNumber, Network myNetwork) {
		super();
		this.number = phoneNumber;
		this.myNetwork = myNetwork;
		registretionNetwork(myNetwork);
	}

	public void registretionNetwork(Network myNetwork) {
		// проверка на существует ли уже номер в сети и кол-во цифр в номере - 7 шт 
		if ((!myNetwork.findNumberInNetwork(number))&&(number/1000000 >= 1)&&(number/10000000 <= 1)) {
			myNetwork.setNumber(number);
			System.out.println(number + " phone number is registered!");
		} else {
			System.out.println(number + " phone number is not registered!");
			this.myNetwork = new Network();
		}		
	}
	
	public void call (int number) {
		if (myNetwork.findNumberInNetwork(number)&&(this.number!=number)) {
			System.out.println("Call: " + number);
		} else {
			System.out.println("This number is not correct: " + number);
		}
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int phoneNumber) {
		this.number = phoneNumber;
	}
	public Network getMyNetwork() {
		return myNetwork;
	}
	public void setMyNetwork(Network myNetwork) {
		this.myNetwork = myNetwork;
	}
	
}
