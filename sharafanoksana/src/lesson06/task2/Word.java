/**
 * @author Sharafan Oksana
 * @date 13.11.2019
 * @package lesson06.task1
 */
package lesson06.task2;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class Word implements Serializable {
    private static final long serialVersionUID = 1;
    private String word;

    Word() {
        this.word = generateWord();
    }

    /**
     * Метод генерирует случайное слово из латинского алфавита. Слово состоит из 1<=n2<=15 латинских букв
     * @return
     */
    private String generateWord(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        int wordLenght = RandomNumberGenerator.getRandom(2, 15);
        int lenAlphabet = alphabet.length();
        StringBuilder sb = new StringBuilder(wordLenght);
        for (int i = 0; i < wordLenght; i++) {
            int randomIdx = random.nextInt(lenAlphabet);
            char letter = alphabet.charAt(randomIdx);
            sb.append(letter);
        }
        return sb.toString();
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
        return word;
    }
}
