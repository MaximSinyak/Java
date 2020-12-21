package ru.geekbrains.Lesson_1;

import java.util.Scanner;

import static java.util.Scanner.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        byte bt = 10;
        short st = 32;
        int it = 50;
        long lg = 12456L;
        float ft = 1.2f;
        double dl = 3.14;
        char cr = 'q';
        boolean bn = true;


        System.out.println("Для подсчета a * (b + (c / d)) введите 4 числа");
        float input_nubmer1 = scanner.nextFloat();
        float input_nubmer2 = scanner.nextFloat();
        float input_nubmer3 = scanner.nextFloat();
        float input_nubmer4 = scanner.nextFloat();
        System.out.println(calculate(input_nubmer1, input_nubmer2, input_nubmer3, input_nubmer4));

        System.out.println("Чтобы проверить сумму введите 2 числа");
        int input_nubmer5 = scanner.nextInt();
        int input_nubmer6 = scanner.nextInt();
        System.out.println(task10and20(input_nubmer5, input_nubmer6));

        System.out.println("Введите число, чтобы проверить положительное ли оно");
        int input_nubmer7 = scanner.nextInt();
        isPositiveOrNegativ(input_nubmer7);

        System.out.println("Введите число, чтобы проверить отрицательное ли оно");
        int input_nubmer8 = scanner.nextInt();
        System.out.println(isNegativ(input_nubmer8));

        System.out.println("Как Вас зовут?");
        String input_name = scanner.next();
        greetings(input_name);

        System.out.println("Введите год");
        int input_year = scanner.nextInt();
        leapYear(input_year);
    }

    public static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean task10and20 (int a, int b) {
        boolean c = (boolean) ((a + b) >= 10 & (a + b) <= 20);
        return c ;
    }

    public static void isPositiveOrNegativ (int a) {
        if (a >= 0) System.out.println("Положительное");
        else System.out.println("Отрицательное");
    }

    public static boolean isNegativ (int a) {
        boolean c = (boolean) (a < 0);
        return c ;
    }

    public static void greetings (String a) {
        System.out.println("Привет, " + a + "!");
    }

    public static void leapYear (int a) {
        if ((((a % 4) == 0) ^ (((a % 100) == 0))) | ((a % 400) == 0)) System.out.println("Год " + a + " - високосный");
        else System.out.println("Год " + a + " - не високосный");
    }
}
