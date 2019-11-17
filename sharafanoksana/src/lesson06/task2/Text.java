/**
 * @author Sharafan Oksana
 * @date 16.11.2019
 * @package lesson06.task2
 */
package lesson06.task2;

import java.util.ArrayList;
import java.util.List;

public class Text{
    private List<String> textList = new ArrayList<>();
    private String text = "";

    public Text() {
        createListText();
    }

    void createListText() {
        for (int i = 0; i < RandomNumberGenerator.getRandom(1, 20); i++) {
            Paragraph p = new Paragraph();
            this.textList.add(p.getParagraph());
        }
        mergeIntoString();
    }

    private void mergeIntoString() {
        text = String.join("", this.textList);
    }

    @Override
    public String toString() {
        return text;
    }
}
