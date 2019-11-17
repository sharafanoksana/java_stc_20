/**
 * @author Sharafan Oksana
 * @date 15.11.2019
 * @package lesson06.task2
 */
package lesson06.task2;

import java.util.ArrayList;
import java.util.List;


public class ParagraphFactory {
    private List<String> paragraphs = new ArrayList<>();

    ParagraphFactory() {
        createListParagraph();
    }

    /**
     *  Метод создает текст, который состоит из абзацев. в одном абзаце 1<=n3<=20 предложений.
     */
    private void createListParagraph() {
        for (int i = 0; i < RandomNumberGenerator.getRandom(1, 20); i++) {
            SentenceFactory s = new SentenceFactory();
            this.paragraphs.add(s.getSentence());
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
