package lesson_7;

public class Cat {
	private String name;
	private int appetite;
//	 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). 
	private boolean full = false;
	
	public Cat(String name, int appetite) {
		this.name = name;
		this.appetite = appetite;
	}
	
	public boolean getFull() {
		return full;
	}
	
	public String getName() {
		return name;
	}
	
	public void eat(Plate p) {
//		Если коту
//		 удалось покушать (хватило еды), сытость = true.
		full = p.decreaseFood(appetite);
	}

}
