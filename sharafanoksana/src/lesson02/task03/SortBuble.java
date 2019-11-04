/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task03
 */
package lesson02.task03;

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
     * @throws Exception - если имена совпадают 
     */
    @Override
    public Person[] sort() throws Exception {
        sortSex(people);
        for (int j = people.length - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (people[i].getSex().compareTo(people[i + 1].getSex()) == 0 | people[i].getSex() == Sex.MAN) {
                    if (Integer.valueOf(people[i].getAge()).compareTo(Integer.valueOf(people[i + 1].getAge())) == 0)
//                        (people[i].getAge() == (people[i + 1].getAge()))
                    {
                        if (people[i].getName().compareTo(people[i + 1].getName()) == 0) {
                            throw new Exception();
                        }
                        toSwap(i, i + 1);
                        return people;
                    } else if (people[i].getAge() < (people[i + 1].getAge())) {
                        toSwap(i, i + 1);
                        return people;
                    } else {
                        return people;
                    }
                }
                toSwap(i, i + 1);
                return people;
            }
            System.out.println(people[j].toString());
        }
        return people;
    }

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

    @Override
    public int compare(Object o, Object t1) {
        return 0;
    }
}





