package ru.geekbrains.Lesson1;

public class Human {
    private String name;
    private int run;
    private  int jump;

    public Human(String name, int run, int jump) {
        this.name = name;
        this.run = run;
        this.jump = jump;
    }

    public String getName(){
        return name;
    }

    public int getRun(){
        return run;
    }

    public  int getJump(){
        return jump;
    }

    public void info() {
        System.out.println(name + " пробегает дистанцию " + run + " метров и перепрыгивает через стену " + jump + " метров.");
    }
}
