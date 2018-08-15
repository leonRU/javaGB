package lesson_3;

public class PriorityQueue {
    private int maxSize;
    private int[] queue;
    private int items;

    public PriorityQueue(int s) {
        maxSize = s;
        queue = new int[maxSize];
        items = 0;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int peek() {
        return queue[items - 1];
    }

    public int remove() {
        return queue[--items];
    }

    public void insert(int item) {
        int i;
        if (isEmpty())
            queue[items++] = item;
        //
        else {
            for (i = items - 1; i >= 0; i--) {
                if (item > queue[i])
                    queue[i + 1] = queue[i];
                else
                    break;
            }
            //
            queue[i + 1] = item;
            items++;
        }
    }
}
