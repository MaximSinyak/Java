package ru.geekbrains.Lesson_2_1;

import arr.length;

public class Main {

    public static void main(String[] args) {

//        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;

        System.out.println("Задание 1");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(arr);
        System.out.println();

//        2. Задать пустой целочисленный массив размером 8.
//        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        System.out.println("Задание 2");
        fillArray();
        System.out.println();

//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
//        пройти по нему циклом, и числа меньшие 6 умножить на 2;

        System.out.println("Задание 3");
        changeArray();
        System.out.println();

//        4. Создать квадратный двумерный целочисленный массив
//        (количество строк и столбцов одинаковое) и
//        с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        System.out.println("Задание 4");
        fillDiagonal(5);
        System.out.println();

//        5. ** Задать одномерный массив и
//        найти в нем минимальный и
//        максимальный элементы (без помощи интернета);

        System.out.println("Задание 5");
        int[] arrMinMax = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        minMax(arrMinMax);
        System.out.println();

//        6. ** Написать метод, в который
//        передается не пустой одномерный целочисленный массив,
//        метод должен вернуть true, если в массиве есть место,
//        в котором сумма левой и правой части массива равны.
//        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
//        checkBalance([1, 1, 1, || 2, 1]) → true,
//        граница показана символами ||, эти символы в массив не входят.

        System.out.println("Задание 6");
        int[] arrBalance = {2, 2, 2, 1, 2, 2, 10, 1};
        checkBalance (arrBalance);
        System.out.println();

//        7. **** Написать метод, которому на вход подается одномерный массив и
//        число n (может быть положительным, или отрицательным),
//        при этом метод должен сместить все элементы массива на n позиций.
//        Элементы смещаются циклично.
//        Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//        Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
//        при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

        System.out.println("Задание 7");
        int[] arrMove = {2, 2, 2, 1, 2, 2, 10, 1};
        moveN(arrMove, 2);
        System.out.println();

    }



        public static void invertArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
        System.out.print(arr[i] + " ");
          }
       System.out.println();
         }


         public static void fillArray() {
            int[] arr = new int[8];
                for (int i = 0, n = 0; i < arr.length; i++, n += 3){
                        arr[i] = n;
                        System.out.print(arr[i] + " ");
                    }
                System.out.println();
            }

            public static void changeArray(){
                int[]w = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
                for (int i = 0; i < w.length; i++) {
                    if (w[i] < 6) w[i] *= 2;
                    System.out.print(w[i] + " ");
                }
                System.out.println();
            }

        public static void fillDiagonal(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) arr[i][j] = 1;
                if (i == Math.abs(n - 1 - j)) arr[i][j] = 1;
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
            }
                    }

        public static void minMax(int [] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("Минимальное значение - " + min + ", максимальное значение - " + max);
    }

        public static void checkBalance (int [] arr) {

            int sum = 0;
            int s = 0;
            boolean rule = false;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                s += arr[i];
                if (s == sum / 2) {
                    System.out.print("|| ");
                    rule = true;
                }
            }
            System.out.println(rule);
        }

        public static void moveN(int [] arr, int n) {

            if (n > 0) {
                for (int N = 1; N <= n; N++) {
                    int cush = arr[0];
                    for (int i = 0; i < (arr.length - 1); i++) {
                        arr[i] = arr[i + 1];
                    }
                    arr[arr.length - 1] = cush;
                }
            } else {
                for (int N = 1; N <= -n; N++) {
                    int cush = arr[arr.length - 1];
                    for (int i = (arr.length - 1); i > 0; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[0] = cush;
                }
            }
            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        }



}
