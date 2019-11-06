/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task03
 */
package lesson02.task03;

/**
 * Класс реализует пользловательский интерфейс Sortable
 */
public class SortBuble implements Sortable {
    private Person[] people;

    public SortBuble(Person[] people) {
        this.people = people;
    }

    //Отсортируем массив строк через пузырьковую сортировку по полу.

    /**
     * Метод сортирует массив Person в порядке: по полу (первые MAN), ворзрасту, имени (по алфавиту)
     *
     * @return people - отсортированный массив
     */
    @Override
    public Person[] sort() {

        for (int j = people.length - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (people[i].getSex() == Sex.MAN) {
                    if (people[i].getSex().compareTo(people[i + 1].getSex()) == 0) {
                        compare(i, i + 1);
                    }
                } else if (people[i].getSex() == Sex.WOMAN) {
                    if (people[i].getSex().compareTo(people[i + 1].getSex()) == 0) {
                        compare(i + 1, i);
                    }
                    toSwap(i, i + 1);
                }
            }
        }
        return people;
    }

    /**
     * Метод сортирует персон по возрасту и имени путем перестановки индексов в массиве (баблсортировка)
     *
     * @param i  - индекс персоны в массиее
     * @param i1 - индекс персоны в массиее
     * @throws SortException наследуется от Exception - если имена совпадают
     */
    private void compare(int i, int i1) {
        if (people[i].getAge() == (people[i1].getAge())) {
            if (people[i].getName().compareTo(people[i1].getName()) == 0) {
                try {
                    throw new SortException();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("ВНИМАНИЕ !!! " + people[i] + " (" + people[i].hashCode() + ") =" +
                            " " + people[i1] + " " + people[i1].hashCode());
                }
            }
            toSwap(i, i1);
        } else if (people[i].getAge() > (people[i1].getAge())) {
            toSwap(i, i1);
        }
    }

    /**
     * метод выводит в консоль содержание массива
     */
    public void printPerson() {
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }

    /**
     * Метод сортирует массив Person по возрасту
     *
     * @param people - массив Person
     * @return - отсортированный массив Person
     */
    public Person[] sortAge(Person[] people) {
        for (int j = people.length - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (people[i].getAge() < people[i + 1].getAge()) {
                    toSwap(i, i + 1);
                }
            }
            System.out.println(people[j].toString());
        }
        return people;
    }

    /**
     * Метод сортирует массив Person по имени
     *
     * @param people - массив Person
     * @return - отсортированный массив Person
     */
    public Person[] sortName(Person[] people) {
        for (int j = 0; j < people.length; j++) {
            for (int i = j + 1; i < people.length; i++) {
                if (people[i].getName().compareTo(people[j].getName()) < 0) {
                    toSwap(j, i);
                }
            }
            System.out.println(people[j].toString());
        }
        return people;
    }

    /**
     * Метод сортирует массив Person по полу
     *
     * @param people - массив Person
     * @return - отсортированный массив Person
     */
    public Person[] sortSex(Person[] people) {
        for (int j = 0; j < people.length; j++) {
            for (int i = j + 1; i < people.length; i++) {
                if (people[i].getSex() == Sex.MAN) {
                    toSwap(j, i);
                }
            }
            System.out.println(people[j].toString());
        }
        return people;
    }

    /**
     * метод меняет местами индексы элементов в массиве
     *
     * @param first  первый индекс
     * @param second второй индекс
     */
    private void toSwap(int first, int second) {
        Person temp = people[first];
        people[first] = people[second];
        people[second] = temp;
    }
}





