package ru.geekbrains.lesson_6;

public class Dog extends Animal {
    public Dog(String name, int runDistance, int swimDistance) {
        super(name, runDistance, swimDistance);
    }

    @Override
    public void run() {
        if (getRunDistance() <= 500) {
            System.out.println(getName() + " пробежал " + getRunDistance() + " м.");
        }
        else {
            System.out.println(getName() + " не пробежит " + getRunDistance() + " м.");
        }
    }

    @Override
    public void  swim() {
        if (getSwimDistance() <= 10) {
            System.out.println(getName() + " проплыл " + getSwimDistance() + " м.");
        }
        else {
            System.out.println(getName() + " не проплывёт " + getSwimDistance() + " м.");
        }
    }
}

