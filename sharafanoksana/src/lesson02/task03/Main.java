/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package stc20.sharafanoksana.tasc01
 */
package lesson02.task03;

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


        public static void main(String[] args) {
            int countPerson = 10;
            Person[] people = new Person[countPerson];
            // Заполнение массива объектами класса Person
            for (int i = 0; i<countPerson; i++ ) {
                people[i] = new Person();
            }
//            SortBuble sortBuble = new SortBuble(people);
//            try {
//                sortBuble.sort();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            SortByPersons sort = new SortByPersons(people);
            for(int i = 0; i < people.length-1; i++){
                for(int j = 0; j < people.length-1; j++){
                    sort.compare(people[j], people[i]);

                }
                people[i].toString();
            }

// Одиночные сортировки

//            sortBuble.sortName(people);
//            System.out.println("_________________________________");
//            sortBuble.sortAge(people);
//            System.out.println("_________________________________");
//            sortBuble.sortSex(people);
        }
    }

