/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task02
 */
package lesson02.task02;

import java.util.Random;
import java.util.Scanner;


public class Generator {
    /**
     * Метод запрашивает у пользователя количества создаваемых рандомных чисел и производит вызов класса
     * @see CustomsSqrt с передачей @param rn для вычисления квадратного корня.
     */
    public void startGenerator() {
        /**
         * Обращение к пользователю
         */
        int count = 0;
        CustomsSqrt customsSqrt = new CustomsSqrt();
        System.out.println("Введите количество генерируемых случайных чисел: ");
        Scanner scan = new Scanner(System.in);
        try {
            count = scan.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }
        /**
         * генерация и вычисление квадратного корня
         */
        for (int i = 0; i <= count - 1; i++) {
            double rn = (double) doRandomNumber();
            customsSqrt.getResultSqrt(rn);
        }
    }

    /**
     * Метод генерирует рандомное число в диапозоне от -100 до 100
     * @return возвращает рандомное число
     */
    private static int doRandomNumber() {
        Random r = new Random();
        int low = -100;
        int hight = 100;
        int result = r.nextInt(hight - low) + low;
        return result;
    }
}
