package com.gmail.vsyniakin.task2_3;

public class Container {

	Object obj;
	Container containerNext;

	public Container() {
		super();
	}

	@Override
	public String toString() {
		return "Container [obj=" + obj.toString() + "]";
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Container getContainerNext() {
		return containerNext;
	}

	public void setContainerNext(Container containerNext) {
		this.containerNext = containerNext;
	}
}
