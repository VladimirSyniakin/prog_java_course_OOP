package com.gmail.vsyniakin.task2_3;

public class BlackClassStack extends MyStack {

	@Override
	public void add(Object classObj) {
		if (classObj.getClass().equals(Class.class)) {
			super.add(classObj);
		} else {
			classObj = classObj.getClass();
			super.add(classObj);
		}
	}

	public boolean checkClassOfObject(Object obj) {
		try {
			Container contTemp = getContainerStart();
			while (contTemp.getObj() != null) {
				if (contTemp.getObj().equals(obj.getClass())) {
					return true;
				} else {
					contTemp = contTemp.getContainerNext();
				}
			}
		} catch (NullPointerException e) {

		}
		return false;
	}
}
