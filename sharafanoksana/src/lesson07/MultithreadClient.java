/**
 * @author Sharafan Oksana
 * @date 20.11.2019
 * @package lesson7_1
 */
package lesson07;

/**
 * Дан массив случайных чисел. Написать программу для вычисления факториалов всех элементов массива. Использовать пул потоков для решения задачи
 */

import lesson06.task2.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MultithreadClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    //    ExecutorService threadPool = Executors.newWorkStealingPool(4); // время выполнения 1 секунда
        ThreadPool threadPool = new ThreadPool(4);// время выполнения 5 секунды; на 8 потоках - 14 секунд; на 100 - 312 секунд
        CounterFactorial counterFactorial = new CounterFactorial();

        long start = System.nanoTime();

        List<Future<Long>> futures = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        int countNumbers = 100000;
        for (int k = 0; k < countNumbers; k++) {
            numbers.add(RandomNumberGenerator.getRandom(0, 100));
        }
        for (long num : numbers) {
            /*при раскоментировании выводится полоное разложение каждого числа массива numbers на составляющие,
             подсчет их факториала с записью в future.*/
//            for (int i = 0; i < num; i++) {
//                final int j = i; // вместо num передать j
                futures.add(
                        CompletableFuture.supplyAsync(
                                () -> counterFactorial.calculateFactorial(num),
                                threadPool
                        ));
//            }
        }

        //todo сделать хаш мап где ключ num из numbers а значение future из futures
        for (Future<Long> future : futures) {
            System.out.println(future.get() + " = " );
        }
        System.out.printf("Executed by %d s", (System.nanoTime() - start) / (1000_000_000));

        // завершение работы программы
        threadPool.shutdown();
    }
}
