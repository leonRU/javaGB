package lesson_6;

import java.util.Random;

public class TreeApp {

	public static void main(String[] args) {
		int TREE_COUNT = 20;
		int NODE_COUNT = 32;
		Random random = new Random();
		
		Tree[] arrTree = new Tree[TREE_COUNT];//20 деревьев
		
		for(int i = 0; i < arrTree.length; i++) {//в цикле
			arrTree[i] = new Tree();
			for(int j = 0; j < NODE_COUNT; j++) {//глубина 6
				arrTree[i].insert(random.nextInt(200)-100);
			}
		}		

	}

}
