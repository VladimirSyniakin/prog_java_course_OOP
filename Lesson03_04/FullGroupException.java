package com.gmail.vsyniakin;


public class FullGroupException extends ArrayIndexOutOfBoundsException {

	@Override
	public String getMessage() {
		
		return "group is full!";
	}
}
