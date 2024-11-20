package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
        //Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getFlatLocation(10, 1, 40));
    }
    static boolean checkNumber(int number) {
        return number > 0;
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //        Место для вашего кода
        final int LIMITFLATS = 4; // кол-во квартир на этаже
        int flatAmount; // номер квартиры

        if (checkNumber(floorAmount) & (checkNumber(entranceAmount) & checkNumber(flatNumber))) {
            flatAmount = floorAmount * entranceAmount * LIMITFLATS; //общее кол-во квартир
        } else {
            return "Некорректные входные данные";
        }

        if (flatNumber <= flatAmount) {
            int flatAmountInEntrance = floorAmount * LIMITFLATS; //кол-во квартир в подъезде

            int entranceNumber; // номер подъезда
            if (flatNumber > flatAmountInEntrance) {
                entranceNumber = flatNumber / flatAmountInEntrance;
                if (entranceNumber % flatAmountInEntrance > 0) {
                    entranceNumber += 1;
                }
            } else {
                entranceNumber = 1;
            }

            //номер этажа
            int floorNumber = (flatNumber - (flatAmountInEntrance * (entranceNumber - 1))) / LIMITFLATS;
            if (flatNumber % LIMITFLATS > 0) {
                floorNumber += 1;
            }

            //номер квартиры на этаже
            int flatNumberOnFloor = flatNumber - (flatAmountInEntrance * (entranceNumber - 1)) - LIMITFLATS * (floorNumber - 1);

            String elevatorSide;
            if (flatNumberOnFloor > 2) {
                elevatorSide = "справа";
            } else {
                elevatorSide = "слева";
            }

            String side;
            if (flatNumberOnFloor % 2 == 0) {
                side = "вправо";
            } else {
                side = "влево";
            }
            return String.format("%d кв - %d подъезд, %d этаж, %s от лифта, %s", flatNumber, entranceNumber, floorNumber, elevatorSide, side);
        } else {
            return "Такой квартиры не существует";
        }
    }
}
