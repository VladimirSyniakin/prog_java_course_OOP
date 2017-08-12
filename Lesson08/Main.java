package com.gmail.vsyniakin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.gmail.vsyniakin.task1.Group;
import com.gmail.vsyniakin.task1.Student;
import com.gmail.vsyniakin.task2_3.BlackClassStack;
import com.gmail.vsyniakin.task2_3.Container;
import com.gmail.vsyniakin.task2_3.StackOfObjects;

public class Main {

	public static void main(String[] args) {

		// Task 1, ObjectOutputStream & ObjectInputStream

		 Group groupOne = new Group("My group of superheroes:");
		
		 groupOne.addStudent(new Student("John", "Mcklein", 43));
		 groupOne.addStudent(new Student("Spider", "Men", 17));
		 groupOne.addStudent(new Student("Black", "Widow", 30));
		 groupOne.addStudent(new Student("Mighty", "Thor", 3000));
		 groupOne.addStudent(new Student("Iron", "Men", 40));
		 groupOne.addStudent(new Student("Sarah", "Connor", 33));
		 groupOne.addStudent(new Student("Leonardo", "Ninja Turtles", 15));
		 groupOne.addStudent(new Student("Cat", "Woman", 30));
		 groupOne.addStudent(new Student("Bruce", "Wayne", 40));
		 groupOne.addStudent(new Student("Wonder", "Woman", 2500));
		
		 System.out.println(groupOne.toString());
		
		 Group groupTwo = null;
		
		 try (ObjectOutputStream oos = new ObjectOutputStream(new
		 FileOutputStream("outGroup.txt")); ObjectInputStream ois = new
		 ObjectInputStream(new FileInputStream("outGroup.txt"))){
		 oos.writeObject(groupOne);
		
		 groupTwo = (Group) ois.readObject();
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 } catch (IOException e) {
		 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
		 e.printStackTrace();
		 }
		
		 System.out.println(groupTwo.toString());

		// Task 2, Task 3, stack of objects with checking black list some objects:

		BlackClassStack blackList = new BlackClassStack();

		StackOfObjects stack = new StackOfObjects(blackList); 

		Object doub = new Double(2.0);
		
		stack.add(new String("String1"));
		stack.add(new Integer(1));
		stack.add(doub);
		stack.add(new String("String2"));
		stack.add(new Double(3.0));
		stack.add(new Long(4));
		stack.add(new Long(5));
		stack.add(new Double(6.0));
		stack.add(new Double(7.0));
		stack.delete(doub);
		stack.add(new String("String3"));
		stack.add(new String("String4"));
		stack.add(new Integer(7));
		
		blackList.add(String.class);
		blackList.add(new Double(2.5));
		
		stack.deleteObjectsOfBlackList();
		
		Container cont = stack.getContainerStart();
		while (cont != null) {
			System.out.println(cont.getObj().toString());
			cont = cont.getContainerNext();
		}


	}

}
