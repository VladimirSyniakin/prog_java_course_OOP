package com.gmail.vsyniakin.task1;

public class Ship implements Runnable {

	private int cargoInShip;
	private int leaveDock = 0;
	private String name;
	private Thread thr;
	private Port port;
	
	public Ship(String name, int cargoInShip, Port port) {
		super();
		this.cargoInShip = cargoInShip;
		this.name = name;
		this.port = port;
		this.thr = new Thread(this);
		this.thr.start();
	}
	
	public Ship() {
		super();
	}

	@Override
	public void run() {
		port.docksWork(this);
		System.out.println(toString());
		unloadingShip();
		port.unblockDock(leaveDock);
	}
	
	private void unloadingShip() {
		for (int i = cargoInShip; i >= 0; i--) {
			System.out.println("Cargo in ship: " + cargoInShip);
			try {
				thr.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cargoInShip = cargoInShip - 1;
		}
	}

	public Thread getThr() {
		return thr;
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	public int getCargoInShip() {
		return cargoInShip;
	}

	public void setCargoInShip(int cargoInShip) {
		this.cargoInShip = cargoInShip;
	}

	public int getLeaveDock() {
		return leaveDock;
	}
	
	public void setLeaveDock(int leaveDock) {
		this.leaveDock = leaveDock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ship [name=" + name + ", cargoInShip=" + cargoInShip + "]";
	}
	
	
}
