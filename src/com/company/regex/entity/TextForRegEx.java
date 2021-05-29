package com.company.regex.entity;

import java.util.Scanner;

public class TextForRegEx {
    private String textForRegularExpression;

    public TextForRegEx(String textForRegularExpression) {
        this.textForRegularExpression = textForRegularExpression;
    }

    public static TextForRegEx getTextForRegExFromConsole() {
        var scanner = new Scanner(System.in);
        System.out.println("Введите обрабатываемую строку: ");
        return new TextForRegEx(scanner.nextLine());
    }

    public String getTextForRegularExpression() {
        return textForRegularExpression;
    }

    public void setTextForRegularExpression(String textForRegularExpression) {
        this.textForRegularExpression = textForRegularExpression;
    }

/*    public void setTextForRegExFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите обрабатываемую строку: ");
        textForRegularExpression = scanner.nextLine();
    }*/
}
