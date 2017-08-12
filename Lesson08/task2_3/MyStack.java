package com.gmail.vsyniakin.task2_3;

public class MyStack {

	private Container containerStart;
	private Container containerLast;

	public MyStack() {
		super();
	}

	public void add(Object obj) {
		Container container = new Container();
		container.setObj(obj);
		if (containerLast == null) {
			containerLast = container;
			containerStart = container;
		} else {
			containerLast.setContainerNext(container);
			containerLast = container;
		}
	}

	public void delete(Object obj) {
		Container contTemp = this.containerStart;
		if (contTemp.getObj().equals(obj)) {
			this.containerStart = contTemp.getContainerNext();
		}
		while (contTemp.getContainerNext() != null) {
			if (contTemp.getContainerNext().getObj().equals(obj)) {
				contTemp.setContainerNext(contTemp.getContainerNext().getContainerNext());
				contTemp = contTemp.getContainerNext();
			} else {
				contTemp = contTemp.getContainerNext();
			}
		}
	}

	public Object findObject(Object obj) {
		try {
			Container contTemp = this.containerStart;
			while (contTemp.getObj() != null) {
				if (contTemp.getObj().equals(obj)) {
					return contTemp.getObj();
				} else {
					contTemp = contTemp.getContainerNext();
				}
			}
		} catch (NullPointerException e) {

		}
		return null;
	}

	public Container getContainerStart() {
		return containerStart;
	}

	public void setContainerStart(Container containerStart) {
		this.containerStart = containerStart;
	}

	public Container getContainerLast() {
		return containerLast;
	}

	public void setContainerLast(Container containerLast) {
		this.containerLast = containerLast;
	}

	@Override
	public String toString() {
		String toStringContainers = containerStart.toString() + "\n";
		Container containerTemp = containerStart.getContainerNext();
		while (containerTemp.getObj() != null) {
			toStringContainers = toStringContainers + containerTemp.toString() + "\n";
			containerTemp = containerTemp.getContainerNext();
		}
		return toStringContainers;
	}

}
