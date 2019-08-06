package task1;

import StudentsData.Group;
import StudentsData.SexList;
import StudentsData.Student;
import StudentsExeption.FullGroupExeption;

public class Main {

	public static void main(String[] args) {
		Group rs32 = new Group("RS-32", "RTF");
		try {
			rs32.addStudent(new Student("Vasil Gavk", SexList.MALE, 22, "RS-32", 12345, 4.0));
			rs32.addStudent(new Student("Tatiana Kusi", SexList.FEMALE, 20, "RS-32", 12346, 3.4));
			rs32.addStudent(new Student("Artem Ric", SexList.MALE, 21, "RS-32", 12347, 4.1));
		} catch (FullGroupExeption e) {
			e.printStackTrace();
		}
		SerialDataBase base = new SerialDataBase(".");
		base.saveGroup(rs32);
		Group[] groups = base.getAllGroups();
		for (Group group : groups) {
			System.out.println(group.toString());
		}
		
	}

}

