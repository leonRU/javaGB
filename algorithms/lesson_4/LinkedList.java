package lesson_4;

public class LinkedList {

    private Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(String name, int age) {
        Link newLink = new Link(name, age);
        newLink.next = first; //null
        first = newLink;
    }

    public Link delete() {
        Link temp = first;
        first = first.next;
        return temp;

    }

    public void display() {
        Link current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    //for iterator
    public void setFirst(Link first) {
        this.first = first;
    }

    public Link getFirst() {
        return first;
    }
}

