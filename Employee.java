package ru.geekbrains.lesson_5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private int phone;
    private float salary;
    private int age;



    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getEmail(){

        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getPhone(){
        return phone;
    }

    public void setPhone(int phone){
        this.phone = phone;
    }

    public float getSalary(){
        return salary;
    }

    public void setSalary(float salary){
        this.salary = salary;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.phone = age;
    }

    public Employee(String fullName, String position, String email, int phone, float salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public static void info(String fullName, String position, String email, int phone, float salary, int age){
        System.out.println("ФИО: " + fullName + " Должность: " + position + " Email: " + email + " Телефон: " + phone + " Зарплата: " + salary + " Возраст: " + age);
    }

}

