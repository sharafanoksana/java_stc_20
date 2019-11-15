/**
 * @author Sharafan Oksana
 * @date 14.11.2019
 * @package lesson06.task2
 */
package lesson06.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sentence {
    private List<String> words = new ArrayList<>();
    private List<String> arrayWords = new ArrayList<>();
    private String sentence = "";

    public Sentence() {
        this.words = words;
        this.arrayWords = arrayWords;
        this.sentence = sentence;
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
     * @return возвращает список слов для составления предложения
     */
    private List<String> getWordForSentence() {
        int lenghtSentence = getRandom(1, 15);
        for (int i = 0; i < lenghtSentence; i++) {
            String sentence = new StringBuilder().append(words.get(getRandom(0, 1000))).append(" ").toString();
            this.arrayWords.add(sentence);
        }
        punctuationInsert();
        return this.arrayWords;
    }

    /**
     * Метод создает предложение из списка отформатированных слов
     *
     * @return строка предложения
     */
    public String getSentence() {
        String sentence = String.join("", getWordForSentence());
        return sentence;
    }

    /**
     * Метод преобразовует набор слов из List<String> arrayWords в отформатированные слова для предложения,
     * где елемент первого слова с большой буквы,
     * в середине в элемент предложения рандомно вставляются знаки припенания,
     * последний елемент предложения заканчивается знаком припенания по рандомному выбору.
     *
     * @return arrayWords
     */
    private List<String> punctuationInsert() {
        // Обработка первого слова в предложении
        int sizeCentence = this.arrayWords.size() - 1;
        String first = this.arrayWords.get(0).substring(0, 1).toUpperCase() + this.arrayWords.get(0).substring(1);
        this.arrayWords.add(0, first);
        this.arrayWords.remove(1);

        // Обработка слов в середине предложения
        if (sizeCentence > 2) {
            for (int i = 0; i < getRandom(1, (sizeCentence / 4) + 1); i++) {
                int idxMid = getRandom(0, sizeCentence - 1);
                String middle = this.arrayWords.get(idxMid).trim() + getPunctuationMidlle();
                this.arrayWords.add(idxMid, middle);
                this.arrayWords.remove(idxMid + 1);
            }
        }

        // Обработка слов в конце предложения
        String last = this.arrayWords.get(sizeCentence).trim() + getPunctuationEnd();
        this.arrayWords.remove(sizeCentence);
        this.arrayWords.add(sizeCentence, last);

        return this.arrayWords;
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
