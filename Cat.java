package ru.geekbrains.lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAppetite(int appetite){
        this.appetite = appetite;
    }

    public int getAppetite(){
        return appetite;
    }

    public void setSatiety(boolean satiety){
        this.satiety = satiety;
    }

    public boolean getSatiety(){
        return satiety;
    }

    public void info () {
        System.out.println("cat: " + name + " " + appetite + " satiety: " + satiety);
    }

}
