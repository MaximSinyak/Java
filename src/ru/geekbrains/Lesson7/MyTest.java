package ru.geekbrains.Lesson7;

public class MyTest {

    @BeforeSuite
    public static void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public static void afterSuit(){
        System.out.println("AfterSuit");
    }

    @Test(priority = 1)
    public static void test1(){
        System.out.println("Test lowest priority");
    }

    @Test(priority = 5)
    public static void test2(){
        System.out.println("Test highest priority");
    }

    @Test(priority = 10)
    public static void test3(){
        System.out.println("Test middle priority");
    }
}
