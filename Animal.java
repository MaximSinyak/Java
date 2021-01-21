package ru.geekbrains.lesson_6;

public abstract class Animal {

    private String name;
    private int runDistance;
    private int swimDistance;


    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getRunDistance(){
        return runDistance;
    }

    public void setRunDistance(int runDistance){
        this.runDistance = runDistance;
    }

    public int getSwimDistance(){
        return swimDistance;
    }

    public void setSwimDistance(int swimDistance){
        this.swimDistance = swimDistance;
    }


    public Animal(String name, int runDistance, int swimDistance){
        this.name = name;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
    }

    public abstract void run ();

    public abstract void swim ();
}
