package lesson_2;

import java.util.Random;

public class MyArr {
	private int[] arr;
	private int size;
	
	public MyArr(int size) {
		this.arr = new int[size];
		this.size = 0;
	}
	
	public void fillArr(Random random, int bound) {
		for(int i = 0; i < this.arr.length; i++) {
			this.insert(random.nextInt(bound));
		}
	}
	
	public void display() {
		for(int i = 0; i < this.size; i++) {
			System.out.println(this.arr[i]);
		}
	}

//	2. Написать методы удаления, 
	public void delete(int value) {
		int i = 0;
		for(i = 0; i < this.size; i++) {
			if(this.arr[i] == value) break;
		}
		
		for(int j = i; j < this.size - 1; j++) {
			this.arr[j] = this.arr[j+1];
		}
		this.size--;
	}
	
//3.добавления, 
	
	public void insert(int value) {
//		int i;
//		for(i = 0; i < this.size; i++) {
//			if(this.arr[i] > value)
//				break;
//		}
//		for(int j = this.size; j > i; j--) {
//			this.arr[j] = this.arr[j-1];
//		}
//		this.arr[i] = value;
//		this.size++;
		this.arr[this.size] = value;
		this.size++;
	}
	
	//3.поиска элемента массива.
	public boolean find(int value) {
		int i;
		for(i = 0; i < this.size; i++) {
			if(this.arr[i] == value) break;
		}
		if(i == this.size) {
			return false;
		}else {
			return true;
		}
	}
	//3.поиска элемента массива.
	public boolean binaryFind(int value) {
		int bot = 0;
		int top = this.size - 1;
		int mid;
		while(bot < top) {
			mid = (bot + top) / 2;
			if(value == this.arr[mid]) {
				return true;
			}else {
				if(value < this.arr[mid]) {
					top = mid;
				}else {
					bot = mid + 1;
				}
			}
		}
		return false;
	}
	
//	4. Написать методы, реализующие рассмотренные виды сортировок 
	private void change(int a, int b) {
		int tmp = this.arr[a];
		this.arr[a] = this.arr[b];
		this.arr[b] = tmp;
	}
	
	public void sortBubble() {
		int out, in;
		for(out = this.size-1; out > 1; out--) {
			for(in = 0; in < out; in++) {
				if(this.arr[in] > this.arr[in+1]) {
					change(in,in+1);
				}
			}
		}
	}
	
	public void sortSelect() {
		int out, in, mark;
		for(out = 0; out < this.size; out++) {
			mark = out;
			for(in = out + 1; in < this.size; in++) {
				if(this.arr[in] < this.arr[mark]) {
					mark = in;
				}
			}
			change(out, mark);
		}
	}
	
	public void sortInsert() {
		int in, out;
		for(out = 1; out < this.size; out++) {
			int temp = this.arr[out];
			in = out;
			while(in > 0 && this.arr[in-1] >= temp) {
				this.arr[in] = this.arr[in-1];
				--in;
			}
			this.arr[in] = temp;
		}
	}
	

}
