package tasks;

public class Summator {
	private int[] mass;
	private int res;
	
	public Summator(int[] mass) {
		super();
		this.mass = mass;
	}

	public Summator() {
		super();
	}

	public int[] getMass() {
		return mass;
	}

	public void setMass(int[] mass) {
		this.mass = mass;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res += res;
	}

	public int getSumm() {
		res = 0;
		Thread s1 = new Thread((new Adder(mass, 0, 4, this)));
		s1.start();

		Thread s2 = new Thread((new Adder(mass, 1, 4, this)));
		s2.start();
		
		Thread s3 = new Thread((new Adder(mass, 2, 4, this)));
		s3.start();
		
		Thread s4 = new Thread((new Adder(mass, 3, 4, this)));
		s4.start();	
		try {
			s1.join();
			s2.join();
			s3.join();
			s4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}