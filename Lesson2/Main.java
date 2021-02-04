package ru.geekbrains.Lesson2;

public class Main {

    private static int sum = 0;

    public static void main(String[] args) {
	// write your code here
      String[][] a = {{"2", "5", "8", "12"}, {"45", "55", "36", "5"}, {"33", "4", "16", "6"}, {"53", "67", "7", "31" }};
      String[][] b = {{"2", "5", "8", "12"}, {"33", "4", "16", "6"}, {"53", "67", "7", "31" }};
      String[][] c = {{"2", "5", "12"}, {"45", "55", "36", "5"}, {"33", "4", "16", "6"}, {"53", "67", "7", "31" }};
      String[][] d = {{"2", "5", "8", "12"}, {"45", "abc", "36", "5"}, {"33", "4", "a", "6"}, {"53", "c", "7", "31" }};


      array(a);
      array(b);
      array(c);
      array(d);
    }

    public static void array(String arr[][]){
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i ++ ){
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++){
                try {
                    int n = Integer.parseInt(arr[i][j]);
                    sum += n;
                } catch (MyArrayDataException e){
                    e.printStackTrace();
                    System.err.println(e.getMessage());
                }

            }
        }
        System.out.println(sum);
    }
}
