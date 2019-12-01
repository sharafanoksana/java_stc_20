/**
 * @author Sharafan Oksana
 * @date 20.11.2019
 * @package lesson7_1
 */
package lesson07;
//todo лист аррей где уже хранятся подсчитанные элементы и следующий расчет элемента уже идет от посчитанного
public class CounterFactorial {
    long calculateFactorial(long elementNum) {
        long result = 1;
        for (int i = 1; i <= elementNum; i++) {
            result = result * (long) i;
        }
        return result;
    }
}
