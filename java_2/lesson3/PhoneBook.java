package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    Map<String, Set<String>> phonebook = new HashMap<>();

    public void add(String name, String phonenumber){
        Set<String> numbers = phonebook.get(name);

        if(numbers == null) {
            numbers = new HashSet<>();
        }

        numbers.add(phonenumber);
        phonebook.put(name,numbers);
    }

    public Set<String> get(String name){
        return phonebook.get(name);
    }
}
