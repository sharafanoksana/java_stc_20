/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task03
 */
package lesson02.task03;

import java.util.Comparator;

/**
 * Класс реализует пользловательский интерфейс Sortable
 * интерфейс Comparator с параметризированным типом Person
 */
public class SortByPersons implements Sortable, Comparator<Person> {

    /**
     * Метод сортирует массив
     *
     * @param p1 - персона 1
     * @param p2 - персона 2
     * @return - числовой результат сравнения от -1 до 1
     */
    public int compare(Person p1, Person p2) {
        int value1 = p1.getSex().compareTo(p2.getSex());
        if (value1 == 0) {
            int value2 = Integer.valueOf(p1.getAge()).compareTo(Integer.valueOf(p2.getAge()));
            if (value2 == 0) {
                int value3 = p1.getName().compareTo(p2.getName());
                if (value3 == 0) {
                    try {
                        throw new SortException();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("ВНИМАНИЕ !!! " + p1 + "(" + p1.hashCode() + ")" + " = "
                                + p2 + "(" + p2.hashCode() + ")");
                    }
                }
                return value3;
            } else {
                return value2;
            }
        }
        return value1;
    }

    @Override
    public Person[] sort(){
        return new Person[0];
    }
}

