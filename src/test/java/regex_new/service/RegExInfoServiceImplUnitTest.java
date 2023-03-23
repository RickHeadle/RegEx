package regex_new.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import regex_new.entity.FakeRegExInfo;
import regex_new.entity.RegExInfo;

@ActiveProfiles(value = "dev")
@ExtendWith(MockitoExtension.class)
public class RegExInfoServiceImplUnitTest {

  @InjectMocks
  private RegExInfoServiceImpl regExService;

  @Test
  @DisplayName(value = "Проверка: паттерн не найден в тексте -> бросаем IllegalStateException")
  void whenFirstPatternNotFound_thenIllegalStateExceptionThrown() {
    String testMessage = "This is a test message.";
    String regularExpression = "^This is a regular expression that won't work on a test message.$";
    RegExInfo regExInfo = FakeRegExInfo.createRegEx(1L, regularExpression, "");

    Executable executable = () -> regExService.findFirst(regExInfo, testMessage);
    Assertions.assertThrows(IllegalStateException.class, executable);
  }

  @Test
  @DisplayName(value = "Проверка: паттерн найден в тексте -> возвращаем найденный паттерн")
  void whenFirstPatternFound_thenReturnPattern() {
    String testMessage = "This is a test message.";
    String regularExpression = "^This is a(?: regular expression that will work on a)? test message.$";
    RegExInfo regExInfo = FakeRegExInfo.createRegEx(1L, regularExpression, "");

    Executable executable = () -> regExService.findFirst(regExInfo, testMessage);
    Assertions.assertDoesNotThrow(executable);
    Assertions.assertEquals(testMessage, regExService.findFirst(regExInfo, testMessage));
  }

  @Test
  @DisplayName(value = "Проверка: найдено несколько паттернов - возвращаем все")
  void whenMultiplePatternsFound_thenReturnThemAll() {
    String testMessage = "This is a test message.";
    // This RegEx can match to a "letter-whitespace-letter" combination.
    String regularExpression = "\\w\\s\\w";
    RegExInfo regExInfo = FakeRegExInfo.createRegEx(1L, regularExpression, "");

    Executable executable = () -> regExService.findAll(regExInfo, testMessage);
    Assertions.assertDoesNotThrow(executable);
    Assertions.assertEquals(3, regExService.findAll(regExInfo, testMessage).size());
  }

  @Test
  @DisplayName(value = "Проверка: не найдено ни одного паттерна - возвращаем пустое множество")
  void whenMultiplePatternsNotFound_thenReturnEmptyList() {
    String testMessage = "This is a test message.";
    String regularExpression = "^This is a regular expression that won't work on a test message.$";
    RegExInfo regExInfo = FakeRegExInfo.createRegEx(1L, regularExpression, "");

    Executable executable = () -> regExService.findAll(regExInfo, testMessage);
    Assertions.assertDoesNotThrow(executable);
    Assertions.assertEquals(0, regExService.findAll(regExInfo, testMessage).size());
  }

}
