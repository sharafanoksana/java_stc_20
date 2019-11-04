/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package stc20.sharafanoksana.tasc01
 */

package lesson02.task02;

/**
 * Задание 2. Составить программу, генерирующую N случайных чисел.
 * Для каждого числа k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.
 */

public class Main {

    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.startGenerator();
    }
}
