package regex.operation;

import lombok.extern.slf4j.Slf4j;
import regex.entity.RegEx;
import regex.entity.TextForRegEx;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Slf4j
public class RegExFindOperation {

    protected RegExFindOperation() {
        //Устранение нарушения правила SonarLint (java:S1118)
        throw new IllegalStateException("Utility class");
    }

    public static String findFromConsole() {
        return find(getRegularExpressionForSearchFromConsole(), TextForRegEx.getTextForRegExFromConsole());
    }

    public static String find(String regularExpression, String textForRegularExpression) {
        return find(new RegEx(regularExpression), new TextForRegEx(textForRegularExpression));
    }

    public static String find(RegEx regularExpression, TextForRegEx textForRegularExpression) {
        return find(regularExpression, textForRegularExpression, true);
    }

    public static String find(RegEx regularExpression, TextForRegEx textForRegularExpression, boolean isPrettyOutputRequired) {
        return find(regularExpression, textForRegularExpression, 0, isPrettyOutputRequired);
    }

    public static String find(RegEx regularExpression, TextForRegEx textForRegularExpression, int groupNumber) {
        return find(regularExpression, textForRegularExpression, groupNumber, true);
    }

    public static String find(RegEx regularExpression, TextForRegEx textForRegularExpression, int groupNumber, boolean isPrettyOutputRequired) {
        Pattern pattern;
        try {
            pattern = Pattern.compile(regularExpression.getRegularExpression());
        } catch (PatternSyntaxException patternSyntaxException) {
            //В случае, если введен некорректный паттерн, он будет преобразован в паттерн поиска пустого значения.
            //Не уверен что это правильное решение, возможно впоследствии будет изменено.
            pattern = Pattern.compile("^$");
        }
        var matcher = pattern.matcher(textForRegularExpression.getTextForRegularExpression());

        if (isPrettyOutputRequired) {
            return matcher.find() ? String.format("Найдено совпадение: '%s'", matcher.group(groupNumber)) : "Совпадения не найдено";
        }
        return matcher.find() ? matcher.group(groupNumber) : "";
    }

    public static String find(String regularExpression, String textForRegularExpression, int groupNumber, boolean isPrettyOutputRequired) {
        return find(new RegEx(regularExpression), new TextForRegEx(textForRegularExpression), groupNumber, isPrettyOutputRequired);
    }

    public static String find(String regularExpression, String textForRegularExpression, boolean isPrettyOutputRequired) {
        return find(new RegEx(regularExpression), new TextForRegEx(textForRegularExpression), isPrettyOutputRequired);
    }

    public static RegEx getRegularExpressionForSearchFromConsole() {
        var scanner = new Scanner(System.in);
        log.info("Введите регулярное выражение для поиска: ");
        return new RegEx(scanner.nextLine());
    }
}
