/**
 * @author Sharafan Oksana
 * @date 26.11.2019
 * @package lesson11
 */
package lesson11;

/**
 * Задание: Перевести одну из предыдущих работ на использование стримов и лямбда-выражений там, где это уместно
 * (возможно, жертвуя производительностью)
 * Подсчет факториала для списка рандомных чисел
 */

import lesson06.task2.RandomNumberGenerator;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        long start = System.nanoTime();

        Map<Integer, BigInteger> tableFactorials = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();// список рандомных чисел для вычисления их факториала
        int countNumbers = 10000;
        int maxNum;
        //заполнение списка numbers рандомными числами
        for (int k = 0; k < countNumbers; k++) {
            numbers.add(RandomNumberGenerator.getRandom(0, 99));
        }
        maxNum = numbers.stream()
                .max(Integer::compare).get();// вычислить макс число из массива

        //подсчет факториала для максимального значения и запись в HashMap
        for (int i= 0; i < maxNum; i++){
            BigInteger factorial = streamedParallel(i);
            tableFactorials.put(i,factorial);
        }

        // выбор значения из HashMap table для рандомного числа из ArrayList numbers
        numbers.stream()
                .forEach((Integer num) -> System.out.printf("%d! = %d \n", num, tableFactorials.get(num)));

        System.out.printf("Executed by %d ms", (System.nanoTime() - start));
    }

    public static BigInteger streamedParallel(int n) {
        if(n < 2) return BigInteger.valueOf(1);
        return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }
}

