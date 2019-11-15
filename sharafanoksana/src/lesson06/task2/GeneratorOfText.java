/**
 * @author Sharafan Oksana
 * @date 14.11.2019
 * @package lesson06.task2
 */
package lesson06.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorOfText {
    List<String> words = new ArrayList<>();
    List<String> sentences = new ArrayList<>();
    List<String> paragraph = new ArrayList<>();

    public GeneratorOfText() {
        this.words = words;
        this.sentences = sentences;
    }

    /**
     * Метод генерирует список слов. Слово состоит из 1<=n2<=15 латинских букв
     *
     * @return
     */
    List<String> creatDistionary() {

        for (int i = 0; i < 1000; i++) {
            this.words.add(new Word().toString());
        }
        return this.words;
    }

    /**
     * Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
     *
     * @return
     */
    // назвать getWordForSentence
    public List<String> creatSentence() {
        int lenghtSentence = getRandom(2, 15);
        for (int i = 0; i < lenghtSentence; i++) {
            String sentence = new StringBuilder().append(words.get(getRandom(0, 1000))).append(" ").toString();
            this.sentences.add(sentence);
        }
        return this.sentences;
    }

    public List<String> creatParagraph() {
        int quantitySentence = getRandom(1, 20);
        for (int i = 0; i <= quantitySentence; i++ ){
            String sent = String.join(" ", creatSentence());
            this.paragraph.add(sent);
        }
        return this.paragraph;
    }

    /**
     * Метод преобразовует набор слов из List<String> sentences в предложение, где первое слово с большой буквы,
     * в середину предложения рандомно вставляются знаки припенания.
     * Предложение заканчивается знаком припенания по рандомному выбору.
     * @return sentences
     */
    public List<String> punctuationInsert() {
        // Обработка первого слова в предложении
        int sizeCentence = this.sentences.size() - 1;
        String first = this.sentences.get(0).substring(0, 1).toUpperCase() + this.sentences.get(0).substring(1);
        this.sentences.add(0, first);
        this.sentences.remove(1);

        // Обработка слов в середине предложения
        for (int i = 0; i < getRandom(1, sizeCentence / 3); i++) {
            int idxMid = getRandom(0, sizeCentence - 1);
            String middle = this.sentences.get(idxMid).trim() + getPunctuationMidlle();
            this.sentences.add(idxMid, middle);
            this.sentences.remove(idxMid + 1);
        }

        // Обработка слов в конце предложения
        String last = this.sentences.get(sizeCentence).trim() + getPunctuationEnd();
        this.sentences.remove(sizeCentence);
        this.sentences.add(sizeCentence, last);

        return this.sentences;
    }

    /**
     * Метод рандомно подбирает пунктуацию для слов в конце предложения
     *
     * @return String возвращает знак пунктуации
     */
    private String getPunctuationEnd() {
        String valEnd = "";
        int elem = getRandom(0, 2);
        switch (elem) {
            case 0:
                valEnd = "? ";
                break;
            case 1:
                valEnd = ". ";
                break;
            case 2:
                valEnd = "! ";
                break;
        }
        return valEnd;
    }

    /**
     * Метод рандомно подбирает пунктуацию для слов в середине предложения
     *
     * @return String возвращает знак пунктуации
     */
    private String getPunctuationMidlle() {
        String valMiddle = "";
        int elem = getRandom(0, 4);
        switch (elem) {
            case 0:
                valMiddle = ", ";
                break;
            case 1:
                valMiddle = ": ";
                break;
            case 2:
                valMiddle = ", ";
                break;
            case 3:
                valMiddle = " - ";
                break;
            case 4:
                valMiddle = "; ";
                break;
        }
        return valMiddle;
    }

    private int getRandom(int min, int max) {
        Random random = new Random();
        int elemLenght = min + random.nextInt(max - min + 1);
        return elemLenght;
    }
}
