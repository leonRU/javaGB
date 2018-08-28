package lesson_7;

public class Vertex {
	public char label;
	public int cost;
	
	public boolean wasVisited;
	
	public Vertex(char label, int cost) {
		this.cost = cost;
		this.label = label;
		this.wasVisited = false;
	}
}
