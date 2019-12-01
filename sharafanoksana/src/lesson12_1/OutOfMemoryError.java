/**
 * @author Sharafan Oksana
 * @date 26.11.2019
 * @package lesson12_1
 */
package lesson12_1;

public class OutOfMemoryError {
    public static void main(String args[]) {
        OutOfMemoryError ome = new OutOfMemoryError();
        ome.generateMyIntArray(1,50);
    }
    public void generateMyIntArray(int start, int end) {
        int multiplier = 100;
        for(int i = 1; i < end; i++) {
            System.out.println("Round " + i + " Free Memory: " +
                    Runtime.getRuntime().freeMemory());
            int[] myIntList = new int[multiplier];
            for(int j= i; j > 1; j--){
                myIntList[j] = i;
            }
            multiplier = multiplier * 10;
        }
    }
}
