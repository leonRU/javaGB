package lesson_7;

public class Main {
	public static void main(String[] args) {
//		Cat cat = new Cat("Barsik", 10);
//		Plate plate = new Plate(100);
//		plate.info();
//		cat.eat(plate);
//		plate.info();
//		System.out.println(cat.getFull());
//		plate.addFood(10);
//		plate.info();
		
//		5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
//		потом вывести информацию о сытости котов в консоль.
		Cat cat = new Cat("Barsik", 10);
		Plate plate = new Plate(40);
		
		Cat[] catArray = new Cat[5];
		catArray[0] = cat;
		catArray[1] = new Cat("Kot1", 15);
		catArray[2] = new Cat("Kot2", 25);
		catArray[3] = new Cat("Kot3", 13);
		catArray[4] = new Cat("Kot4", 4);
		
		for(Cat i: catArray) {
			i.eat(plate);
		}
		
		for(Cat i: catArray) {
			System.out.println(i.getName() + ": " + i.getFull());
		}
	}
}
