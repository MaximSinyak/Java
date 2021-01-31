package ru.geekbrains.Lesson1exp;

public class DayOfWeekMain {

    public enum DayOfWeek{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        getWorkingHours(DayOfWeek.MONDAY);
    }

    public static void getWorkingHours(DayOfWeek dayOfWeek){
        switch (dayOfWeek) {
            case MONDAY:
                System.out.println("До конца рабочей недели осталось: " + (8.2 * 4 + 7.2));
                break;
            case TUESDAY:
                System.out.println("До конца рабочей недели осталось: " + (8.2 * 3 + 7.2));
                break;
            case WEDNESDAY:
                System.out.println("До конца рабочей недели осталось: " + (8.2 * 2 + 7.2));
                break;
            case THURSDAY:
                System.out.println("До конца рабочей недели осталось: " + (8.2 + 7.2));
                break;
            case FRIDAY:
                System.out.println("До конца рабочей недели осталось: " + 7.2);
                break;
            case SATURDAY:
                System.out.println("Сегодня выходной");
                break;
            case SUNDAY:
                System.out.println("Сегодня выходной");
                break;

        }
    }
}
