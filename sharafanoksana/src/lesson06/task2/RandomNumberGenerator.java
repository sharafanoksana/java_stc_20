/**
 * @author Sharafan Oksana
 * @date 17.11.2019
 * @package lesson06.task2
 */
package lesson06.task2;

import java.util.Random;

public class RandomNumberGenerator {
    static int getRandom(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min + 1);
    }
}
