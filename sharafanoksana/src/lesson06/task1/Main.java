/**
 * @author Sharafan Oksana
 * @date 13.11.2019
 * @package lesson06.task1
 */
package lesson06.task1;


/**
 * Задание 1. Написать программу, читающую текстовый файл. Программа должна составлять отсортированный
 * по алфавиту список слов, найденных в файле и сохранять его в файл-результат. Найденные слова не
 * должны повторяться, регистр не должен учитываться. Одно слово в разных падежах – это разные слова.
 */
public class Main {
    public static void main(String[] args) {
        Dictionary d= new Dictionary();
        d.getWordsFromFile();
        d.print();
        d.saveWordsToFile();
    }
}
