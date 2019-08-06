package Tasks;


import java.util.Arrays;

public class Phone {
	private String myNumber;
	private String[][] myContacts;

	public Phone(String myNumber, String[][] myContacts) {
		super();
		this.myNumber = myNumber;
		this.myContacts = myContacts;
	}

	public Phone(String myNumber) {
		super();
		this.myNumber = myNumber;
		myContacts = new String[1][2];
	}

	public Phone() {
		super();
		myContacts = new String[1][2];
	}

	public String getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(String myNumber) {
		this.myNumber = myNumber;
	}

	public String[][] getMyContacts() {
		return myContacts;
	}

	public void setMyContacts(String[][] myContacts) {
		this.myContacts = myContacts;
	}

	public int serachContact(String number) {
		if(number == null) {
			return -1;
		}
		for (int i = 0; i < myContacts.length; i++) {
			if (number.equals(myContacts[i][0])) {
				return i;
			}
		}
		return -1;
	}

	public String addContact(String number, String name) {
		if (serachContact(number) < 0) {
			for (int i = 0; i < myContacts.length; i++) {
				if (myContacts[i][0] == null) {
					myContacts[i][0] = number;
					myContacts[i][1] = name;
					return "Contact added";
				}
			}
			myContacts = Arrays.copyOf(myContacts, myContacts.length + 1);
			myContacts[myContacts.length - 1][0] = number;
			myContacts[myContacts.length - 1][1] = name;
			return "Contact added";
		}else {
			return "Contact exists";
		}
	}

	public String deleteContact(String number) {
		int indx = serachContact(number);
		if (indx >= 0) {
			myContacts[indx][0] = null;
			myContacts[indx][1] = null;
			return "Contact deleted";
		}else {
			return "Contact does not exists";
		}
	}
	
	public String incomingCall(String number) {
		for (int i = 0; i < myContacts.length; i++) {
			if (number.equals(myContacts[i][0])) {
				return ("Incoming call: " + myContacts[i][1]);
			}
		}
		return ("Incoming call: " + number);
	}

	public String outgoingCall(Phone otherPhone, Network operator) {
		if(otherPhone.getMyNumber() == null) {
			return "unkwon number";
		}
			
		if (operator.serachNumber(otherPhone.getMyNumber()) < 0){
			return myNumber + ": Number " + otherPhone.getMyNumber() + " not registered";
			
		}else if(operator.serachNumber(myNumber) < 0) {
			return myNumber + ": Your number not registered";
		} else {
			return otherPhone.incomingCall(myNumber);
		}
	}
}
