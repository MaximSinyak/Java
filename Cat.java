package ru.geekbrains.lesson_6;

public class Cat extends Animal {

    public Cat (String name, int runDistance, int swimDistance){
        super(name, runDistance,swimDistance);
    }

    @Override
    public void run() {
        if (getRunDistance() <= 200) {
           System.out.println(getName() + " пробежал " + getRunDistance() + " м.");
        }
        else {
            System.out.println(getName() + " не пробежит " + getRunDistance() + " м.");
        }
    }

    @Override
    public void swim() {
        System.out.println("Коты не плавают.");
    }

}
