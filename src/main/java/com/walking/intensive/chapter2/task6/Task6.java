package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getGcd(-1, 0));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }
        return m * n / getGcd(m, n);
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (m < 0 || n < 0) {
            return -1;
        }
        int gcd = Math.min(m, n) + 1;

        do {
            gcd -= 1;
        } while ((m % gcd != 0 || n % gcd != 0) && gcd > 1);

        return gcd;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью рекурсивной версии алгоритма Евклида.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (m < 0 || n < 0) {
            return -1;
        }
        if (m == 0 || n == 0) {
            return m + n;
        }
        if (m > n) {
            return getGcdByEuclideanAlgorithm(m % n, n);
        } else {
            return getGcdByEuclideanAlgorithm(m, n % m);
        }
    }


}
