/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task03
 */
package lesson02.task03;

import java.util.Comparator;

public class SortByPersons implements Comparator<Person> {
    private Person[] people;

    public SortByPersons(Person[] people) {
        this.people = people;
    }

    public int compare(Person p1, Person p2){
            int value1 = p1.getSex().compareTo(p2.getSex());
            if (value1 == 0) {
                int value2 = String.valueOf(p1.getAge()).compareTo(String.valueOf(p2.getAge()));
                if (value2 == 0) {
                    return p1.getName().compareTo(p2.getName());
                } else {
                    return value2;
                }
            }
            return value1;
//        int value1 = p1.getName().compareTo(p2.getName());
//        if (value1 == 0) {
//            int value2 = String.valueOf(p1.getAge()).compareTo(String.valueOf(p2.getAge()));
//            if (value2 == 0) {
//                return p1.getSex().compareTo(p2.getSex());
//            } else {
//                return value2;
//            }
//        }
//        return value1;
        }
}

