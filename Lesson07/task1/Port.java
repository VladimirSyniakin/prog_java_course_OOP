package com.gmail.vsyniakin.task1;

public class Port {

	private boolean dockOne = false;
	private boolean dockTwo = false;

	public synchronized void docksWork(Ship ship) {

		for (; (dockOne&&dockTwo);) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (!dockOne) {
			dockOne = true;
			ship.setLeaveDock(1);
		} else if (!dockTwo) {
			dockTwo = true;
			ship.setLeaveDock(2);
		}
	}
	
	public synchronized void unblockDock (int numberDock) {
		if (numberDock == 1) {
			dockOne = false;
			notify();
		} else if (numberDock == 2) {
			dockTwo = false;
			notify();
		}
	}
				
	@Override
	public String toString() {
		return "Port [dockOne=" + dockOne + ", dockTwo=" + dockTwo + "]";
	}

	public boolean isDockOne() {
		return dockOne;
	}

	public void setDockOne(boolean dockOne) {
		this.dockOne = dockOne;
	}

	public boolean isDockTwo() {
		return dockTwo;
	}

	public void setDockTwo(boolean dockTwo) {
		this.dockTwo = dockTwo;
	}
}
