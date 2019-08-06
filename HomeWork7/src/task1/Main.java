package task1;

public class Main {

	public static void main(String[] args) {
		Port port = new Port(2);
		Ship sh1 = new Ship("Ship1", 10);
		Ship sh2 = new Ship("Ship2", 10);
		Ship sh3 = new Ship("Ship3", 10);
		
		port.addShip(sh1);
		port.addShip(sh2);
		port.addShip(sh3);
		port.startUnloading();
	}

}