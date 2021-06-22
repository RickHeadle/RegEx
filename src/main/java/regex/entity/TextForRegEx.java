package regex.entity;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class TextForRegEx {
    private String textForRegularExpression;

    public TextForRegEx(String textForRegularExpression) {
        this.textForRegularExpression = textForRegularExpression;
    }

    public static TextForRegEx getTextForRegExFromConsole() {
        var scanner = new Scanner(System.in);
        log.info("Введите обрабатываемую строку: ");
        return new TextForRegEx(scanner.nextLine());
    }

    public String getTextForRegularExpression() {
        return textForRegularExpression;
    }

    public void setTextForRegularExpression(String textForRegularExpression) {
        this.textForRegularExpression = textForRegularExpression;
    }
}