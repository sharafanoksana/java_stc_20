/**
 * @author Sharafan Oksana
 * @date 13.11.2019
 * @package lesson06.task2
 */
package lesson26;

import java.util.*;

/**
 * Задание 2. Создать генератор текстовых файлов, работающий по следующим правилам:
 * <p>
 * -    Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * -    Слово состоит из 1<=n2<=15 латинских букв
 * -    Слова разделены одним пробелом
 * -    Предложение начинается с заглавной буквы
 * -    Предложение заканчивается (.|!|?)+" "
 * -    Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и
 * перенос каретки.
 * -    Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в
 * следующее предложение (1/probability).
 * -    Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
 * который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.
 */
public class Main {
    public static void main(String[] args) {
        String[] wordsArray = new String[1000];
        for (int i = 0; i < 1000; i++) {
            wordsArray[i] = new Word().toString();
        }
        List<String> words = Arrays.asList(wordsArray);

        FileFactory fileFactory = new FileFactory();
        //Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
        // который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность
        String path = "C:\\Users\\sharafan\\IdeaProjects\\java_stc_20\\sharafanoksana\\src\\lesson06\\task2\\randomTexts";
        fileFactory.getFiles(path, 5, 2500, words, 50);
    }
}
