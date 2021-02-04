package ru.geekbrains.Lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException() {}
    public MyArraySizeException(String gripe) {
        super(gripe);
    }

}
