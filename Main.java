package ru.geekbrains.lesson_5;



public class Main {

    public static void main(String[] args) {
        Employee[] persArray = new Employee[5]; // Вначале объявляем массив объектов
        persArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", 892312312, 30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Employee("Petrov Pavel", "Engineer", "petrov@mailbox.com", 894077360, 50000, 45);
        persArray[2] = new Employee("Sidorov Semen", "Engineer", "sidorov@mailbox.com", 896356541, 30000, 29);
        persArray[3] = new Employee("Popov Dmitrij", "Engineer", "popov@mailbox.com", 894840658, 60000, 50);
        persArray[4] = new Employee("Tihomirov Ruslan", "Engineer", "tihomirov@mailbox.com", 899597566, 40000, 39);



       for (Employee i : persArray){
           if (i.getAge() > 40) Employee.info(i.getFullName(), i.getPosition(), i.getEmail(), i.getPhone(), i.getSalary(), i.getAge());
       }



    }
}

