package com.walking.intensive.chapter2.task10;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(isPalindrome("        "));
    }

    static boolean isPalindrome(String inputString) {

        if (inputString == null) {
            return false;
        }

        String clearString = inputString.replaceAll("[^а-яА-Я]", "").toLowerCase();

        if (clearString.length() < 2) {
            return false;
        }

        String palidrome = "";

        for (int i = clearString.length() - 1; i >= clearString.length() / 2; i--) {
            if (clearString.charAt(i) != clearString.charAt(clearString.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
