package regex.operation;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import regex.entity.RegEx;
import regex.entity.TextForRegEx;

import java.util.Scanner;
import java.util.regex.Pattern;

import static regex.operation.RegExFindOperation.find;

@Slf4j
public class RegExReplaceOperation {

    private static final String FIND_GROUP_NUMBER_WITH_UPPERCASE = "\\\\U[\\\\$](\\d)\\\\E";
    private static final String FIND_GROUP_NUMBER_WITH_LOWERCASE = "\\\\L[\\\\$](\\d)\\\\E";
    private static final String REPLACE_IN_GROUP_CONSTRUCTION = "\\$1";

    private RegExReplaceOperation() {
        throw new IllegalStateException("Utility class");
    }

    private static int getCaseChangingGroupNumber(RegEx replaceRegularExpression,
                                                  boolean isUpperCaseOperation) {
        return Integer.parseInt(
                find(
                        isUpperCaseOperation ? FIND_GROUP_NUMBER_WITH_UPPERCASE : FIND_GROUP_NUMBER_WITH_LOWERCASE,
                        replaceRegularExpression.getRegularExpression(),
                        1,
                        false));
    }

    private static String getRegExWithoutCaseChangeConstruction(RegEx replaceRegularExpression,
                                                                boolean isUpperCaseOperation) {
        return replace(
                isUpperCaseOperation ? FIND_GROUP_NUMBER_WITH_UPPERCASE : FIND_GROUP_NUMBER_WITH_LOWERCASE,
                replaceRegularExpression.getRegularExpression(),
                REPLACE_IN_GROUP_CONSTRUCTION,
                false);
    }

    /**
     * Костыль, но найти нормального решения в синтаксисе Java найти, к сожалению, не удалось. <br>
     * Парсит загруженное регулярное выражение, находит символы преобразования в верхний регистр,
     * исключает их из регулярного выражения, вручную преобразует в результате символы в верхний регистр -
     * и возвращает результат для дальнейшей обработки.
     */
    private static String replaceWithCaseChanging(RegEx searchRegularExpression,
                                                  TextForRegEx textForRegularExpression,
                                                  RegEx replaceRegularExpression,
                                                  boolean isUpperCaseOperation) {
        //Найти набор, соответствующий преобразованию группы в верхний регистр - в полученном регулярном выражении замены
        //Исключить символы преобразования в верхний регистр из регулярного выражения замены
        //Выполнить скрипт на тексте и получить группу, в которой необходим верхний регистр
        //+ преобразовать полученную группу в верхний регистр
        //Произвести в тексте замену группы на группу в верхнем регистре
        //Выполнить измененный скрипт (из которого исключена команда для верхнего регистра) на измененном тексте
        return replace(
                searchRegularExpression.getRegularExpression(),
                changeCaseInText(
                        searchRegularExpression,
                        textForRegularExpression,
                        replaceRegularExpression,
                        isUpperCaseOperation),
                getRegExWithoutCaseChangeConstruction(
                        replaceRegularExpression,
                        isUpperCaseOperation),
                false);
    }

    private static String changeCaseInText(RegEx searchRegularExpression,
                                           TextForRegEx textForRegularExpression,
                                           RegEx replaceRegularExpression,
                                           boolean isUpperCaseOperation) {
        //Выполнить рег.выражение на тексте и получить группу, в которой необходим верхний/нижний регистр
        //+ преобразовать полученную группу в верхний/нижний регистр
        String groupTextForCaseTransit =
                find(
                        searchRegularExpression.getRegularExpression(),
                        textForRegularExpression.getTextForRegularExpression(),
                        getCaseChangingGroupNumber(replaceRegularExpression, isUpperCaseOperation),
                        false);
        String groupTextCaseChanged =
                isUpperCaseOperation
                        ? groupTextForCaseTransit.toUpperCase()
                        : groupTextForCaseTransit.toLowerCase();
        //Произвести в тексте замену группы на группу в верхнем/нижнем регистре
        return textForRegularExpression.getTextForRegularExpression().replaceFirst(
                groupTextForCaseTransit,
                groupTextCaseChanged);
    }

    static boolean isUpperCaseGroupInReplaceRegEx(@NotNull RegEx replaceRegularExpression) {
        String checkResult = find(
                FIND_GROUP_NUMBER_WITH_UPPERCASE,
                replaceRegularExpression.getRegularExpression(),
                1,
                false);
        return !(checkResult.isEmpty() || checkResult.isBlank());
    }

    private static boolean isLowerCaseGroupInReplaceRegEx(@NotNull RegEx replaceRegularExpression) {
        String checkResult = find(
                FIND_GROUP_NUMBER_WITH_LOWERCASE,
                replaceRegularExpression.getRegularExpression(),
                1,
                false);
        return !(checkResult.isEmpty() || checkResult.isBlank());
    }

