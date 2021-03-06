/**
 * @author Sharafan Oksana
 * @date 06.11.2019
 * @package lesson03.task01
 */
package lesson03.task01;

import lesson03.task02.ObjectBox;

import java.util.*;
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

/**
 * Класс содержит объект коллекции ArrayList<Number>
 */
public class MathBox extends ObjectBox {
    private List<Number> listNumber;

    /**
     * Конструктор на вход получает массив Number. Элементы не могут повторяться.
     * Через коллекцию HashSet исключаем наличие дубликатов. Элементы массива внутри объекта
     * раскладываются в коллекцию ArrayList<Number>.
     * @param numbers - массив Number
     */
    public MathBox(Number[] numbers) {
        super(numbers);
        this.listNumber = new ArrayList<>(Arrays.asList(numbers));
        Set<? extends Number> set = new HashSet<>(this.listNumber);
        this.listNumber.clear();
        this.listNumber.addAll(set);
    }

    /**
     * метод подсчитывает сумму всех элементов коллекции.
     * @return - сумму всех элементов коллекции
     */
    public double summator() {
        double summ = 0;
        for (Number element : this.listNumber) {
            summ += element.doubleValue();
        }
        return summ;
    }

    /**
     * метод выполняет поочередное деление всех хранящихся в объекте элементов на делитель <>divider</>,
     * Хранящиеся в объекте данные полностью заменяются результатами деления.
     * @param divider - делитель
     * @return - обновленный список
     */
    public List<? extends Number> spliter(double divider) {
        for (Number element : this.listNumber) {
            int index = this.listNumber.indexOf(element);
            double elem = Double.valueOf(String.valueOf(element));
            elem = elem / divider;
            this.listNumber.set(index, elem);
        }
        return this.listNumber;
    }

    /**
     * метод получает на вход Integer и если такое значение есть в коллекции, удаляет его.
     * @param value - сравниваемое значение
     * @return измененный this.listNumber, если элемент был удален
     */
    public List<? extends Number> checkValue(Integer value) {
        System.out.println("Коллекция содержит елемент? " + value + " - " + this.listNumber.contains(value));
//        if(listNumber.contains(value)){
//                listNumber.remove(listNumber.indexOf(value)); //todo : исправить код
//        }
        for (Iterator<? extends Number> iter = this.listNumber.iterator(); iter.hasNext();){
            if (iter.next().equals(value)){
                iter.remove();
                System.out.println("Элемент: " + value + " - удален!");
            }
        }
        return this.listNumber;
    }

    public List<Number> getListNumber() {
        return this.listNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return this.listNumber.equals(mathBox.listNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.listNumber);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "listNumber=" + listNumber +
                '}';
    }
}
