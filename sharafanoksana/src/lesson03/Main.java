/**
 * @author Sharafan Oksana
 * @date 06.11.2019
 * @package lesson03.task01
 */
package lesson03;

import lesson03.task01.MathBox;
import lesson03.task02.ObjectBox;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

/**
 * Задание 1. Написать класс MathBox, реализующий следующий функционал:
 * -    Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта
 * раскладываются в подходящую коллекцию (выбрать самостоятельно).
 * -    Существует метод summator, возвращающий сумму всех элементов коллекции.
 * -    Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
 * являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
 * -    Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать MathBox
 * для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap). Выполнение
 * контракта обязательно!
 * -    Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
 */

public class Main {
    public static void main(String[] args) {
        Number[] numbers = {1,2,3,4,5,6,6,7,8,9,10,2.5,4};

        Integer value = 2; // проверяемое значение
        double divider = 4; // делитель

        MathBox mathBox = new MathBox(numbers);
        System.out.println("Создан объект класса MathBox");
        System.out.println(mathBox.toString());
        System.out.println("Вызван метод summator()");
        System.out.println(mathBox.summator());
        System.out.println("Вызван метод checkValue() с параметром " + value);
        mathBox.checkValue(value);
        System.out.println(mathBox.toString());
        System.out.println("Вызван метод spliter() с параметром " + divider);
        mathBox.spliter(divider);
        System.out.println(mathBox.toString());
        System.out.println("Вызван метод summator()");
        System.out.println(mathBox.summator());
    }
}
