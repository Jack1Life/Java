package task4;

public enum Friends {
	SHELDON("Sheldon"), LEONARD("Sheldon"), VOLOVITC("Volovitc"), KUTARAPALLI("Kutarapalli"), PENNY("Penny");
	private String friend;

	private Friends(String friend) {
		this.friend = friend;
	}

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}

}
