package regex.operation;

import regex.entity.RegEx;
import regex.entity.TextForRegEx;

import java.util.regex.Pattern;

public class RegExFindOperation {

    //    Находит все группы, вне зависимости от преобразования регистра
//    private static final String FIND_UPPERCASE_IN_GROUP_CONSTRUCTION = "(?:\\\\U)?([\\\\$]\\d)(?:\\\\E)?";

    protected RegExFindOperation() {
        //Устранение нарушения правила SonarLint (java:S1118)
        throw new IllegalStateException("Utility class");
    }

    public static String findFromConsole() {
        return find(RegExReplaceOperation.getRegularExpressionFromConsole(), TextForRegEx.getTextForRegExFromConsole());
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
        var pattern = Pattern.compile(regularExpression.getRegularExpression());
        var matcher = pattern.matcher(textForRegularExpression.getTextForRegularExpression());

        if (isPrettyOutputRequired) {
            return matcher.find() ? "Найдено совпадение: " + matcher.group(groupNumber) : "Совпадения не найдено";
        }
        return matcher.find() ? matcher.group(groupNumber) : "";
    }

    public static String find(String regularExpression, String textForRegularExpression, int groupNumber, boolean isPrettyOutputRequired) {
        return find(new RegEx(regularExpression), new TextForRegEx(textForRegularExpression), groupNumber, isPrettyOutputRequired);
    }

    public static String find(String regularExpression, String textForRegularExpression, boolean isPrettyOutputRequired) {
        return find(new RegEx(regularExpression), new TextForRegEx(textForRegularExpression), isPrettyOutputRequired);
    }

}
