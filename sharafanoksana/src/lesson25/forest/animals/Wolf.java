package lesson25.forest.animals;

import java.util.UUID;

/**
 * Присвоение рандомного имени животному
 */
public class Wolf extends Animal {
    public Wolf()
    {
        this.setName("Я волк " + UUID.randomUUID());
    }
}

