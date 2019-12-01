/**
 * @author Sharafan Oksana
 * @date 20.11.2019
 * @package lesson7_1
 */
package lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

//todo лист аррей где уже хранятся подсчитанные элементы и следующий расчет элемента уже идет от посчитанного
public class CounterFactorialStream {
    protected static List<Long> table = new ArrayList<>(); // создаем кэш

    static {
        table.add(Long.valueOf(1)); // первый элемент кэша инициализируется значением 0! = 1
    }

    public static Long calculateFactorialStream(long num) {
        if (num < 0) throw new IllegalArgumentException("x должен быть неотрицательным.");
        for (int i = table.size(); i <= num; i++) {
            Long lastfact = table.get(i - 1);
            synchronized (CounterFactorialStream.class) {
                Long nextfact = lastfact * (Long.valueOf(i));
                table.add(nextfact);
            }
        }
        return table.get((int) num);
    }

//    public <U> Long calculateFactorialStrim(long num) {
//        if (num < 0) throw new IllegalArgumentException("x должен быть неотрицательным.");
//        for (int size = table.size(); size <= num; size++) {
//            Long lastfact = table.get(size - 1);
//            Long nextfact = lastfact * (Long.valueOf(size));
//            table.add(nextfact);
//        }
//        return (Long)table.get(num);
//    }


//
//    long calculateFactorial(long elementNum) {
//        long result = 1;
//        for (int i = 1; i <= elementNum; i++) {
//            result = result * i;
//        }
//        return result;
//    }


//        List<Long> list = new ArrayList<>();
//        Integer num = elementNum;
//        Stream.iterate(1, x -> x <= num, x -> x + 1)
//                .forEach(list::add);
//        // подсчет факториала
//        Optional<Integer> factorial = Stream.of(Stream.iterate(1, x -> x <= num, x -> x + 1)).reduce((acc, x) -> acc * x);
//        System.out.println(factorial.get());


//        Function<Long,Long> factorial = (Long elementNum) -> {
//            long result = 1;
//            for (long i = 1; i <= elementNum; i++){
//                result = result * i;
//            }
//            return result;
//        };
//        System.out.println( );

//        Optional<Integer> factorial = Stream.of(
//                Stream.iterate(1, x -> x <= elementNum, x -> x + 1))
//                .reduce((acc, x) -> acc * x);
}

