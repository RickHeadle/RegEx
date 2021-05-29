package com.company.morning;

public class StaticDemo {
    public static void main(String[] args) {
        MsuStudent kolya = new MsuStudent("Kolyma", 12, 3.5);
        MsuStudent masha = new MsuStudent("Masha", 15, 4.9);

        System.out.println(kolya.college);
    }
}
