package ru.geekbrains.lesson_6;

public class Main {
    private static int countCat = 0;
    private static int countDog = 0;

     public static void main(String[] args){
         makeCat("Barsik", 30, 40);
         makeCat("Murzik", 250, 4);
         makeDog("Tuzik", 400, 4);
         makeDog("Sharik", 600, 9);
         makeDog("Barbos", 300, 20);
System.out.println("Создано: кошек - " + countCat +  "; собак - " + countDog);

     }

     public static int makeCat(String name, int run, int swim){
         Cat cat = new Cat(name, run, swim);
         cat.run();
         cat.swim();
         return countCat++;
     }

    public static int makeDog(String name, int run, int swim){
        Dog dog = new Dog(name, run, swim);
        dog.run();
        dog.swim();
        return countDog++;
    }

}
