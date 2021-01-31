package ru.geekbrains.Lesson1;

public class Racetrack implements Action {
    private int distanse;
    private boolean overcome;

    public  Racetrack (int distanse){
        this.distanse = distanse;
    }

    public int getDistanse(){
        return distanse;
    }


    @Override
    public boolean action (String name, int run, int distanse){

        if (run >= distanse){
            System.out.println(name + " преодолел препятствие");
            overcome = true;
        }
        else overcome = false;
        return overcome;
    }
}
