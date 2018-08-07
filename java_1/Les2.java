package les2;

import java.util.Arrays;

public class Les2 {
	public static void main(String [] args) {
		System.out.println("TASK 1: array inverting.");
		invertArray();
		System.out.println("TASK 2: fill array.");
		fillArray();
		System.out.println("TASK 3: change array.");
		changeArray();
		System.out.println("TASK 4: fill the diagonals of array.");
		fillDiagonal();
		System.out.println("TASK 5: find max and min in array.");
		findElements();
		
		System.out.println("TASK 6: checkBalance in array.");
		int[] balance_arr = new int[5]; 
		int balance_range = 10;
		for (int i = 0; i < balance_arr.length; i++) {
			balance_arr[i] = (int) (Math.random() * balance_range);			
		}
		System.out.println("Initial array: " + Arrays.toString(balance_arr));
		System.out.println(checkBalance(balance_arr));
		
		System.out.println("TASK 7: shift in array.");
		int[] shift_arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; 
		int n = 3;
		
		System.out.println("Initial array: " + Arrays.toString(shift_arr) +", shift = " + n);
		shiftArray(shift_arr, n);
		System.out.println("Final array:   " + Arrays.toString(shift_arr));
	}
	
	public static int[] shiftArray(int[] arr, int shift) { //task7 v1
		if(shift % arr.length != 0) {
			int t = 0;
			if(Math.abs(shift) > arr.length) {
				shift = shift % arr.length;	
				System.out.println("real shift = " + shift);
			}
			if(shift > 0) {
				for(int i = 0; i < shift; i++) {
					t = arr[0];
					arr[0] = arr[arr.length - 1];
					
					for (int j = 1; j < arr.length - 1; j++) {
	                    arr[arr.length - j] = arr[arr.length - 1 - j];
	                }
	                arr[1] = t;
				}
			}else {
				for(int i = 0; i > shift; i--) {
					t = arr[arr.length - 1];
					arr[arr.length - 1] = arr[0];
					
					for (int j = 1; j < arr.length - 1; j++) {
	                    arr[j-1] = arr[j];
	                }
	                arr[arr.length - 2] = t;
				}
			}
		}
		return arr;
	}

	public static void invertArray() {//task1
		int[] arr = { 1, 0, 1, 0, 0, 1 };
		System.out.println("Initial array: " + Arrays.toString(arr));
		for(int i = 0; i < arr.length; i++) {		
		arr[i] = (arr[i] == 1) ?  0 : 1;
		}
		System.out.println("Final array:   " + Arrays.toString(arr));
	}
	
	public static void fillArray() {//task2
		int[] arr = new int[8];
		System.out.println("Initial array: " + Arrays.toString(arr));
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i * 3;
		}
		System.out.println("Final array:   " + Arrays.toString(arr));	
	}
	
	public static void changeArray() {//task3
		int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
		System.out.println("Initial array: " + Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (arr[i] < 6) ? (arr[i] * 2) : arr[i];
		}
		System.out.println("Final array:   " + Arrays.toString(arr));
	}
	
	public static void printArray(int arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public static void fillDiagonal() {//task4
		int[][] arr = new int[3][3];
		System.out.println("Initial array: ");
		printArray(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (i == j) || (((arr.length - 1) - i) == j) ? 1 : 0;
			}
		}
		System.out.println("Final array:   ");
		printArray(arr);
	}
	
	private static void findElements() {//task5
		int [] arr = new int[10];
		int range = 100;
		int min;
		int max;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * range);			
		}
		System.out.println("Array: " + Arrays.toString(arr));
		min = max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}else {
				if(arr[i] > max) {
					max = arr[i];
				}
			}
		}
		System.out.println("Max = " + max + ", min = " + min + ".");		
	}
	
	private static boolean checkBalance(int[] arr){ //task6
		int check_left = 0;
		int check_right = 0;
		
		for(int i=0; i < arr.length; i++) {
			if(i < arr.length/2) {
				check_left += arr[i];
			}else {
				check_right += arr[i];
			}			
		}
		
		if(check_left == check_right) {
			System.out.println("left = right");
			return true;
		}
		
		int direction = (check_left > check_right) ? -1: 1;
		int shift = (direction > 0) ? 0 : -1;
				
		for(int k = 0; k < arr.length/2; k++) {
			check_left = check_left + direction * arr[arr.length/2 + k * direction + shift];
			check_right = check_right - direction * arr[arr.length/2 + k * direction + shift];
			
			if(check_left == check_right) {
				System.out.println("left = right = " + check_left + ", k = " + k);
				return true;
			}
			if(direction > 0 && check_left > check_right) {
				System.out.println("direction > 0 && check_left > check_right; left = " + check_left + ", right = " + check_right + ", k = " + k);
				return false;
			}
			if(direction < 0 && check_left < check_right) {
				System.out.println("direction < 0 && check_left < check_right; left = " + check_left + ", right = " + check_right + ", k = " + k);
				return false;
			}
		}
		System.out.println("exit, left = " + check_left + ", right = " + check_right + ", k = max");
		return false;
	}
}
// Console log
// TASK 1: array inverting.
// Initial array: [1, 0, 1, 0, 0, 1]
// Final array:   [0, 1, 0, 1, 1, 0]
// TASK 2: fill array.
// Initial array: [0, 0, 0, 0, 0, 0, 0, 0]
// Final array:   [0, 3, 6, 9, 12, 15, 18, 21]
// TASK 3: change array.
// Initial array: [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]
// Final array:   [2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2]
// TASK 4: fill the diagonals of array.
// Initial array: 
// [0, 0, 0]
// [0, 0, 0]
// [0, 0, 0]
// Final array:   
// [1, 0, 1]
// [0, 1, 0]
// [1, 0, 1]
// TASK 5: find max and min in array.
// Array: [73, 60, 50, 35, 49, 97, 92, 56, 59, 51]
// Max = 97, min = 35.
// TASK 6: checkBalance in array.
// Initial array: [2, 2, 3, 1, 4]
// direction > 0 && check_left > check_right; left = 7, right = 5, k = 0
// false
// TASK 7: shift in array.
// Initial array: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], shift = 3
// Final array:   [7, 8, 9, 0, 1, 2, 3, 4, 5, 6]

