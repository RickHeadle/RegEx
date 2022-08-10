package regex.entity;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
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

    public static RegEx getRegularExpressionFromConsole() {
        var scanner = new Scanner(System.in);
        log.info("Введите регулярное выражение:");
        return new RegEx(scanner.nextLine());
    }

}
