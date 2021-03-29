package ru.geekbrains.Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        start(MyTest.class);
    }

    public static void start(Class<?> testClass){

        final int MIN_PRIORITY = 1;
        final int MAX_PRIORITY = 10;
        int before = 0;
        int after = 0;

        Map<Integer, Method> map = new TreeMap<>();

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                map.put(MIN_PRIORITY - 1, method);
                before++;
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                map.put(MAX_PRIORITY + 1, method);
                after++;
            }
            if (method.getAnnotation(Test.class) != null) {
                Test test = method.getAnnotation(Test.class);
                map.put(test.priority(), method);
            }
        }

        try {
            if (before > 1 || after > 1) throw new RuntimeException("Before or after method more then one time");
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        try {
            MyTest myTest = new MyTest();
            for (Integer key : map.keySet()) {
                map.get(key).invoke(myTest);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
