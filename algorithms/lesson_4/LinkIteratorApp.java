package lesson_4;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);

        list.display();


        itr.reset();
        //ваши тесты
        itr.nextLink();
        itr.getCurrent().display();
        System.out.println(itr.atEnd());
        System.out.println(itr.deleteCurrent());
    }
}
