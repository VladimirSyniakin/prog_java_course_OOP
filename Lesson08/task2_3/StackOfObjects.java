package com.gmail.vsyniakin.task2_3;

public class StackOfObjects extends MyStack {

	private BlackClassStack blackList;

	public StackOfObjects() {
		super();
	}

	public StackOfObjects(BlackClassStack blackList) {
		super();
		this.blackList = blackList;
	}

	@Override
	public void add(Object obj) {
		try {
			if (!blackList.checkClassOfObject(obj)) {
				super.add(obj);
			} else {
				System.out.println("Class of the object in the blacklist!");
			}
		} catch (NullPointerException e) {
			super.add(obj);
		}
	}

	public void deleteObjectsOfBlackList() {
		Container tempContainer = getContainerStart();
		try {
			while (tempContainer.getObj() != null) {
				if (blackList.checkClassOfObject(tempContainer.getObj())) {
					delete(tempContainer.getObj());
					tempContainer = tempContainer.getContainerNext();
				} else {
					tempContainer = tempContainer.getContainerNext();
				}
			}
		} catch (NullPointerException e) {

		}

	}

	public BlackClassStack getBlackList() {
		return blackList;
	}

	public void setBlackList(BlackClassStack blackList) {
		this.blackList = blackList;
	}

}
