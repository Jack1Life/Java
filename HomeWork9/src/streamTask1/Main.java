package streamTask1;

import java.util.ArrayList;
import java.util.stream.Collectors;

import StudentsData.Group;
import StudentsData.SexList;
import StudentsData.Student;
import StudentsExeption.FullGroupExeption;

public class Main {

	public static ArrayList<Student> task1(Group gr, char firstLetter) {
		return gr.getStudents().stream().filter(n -> (n.getName().charAt(0) == firstLetter))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public static void main(String[] args) {
		Group rs = new Group("RS-31", "RTF");
		try {
			rs.addStudent(new Student("Volovitc Kleo", SexList.MALE, 21, rs.getName(), 667732, 3.2));
			rs.addStudent(new Student("Feduniak Nastya", SexList.FEMALE, 21, rs.getName(), 667732, 3.2));
			rs.addStudent(new Student("Vlush Duy", SexList.MALE, 21, rs.getName(), 667732, 3.2));
			rs.addStudent(new Student("Franko Ivan", SexList.MALE, 21, rs.getName(), 667732, 3.2));
			rs.addStudent(new Student("Mumiyo Vlad", SexList.MALE, 21, rs.getName(), 667732, 3.2));
		} catch (FullGroupExeption e) {
			e.printStackTrace();
		}
		ArrayList<Student> filtr = task1(rs, 'M');
		for (Student student : filtr) {
			System.out.println(student.toString());
			System.out.println();
		}
	}

}
