package ru.geekbrains.Lesson_3;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //    1. Написать программу, которая загадывает случайное число от 0 до 9 и
        //    пользователю дается 3 попытки угадать это число.
        //    При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное,
        //    или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
        //    (1 – повторить, 0 – нет).

        findNumber();


        // 2. * Создать массив из слов
        //String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
        //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        //apple – загаданное
        //apricot - ответ игрока
        //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        //Для сравнения двух слов посимвольно можно пользоваться:
        //String str = "apple";
        //char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
        //Играем до тех пор, пока игрок не отгадает слово.
        //Используем только маленькие буквы.

        findFruit();

        scanner.close();
    }

    public static void findNumber() {

        System.out.println("Ваша задача угадать число.");
        playLevel();


    }

    private static void playLevel() {
        int number = (int) (Math.random() * 9);
        int n = 0;
        while (true && n < 3) {
            System.out.println("Угадайте число от 0 до 9");
            int input_nubmer = scanner.nextInt();
            if (input_nubmer == number) {
                System.out.println("Вы угадали");
                break;
            } else if (input_nubmer > number) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше");
            }
            n++;
            if (n < 3) {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int choose = scanner.nextInt();
                if (choose == 0) break;
            } else {
                System.out.println("У вас закончились попытки угадать число");
            }
        }
    }


    public static void findFruit() {

        char[] symbols = new char[15];
        for (int i = 0; i < 15; i++) symbols[i] = '#';
        System.out.println(symbols);

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int randomWord = (int) (Math.random() * (words.length - 1));
        String word = words[randomWord];

        char[] letters = word.toCharArray();

        while (playGame(word, symbols) == false) ;

    }

    private static boolean playGame(String word, char[] symbols) {
        System.out.println("Угадайте загаданный фрукт или овощ");
        String inputWord = scanner.nextLine();

        Boolean rule = word.equals(inputWord);

        if (rule) {
            System.out.println("Вы угадали, загаданный фрукт или овощ - " + word);

        } else {
            System.out.println("Вы не угадали");
            char[] letters1 = word.toCharArray();
            char[] letters2 = inputWord.toCharArray();
            for (int i = 0; i < letters1.length && i < letters2.length; i++) {
                if (letters1[i] == letters2[i]) symbols[i] = letters1[i];
            }
            System.out.println(symbols);
        }
        return rule;
    }

}