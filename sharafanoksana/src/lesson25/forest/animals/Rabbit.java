package lesson25.forest.animals;

import java.util.UUID;

/**
 * Присвоение рандомного имени животному
 */
public class Rabbit extends Animal {
    public Rabbit()
    {
        this.setName("Я заяц " + UUID.randomUUID());
        this.setHard(2);
    }


}
