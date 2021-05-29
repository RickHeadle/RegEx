package com.company.regex.entity;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class RegEx {
    private String regularExpression;

    public RegEx(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRegularExpression() {
        return regularExpression;
    }

    public void setRegularExpression(String regularExpression) {
        this.regularExpression = regularExpression;
    }

/*    public void setRegularExpressionFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите регулярное выражение: ");
        regularExpression = scanner.nextLine();
    }*/

}
