package com.gmail.vsyniakin;

import java.io.File;

import com.gmail.vsyniakin.task1.Port;
import com.gmail.vsyniakin.task1.Ship;
import com.gmail.vsyniakin.task2.CopyFile;

public class Main {

	public static void main(String[] args) {
		Port port = new Port();
		Ship [] ships = new Ship [] {new Ship("One", 10, port), new Ship("Two", 10, port), new Ship("Three", 10, port)};
		
		CopyFile copy = new CopyFile(new File(".\\Nezvannie gosti  (2005) DVDRip.avi"), new File(".\\copyTemp"));
		copy.startCopy();
		
	}

	
}
