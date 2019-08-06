package task2;

import java.util.Arrays;

public class ClassStack {
	private Object[] stack;
	private int counter;
	private BlackList blackList;

	public ClassStack(BlackList blackList) {
		super();
		this.blackList = blackList;
		this.stack = new Object[10];
		this.counter = 0;
	}

	public ClassStack() {
		super();
		this.stack = new Object[10];
		this.counter = 0;
	}

	public BlackList getBlackList() {
		return blackList;
	}

	public void setBlackList(BlackList blackList) {
		this.blackList = blackList;
	}

	public int addObject(Object ob) {
		if (blackList.isBlackClass(ob)) {
			System.out.println("Class is in black list!");
			return -1;
		}
		this.stack[this.counter++] = ob;
		if (this.counter >= this.stack.length) {
			this.stack = Arrays.copyOf(this.stack, this.stack.length + 10);
		}
		return 0;
	}

	public Object getObject() {
		if (this.counter < 1) {
			return null;
		}
		return this.stack[this.counter - 1];
	}

	public Object getAndDeleteObject() {
		if (this.counter < 1) {
			return null;
		}
		Object ob = this.stack[--this.counter];
		this.stack[this.counter] = null;
		return ob;
	}
}
