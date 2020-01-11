/**
 * @author Sharafan Oksana
 * @date 10.01.2020
 * @package lesson10
 */
package lesson10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * класс хранящий в ссылочном приватном
 * списке информацию о последних 10 (или меньше) сообщениях
 */
public class Story {
    private LinkedList<String> story = new LinkedList<>();

    /**
     * отсылаем последовательно каждое сообщение из списка
     * в поток вывода данному клиенту (новому подключению)
     * @param writer
     */
    public void printStory(BufferedWriter writer) {
        if(story.size() > 0) {
            try {
                writer.write("History messages" + "\n");
                for (String vr : story) {
                    writer.write(vr + "\n");
                }
                writer.write("/...." + "\n");
                writer.flush();
            } catch (IOException ignored) {}

        }
    }

    /**
     * добавить новый элемент в список
     * @param el
     */
    public void addStoryEl(String el) {
        // если сообщений больше 10, удаляем первое и добавляем новое
        // иначе просто добавить
        if (story.size() >= 10) {
            story.removeFirst();
            story.add(el);
        } else {
            story.add(el);
        }
    }
}
