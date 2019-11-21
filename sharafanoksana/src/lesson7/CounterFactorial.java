/**
 * @author Sharafan Oksana
 * @date 20.11.2019
 * @package lesson7_1
 */
package lesson7;

public class CounterFactorial {

    double calculateFactorial(double elementNum) {
        double result = 1;
        for (double i = 1; i <= elementNum; i++) {
            result = result *i;
        }
        return result;
    }
}
