package com.company.regex.test;

import com.company.regex.entity.RegEx;
import com.company.regex.entity.TextForRegEx;
import com.company.regex.operation.RegExFindOperation;
import com.company.regex.operation.RegExReplaceOperation;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class RegExTest {
    private static final RegEx SEARCH_REGULAR_EXPRESSION_EXAMPLE = new RegEx("^\\[?(\\w{5})(?:\\-{1,5})(\\d{3,4})\\]?");
    private static final TextForRegEx TEXT_FOR_REG_EX_EXAMPLE = new TextForRegEx("[rOrkO---2482 Рефакторинг автоскролла bfb7dbcf");
    private static final RegEx REPLACE_REGULAR_EXPRESSION_LOWERCASE_EXAMPLE = new RegEx("\\[\\L$1\\E\\-$2\\]");
    private static final RegEx REPLACE_REGULAR_EXPRESSION_UPPERCASE_EXAMPLE = new RegEx("\\[\\U$1\\E\\-$2\\]");

    public static void checkFromConsole() {
        var scanner = new Scanner(System.in);
        System.out.println("Введите номер операции для проверки: ");
        System.out.println("1 - Поиск");
        System.out.println("2 - Замена");
        switch (scanner.nextByte()) {
            case 1:
                System.out.println(RegExFindOperation.findFromConsole());
                break;
            case 2:
                System.out.println(RegExReplaceOperation.replaceFromConsole());
                break;
            default:
                System.out.println("Операция для проверки не распознана. Завершение работы приложения");
        }
    }

    @Test
    public void checkFind() {
        assertEquals("Найдено совпадение: [rOrkO---2482",
                RegExFindOperation.find(
                        SEARCH_REGULAR_EXPRESSION_EXAMPLE,
                        TEXT_FOR_REG_EX_EXAMPLE));
    }

    @Test
    public void checkReplace_toLowerCase() {
        assertEquals("[rorko-2482] Рефакторинг автоскролла bfb7dbcf",
                RegExReplaceOperation.replace(
                        SEARCH_REGULAR_EXPRESSION_EXAMPLE,
                        TEXT_FOR_REG_EX_EXAMPLE,
                        REPLACE_REGULAR_EXPRESSION_LOWERCASE_EXAMPLE,
                        false));

    }

    @Test
    public void checkReplace_toUpperCase() {
        assertEquals("[RORKO-2482] Рефакторинг автоскролла bfb7dbcf",
                RegExReplaceOperation.replace(
                        SEARCH_REGULAR_EXPRESSION_EXAMPLE,
                        TEXT_FOR_REG_EX_EXAMPLE,
                        REPLACE_REGULAR_EXPRESSION_UPPERCASE_EXAMPLE,
                        false));
    }
}
