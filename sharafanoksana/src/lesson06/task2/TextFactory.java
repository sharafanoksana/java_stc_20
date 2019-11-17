/**
 * @author Sharafan Oksana
 * @date 16.11.2019
 * @package lesson06.task2
 */
package lesson06.task2;

import java.util.ArrayList;
import java.util.List;

public class TextFactory {
    private List<String> textList = new ArrayList<>();
    private String text = "";

    /**
     * В конструктор передается словарь для создания предложений и количество абзацев в тексте
     * @param size количество абзацев
     * @param words ArrayList слов
     */
    public TextFactory(int size, List<String> words) {
        createListText(size, words);
    }

    /**
     * Метод генерирует текст из абзацев
     * @param size количество генерируемых абзацев в тексте
     */
    void createListText(int size, List<String> words) {
        for (int i = 0; i < size; i++) {
            ParagraphFactory p = new ParagraphFactory(words);
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
