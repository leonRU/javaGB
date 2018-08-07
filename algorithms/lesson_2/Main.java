package lesson_2;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		final int BOUND = 1000000;
		
//		1. Создать массив большого размера (миллион элементов).
		MyArr array = new MyArr(100000);
//		3. Заполнить массив случайными числами.
		Random random = new Random();
		array.fillArr(random, BOUND);
//		4. и проверить скорость
//		выполнения каждой.
		double startTime = System.currentTimeMillis();
		array.sortBubble();
		double stopTime = System.currentTimeMillis();
		System.out.println("Bubble time = " + ((stopTime - startTime)/1000) + " sec");
		
		startTime = System.currentTimeMillis();
		array.sortSelect();
		stopTime = System.currentTimeMillis();
		System.out.println("sortSelect time = " + ((stopTime - startTime)/1000) + " sec");
		
		startTime = System.currentTimeMillis();
		array.sortInsert();
		stopTime = System.currentTimeMillis();
		System.out.println("sortInsert time = " + ((stopTime - startTime)/1000) + " sec");
		//для BOUND = 100.000
		//Bubble time = 32.826 sec
		//sortSelect time = 10.13 sec
		//sortInsert time = 12.276 sec
		//для BOUND = 1.000.000 результатов за вменяемое время я не дождался

		
		
//		
//		arr.insert(-10);
//		arr.insert(45);
//		arr.insert(26);
//		arr.insert(20);
//		arr.insert(25);
//		arr.insert(40);
//		arr.insert(75);
//		arr.insert(80);
//		arr.insert(82);
//		arr.insert(91);
//		
//		int search = -10;
//		
//		System.out.println(arr.binaryFind(search));
//		
//		System.out.println("Выводим массив");
//		arr.display();
//		
//		if(arr.find(search)) {
//			arr.delete(search);
//			System.out.println("Элемент " + search + " удален");
//		}else {
//			System.out.println("Не удалось найти элемент " + search);
//		}
//		
//		System.out.println("Выводим новый массив");
//		arr.display();

	}

}
