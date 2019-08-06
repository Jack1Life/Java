package Tasks;

public class Human {
	private String name;
	private SexList sex;
	private int age;
	private int weight;
	private int growth;

	public Human(String name, SexList sex, int age, int weight, int high) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.weight = weight;
		this.growth = high;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SexList getSex() {
		return sex;
	}

	public void setSex(SexList sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHigh() {
		return growth;
	}

	public void setHigh(int high) {
		this.growth = high;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", sex=" + sex + ", age=" + age + ", weight=" + weight + ", high=" + growth + "]";
	}

}
