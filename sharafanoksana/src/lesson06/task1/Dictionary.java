/**
 * @author Sharafan Oksana
 * @date 13.11.2019
 * @package lesson06.task1
 */
package lesson06.task1;


import java.io.*;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.TreeSet;

public class Dictionary {
    private Set<String> words = new TreeSet<>();
    private String line;

    /**
     * Метод считывает из текстового файла слова без знаков пунктуации в нижним регистре и сохраняетя их
     * в коллекции TreeSet words отсортированными
     */
    public void getWordsFromFile() {
        try (
                FileInputStream fis = new FileInputStream("book.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr)) {
            while ((line = br.readLine()) != null) {
                String[] wordArray = line.split("[\\p{IsPunctuation}\\p{IsWhite_Space}]+");
                 for (String elem: wordArray){
                    words.add(elem.toLowerCase());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод считывает соллекцию Set<String> words и записывает слова в файл dectionary.txt. Файл dectionary.txt
     * всегда перезаписывается
     */
    public void saveWordsToFile(){
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dectionary.txt"),"UTF-8"));
        ) {
            for (String elem: words){
                writer.write(elem + "\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Запись в файл \"dectionary.txt\" создана");
        }
    }

    public void print(){
        System.out.println(words.toString());
        System.out.println(words.size());
    }
}

