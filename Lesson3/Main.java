package ru.geekbrains.Lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] array = {"технология", "ситуация", "разработка", "целое", "книга", "польза", "заседание", "разработка", "модель", "книга", "перспектива", "наблюдение", "администрация", "технология", "книга", "уход", "передача", "здание", "язык", "сбор"};

        Map<String, Integer> map = new HashMap<>();
        for (String i : array){
            String word = i;
            int val = map.getOrDefault(word, 0);
            map.put(word, val + 1);
        }
        System.out.println(map);


//        Для тестирования 2 задания
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", 7788 );
        phonebook.add("Иванов", 9965 );
        phonebook.add("Иванов", 99690 );
        phonebook.add("Петров", 99876 );
        phonebook.add("Сидоров", 99986 );
        phonebook.add("Сидоров", 99236 );
        System.out.println(phonebook.get("Сидоров"));

    }
}
