package task1;

import java.util.Arrays;

public class Port {
	private Ship[] shipQueue;
	private boolean[] docs;

	public Port(int docNum) {
		super();
		docs = new boolean[docNum];
		for (int i = 0; i < docs.length; i++) {
			docs[i] = true;
		}
		shipQueue = new Ship[5];
	}

	public Port() {
		super();
	}

	public boolean[] getDocs() {
		return docs;
	}

	public void setDocs(boolean[] docs) {
		this.docs = docs;
	}

	public void addShip(Ship sh) {
		for (int i = 0; i < shipQueue.length; i++) {
			if (shipQueue[i] == null) {
				shipQueue[i] = sh;
				return;
			}
		}
		shipQueue = Arrays.copyOf(shipQueue, shipQueue.length + 1);
		shipQueue[shipQueue.length - 1] = sh;
	}

	public void occupyDoc(int num) {
		docs[num] = false;
	}

	public void releaseDoc(int num) {
		docs[num] = true;
	}

	public void startUnloading() {
		for (int i = 0; i < shipQueue.length; i++) {
			if (shipQueue[i] != null) {
				for (int j = 0; true; j++) {
					if (j >= docs.length) {
						j = 0;
					}
					if (docs[j]) {
						Thread t = new Thread(new UnloadingShip(shipQueue[i], this, j));
						occupyDoc(j);
						t.start();
						break;
					}
				}
			}
		}
	}

}