    /**
     * Обработка обычного регулярного выражения синтаксиса Java 8. <br>
     * Вынесено в отдельный метод для доп. проверки на наличие спецсимволов
     * перевода группы в верхний/нижний регистр, которых нет в синтаксисе Java 8.
     */
    private static String replaceJavaRegEx(RegEx searchRegularExpression,
                                           TextForRegEx textForRegularExpression,
                                           RegEx replaceRegularExpression) {
        var searchPattern = Pattern.compile(searchRegularExpression.getRegularExpression());
        return searchPattern.matcher(textForRegularExpression.getTextForRegularExpression())
                .replaceAll(replaceRegularExpression.getRegularExpression());
    }

    public static String replace(RegEx searchRegularExpression,
                                 TextForRegEx textForRegularExpression,
                                 RegEx replaceRegularExpression,
                                 boolean isPrettyOutputRequired) {

        String result = textForRegularExpression.getTextForRegularExpression();
        if (isUpperCaseGroupInReplaceRegEx(replaceRegularExpression)) {
            return prettyOutputGenerator(
                    replaceWithCaseChanging(
                            searchRegularExpression,
                            textForRegularExpression,
                            replaceRegularExpression,
                            true),
                    isPrettyOutputRequired);
        } else if (isLowerCaseGroupInReplaceRegEx(replaceRegularExpression)) {
            return prettyOutputGenerator(
                    replaceWithCaseChanging(
                            searchRegularExpression,
                            textForRegularExpression,
                            replaceRegularExpression,
                            false),
                    isPrettyOutputRequired);
        }
        return prettyOutputGenerator(
                replaceJavaRegEx(
                        searchRegularExpression,
                        new TextForRegEx(result),
                        replaceRegularExpression
                ),
                isPrettyOutputRequired);
    }

    public static String replace(RegEx searchRegularExpression,
                                 TextForRegEx textForRegularExpression,
                                 RegEx replaceRegularExpression) {
        return replace(
                searchRegularExpression,
                textForRegularExpression,
                replaceRegularExpression,
                true
        );
    }

    public static String replace(String searchRegularExpression,
                                 String textForRegularExpression,
                                 String replaceRegularExpression) {
        return replace(
                searchRegularExpression,
                textForRegularExpression,
                replaceRegularExpression,
                true
        );
    }

    public static String replace(String searchRegularExpression,
                                 String textForRegularExpression,
                                 String replaceRegularExpression,
                                 boolean isPrettyOutputRequired) {
        return replace(
                new RegEx(searchRegularExpression),
                new TextForRegEx(textForRegularExpression),
                new RegEx(replaceRegularExpression),
                isPrettyOutputRequired
        );
    }

    public static String replaceFromConsole() {
        return replace(
                RegExFindOperation.getRegularExpressionForSearchFromConsole(),
                TextForRegEx.getTextForRegExFromConsole(),
                getRegularExpressionForReplaceFromConsole()
        );
    }

    static String prettyOutputGenerator(String text, boolean isPrettyOutputRequired) {
        if (isPrettyOutputRequired) {
            return !text.isBlank() ? "Новая строка: " + text : "Совпадения не найдено";
        } else {
            return text;
        }
    }

    public static boolean isUpperCaseGroupInReplaceRegEx(String replaceRegularExpression) {
        return isUpperCaseGroupInReplaceRegEx(new RegEx(replaceRegularExpression));
    }

    public static void replaceMultipleTimes(RegEx searchRegularExpression,
                                            TextForRegEx textForRegularExpression,
                                            RegEx replaceRegularExpression,
                                            byte operationNumber,
                                            boolean isPrettyOutputRequired) {
        final var RESULT_INFO = "Результат: %s";
        /*Нам нужно проверить возможность выполнения нескольких последовательных операций замены
        Пока просто мысли вслух, проработаем алгоритм.
        Мы должны получать все те же данные, что и для обычной замены
        Текст для замены будет браться из предыдущей итерации*/
        if (operationNumber < 1) {
            throw new IllegalArgumentException("Получено недопустимое значение числа итераций для операции замены");
        }
        var result = new StringBuilder(
                replace(
                        searchRegularExpression,
                        textForRegularExpression,
                        replaceRegularExpression,
                        false));
        if (isPrettyOutputRequired) {
            log.info("Итерация №0.");
            log.info(String.format(RESULT_INFO, result));
        }
        for (byte iteration = 1; iteration < operationNumber; iteration++) {
            //TODO: Внимание, вопрос - а как мы можем написать на эту операцию unit-test?
            result = new StringBuilder(replace(RegExFindOperation.getRegularExpressionForSearchFromConsole(), new TextForRegEx(result.toString()), getRegularExpressionForReplaceFromConsole(), false));
            if (isPrettyOutputRequired) {
                log.info(String.format("Итерация №%s.", iteration));
                log.info(String.format(RESULT_INFO, result));
            }
        }
        if (!isPrettyOutputRequired) {
            log.info(String.format(RESULT_INFO, result));
        }
    }

    public static RegEx getRegularExpressionForReplaceFromConsole() {
        var scanner = new Scanner(System.in);
        log.info("Введите регулярное выражение для замены: ");
        return new RegEx(scanner.nextLine());
    }
}