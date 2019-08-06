package Tasks;

public class Cat {
	private String tabooka;
	private String nameIsName;
	private int age;
	private double weight;
	private SexList sex;
	private String breed;

	public Cat(String name, int age, double weight, SexList sex, String breed) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.sex = sex;
		this.breed = breed;
	}

	public Cat() {
		super();
		sex = SexList.NOBODY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public SexList getSex() {
		return sex;
	}

	public void setSex(SexList sex) {
		this.sex = sex;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getVoice() {
		if (sex == SexList.EUNUCH) {
			return "Ehh...";
		} else if (sex == SexList.FEMALE) {
			return "Meeu.";
		} else {
			return "Meeeeeeeeeow!";
		}
	}

	public Cat toPair(Cat otherCat) {
		if ((sex == otherCat.getSex()) || (sex == SexList.EUNUCH) || (otherCat.getSex() == SexList.EUNUCH)) {
			return new Cat();
		} else if (breed.equals(otherCat.getBreed())) {
			return new Cat("newborn", 0, 0.3, otherCat.getSex(), breed);
		} else {
			return new Cat("newborn", 0, 0.3, otherCat.getSex(), "metis");
		}
	}

	public String castrate() {
		if (sex == SexList.MALE) {
			sex = SexList.EUNUCH;
			return "Castration comlete";
		} else {
			return "Device not found";
		}
	}
	
	@Override
	public String toString() {
		return "\nname: " + name + "\nage: " + age + "\nweight: " + weight + "kg" + "\nsex: " + sex + "\nbreed: "
				+ breed;
	}
}
