package les3;

import java.util.Random;
import java.util.Scanner;

public class Les3b {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		do {
			int value = random.nextInt(10);
			if(game(value,sc)) {
				System.out.println("Вы угадали! Было загадано число " + value);
			}else {
				System.out.println("К сожалению, Вы проиграли. Правильный ответ " + value);
			}	
		}while(rerun(sc));
		sc.close();
	}
	
	public static boolean game(int value, Scanner sc) {
		int in;
		System.out.println("Угадайте число от 0 до 9! У вас всего 3 попытки!");
		for(int i = 1; i < 4; i++) {
			System.out.printf("Попытка %d, введите число: ", i);
			in = sc.nextInt();
			if(in == value) {
				return true;
			}
			if(in > value) {
				System.out.println("Загаданное число меньше!");
			}else {
				System.out.println("Загаданное число больше!");
			}
		}
		return false;
	}
	
	public static boolean rerun(Scanner sc) {
		int in;
		do {
			System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
			in = sc.nextInt();
		}while(in != 0 && in != 1);
		if(in == 1) {
			System.out.println("Отлично! Сыграем еще разок!");
			return true;
		}else {
			System.out.println("Как хотите! Приятного вечера, приходите еще!");
			return false;
		}
	}
}
