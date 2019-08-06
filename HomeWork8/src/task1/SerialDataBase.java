package task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import StudentsData.DAOGroup;
import StudentsData.Group;

public class SerialDataBase implements DAOGroup{
	private static final long serialVersionUID = 1L;
	private String way;
	private File directory;
	
	public SerialDataBase(String way) {
		super();
		this.way = way;
		this.directory = new File(this.way);
	}

	public SerialDataBase() {
		super();
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
		this.directory = new File(this.way);
	}

	public void saveGroup(Group gr) {
		if(!this.directory.exists()) {
			this.directory.mkdirs();
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.way + "/" + gr.getName()))) {
			oos.writeObject(gr);
		} catch (IOException e) {
			System.out.println("Saving of group failed!");
		}
	}

	public Group getGroup(String name) {
		if(!this.directory.exists()) {
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.way + "/" + name))) {
			Group gr = (Group) ois.readObject();
			return gr;

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Geting of group failed!");
		}
		return null;
	}

	public Group[] getAllGroups() {
		File fl = new File(way);
		if (fl.isFile() || !fl.exists()) {
			return null;
		}
		File[] list = fl.listFiles();
		Group[] groupList = new Group[list.length];
		for (int i = 0; i < groupList.length; i++) {
			groupList[i] = getGroup(list[i].getName());
		}
		return groupList;
	}
}

