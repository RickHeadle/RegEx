package regex.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import regex.operation.RegExFindOperation;
import regex.operation.RegExReplaceOperation;

@Slf4j
class RegExUnitTest {
    private static final RegEx SEARCH_REGULAR_EXPRESSION_EXAMPLE = new RegEx("^\\[?(\\w{5})(?:\\-{1,5})(\\d{3,4})\\]?");
    private static final TextForRegEx TEXT_FOR_REG_EX_EXAMPLE = new TextForRegEx("[rOrkO---2482 Рефакторинг автоскролла bfb7dbcf");
    private static final RegEx REPLACE_REGULAR_EXPRESSION_LOWERCASE_EXAMPLE = new RegEx("\\[\\L$1\\E\\-$2\\]");
    private static final RegEx REPLACE_REGULAR_EXPRESSION_UPPERCASE_EXAMPLE = new RegEx("\\[\\U$1\\E\\-$2\\]");

    @Test
    void checkFind() {
        Assertions.assertEquals("Найдено совпадение: '[rOrkO---2482'",
                RegExFindOperation.find(
                        SEARCH_REGULAR_EXPRESSION_EXAMPLE,
                        TEXT_FOR_REG_EX_EXAMPLE));
    }

    @Test
    void checkReplaceToLowerCase() {
        Assertions.assertEquals("[rorko-2482] Рефакторинг автоскролла bfb7dbcf",
                RegExReplaceOperation.replace(
                        SEARCH_REGULAR_EXPRESSION_EXAMPLE,
                        TEXT_FOR_REG_EX_EXAMPLE,
                        REPLACE_REGULAR_EXPRESSION_LOWERCASE_EXAMPLE,
                        false));

    }

    @Test
    void checkReplaceToUpperCase() {
        Assertions.assertEquals("[RORKO-2482] Рефакторинг автоскролла bfb7dbcf",
                RegExReplaceOperation.replace(
                        SEARCH_REGULAR_EXPRESSION_EXAMPLE,
                        TEXT_FOR_REG_EX_EXAMPLE,
                        REPLACE_REGULAR_EXPRESSION_UPPERCASE_EXAMPLE,
                        false));
    }

    /*
     * Итерация №0
     * Поиск: ^\[?(\D{5}\-?\d+)\]?(?:\s)(.+?)$
     * Текст: [RORKO-2873] 65kay rorko 2873 заглушка ABAC 1529eff3
     * Замена: \[RORKO\-2873\] заглушка ABAC 1529eff3
     * Результат: [RORKO-2873] заглушка ABAC 1529eff3
     *
     * Итерация №1
     * Поиск: (?=.*[0-9](?=.*[a-z]))([a-z0-9]+)$
     * Текст: [RORKO-2873] заглушка ABAC 1529eff3
     * Замена: \[hexReplacer_discoDancer\]
     * Результат: [RORKO-2873] заглушка ABAC [hexReplacer_discoDancer]
     *
     * Итерация №2
     * Поиск: ^\[\b(RORKO\-\d+)\]
     * Текст: [RORKO-2873] заглушка ABAC [hexReplacer_discoDancer]
     * Замена: \[pORKO\-NONUM\]
     * Результат: [pORKO-NONUM] заглушка ABAC [hexReplacer_discoDancer]
     */
    @Disabled
    @ParameterizedTest
    @CsvSource({
            "^\\[?(\\D{5}\\-?\\d+)\\]?(?:\\s)(.+?)$ , \\[RORKO\\-2873\\] заглушка ABAC 1529eff3",
            "(?=.*[0-9](?=.*[a-z]))([a-z0-9]+)$ , \\[hexReplacer_discoDancer\\]",
            "^\\[\\b(RORKO\\-\\d+)\\] , \\[pORKO\\-NONUM\\]"
    })
    void checkMultipleReplace(String search, String replace) {
/*        final byte OPERATION_AND_ITERATION_NUMBER = 3;
        final String INITIAL_TEXT = "[RORKO-2873] 65kay rorko 2873 заглушка ABAC 1529eff3";

        StringBuilder stringBuilder = new StringBuilder(INITIAL_TEXT);*/
    }
}
