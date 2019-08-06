package Tasks;

import java.io.File;

import exeptions.FullGroupExeption;

public class Main {

	public static void main(String[] args) {
		//Group RS32 = new Group("RS32", "RTF");
		File dir = new File("dir");
//		dir.mkdir();
		 DAOGroup rs = new FileSystem(dir);
		 Group RS32 = rs.getGroup("RS32");
//		try {
//			RS32.addStudent(new Student("Gorbul Engeniy", SexList.MALE,   21, "", 773301, 4.3));
//			RS32.addStudent(new Student("Aduev Viktor",   SexList.MALE,   17, "", 773302, 4.9));
//			RS32.addStudent(new Student("Glovakin Petro", SexList.MALE,   23, "", 773303, 3.3));
//			RS32.addStudent(new Student("Harin Nikita",   SexList.MALE,   20, "", 773304, 4.0));
//			RS32.addStudent(new Student("Strashko Vlada", SexList.FEMALE, 17, "", 773305, 3.9));
//			RS32.addStudent(new Student("Baha Diana",     SexList.FEMALE, 18, "", 773306, 3.7));
//			RS32.addStudent(new Student("Karas Engeniy",  SexList.MALE,   18, "", 773307, 3.6));
//			RS32.addStudent(new Student("Banya Viktor",   SexList.MALE,   19, "", 773308, 3.2));
//			RS32.addStudent(new Student("Gogot Zarub",    SexList.MALE,   19, "", 773309, 3.3));
//			RS32.addStudent(new Student("Smus Ivanna",    SexList.FEMALE, 17, "", 773310, 4.0));
//			RS32.addStudent(new Student("Li Ya",          SexList.MALE,   22, "", 773311, 3.9));			
//		} catch(FullGroupExeption e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println(RS32.toString());
		//System.out.println();
		//RS32.expelStudent(RS32.searchStudent("Petro"));
		//RS32.createNewStudent();
		
		//System.out.println(RS32.toString());
//		System.out.println();
//		
//		Student[] recruts = RS32.watchRecruits();
//		for (Student student : recruts) {
//			System.out.println(student.getName());
//		}
//		System.out.println();
//		try {
//		System.out.println(RS32.searchStudent("Smus").toString());
//		} catch(NullPointerException e) {
//			System.out.println("Student not found");
//		}
//		File dir = new File("dir");
//		dir.mkdir();
//		 DAOGroup rs = new FileSystem(dir);
//		 rs.saveGroup(RS32);
	}

}
