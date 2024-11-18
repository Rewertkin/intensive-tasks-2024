package com.walking.intensive.chapter1.task1;
/**
 * Реализуйте метод getAgeString(), который будет принимать параметром целое число (возраст) и возвращать строку
 * вида: "Вам N лет". Программа должна учитывать правила русского языка.
 *
 * <p>Пример верного исполнения кода: "Вам 5 лет", "Вам 4 года".
 * Пример неверной работы программы: "Вам 14 года".
 *
 * <p>Также необходимо учесть негативные сценарии. Например, попытку передать в метод невалидное значение - например,
 * отрицательное число. В таких случаях ожидается, что метод вернет строку "Некорректный ввод".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task1 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        int age = 12;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int inAge) {

        int calcAge = inAge;
        while (calcAge > 10) {
            if (calcAge >= 11 & calcAge <= 14) {
                break;
            } else if (calcAge > 100) {
                calcAge %= 100;
            } else {
                calcAge %= 10;
            }
        }

        String wordAge;
        if (calcAge == 1) {
            return String.format("Вам %d год", inAge);
        } else if (calcAge > 1 & calcAge < 5) {
            return String.format("Вам %d года", inAge);
        } else {
            return String.format("Вам %d лет", inAge);
        }
    }
}
