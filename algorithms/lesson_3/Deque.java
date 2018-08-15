package lesson_3;

public class Deque {
	private int maxSize;
	private int[] Deque;
	private int head;
	private int tail;
	private int items;

	public Deque(int s){
		maxSize = s;
		Deque = new int[maxSize];
		head = 0;
		tail = 0;
	}
	
	public void insertLeft(int i) {
		Deque[head] = i;
		if(--head < 0) {
			head = maxSize - 1;
		}
	}
	
	public int removeLeft(){
		if(++head == maxSize) {
			head = 0;
		}			
		return Deque[head];
	}
	
	public void insertRight(int i){
		if(++tail == maxSize) {
			tail = 0;
		}
		Deque[tail] = i;
	}
	
	public int removeRight(){
		int temp = Deque[tail];
		if(--tail < 0) {
			tail = maxSize - 1;
		}
		return temp;
	}
	
	
	public boolean isEmpty(){
		return (items==0);
	}
	
	public boolean isFull(){
		return (items==maxSize);
	}
	
	public int size(){
		return items;
	}
}