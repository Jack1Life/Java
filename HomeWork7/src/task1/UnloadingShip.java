package task1;

public class UnloadingShip implements Runnable{
	private Ship ship;
	private Port port;
	private int docNum;
	public UnloadingShip(Ship ship, Port port, int docNum) {
		super();
		this.ship = ship;
		this.port = port;
		this.docNum = docNum;
	}
	public UnloadingShip() {
		super();
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	public Port getPort() {
		return port;
	}
	public void setPort(Port port) {
		this.port = port;
	}
	public int getDocNum() {
		return docNum;
	}
	public void setDocNum(int docNum) {
		this.docNum = docNum;
	}
	
	public void run() {
		Thread thisThread = Thread.currentThread();
		for( ; this.ship.getBoxesNum() > 0; ) {
			this.ship.setBoxesNum(this.ship.getBoxesNum() - 1);
			System.out.println(ship.getName() + " have " + this.ship.getBoxesNum()  + " boxes");
			try {
				thisThread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.port.releaseDoc(docNum);
		System.out.println("Ship" + ship.getName() + " is unloaded in doc " + (docNum + 1));
	}
}