/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task01
 */
package lesson02.task01;

/**
 * Класс пользовательского MyException наследуется от Exception
 */
public class MyException extends Exception {
    public MyException() {
        try {
            throw new Exception("Вызван свой вариант ошибки через оператор throw");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //super("Вызван свой вариант ошибки через оператор throw");
    }
}
