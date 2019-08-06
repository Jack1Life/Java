package StudentsData;

public interface DAOGroup {
	public Group getGroup(String name);
	public Group[] getAllGroups();
	public void  saveGroup(Group gr);
}
