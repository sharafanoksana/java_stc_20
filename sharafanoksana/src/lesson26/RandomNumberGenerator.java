/**
 * @author Sharafan Oksana
 * @date 17.11.2019
 * @package lesson06.task2
 */
package lesson26;

import java.util.Random;

public class RandomNumberGenerator {
    /**
     * Метод генерирует случайное число в заданном диапазоне
     * @param min минимальное число диапазона
     * @param max максимальное число диапазона
     * @return возвращает случайной число из заданного диапазона
     */
    public static int getRandom(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min + 1);
    }
}
