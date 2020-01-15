/**
 * @author Sharafan Oksana
 * @date 15.11.2019
 * @package lesson06.task2
 */
package lesson26;

import java.util.ArrayList;
import java.util.List;


public class ParagraphFactory {
    private List<String> paragraphs = new ArrayList<>();

    /**
     * В конструктор передается словарь для создания предложений
     * @param words ArrayList слов
     * @param probability
     */
    ParagraphFactory(List<String> words, int probability) {
        createListParagraph(words, probability);
    }

    /**
     *  Метод создает текст, который состоит из абзацев. в одном абзаце 1<=n3<=20 предложений.
     */
    private void createListParagraph(List<String> words, int probability) {
        for (int i = 0; i < RandomNumberGenerator.getRandom(1, 20); i++) {
            SentenceFactory s = new SentenceFactory(words, probability);
            this.paragraphs.add(s.getSentence(probability));
        }
        insertMetaElem();
    }

    /**
     * Метод вставляет в конец абзаца разрыв строки и перенос каретки
     */
    private void insertMetaElem() {
        int sizeParagraph = this.paragraphs.size() - 1;
        String last = this.paragraphs.get(sizeParagraph).trim() + "\n\r";
        this.paragraphs.remove(sizeParagraph);
        this.paragraphs.add(sizeParagraph, last);
    }

    /**
     * Метод возвращает строку "склеенных" в абзац предложений
     * @return строку абзаца
     */
    String getParagraph() {
        return String.join("", this.paragraphs);
    }
}
