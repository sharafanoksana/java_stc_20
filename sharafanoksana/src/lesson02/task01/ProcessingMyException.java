/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task01
 */
package lesson02.task01;

/**
 * При создании экземпляра класса в конструкторе вызовается метод collException(),
 * генерирующий MyException
 */
public class ProcessingMyException {
    private Object object;

    public ProcessingMyException() {
        collException();
    }

    /**
     * При вызове этого метода реализуется обработка MyException
     */
    private void collException() {
        try {
            object = new Object();
            System.out.println("Создан экземпляр класса Object в блоке try");
            throw new MyException();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка обработана в блоке catch. ");
        } finally {
            System.out.println("Hello, World!\n_________________________________\n");
        }
    }
}
