/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task01
 */
package lesson02.task01;

import java.util.Random;

/**
 * При создании экземпляра класса в конструкторе вызовается метод collException(),
 * генерирующий NullPointerException
 */
public class ProcessingNPE {
    Random r = null;

    public ProcessingNPE() {
        collException();
    }

    /**
     * При вызове этого метода реализуется обработка NullPointerException
     */
    private void collException() {
        Random r = null;
        try {
            System.out.println(r.toString());
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("Рандомное число не создано (NPE): " + npe.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Hello, World! \n_________________________________\n");
        }
    }
}
