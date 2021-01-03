package ru.geekbrains.Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интелект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void aiTurn() {
        int x, y;
        boolean move = false;

//            проверить наличие 3-х Х, стоящих рядом
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < (SIZE - 2); j++) {
                if (map[i][j] == DOT_X && map[i][j + 1] == DOT_X && map[i][j + 2] == DOT_X && !move) {
                    if ((j - 1 >= 0) && (map[i][j - 1] == DOT_EMPTY)) {
                        map[i][j - 1] = DOT_O;
                        move = true;
                        break;
                    } else if ((j + 3 < SIZE) && (map[i][j + 3] == DOT_EMPTY)) {
                        map[i][j + 3] = DOT_O;
                        move = true;
                        break;
                    }
                }
            }
        }


        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < (SIZE - 2); i++) {
                if (map[i][j] == DOT_X && map[i + 1][j] == DOT_X && map[i + 2][j] == DOT_X && !move) {
                    if ((i - 1 >= 0) && (map[i - 1][j] == DOT_EMPTY)) {
                        map[i - 1][j] = DOT_O;
                        move = true;
                        break;
                    } else if ((i + 3 < SIZE) && (map[i + 3][j] == DOT_EMPTY)) {
                        map[i + 3][j] = DOT_O;
                        move = true;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < (SIZE - 2); i++) {
            for (int j = 0; j < (SIZE - 2); j++) {
                if (map[i][j] == DOT_X && map[i + 1][j + 1] == DOT_X && map[i + 2][j + 2] == DOT_X && !move) {
                    if ((i - 1 >= 0) && (j - 1 >= 0) && (map[i - 1][j - 1] == DOT_EMPTY)) {
                        map[i - 1][j - 1] = DOT_O;
                        move = true;
                        break;
                    } else if ((i + 3 < SIZE) && (j + 3 < SIZE) && (map[i + 3][j + 3] == DOT_EMPTY)) {
                        map[i + 3][j + 3] = DOT_O;
                        move = true;
                        break;
                    }
                } else if (map[4 - i][j] == DOT_X && map[3 - i][j + 1] == DOT_X && map[2 - i][j + 2] == DOT_X && !move) {
                    if ((5 - i < SIZE) && (j - 1 >= 0) && (map[5 - i][j - 1] == DOT_EMPTY)) {
                        map[5 - i][j - 1] = DOT_O;
                        move = true;
                        break;
                    } else if ((1 - i >= 0) && (j + 3 < SIZE) && (map[1 - i][j + 3] == DOT_EMPTY)) {
                        map[1 - i][j + 3] = DOT_O;
                        move = true;
                        break;
                    }
                }
            }
        }

//      проверить Х, стоящие через клетку
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < (SIZE - 2); j++) {
                if (map[i][j] == DOT_X && map[i][j + 2] == DOT_X && !move) {
                    map[i][j + 1] = DOT_O;
                    move = true;
                    break;
                }
            }
        }


        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < (SIZE - 2); i++) {
                if (map[i][j] == DOT_X && map[i + 2][j] == DOT_X && !move) {
                    map[i + 1][j] = DOT_O;
                    move = true;
                    break;

                }
            }
        }

//            проверить наличие 2-х Х, стоящих рядом

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < (SIZE - 1); j++) {
                if (map[i][j] == DOT_X && map[i][j + 1] == DOT_X && !move) {
                    if ((j - 1 >= 0) && (map[i][j - 1] == DOT_EMPTY)) {
                        map[i][j - 1] = DOT_O;
                        move = true;
                        break;
                    } else if ((j + 2 < SIZE) && (map[i][j + 2] == DOT_EMPTY)) {
                        map[i][j + 2] = DOT_O;
                        move = true;
                        break;
                    }
                }
            }
        }


        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < (SIZE - 1); i++) {
                if (map[i][j] == DOT_X && map[i + 1][j] == DOT_X && !move) {
                    if ((i - 1 >= 0) && (map[i - 1][j] == DOT_EMPTY)) {
                        map[i - 1][j] = DOT_O;
                        move = true;
                        break;
                    } else if ((i + 2 < SIZE) && (map[i + 2][j] == DOT_EMPTY)) {
                        map[i + 2][j] = DOT_O;
                        move = true;
                        break;
                    }
                }
            }
        }


        for (int i = 0; i < (SIZE - 1); i++) {
            for (int j = 0; j < (SIZE - 1); j++) {
                if (map[i][j] == DOT_X && map[i + 1][j + 1] == DOT_X && !move) {
                    if ((i - 1 >= 0) && (j - 1 >= 0) && (map[i - 1][j - 1] == DOT_EMPTY)) {
                        map[i - 1][j - 1] = DOT_O;
                        move = true;
                        break;
                    } else if ((i + 2 < SIZE) && (j + 2 < SIZE) && (map[i + 2][j + 2] == DOT_EMPTY)) {
                        map[i + 2][j + 2] = DOT_O;
                        move = true;
                        break;
                    }
                } else if (map[4 - i][j] == DOT_X && map[3 - i][j + 1] == DOT_X && !move) {
                    if ((5 - i < SIZE) && (j - 1 >= 0) && (map[5 - i][j - 1] == DOT_EMPTY)) {
                        map[5 - i][j - 1] = DOT_O;
                        move = true;
                        break;
                    } else if ((2 - i >= 0) && (j + 2 < SIZE) && (map[2 - i][j + 2] == DOT_EMPTY)) {
                        map[2 - i][j + 2] = DOT_O;
                        move = true;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < (SIZE - 2); i++) {
            for (int j = 0; j < (SIZE - 2); j++) {
                if (map[i][j] == DOT_X && map[i + 2][j + 2] == DOT_X && !move) {
                    map[i + 1][j + 1] = DOT_O;
                    move = true;
                    break;

                } else if (map[4 - i][j] == DOT_X && map[2 - i][j + 2] == DOT_X && !move) {
                    map[3 - i][j + 1] = DOT_O;
                    move = true;
                    break;

                }
            }
        }

        if (!move) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }
            while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
    }


    public static boolean checkWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[i][j] == symb && map[i][j + 1] == symb && map[i][j + 2] == symb && map[i][j + 3] == symb)
                    return true;
            }
        }
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < 2; i++) {
                if (map[i][j] == symb && map[i + 1][j] == symb && map[i + 2][j] == symb && map[i + 3][j] == symb)
                    return true;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[i][j] == symb && map[i + 1][j + 1] == symb && map[i + 2][j + 2] == symb && map[i + 3][j + 3] == symb)
                    return true;
                if (map[4 - i][j] == symb && map[3 - i][j + 1] == symb && map[2 - i][j + 2] == symb && map[1 - i][j + 3] == symb)
                    return true;
            }
        }
        return false;
    }


    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}
