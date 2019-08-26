package StudentsData;

import java.util.ArrayList;

public interface DAOGroup {
	public Group getGroup(String name);
	public ArrayList<Group>  getAllGroups();
	public void  saveGroup(Group gr);
}
