package les1;

public class homework {
	public static void main ( String [] args ) { //task1
		byte tByte = 28;			//task2 start
		short tShort = 129;
		int tInt = 123145;
		long tLong = 100000L;
		float tFloat = 123.3f;
		double tDouble = 129.127;
		boolean tBoolean = false;
		char tChar = 't';		//task2 end
		
		int a = 2;
		int b = 4;
		int c = 10;
		int d = 2;
		int e = 18;
		System.out.println("Task 3. a *(b + (c / d)) = " + calculate(a, b, c, d)); //task3
		
		System.out.println("Task 4. 10 <= arg1 + arg2 <= 20 is " + task4(a,e)); //task4
		
		System.out.print("Task 5. ");
		isPositive(a);//task5
		
		System.out.println("Task 6. " + isNegative(e));//task6
		
		String name = "noone";
		System.out.print("Task 7. ");
		sayHelloTo(name);//task7
		
		int year = 2003;
		System.out.print("Task 8. ");
		isYear(year);//task8
		
	}
	
	public static int calculate(int x, int y, int z, int w) {//task3
		return x * (y + (z / w));
	}
	
	public static boolean task4(int x, int y) { //task4
		if(x + y >= 10 && x + y <=20) {
			return true;
		}
		return false;
	}
	
	public static void isPositive(int x) {//task5
		if(x<0) {
			System.out.println(x + " is negative");
		}else {
			System.out.println(x + " is positive");
		}
	}
	
	public static boolean isNegative(int x) {//task6
		if(x<0) {
			return true;
		}
		return false;
	}
	
	public static void sayHelloTo (String name) {//task7
		System.out.println("Привет, " + name + "!");
	}
	
	public static void isYear(int x) {//task8
		if(x % 4 == 0 && x % 100 != 0 || x % 400 == 0) {
			System.out.println("Год " + x + " високосный");
		}else {
			System.out.println("Год " + x + " невисокосный");
		}	
	}
}
