package StudentsData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import StudentsExeption.FullGroupExeption;

public class FileSystem implements DAOGroup {
	private File directory;

	public FileSystem(File directory) throws IllegalArgumentException {
		super();
		if (!directory.exists())
			directory.mkdir();
		if (directory.isFile())
			throw new IllegalArgumentException();
		this.directory = directory;
	}

	public FileSystem() {
		super();
	}

	public File getWay() {
		return directory;
	}

	public void setWay(File way) {
		if (!directory.exists())
			directory.mkdir();
		if (directory.isFile())
			throw new IllegalArgumentException();
		this.directory = way;
	}

	private File searchFile(String name) {
		for (File file : directory.listFiles()) {
			if ((file.getName().lastIndexOf(name) >= 0) && (file.getAbsolutePath().lastIndexOf(".txt") >= 0)) {
				return file;
			}
		}
		return null;
	}

	private String findParametr(StringBuilder data, String begin, String end) {
		int indxStart = data.indexOf(begin);
		if (indxStart < 0)
			return null;
		indxStart += begin.length();
		int indxEnd = data.indexOf(end, indxStart);
		if (indxStart < indxEnd) {
			StringBuilder myData = new StringBuilder("");
			myData.append(data, indxStart, indxEnd);
			return myData.toString();
		} else {
			return null;
		}
	}

	private int stringToInt(String str) {
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) >= '0') && (str.charAt(i) <= '9')) {
				num = num * 10 + (str.charAt(i) - 0x30);
			}
		}
		return num;
	}

	private double stringToDouble(String str) {
		double num = stringToInt(str);
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				flag = 1;
			}
			if ((str.charAt(i) >= '0') && (str.charAt(i) <= '9') && flag > 0) {
				num /= 10;
			}
		}
		return num;
	}

	private Student findStudent(StringBuilder data) {
		Student st = new Student();
		StringBuilder myData = new StringBuilder("");
		myData.append(data);
		if (myData.indexOf("Name: ") >= 0) {
			st.setName(findParametr(myData, "Name: ", "  "));
			if (data.indexOf("MALE") > data.indexOf("FEMALE")) {
				st.setSex(SexList.FEMALE);
			} else {
				st.setSex(SexList.MALE);
			}
			myData.delete(0, myData.indexOf("Age:"));
			st.setAge(stringToInt(findParametr(myData, "Age: ", "  ")));
			myData.delete(0, myData.indexOf("Record Book: "));
			st.setRecordBookNum(stringToInt(findParametr(data, "Record Book: ", "   ")));
			myData.delete(0, myData.indexOf("Grade point average: "));
			st.setGradePointAverage(stringToDouble(findParametr(data, "Grade point average: ", "  ")));
			return st;
		} else {
			return null;
		}
	}

	public Group getGroup(String name) {
		Group gr = new Group();
		char[] symbols = new char[1024 * 1024];
		File myFile = searchFile(name);
		if (myFile == null) {
			return null;
		}
		try (FileReader rd = new FileReader(myFile);) {
			rd.read(symbols);
			StringBuilder str = new StringBuilder("");
			str.append(symbols);
			gr.setFaculty(findParametr(str, "Faculty: ", System.lineSeparator()));
			str.delete(0, (str.indexOf("Group: ")));
			gr.setName(findParametr(str, "Group: ", System.lineSeparator()));
			while (str.indexOf("Name: ") >= 0) {
				gr.addStudent(findStudent(str));
				str.delete(0, (str.indexOf("Grade point average:") + 10));
				if (str.indexOf("Name: ") < 0) {
					if (rd.read(symbols) < 0)
						return gr;
					str.append(symbols);
				}
			}
		} catch (IOException e) {
		} catch (FullGroupExeption e) {
			return gr;
		}
		return gr;
	}

	public ArrayList<Group> getAllGroups() {
		ArrayList<Group> gr = new ArrayList<Group>();
		File[] list = directory.listFiles();
		for (File file : list) {
			gr.add(getGroup(file.getName()));
		}
		return gr;
	}

	private String addSpace(int amm) {
		String space = "";
		for (int i = 0; i < amm; i++) {
			space += " ";
		}
		return space;
	}

	public void saveGroup(Group gr) {
		File newGroup = new File(this.directory.getAbsolutePath() + "/Group " + gr.getName() + ".txt");
		try (PrintWriter writeGroup = new PrintWriter(newGroup);) {
			writeGroup.println("Faculty: " + gr.getFaculty());
			writeGroup.println("Group: " + gr.getName());
			for (Student stud : gr.getStudents()) {
				if (stud != null) {
					writeGroup.print("Name: " + stud.getName() + addSpace(30 - stud.getName().length()));
					if (stud.getSex() == SexList.FEMALE)
						writeGroup.print("Sex: FEMALE   Age: ");
					else
						writeGroup.print("Sex: MALE     Age: ");
					writeGroup.println(stud.getAge() + "    Record Book: " + stud.getRecordBookNum()
							+ "    Grade point average: " + stud.getGradePointAverage() + "  ");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
