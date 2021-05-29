package com.company.regex.test;

import com.company.regex.entity.RegEx;
import com.company.regex.entity.TextForRegEx;
import com.company.regex.operation.RegExOperations;
import com.company.regex.operation.RegExReplaceOperation;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class RegExTest {
    private static final String SEARCH_REGULAR_EXPRESSION_EXAMPLE = "^\\[?(\\w{5})(?:\\-{1,5})(\\d{3,4})\\]?";
    private static final String TEXT_FOR_REG_EX_EXAMPLE = "[rOrkO---2482 Рефакторинг автоскролла bfb7dbcf";
    private static final String REPLACE_REGULAR_EXPRESSION_LOWERCASE_EXAMPLE = "\\[\\L$1\\E\\-$2\\]";
    private static final String REPLACE_REGULAR_EXPRESSION_UPPERCASE_EXAMPLE = "\\[\\U$1\\E\\-$2\\]";

    @Test
    public void checkFind() {
        var regularExpression = new RegEx(SEARCH_REGULAR_EXPRESSION_EXAMPLE);
        var textForRegularExpression = new TextForRegEx(TEXT_FOR_REG_EX_EXAMPLE);
        assertEquals("Найдено совпадение: [rOrkO---2482", RegExOperations.find(regularExpression, textForRegularExpression));
    }

    @Test
    public void checkReplace() {
        final var searchRegularExpression = new RegEx(SEARCH_REGULAR_EXPRESSION_EXAMPLE);
        final var textForRegularExpression = new TextForRegEx(TEXT_FOR_REG_EX_EXAMPLE);
        final var replaceCaseRegularExpression = new RegEx(REPLACE_REGULAR_EXPRESSION_LOWERCASE_EXAMPLE);
        assertEquals("[rorko-2482] Рефакторинг автоскролла bfb7dbcf",
                RegExReplaceOperation.replace(searchRegularExpression, textForRegularExpression, replaceCaseRegularExpression, false));
        replaceCaseRegularExpression.setRegularExpression(REPLACE_REGULAR_EXPRESSION_UPPERCASE_EXAMPLE);
        assertEquals("[RORKO-2482] Рефакторинг автоскролла bfb7dbcf",
                RegExReplaceOperation.replace(searchRegularExpression, textForRegularExpression, replaceCaseRegularExpression, false));

    }

    public static void checkFromConsole() {
        var scanner = new Scanner(System.in);
        System.out.println("Введите номер операции для проверки: ");
        System.out.println("1 - Поиск");
        System.out.println("2 - Замена");
        switch (scanner.nextByte()) {
            case 1:
                System.out.println(RegExOperations.findFromConsole());
                break;
            case 2:
                System.out.println(RegExReplaceOperation.replaceFromConsole());
                break;
            default:
                System.out.println("Операция для проверки не распознана. Завершение работы приложения");
        }
    }
}
