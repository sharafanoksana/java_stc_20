/**
 * @author Sharafan Oksana
 * @date 26.11.2019
 * @package lesson11
 */
package lesson11;

/**
 * Задание: Перевести одну из предыдущих работ на использование стримов и лямбда-выражений там, где это уместно
 * (возможно, жертвуя производительностью)
 */
import lesson06.task2.RandomNumberGenerator;
import lesson07.CounterFactorial;
import lesson07.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //    ExecutorService threadPool = Executors.newWorkStealingPool(4); // время выполнения 1 секунда
        ThreadPool threadPool = new ThreadPool(4);// время выполнения 5 секунды; на 8 потоках - 14 секунд; на 100 - 312 секунд
        CounterFactorialStream counterFactorial = new CounterFactorialStream();

        long start = System.nanoTime();

        List<Future<Long>> futures = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        int countNumbers = 100000;
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < countNumbers; k++) {
            int rand = RandomNumberGenerator.getRandom(0, 10);
            numbers.add(rand);
//            max = Math.max(rand, max);
        }
//        numbers.stream().max(Integer::compare).get();// вычислить макс число из массива
//       // numbers.forEach(); // использовать для лямда
//        for (long num : numbers) {
//            /*при раскоментировании выводится полоное разложение каждого числа массива numbers на составляющие,
//             подсчет их факториала с записью в future.*/
////            for (int i = 0; i < num; i++) {
////                final int j = i; // вместо num передать j
//            futures.add(
//                    CompletableFuture.supplyAsync(
//                            () -> counterFactorial.(num),
//                            threadPool
//                    ));
////            }
//        }

        //todo сделать хаш мап где ключ num из numbers а значение future из futures
        for (Future<Long> future : futures) {
            System.out.println(future.get() + " = ");
        }
        System.out.printf("Executed by %d s", (System.nanoTime() - start) / (1000_000_000));

        // завершение работы программы
        threadPool.shutdown();
    }
}
