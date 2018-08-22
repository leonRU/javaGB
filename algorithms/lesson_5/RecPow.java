package lesson_5;

public class RecPow {
	public static void main(String[] args) {
		int number = 2;
		int degree = 5;
		System.out.println(pow(number,degree));
	}

	public static int pow(int number, int degree) {
		if(degree == 1) {
			return number;
		}
		return number * pow(number, degree - 1);
	}
}
