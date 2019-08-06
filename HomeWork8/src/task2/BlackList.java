package task2;

import java.util.Arrays;

public class BlackList {
	private Class[] blackList;

	public BlackList() {
		super();
		this.blackList = new Class[10];
	}
	
	public void addClass(Class cl) {
		for(int i = 0; i < this.blackList.length; i++) {
			if(this.blackList[i] == cl)
				return;
		}
		for(int i = 0; i <= this.blackList.length; i++) {
			if(i == this.blackList.length) {
				this.blackList = Arrays.copyOf(this.blackList, this.blackList.length + 10);
			}
			if(this.blackList[i] == null) {
				this.blackList[i] = cl;
				return;
			}
		}
	}
	
	public boolean isBlackClass(Object obj)
	{
		for(int i = 0; i < this.blackList.length; i++) {
			if(this.blackList[i] == obj.getClass())
				return true;
		}
		return false;
	}
}