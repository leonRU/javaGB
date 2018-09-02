package lesson_8;


public class Item {
	private int key;
	private Item next;
	
	public Item(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public Item getNext() {
		return next;
	}
	
	public void setNext(Item next) {
		this.next = next;
	}

}
