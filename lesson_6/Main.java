package lesson_6;

public class Main {

	public static void main(String[] args) {
		Cat cat1 = new Cat(200, 0, 2);
		Dog dog1 = new Dog(500, 10, 0.5);
		Dog dog2 = new Dog(600, 20, 1);
		
		dog1.run(400);
		dog1.run(600);
		
		cat1.swim(10);
		cat1.swim(0);
		
		dog2.jump(1);
		dog1.jump(1);
	}

}
