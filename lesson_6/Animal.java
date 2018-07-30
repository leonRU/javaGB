package lesson_6;

public class Animal {
	double max_run_range;
	double max_swim_range;
	double max_jump_range;
	
	public Animal() {}
	public Animal(int max_run_range, int max_swim_range, double max_jump_range) {
		this.max_run_range = max_run_range;
		this.max_swim_range = max_swim_range;
		this.max_jump_range = max_jump_range;
	}
	
	public void run(int range) {
		if(range <= max_run_range) {
			System.out.println(this.getClass().getSimpleName() + " try run: true");
			return;
		}
		System.out.println(this.getClass().getSimpleName() + " try run: false");
	}
	
	public void swim(int range) {
		if(range <= max_swim_range) {
			System.out.println(this.getClass().getSimpleName() + " try swim: true");
			return;
		}
		System.out.println(this.getClass().getSimpleName() + " try swim: false");
	}
	
	public void jump(double range) {
		if(range <= max_jump_range) {
			System.out.println(this.getClass().getSimpleName() + " try jump: true");
			return;
		}
		System.out.println(this.getClass().getSimpleName() + " try jump: false");
	}	
}


