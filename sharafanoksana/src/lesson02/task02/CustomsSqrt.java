/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task02
 */
package lesson02.task02;

public class CustomsSqrt {
    private double num;

    /**
     * Метод вычисляет квадратный корень
     * В методе обрабатывается исключение если результат равен NAN - выводится сообщение об ошибке в консоль,
     * Если квадрат целой части resultSqrt числа равен rn - выводится сообщение в консоль
     * @param rn - рандомное число
     */
    public void getResultSqrt(Double rn) {
        // вычисление квадратного корня
        double resultSqrt = Math.sqrt(rn);
        if (Double.isNaN(resultSqrt)) {
            try {
                throw new Exception("NAN");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.printf("Вычисление квадрат из (%.3f) НЕДОПУСТИМО! \n", rn, e.toString());
            }
        } else if (rn == (int) resultSqrt) {
            System.out.printf("ВНИМАНИЕ! Квадрат целой части  %.3f равен (%.3f)\n",  resultSqrt, rn);
        } else {
            //System.out.printf("sqrt(%.3f) == %.3f - РЕЗУЛЬТАТ НЕ БУДЕТ ВЫВЕДЕН НА ЭКРАН \n", rn, resultSqrt);
        }
    }
}
