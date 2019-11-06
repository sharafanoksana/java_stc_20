/**
 * @author Sharafan Oksana
 * @date 05.11.2019
 * @package lesson02.task03
 */
package lesson02.task03;

public class SortException extends Exception {
    public SortException() throws Exception {
        throw new Exception("Внимание! Совпадение Person!");
    }
}
