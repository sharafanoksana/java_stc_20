/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task01
 */
package lesson02.task01;

/**
 * При создании экземпляра класса в конструкторе вызовается метод collException(),
 * генерирующий ArrayIndexOutOfBoundsException
 */
public class ProcessingArrayBoundException {
    int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public ProcessingArrayBoundException() {
        collException();
    }

    /**
     * При вызове этого метода реализуется обработка ArrayIndexOutOfBoundsException
     */
    private void collException() {
        try {
            System.out.println(num[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Ой, такого индекса нет в массиве! " + e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Hello, World! \n_________________________________\n");
        }
    }
}