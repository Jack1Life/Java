package Tasks;

public interface DAOGroup {
	public Group getGroup(String name);
	public Group getAllGroup();
	public void  saveGroup(Group gr);
}