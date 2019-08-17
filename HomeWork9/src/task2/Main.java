package task2;

import java.util.ArrayList;

import StudentsData.Group;
import StudentsData.SexList;
import StudentsData.Student;
import StudentsExeption.FullGroupExeption;

public class Main {

	public static void main(String[] args) {
		Group myGroup = new Group("RS-31", "RTF");
		try {
			myGroup.addStudent(new Student("Vasya", SexList.MALE, 22, myGroup.getName(), 112233, 3.1));
			myGroup.addStudent(new Student("Serg", SexList.MALE, 21, myGroup.getName(), 112233, 3.1));
			myGroup.addStudent(new Student("Masha", SexList.FEMALE, 23, myGroup.getName(), 112233, 3.1));
			myGroup.addStudent(new Student("Farik", SexList.MALE, 25, myGroup.getName(), 112233, 3.1));
			myGroup.addStudent(new Student("Gas", SexList.MALE, 20, myGroup.getName(), 112233, 3.1));
			myGroup.addStudent(new Student("Kolya", SexList.MALE, 22, myGroup.getName(), 112233, 3.1));
		} catch (FullGroupExeption e) {
			e.printStackTrace();
		}
		System.out.println(myGroup.toString());
		System.out.println();
		
		myGroup.expelStudent(myGroup.searchStudent("Gas"));
		System.out.println(myGroup.toString());
		System.out.println();
		
		for (Student student : myGroup.watchRecruits()) {
			System.out.println(student.toString());
			System.out.println();
		}
	}

}
