package com.gmail.vsyniakin.phone;

public class Main {

	public static void main(String[] args) {
		// создание сети, с указанием размера сети (4 номеров):
		Network myNetwork = new Network(new int [4]);
		
		// добавление номера телефона и регистрация в сети
		Phone phone1 = new Phone(5551111, myNetwork);
		Phone phone2 = new Phone(5552222, myNetwork);
		Phone phone3 = new Phone(5553333, myNetwork);
		Phone phone4 = new Phone(5553333, myNetwork);	// номер не зарегистрируется так как такой номер есть в сети phone3 - 5553333
		Phone phone5 = new Phone(5555555, myNetwork);
		Phone phone6 = new Phone(55566666, myNetwork);	// номер не зарегистрируется так как не корректно введено кол-во цифр
		Phone phone7 = new Phone(555777, myNetwork);	// номер не зарегистрируется так как не корректно введено кол-во цифр
		Phone phone8 = new Phone(5558888, myNetwork);	// номер не зарегистрируется, ввыведет: "Network is full!"  
		
		// Варианты звонков на другие номера с phone1:
		phone1.call(phone3.getNumber());	// нормальный звонок
		phone1.call(phone2.getNumber());	// нормальный звонок
		phone1.call(5554444);				// номера в базе нет
		phone1.call(phone1.getNumber());	// позвонить сам на себя, "This number is not correct"
		
		// звонок с номера, что не в сети (phone4): 
		phone4.call(5551111);				// "This number is not correct"
		
	}

}

