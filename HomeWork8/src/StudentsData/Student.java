package StudentsData;

import java.io.Serializable;

public class Student extends Human{
	private String group;
	private int recordBookNum;
	private double gradePointAverage;

	public Student(String name, SexList sex, int age, String group, int recordBookNum, double gradePointAverage) {
		super();
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
		this.group = group;
		this.recordBookNum = recordBookNum;
		this.gradePointAverage = gradePointAverage;
	}

	public Student() {
		super();
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getRecordBookNum() {
		return recordBookNum;
	}

	public void setRecordBookNum(int recordBookNum) {
		this.recordBookNum = recordBookNum;
	}

	public double getGradePointAverage() {
		return gradePointAverage;
	}

	public void setGradePointAverage(double gradePointAverage) {
		this.gradePointAverage = gradePointAverage;
	}

	@Override
	public String toString() {
		return "Student " + this.getName() + System.lineSeparator() + "Age: " + this.getAge() + System.lineSeparator()
				+ "group: " + group + System.lineSeparator() + "recordBookNum: " + recordBookNum
				+ System.lineSeparator() + "gradePointAverage: " + gradePointAverage;
	}

}
