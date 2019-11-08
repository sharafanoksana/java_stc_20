/**
 * @author Sharafan Oksana
 * @date 06.11.2019
 * @package lesson03.task01
 */
package lesson03.task01;

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
        int quantity = 10;
//        Number[] numbers = new Number[quantity];
        Number[] numbers = {2, 3, 4, 5.0, 5,  6, 7, 8, 8, 9, 10};
//        for (int i = 0; i<numbers.length; i++){
//            numbers[i] = (Double)numbers[i]*1.0;
//            System.out.println(numbers[i]);
//        }


        Number value = 2.5; // проверяемое значение
        double divider = 4; // делитель

        MathBox mathBox = new MathBox(numbers);


        System.out.println(mathBox.toString());
        System.out.println(mathBox.summator());
        mathBox.checkValue(value);
        System.out.println(mathBox.toString());


        mathBox.spliter(divider);
        System.out.println(mathBox.toString());

        System.out.println(mathBox.summator());

        MathBox mathBox1 = new MathBox(numbers);

        mathBox.checkValue(value);
        System.out.println(mathBox.toString());
    }
}
