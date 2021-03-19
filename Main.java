package ru.geekbrains.Lesson4;

public class Main {

    static Object mon = new Object();
    static volatile char letter = 'A';

    public static void main(String[] args) {
	    new Thread(() -> {
	        try {
	            for (int i = 0; i < 5; i++) {
	                synchronized (mon) {
	                    while (letter != 'A') {
	                        mon.wait();
                        }
	                    System.out.print(letter);
	                    letter = 'B';
	                    mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
	            e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (letter != 'B') {
                            mon.wait();
                        }
                        System.out.print(letter);
                        letter = 'C';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (letter != 'C') {
                            mon.wait();
                        }
                        System.out.print(letter);
                        letter = 'A';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
