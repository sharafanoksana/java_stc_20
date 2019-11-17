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
public class FileFactory {
    static int elemCount = 0;

    /**
     * Метод для создания сгенерированных текстовых файлов
     * @param path путь к директории для создания файлов
     * @param n - количество создаваемых файлов
     * @param size - размер файлов в todo вероятность ????????????
     */
    public void getFiles(String path, int n, int size, List<String> words) {
        for (int i = 0; i < n; i++) {
            TextFactory textFactory = new TextFactory(size, words);
            String pth = path + "\\6_" + i + ".txt";
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pth), "UTF-8"));
            ) {
                for (String elem : textFactory.getTextList()) {
                    writer.write(elem);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Запись в файл " + "6_" + i + ".txt  создана");
            }
        }
    }
}
