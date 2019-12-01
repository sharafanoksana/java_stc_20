/**
 * @author Sharafan Oksana
 * @date 17.11.2019
 * @package lesson06.task2
 */
package lesson12;

import lesson06.task2.TextFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Фабрика создания текстовых файлов
 */
class FileFactory12 {

    /**
     * Метод для создания сгенерированных текстовых файлов в заданном количестве
     * @param path - католог, в который записываются файлы
     * @param size - размер файла
     * @param words - список слов, для генерации текста
     * @param probability - вероятность вхождения слов в текст 1-100
     */
    public void getFiles(String path, int size, List<String> words, int probability) {
        while (true) {
            String pth = path + "\\12.txt";
            getFile(pth, size, words, probability);
        }
    }

    /**
     * Метод создает один файл заданного размера
     *
     * @param pth         - полное имя файла
     * @param size        - размер файла
     * @param words       - список слов
     * @param probability - вероятность попаденя слов из словаря в текст
     */
    private void getFile(String pth, int size, List<String> words, int probability) {
        int elemCount = 0;
        File file = new File(pth);
        TextFactory textFactory = new TextFactory(words, probability);
        try (FileOutputStream out = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            while (elemCount < size) {
                for (String elem : textFactory.getTextList()) {
                    byte[] buffer = elem.getBytes();
                    if (buffer.length < size - elemCount) {
                        bos.write(buffer, 0, buffer.length);
                        elemCount += buffer.length;
                        System.out.println(elem);
                    } else {
                        bos.write(buffer, 0, size - elemCount);
                        elemCount += (size - elemCount);
                    }

                    elemCount = 0;
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Запись в файл " + file.getName() + " создана. Размер файла: " + file.length());
        }
    }
}
