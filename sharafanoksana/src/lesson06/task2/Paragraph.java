/**
 * @author Sharafan Oksana
 * @date 15.11.2019
 * @package lesson06.task2
 */
package lesson06.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Paragraph {
    private List<String> paragraphs = new ArrayList<>();
    private String paragraph = "";

    public Paragraph() {
        this.paragraphs = paragraphs;
    }

    /**
     *  -    Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и
     *       перенос каретки.
     */
    public void createListParagraf() {
        for (int i = 0; i < getRandom(1, 20); i++) {
            Sentence s = new Sentence();
            s.creatDistionary();
            this.paragraphs.add(s.getSentence());
            System.out.println(s.getSentence());
        }
        insertMetaElem();
    }

    private void insertMetaElem() {
        int sizeParagraph = this.paragraphs.size() - 1;
        String last = this.paragraphs.get(sizeParagraph).trim() + "\n\r";
        this.paragraphs.remove(sizeParagraph);
        this.paragraphs.add(sizeParagraph, last);
    }

    public String getParagraph() {
        String sentence = String.join("", this.paragraphs);

        return sentence;
    }

    private int getRandom(int min, int max) {
        Random random = new Random();
        int elemLenght = min + random.nextInt(max - min + 1);
        return elemLenght;
    }
}
