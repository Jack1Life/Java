package Tasks;

import java.util.Arrays;

public class Network {
	private String[] regNumbers;

	public Network(String[] regNumbers) {
		super();
		this.regNumbers = regNumbers;
	}
	
	public Network() {
		super();
		regNumbers = new String[1];
	}

	public String[] getRegNumbers() {
		return regNumbers;
	}
	
	public void setRegNumbers(String[] regNumbers) {
		this.regNumbers = regNumbers;
	}

	public int serachNumber(String number) {
		if(number == null) {
			return -1;
		}
		for (int i = 0; i < regNumbers.length; i++)  {
			if(number.equals(regNumbers[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public String addNumber(String number) {
		if(serachNumber(number) >= 0) {
			return "number was added earlier";
		} else {
			for (int i = 0; i < regNumbers.length; i++) {
				if(regNumbers[i] == null) {
					regNumbers[i] = number;
					return "Number " + number + " added to network";
				}
			}
			regNumbers = Arrays.copyOf(regNumbers, regNumbers.length + 1);
			regNumbers[regNumbers.length - 1] = number;
			return "Number " + number + " added to network";
		}
	}
	
	public String deleteNumber(String number) {
		int indx = serachNumber(number);
		if(indx < 0) {
			return "Number has not been registered";
		} else {
			regNumbers[indx] = null;
			return "Number " + number + " was deleted";
		}
	}
}
