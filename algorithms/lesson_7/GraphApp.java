package lesson_7;

public class GraphApp {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A', 1);
		graph.addVertex('B', 20);
		graph.addVertex('C', 5);
		graph.addVertex('D', 5);
		graph.addVertex('E', 6);
		graph.addVertex('F', 7);
		graph.addVertex('G', 43);
		graph.addVertex('H', 44);
		graph.addVertex('I', 12);
		graph.addVertex('J', 33);
		
		graph.addEdge(0, 1);//AB
		graph.addEdge(0, 2);//AC
		graph.addEdge(1, 2);//BC
		graph.addEdge(1, 9);//BJ
		graph.addEdge(2, 9);//CJ
		graph.addEdge(0, 3);//AD
		graph.addEdge(3, 4);//DE
		graph.addEdge(4, 7);//DH
		graph.addEdge(7, 9);//HJ
		
	//	graph.dfs();
		//A-B-J = 20 + 33 = 53
		//A-C-J = 5 + 33 = 38
		graph.bfs(0, 9);	
	}

}
