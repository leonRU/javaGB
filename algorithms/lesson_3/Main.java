package lesson_3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "name";
		Stack sc = new Stack(s.length());
		
		for(int i = 0; i < s.length(); i++) {
			sc.push(s.charAt(i));
		}
//		System.out.println(sc.peek());
		System.out.println(s);
		
		StringBuilder newStr = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			newStr.append(sc.pop());
		}
		System.out.println(newStr);
		
		
		Deque d = new Deque(10);
		d.insertRight(1);
		d.insertRight(2);
		d.insertRight(5);
		System.out.println(d.removeLeft());
	}

}
