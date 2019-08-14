package task2;

import StudentsData.Group;
import StudentsData.SexList;
import StudentsData.Student;

public class Main {

	public static void main(String[] args) {
		BlackList bl = new BlackList();
		bl.addClass(Student.class);
		ClassStack stack = new ClassStack(bl);
		
		Student st1 = new Student("Vasil Gavk", SexList.MALE, 22, "RS-32", 12345, 4.0);
		Student st2 = (new Student("Tatiana Kusi", SexList.FEMALE, 20, "RS-32", 12346, 3.4));
		Student st3 = (new Student("Artem Ric", SexList.MALE, 21, "RS-32", 12347, 4.1));
		Group rs = new Group("RS-72", "FMI");
		
		//stack.addObject(st3);
		//stack.addObject(st1);
		stack.addObject(st2);
		stack.addObject(rs);
		
		System.out.println(stack.getObject().toString());
		System.out.println();
		System.out.println(stack.getAndDeleteObject().toString());
		System.out.println();
		System.out.println(stack.getObject());
	}

}
