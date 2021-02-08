package ru.geekbrains.Lesson3;

import java.util.*;



public class Phonebook {

    Map<Integer, String> phoneBookMap = new HashMap<>();

    public void add(String name, int phoneNumber){
        phoneBookMap.put(phoneNumber, name);
    }

    public List<Integer> get(String name) {
        ArrayList <Integer> numberList = new ArrayList<>();
        for (Map.Entry<Integer, String> i : phoneBookMap.entrySet()) {
            if (i.getValue().equals(name)) numberList.add(i.getKey());
        }
        return numberList;
    }


}
