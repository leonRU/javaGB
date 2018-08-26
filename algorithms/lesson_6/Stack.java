package lesson_6;

public class Stack{
	private int maxSize;
	private Node[] stack;
	private int top;
	
	public Stack(int size){
		this.maxSize = size;
		this.stack = new Node[this.maxSize];
		this.top = -1;
	}
	
	public void push(Node i){
		this.stack[++this.top] = i;
	}

	public Node pop(){
		return this.stack[this.top--];
	}

	public Node peek(){
		return this.stack[this.top];
	}
	
	public boolean isEmpty(){
		return (this.top == -1);
	}

	public boolean isFull(){
		return (this.top == this.maxSize-1);
	}
}