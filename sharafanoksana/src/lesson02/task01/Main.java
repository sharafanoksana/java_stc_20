/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package stc20.sharafanoksana.tasc01
 */

/**
 * Задание 1.
 * Написать программу ”Hello, World!”.
 * В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
 * - Смоделировав ошибку «NullPointerException»
 * - Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 * - Вызвав свой вариант ошибки через оператор throw
 */

package lesson02.task01;

public class Main {
    public static void main(String[] args) {

        // вызов класса, генерирующего NPE
        ProcessingNPE pNPE = new ProcessingNPE();

        // вызов класса, генерирующего ArrayIndexOutOfBoundsException
        ProcessingArrayBoundException pArrayBoundException = new ProcessingArrayBoundException();

        // вызов класса, генерирующего MyException
        ProcessingMyException pME = new ProcessingMyException();
    }
}
