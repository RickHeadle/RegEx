package regex.test;

import lombok.extern.slf4j.Slf4j;
import regex.operation.RegExFindOperation;
import regex.operation.RegExReplaceOperation;

import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
public class RegExManualConsoleTest {

    public static void main(String[] args) {
        checkFromConsole();
    }

    public static void checkFromConsole() {
        var scanner = new Scanner(System.in);
        log.info("Введите номер операции для проверки: ");
        log.info("1 - Поиск");
        log.info("2 - Замена");
        try {
            switch (scanner.nextByte()) {
                case 1 -> log.info(RegExFindOperation.findFromConsole());
                case 2 -> log.info(RegExReplaceOperation.replaceFromConsole());
                default -> log.warn("Операция для проверки не распознана.");
            }
        } catch (InputMismatchException inputMismatchException) {
            log.warn("Введено некорректное значение.");
        } catch (Exception exception) { //NoSuchElementException | IllegalStateException
            log.warn("Не удалось обработать значение.");
        } finally {
            log.info("Завершение работы приложения.");
        }
    }
}
