package StudentsData;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import StudentsExeption.FullGroupExeption;

public class Group implements Voencom, Serializable {
	private Student[] students = new Student[10];
	private String name;
	private String faculty;

	public Group(Student[] students, String name, String faculty) {
		super();
		this.students = students;
		this.name = name;
		this.faculty = faculty;
	}

	public Group(String name, String faculty) {
		super();
		this.name = name;
		this.faculty = faculty;
	}

	public Group() {
		super();
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public void addStudent(Student stud) throws FullGroupExeption {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = stud;
				students[i].setGroup(this.getName());
				return;
			}
		}
		throw new FullGroupExeption(stud);
	}

	public void expelStudent(Student stud) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == stud) {
				students[i] = null;
				break;
			}
		}
	}

	public Student searchStudent(String name) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getName().lastIndexOf(name) >= 0) {
				return students[i];
			}
		}
		return null;
	}

	private int compare(String str1, String str2) {
		int len = str1.length();
		if (str2.length() > len) {
			len = str2.length();
		}
		for (int i = 0; i < len; i++) {
			if (str1.charAt(i) > str2.charAt(i)) {
				return 1;
			} else if (str1.charAt(i) < str2.charAt(i)) {
				return -1;
			}
		}
		return 1;
	}

	private int compare(double n1, double n2) {
		if (n1 < n2) {
			return 1;
		} else {
			return -1;
		}
	}

	public void sortStudents(SortParametrs p) {
		Arrays.sort(students, (st1, st2) -> {
			if (st1 == null)
				return 1;
			if (st2 == null)
				return -1;
			if (p == SortParametrs.NAME) {
				return compare(((Student) st1).getName(), ((Student) st2).getName());
			} else if (p == SortParametrs.AGE) {
				return (compare(((Student) st1).getAge(), ((Student) st2).getAge()));
			} else if (p == SortParametrs.BOOKNUM) {
				return (compare(((Student) st1).getRecordBookNum(), ((Student) st2).getRecordBookNum()));
			} else if (p == SortParametrs.GRADE) {
				return (compare(((Student) st1).getGradePointAverage(), ((Student) st2).getGradePointAverage()));
			} else if (p == SortParametrs.SEX) {
				if (st1.getSex() == SexList.MALE) {
					return -1;
				} else {
					return 1;
				}
			}
			return 0;
		});
	}

	public void createNewStudent() {
		Scanner sc = new Scanner(System.in);
		SexList sex;
		System.out.println("Enter name of the student:");
		String name = sc.nextLine();
		System.out.println("Enter sex of the student (m/f):");
		if (sc.nextLine().equals("f")) {
			sex = SexList.FEMALE;
		} else {
			sex = SexList.MALE;
		}
		System.out.println("Enter age of the student:");
		int age = sc.nextInt();
		System.out.println("Enter number of record book:");
		int recordBookNum = sc.nextInt();
		System.out.println("Enter grade point average:");
		double gradePointAverage = sc.nextDouble();
		try {
			addStudent(new Student(name, sex, age, this.name, recordBookNum, gradePointAverage));
		} catch (FullGroupExeption e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	public Student[] watchRecruits() {
		Student[] recruits = new Student[0];
		for (Student student : students) {
			if (student == null)
				continue;
			if (student.getAge() > 17 && student.getSex() == SexList.MALE) {
				recruits = Arrays.copyOf(recruits, (recruits.length + 1));
				recruits[recruits.length - 1] = student;
			}
		}
		return recruits;
	}

	@Override
	public String toString() {
		String str = "Group " + this.name + ":";
		//sortStudents(SortParametrs.NAME);
		for (Student student : students) {
			if (student != null)
				str += System.lineSeparator() + student.getName() + " Age: " + student.getAge() + " Sex: "
						+ student.getSex() + " Record book: " + student.getRecordBookNum() + " Grade point: "
						+ student.getGradePointAverage();
		}
		return str;
	}

}