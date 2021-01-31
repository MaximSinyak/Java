package ru.geekbrains.Lesson1;

public class Wall implements Action{
    private int height;
    private boolean overcome;

    public  Wall (int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }


    @Override
    public boolean action (String name, int jump, int height){

        if (jump >= height){
            System.out.println(name + " преодолел препятствие");
            overcome = true;
        }
        else overcome = false;
        return overcome;
    }
}
