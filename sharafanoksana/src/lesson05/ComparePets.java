/**
 * @author Sharafan Oksana
 * @date 11.11.2019
 * @package lesson05
 */
package lesson05;

import lesson02.task03.SortException;

import java.util.Comparator;

public class ComparePets implements Comparator<Pet> {
    /**
     * Метод сортирует PetCollection в следующем порядке по полям:
     * 1 - владелец
     * 2 - кличка животного
     * 3 - вес животного
     *
     * @param p1 - питомец 1
     * @param p2 - питомец 2
     * @return - возвращает отсортированные значения
     */
    @Override
    public int compare(Pet p1, Pet p2) {
        int value1 = p1.getOwner().getName().compareTo(p2.getOwner().getName());
        if (value1 == 0) {
            int value2 = String.valueOf(p1.getNickname()).compareTo(String.valueOf(p2.getNickname()));
            if (value2 == 0) {
                int value3 = Double.valueOf(p1.getWeight()).compareTo(Double.valueOf(p2.getWeight()));
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
}
