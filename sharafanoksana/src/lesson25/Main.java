package lesson25;

import lesson25.forest.Forest;

public class Main {
    /**
     * Создание животных в лесу
     *
     * @param args
     */
    public static void main(String[] args)
    {
        Forest forest = new Forest(10);
        for (int i = 0; i < 3; i++)
        {
            forest.tick();

            System.out.println(); // разелитель хода
        }
    }
}
