/**
 * @author Sharafan Oksana
 * @date 16.11.2019
 * @package lesson06.task2
 */
package lesson12;

import lesson06.task2.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class TextFactory12 {
    private List<String> textList = new ArrayList<>();
    private String text = "";
    private int size = 0;


    /**
     * В конструктор передается словарь для создания предложений и количество абзацев в тексте
     *  @param words       ArrayList слов
     * @param probability вероятность вхождения слов
     */
    public TextFactory12(List<String> words, int probability) {
        createListText(words, probability);
    }

    /**
     * Метод генерирует текст из абзацев
     * количество генерируемых абзацев в тексте 1 - 20
     */
    void createListText(List<String> words, int probability) {
            for (int i = 0; i < RandomNumberGenerator.getRandom(1, 20); i++) {
                ParagraphFactory12 p = new ParagraphFactory12(words, probability);
                this.textList.add(p.getParagraph());
            }
        mergeIntoString();
    }

    /**
     * Метод возвращает строку абзацев "склеенных" в текст файла
     */
    private void mergeIntoString() {
        text = String.join("", this.textList);
    }

    public List<String> getTextList() {
        return textList;
    }
}
