/**
 * @author Sharafan Oksana
 * @date 17.11.2019
 * @package lesson06.task2
 */
package lesson06.task2;

import java.io.*;
import java.util.List;

/**
 * Фабрика создания текстовых файлов
 */
class FileFactory {

    /**
     * Метод для создания сгенерированных текстовых файлов в заданном количестве
     * @param path - католог, в который записываются файлы
     * @param n - количество записываемых файлов
     * @param size - размер файла
     * @param words - список слов, для генерации текста
     * @param probability - вероятность вхождения слов в текст 1-100
     */
    public void getFiles(String path, int n, int size, List<String> words, int probability) {
        for (int i = 0; i < n; i++) {
            String pth = path + "\\6_" + i + ".txt";
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
                    } else {
                        bos.write(buffer, 0, size - elemCount);
                        elemCount += (size - elemCount);
                    }
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
