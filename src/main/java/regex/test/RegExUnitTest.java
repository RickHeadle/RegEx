package regex.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import regex.entity.RegEx;
import regex.entity.TextForRegEx;
import regex.operation.RegExFindOperation;
import regex.operation.RegExReplaceOperation;

@Slf4j
public class RegExUnitTest {
    private static final RegEx SEARCH_REGULAR_EXPRESSION_EXAMPLE = new RegEx("^\\[?(\\w{5})(?:\\-{1,5})(\\d{3,4})\\]?");
    private static final TextForRegEx TEXT_FOR_REG_EX_EXAMPLE = new TextForRegEx("[rOrkO---2482 Рефакторинг автоскролла bfb7dbcf");
    private static final RegEx REPLACE_REGULAR_EXPRESSION_LOWERCASE_EXAMPLE = new RegEx("\\[\\L$1\\E\\-$2\\]");
    private static final RegEx REPLACE_REGULAR_EXPRESSION_UPPERCASE_EXAMPLE = new RegEx("\\[\\U$1\\E\\-$2\\]");

    @Test
    public void checkFind() {
        Assertions.assertEquals("Найдено совпадение: '[rOrkO---2482'",
                RegExFindOperation.find(
                        SEARCH_REGULAR_EXPRESSION_EXAMPLE,
                        TEXT_FOR_REG_EX_EXAMPLE));
    }

    @Test
    public void checkReplaceToLowerCase() {
        Assertions.assertEquals("[rorko-2482] Рефакторинг автоскролла bfb7dbcf",
                RegExReplaceOperation.replace(
                        SEARCH_REGULAR_EXPRESSION_EXAMPLE,
                        TEXT_FOR_REG_EX_EXAMPLE,
                        REPLACE_REGULAR_EXPRESSION_LOWERCASE_EXAMPLE,
                        false));

    }

    @Test
    public void checkReplaceToUpperCase() {
        Assertions.assertEquals("[RORKO-2482] Рефакторинг автоскролла bfb7dbcf",
                RegExReplaceOperation.replace(
                        SEARCH_REGULAR_EXPRESSION_EXAMPLE,
                        TEXT_FOR_REG_EX_EXAMPLE,
                        REPLACE_REGULAR_EXPRESSION_UPPERCASE_EXAMPLE,
                        false));
    }
}
