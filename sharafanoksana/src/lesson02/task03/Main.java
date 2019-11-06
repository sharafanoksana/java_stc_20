/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package stc20.sharafanoksana.tasc01
 */
package lesson02.task03;

import java.util.Arrays;

/**
 * Задание 3. Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка).
 * Создать два класса, методы которых будут реализовывать сортировку объектов. Предусмотреть единый интерфейс
 * для классов сортировки. Реализовать два различных метода сортировки этого массива по правилам:
 * -первые идут мужчины
 * -выше в списке тот, кто более старший
 * -имена сортируются по алфавиту
 *
 * Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 */

public class Main {


    public static void main(String[] args) throws Exception {
        //Замер времени выполнения программы сортировки - старт
        long startTime = System.currentTimeMillis();

        long total = 0;
        for (int i = 0; i < 10000000; i++) {
            total += i;
        }

        // количесто создаваемых персон
        int countPerson = 10000;

        Person[] people = new Person[countPerson];
        // Заполнение массива объектами класса Person
        for (int i = 0; i < countPerson; i++) {
            people[i] = new Person();
        }

//        // Создание экземпляра класса SortByPersons и старт SortByPersons
//        SortByPersons comparator = new SortByPersons();
//        /**
//         * Вызов метода сортировки массива Person через ava.util.Arrays
//         * @param people - массив Person
//         * @param comparator - экземпляра класса SortByPersons
//         */
//        Arrays.sort(people, comparator);
//        for (int i = 0; i < people.length; i++) {
//            System.out.println(people[i].toString());
//        }


        /**
         * Старт SortBuble
         */
        SortBuble sortBuble = new SortBuble(people);
        sortBuble.sort();
        sortBuble.printPerson();

        //Замер времени выполнения программы сортировки - завершение
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);




// Одиночные сортировки

//            sortBuble.sortName(people);
//            System.out.println("_________________________________");
//            sortBuble.sortAge(people);
//            System.out.println("_________________________________");
//            sortBuble.sortSex(people);
    }

}

