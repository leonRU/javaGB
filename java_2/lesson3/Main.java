package lesson3;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args) {
        String[] words = {"a", "b", "c", "c", "a",
                          "c", "d", "e", "f", "c",
                          "a", "a", "x", "y", "z"};

        Map<String, Integer> map = new HashMap<>();

        for(String w : words){
            if (map.containsKey(w))
                map.put(w, map.get(w) + 1);
            else
                map.put(w, 1);
        }

        System.out.println("### Task 1 ###");

        System.out.println("Unique strings: " + map.size());
        System.out.println(map.entrySet());

        System.out.println();
        System.out.println("### Task 2 ###");

        PhoneBook pb = new PhoneBook();

        pb.add("Ivanov", "123565");
        pb.add("Petrov", "124542312");
        pb.add("Ivanov", "1212222");

        System.out.println(pb.get("Ivanov"));

    }
}
