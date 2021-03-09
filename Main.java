package ru.geekbrains.Lesson1;

import ru.geekbrains.Lesson1.fruits.Apple;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String  [] array = {"fruit", "apple", "orange"};
        swap(array, 0 , 2);
        ArrayList<String> arrayList = arrayToArrayList(array);
        System.out.println(arrayList);

    }
    public static <T> ArrayList<T> arrayToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }


    public static <T> void swap(T[] array, int i1, int i2) {
        if (i1 < array.length && i2 < array.length) {
            T temp = array[i1];
            array[i1] = array[i2];
            array[i2] = temp;
        }
    }


}
