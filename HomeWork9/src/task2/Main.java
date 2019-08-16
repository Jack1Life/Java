package task2;

import StudentsData.Group;

public class Main {

	public static void main(String[] args) {
		Group myGroup = new Group("RS-31", "RTF");
		myGroup.createNewStudent();
		myGroup.createNewStudent();
		System.out.println(myGroup.toString());
		
	}

}
