package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        double x = getAreaAdvanced(12, 13, 5);
        System.out.format("%.2f", x);
        //System.out.print(Math.asin(0.3846));
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {

        if (checkFailSides(a, b, c)) {
            return -1;
        }
        return (double) 1 / 4 * Math.sqrt((a + b - c) * (a - b + c) * (-a + b + c) * (a + b + c));
    }


    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        double[] heightsArray = new double[0];

        if (checkFailSides(a, b, c)) {
            return heightsArray;
        }

        double area = getAreaByHeron(a, b, c);

        heightsArray = new double[3];
        double[] arraySides = {a, b, c};

        for (int i = 0; i < 3; i++) {
            heightsArray[i] = 2 * area / arraySides[i];
        }

        Arrays.sort(heightsArray);
        return heightsArray;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        double[] mediansArray = new double[0];

        if (checkFailSides(a, b, c)) {
            return mediansArray;
        }
        mediansArray = new double[3];

        for (int i = 0; i < 3; ++i) {
            mediansArray[i] = switch (i) {
                case 0 -> Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2)) * 1 / 2;
                case 1 -> Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(c, 2) - Math.pow(b, 2)) * 1 / 2;
                case 2 -> Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2)) * 1 / 2;
                default -> 0;
            };
        }
        Arrays.sort(mediansArray);

        return mediansArray;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        double[] bisectorsArray = new double[0];

        if (checkFailSides(a, b, c)) {
            return bisectorsArray;
        }

        bisectorsArray = new double[3];

        for (int i = 0; i < 3; ++i) {
            bisectorsArray[i] = switch (i) {
                case 0 -> (Math.sqrt(a * b * (a + b + c) * (a + b - c))) / (a + b);
                case 1 -> (Math.sqrt(a * c * (a + b + c) * (a + c - b))) / (a + c);
                case 2 -> (Math.sqrt(c * b * (a + b + c) * (c + b - a))) / (c + b);
                default -> 0;
            };
        }

        Arrays.sort(bisectorsArray);
        return bisectorsArray;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        //        Место для вашего кода
        double[] anglesArray = new double[0];

        if (checkFailSides(a, b, c)) {
            return anglesArray;
        }


        anglesArray = new double[3];

        double area = getAreaByHeron(a, b, c);

        for (int i = 0; i < 3; ++i) {
            anglesArray[i] = switch (i) {
                case 0 -> Math.toDegrees(Math.asin((2 * area) / (a * b)));
                case 1 -> Math.toDegrees(Math.asin((2 * area) / (b * c)));
                case 2 -> Math.toDegrees(Math.asin((2 * area) / (a * c)));
                default -> 0;
            };
        }

        Arrays.sort(anglesArray);
        return anglesArray;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (checkFailSides(a, b, c)) {
            return -1;
        }
        return getAreaByHeron(a, b, c) / ((a + b + c) / 2);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (checkFailSides(a, b, c)) {
            return -1;
        }
        return a * b * c / (4 * getAreaByHeron(a, b, c));
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {

        if (checkFailSides(a, b, c)) {
            return -1;
        }
        //найдем косинус
        double cos = (a * a + b * b - c * c) / (2 * a * b);

        //найдем синус
        double sin = Math.sqrt(1 - cos * cos);

        //найдем площадь
        return a * b * sin / 2;
    }

    static boolean checkFailSides(double a, double b, double c) {
        return b + c < a || a + c < b || a + b < c || a < 0 || b < 0 || c < 0;
    }
}
