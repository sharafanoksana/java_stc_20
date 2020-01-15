package lesson25.forest;



import lesson25.forest.animals.Animal;
import lesson25.forest.animals.Rabbit;
import lesson25.forest.animals.Wolf;

import java.util.ArrayList;
import java.util.Random;

/**
 * Создание леса со сторонами 20*20
 */
public class Forest {
    public static final int FOREST_SIZE = 20;
    ArrayList<Animal> arrayOfAnimals;

    /**
     * Создание животных в лесу ФАБРИЧНЫМ ПАТЕРНОМ
     *
     * @param countAnimals количество животны создоваемых в лесу
     */
    public Forest(int countAnimals)
    {
        this.arrayOfAnimals = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < countAnimals; i++)
        {
            int r = random.nextInt(3);
            if (r == 1)
            {
                this.arrayOfAnimals.add(new Wolf());
            }
            else
            {
                this.arrayOfAnimals.add(new Rabbit());
            }
        }
    }

    /**
     * Вывод на экран координат движения животных
     */
    public void tick()
    {
        for (Animal currentAnimal : this.arrayOfAnimals)
        {
            System.out.println(currentAnimal.getStaistic());
            currentAnimal.doMove();
        }
    }
}
