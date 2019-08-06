package Tasks;

public class Main {

	public static void task1() {
		//SexDeclaration sexList = new SexDeclaration();
		SexList male = SexList.MALE;
		
		Cat cat1 = new Cat("Vaska", 3, 7.7, SexList.MALE, "Abyssinian");
		Cat cat2 = new Cat("Murka", 3, 7.7, SexList.FEMALE, "Abyssinian");
		System.out.println(cat1.getVoice());
		System.out.println(cat2.getVoice());
		Cat newCat = cat1.toPair(cat2);
		if (newCat.getSex() != SexList.NOBODY) {
			Cat cat3 = newCat;
			cat3.setName("Arnolda");
			System.out.println("We have new cat: " + cat3.toString());
			System.out.println(cat1.getName() + ": " + cat1.castrate());
			System.out.println(cat2.getName() + ": " + cat2.castrate());
		}
		System.out.println(cat1.getVoice());
		System.out.println(cat2.getVoice());
	}

	public static void task2() {
		Triangle tria1 = new Triangle(1, 2, 1.41);
		Triangle tria2 = new Triangle(10, 10, (10 * 1.41));
		Triangle tria3 = new Triangle(Math.PI, 2, 4);
		System.out.println(tria1.getArea());
		System.out.println(tria2.getArea());
		System.out.println(tria3.getArea());
	}

	public static void task3() {
		Vector3d vect1 = new Vector3d(1,0,0);
		Vector3d vect2 = new Vector3d(0,5,0);
		Vector3d vect3 = new Vector3d(1,3,8);
		System.out.println("vect1 = " + vect1.toString());
		System.out.println("vect2 = " + vect2.toString());
		System.out.println("vect3 = " + vect3.toString());
		
		System.out.println("vect1 * vect2 = " + vect1.scalarMult(vect2));
		System.out.println("vect2 * vect3 = " + vect2.scalarMult(vect3));
		
		System.out.println("vect1 x vect2 = " + vect1.vectorMult(vect2));
		System.out.println("vect3 x vect1 = " + vect3.vectorMult(vect1));
		
		vect1.addVector(vect3);
		vect3.addVector(vect2);
		System.out.println("vect1 + vect3 = " + vect1);
		System.out.println("vect3 + vect2 = " + vect3);
		
	}

	public static void task4() {
		String[] numbers = {"+380956508735", "+380661765954", "+380970068750"};
		Network myOperator = new Network(numbers);
		Phone phone1 = new Phone(numbers[0]);
		Phone phone2 = new Phone(numbers[1]);
		Phone phone3 = new Phone(numbers[2]);
		Phone phone4 = new Phone("+380660302789");
		
		System.out.println(phone2.outgoingCall(phone1, myOperator));
		System.out.println(myOperator.deleteNumber("+380661765954"));
		System.out.println(phone2.outgoingCall(phone1, myOperator));
		System.out.println(phone3.outgoingCall(phone4, myOperator));
		System.out.println(myOperator.addNumber("+380661765954"));
		System.out.println(phone1.addContact("+380661765954", "����� �����������"));
		System.out.println(phone2.outgoingCall(phone1, myOperator));
	}
	
	public static void main(String[] args) {
		task1();
	}

}