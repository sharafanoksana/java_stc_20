/**
 * @author Sharafan Oksana
 * @date 13.11.2019
 * @package lesson06.task2
 */
package lesson12;

import java.util.Arrays;
import java.util.List;

/**
 Задание 1.     Необходимо создать программу, которая продемонстрирует утечку памяти в Java. При этом объекты должны
                не только создаваться, но и периодически частично удаляться, чтобы GC имел возможность очищать часть
                памяти. Через некоторое время программа должна завершиться с ошибкой OutOfMemoryError c пометкой Java
                Heap Space.

 Задание 2.     Доработать программу так, чтобы ошибка OutOfMemoryError возникала в Metaspace /Permanent Generation
 */
public class Main {
    public static void main(String[] args) {
        String[] wordsArray = new String[1000];
        for (int i = 0; i < 1000; i++) {
            wordsArray[i] = new Word12().toString();
        }
        List<String> words = Arrays.asList(wordsArray);

        FileFactory12 fileFactory = new FileFactory12();
        //Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
        // который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность
        String path = "C:\\Users\\sharafan\\IdeaProjects\\java_stc_20\\sharafanoksana\\src\\lesson12";
        fileFactory.getFiles(path, 2500, words,100);
    }
}
