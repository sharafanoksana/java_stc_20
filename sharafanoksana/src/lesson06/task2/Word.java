/**
 * @author Sharafan Oksana
 * @date 13.11.2019
 * @package lesson06.task1
 */
package lesson06.task2;

import java.io.Serializable;
import java.util.Objects;

public class Word implements Serializable {
    private static final long serialVersionUID = 1;
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
