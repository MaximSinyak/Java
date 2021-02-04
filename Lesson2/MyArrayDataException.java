package ru.geekbrains.Lesson2;

public class MyArrayDataException extends ClassCastException{
    public MyArrayDataException() {}
    public MyArrayDataException(String gripe) {
        super(gripe);
    }
}
