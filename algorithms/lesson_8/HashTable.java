package lesson_8;

public class HashTable {
	private int arraySize;
	private Item nonItem;
    
	
	private Item[] table;
       

    public HashTable(int size) {
        arraySize = size;
        table = new Item[arraySize];
        nonItem = new Item(-1);
    }

//    public void display() {
//        for (int i = 0; i < arraySize; i++) {
//            if (hashArray[i] != null) {
//                System.out.println(hashArray[i].getKey());
//            } else System.out.println("***");
//        }
//    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        if(table[hashVal] == null) {
        	return null;
        }else {
        	Item entry = table[hashVal];
        	while (entry != null && entry.getKey() != key) {
        		entry = entry.getNext();
        	if(entry == null) {
        		return null;
        	}else {
        		return entry;
        		}
        	}
        }
        return null;
    }

    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        
        if(table[hashVal] == null) {
        	table[hashVal] = new Item(key);
        }else {
        	Item entry = table[hashVal];
        	while(entry.getNext() != null && entry.getKey() != key) {
        		entry = entry.getNext();
        	}
        	entry.setNext(new Item(key));
        }
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        
        if(table[hashVal] != null) {
        	Item prevEntry = null;
        	Item entry = table[hashVal];
        	
        	while(entry.getNext() != null && entry.getKey() != key) {
        		prevEntry = entry;
        		entry = entry.getNext();
        	}

            if(entry.getKey() == key) {
            	if(prevEntry == null) {
            		table[hashVal] = entry.getNext();
            	}else {
            		prevEntry.setNext(entry.getNext());
            	}
            }
        }
    }

    private int getPrime(int min) {
        for (int j = min + 1; true; j++) {
            if (isPrime(j))
                return j;
        }
    }

    private boolean isPrime(int n) {
        for (int i = 1; (i * i <= n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

