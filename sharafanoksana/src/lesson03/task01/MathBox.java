/**
 * @author Sharafan Oksana
 * @date 06.11.2019
 * @package lesson03.task01
 */
package lesson03.task01;

import java.util.*;

/**
 * Класс содержит объект коллекции ArrayList<Number>
 */
public class MathBox {
    private List<Number> listNumber;


    /**
     * Конструктор на вход получает массив Number. Элементы не могут повторяться.
     * Через коллекцию HashSet исключаем наличие дубликатов. Элементы массива внутри объекта
     * раскладываются в коллекцию ArrayList<Number>.
     * @param numbers - массив Number
     */
    public MathBox(Number[] numbers) {
        nambersToDuble(numbers);
        this.listNumber = new ArrayList<Number>(Arrays.asList(numbers));
        Set<? extends Number> set = new HashSet<Number>(this.listNumber);
        this.listNumber.clear();
        this.listNumber.addAll(set);
//        checkArray(this.listNumber);
    }

    public static Number[] nambersToDuble(Number[] numbers) {
        for (int i = 0; i<numbers.length; i++){
            numbers[i].doubleValue();
        }
        return numbers;
    }

    /** 2 вариант решения - метод создает дубликат из повторяющихся элементов
     public MathBox(Number[] numbers) {
     this.listNumber = getDuplicate(new ArrayList<Number>(Arrays.asList(numbers)));
     }

     public static <T> List getDuplicate(Collection<T> list) {

     final List<T> duplicatedObjects = new ArrayList<T>();
     Set<T> set = new HashSet<T>() {
    @Override
    public boolean add(T e) {
    if (contains(e)) {
    duplicatedObjects.add(e);
    }
    return super.add(e);
    }
    };
     for (T t : list) {
     set.add(t);
     }
     return duplicatedObjects;
     }


     public static <T> boolean hasDuplicate(Collection<T> list) {
     if (getDuplicate(list).isEmpty())
     return false;
     return true;
     }
     */

// 1 вариант решения
//
//    private List<Number> checkArray(List<Number> numbers) {
//        for (Iterator<? extends Number> iter = this.listNumber.iterator(); iter.hasNext();){
//            if (iter.next().equals(iter.hasNext())){
//                iter.remove();
//            }
//        }
//        return this.listNumber;
//    }

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

    public List<? extends Number> spliter(double divider) {
        for (Number element : this.listNumber) {
            int index = this.listNumber.indexOf(element);
            element = element.doubleValue() / divider;
            this.listNumber.set(index, element);
        }
        return this.listNumber;
    }

    public List<? extends Number> checkValue(Number value) {
        System.out.println("Коллекция содержит елемент? " + value + " - " + this.listNumber.contains(value));
        for (Iterator<? extends Number> iter = this.listNumber.iterator(); iter.hasNext();){
            if (iter.next().equals(value)){
                iter.remove();
                System.out.println("Элемент: " + value + " - удален!");
            }
        }
        return this.listNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathBox)) return false;
        MathBox mathBox = (MathBox) o;
        return listNumber.equals(mathBox.listNumber);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "listNumber=" + listNumber +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(listNumber);
    }
}
