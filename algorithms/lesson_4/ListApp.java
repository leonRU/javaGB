package lesson_4;

public class ListApp {
    public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.insert("Василий", 21);
      list.insert("Игорь", 23);
      list.insert("Антон", 22);

      list.display();
      System.out.println();
      if (!list.isEmpty()) list.delete();

      list.display();
  }
}
