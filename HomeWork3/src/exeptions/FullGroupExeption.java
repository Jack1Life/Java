package exeptions;

import Tasks.Student;

public class FullGroupExeption extends Exception{
	
	Student excessStud;
	
	
	public FullGroupExeption(Student excess) {
		super();
		this.excessStud = excess;
	}

	public FullGroupExeption() {
		super();
	}


	@Override
	public String getMessage() {
		return "Group is full! " + excessStud.getName() + " is excess.";
	}
}