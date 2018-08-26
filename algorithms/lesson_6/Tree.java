package lesson_6;

public class Tree {
	private Node root;
	
	public Node find(int key) {
		Node current = root;
		while(current.key != key) {
			if(key < current.key) {
				current = current.leftChild;
			}else {
				current = current.rightChild;
			}
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	
	public void insert(int key) {
		Node node = new Node();
		node.key = key;
		if(root == null) {
			root = node;
		}else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(key < current.key) {
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = node;
						return;
					}
				}else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = node;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.key != key) {
			parent = current;
			if(key < current.key) {
				isLeftChild = true;
				current = current.leftChild;
			}else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null) {
				return false;
			}
		}
		
		//если узел не имеет потомков
		
		if(current.leftChild == null && current.rightChild == null) {
			if(current == root) {
				root = null;
			}else
				if(isLeftChild) {
					parent.leftChild = null;
				}else {
					parent.rightChild = null;
				}
		}
		
		//если нет левого потомка
		
		else
			if(current.leftChild == null) {
				if(current == root) {
					root = current.rightChild;
				}else
					if(isLeftChild) {
						parent.leftChild = current.rightChild;
					}else {
						parent.rightChild = current.rightChild;
					}
			}else {
				Node successor = getSuccesor(current);
				if(current == root) {
					root = successor;
				}else
					if(isLeftChild) {
						parent.leftChild = successor;
					}else {
						parent.rightChild = successor;
					}
				successor.leftChild = current.leftChild;
			}
		return true;		
	}

	public Node getSuccesor(Node node) {
		Node successorParent = node;
		Node successor = node;
		Node current = node.rightChild;
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != node.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = node.rightChild;
		}
		return successor;
	}
	
	public void traverse(int traverseType) {
		switch(traverseType) {
			case 1: System.out.println("Preorder traversal");
			preOrder(root);
			break;
			case 2: System.out.println("Postorder traversal");
			postOrder(root);
			break;
			case 3: System.out.println("Inorder traversal");
			inOrder(root);
			break;
		}
	}
	
	private void preOrder(Node rootNode) {
		if(rootNode != null) {
			rootNode.display();
			preOrder(rootNode.leftChild);
			preOrder(rootNode.rightChild);
		}
	}
	
	private void postOrder(Node rootNode) {
		if(rootNode != null) {
			postOrder(rootNode.leftChild);
			postOrder(rootNode.rightChild);
			rootNode.display();
		}
	}
	
	private void inOrder(Node rootNode) {
		if(rootNode != null) {
			inOrder(rootNode.leftChild);
			rootNode.display();
			inOrder(rootNode.rightChild);
		}
	}
	
	public void displayTree() {
		Stack stack = new Stack(100);
		stack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		
		while(isRowEmpty == false) {
			Stack localStack = new Stack(100);
			isRowEmpty = true;
			for(int i = 0; i < nBlanks; i++) {
				System.out.println(" ");
			}
			while(stack.isEmpty() == false) {
				Node temp = stack.pop();
				if(temp != null) {
					temp.display();
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null || temp.rightChild != null) {
						isRowEmpty = false;
					}
				}else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j = 0; j < nBlanks * 2 - 2; j++) {
					System.out.print(' ');
					
				}
			}
			System.out.println(" ");
			nBlanks = nBlanks / 2;
			while(localStack.isEmpty() == false) {
				stack.push(localStack.pop());
			}
			System.out.println("....................................................");
		}
	}	
}
