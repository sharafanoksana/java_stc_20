/**
 * @author Sharafan Oksana
 * @date 20.11.2019
 * @package lesson7_1
 */
package lesson7;

public class CounterFactorial { //todo

    long calculateFactorial(long elementNum) {
        long result = 1;
        for (int i = 1; i <= elementNum; i++) {
            result = result *i;
        }
        return result;
    }
}
