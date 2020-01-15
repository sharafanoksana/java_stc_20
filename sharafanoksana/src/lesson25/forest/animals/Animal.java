package lesson25.forest.animals;

import lesson25.forest.Forest;

import java.util.Random;

public class Animal {
    private String name;
    private Random random;
    /**
     * Текущие координаты животного
     */
    private int x, y;
    /**
     * Дальность прыжка
     */
    private int hard;

    public Animal()
    {
        this.random = new Random();
        this.x = this.random.nextInt(Forest.FOREST_SIZE);
        this.y = this.random.nextInt(Forest.FOREST_SIZE);
        this.hard = 1;
    }

    protected void setName(String name)
    {
        this.name = name;
    }

    protected void setHard(int hard)
    {
        this.hard = hard;
    }

    /**
     * Вывод состояния строк
     *
     * @return String
     */
    public String getStaistic()
    {
        return this.name + ". Мои координаты (" + this.x + ";" + this.y + ")";
    }

    /**
     * Базовый метод для хода животного
     * <p>
     * int hard - сила прыжка
     *
     * @param param - параметр Х или y
     * @return int - выбор действия (+) или (-) или (0) в зависимости от рандомного числа r (1-3)
     */
    private int getMoveCoord(int param, int hard)
    {
        int r = this.random.nextInt(3);
        if (r == 1 && (param + hard) < Forest.FOREST_SIZE)
        {
            param += hard;
        }
        else if (r == 2 && (param - hard) > 0)
        {
            param -= hard;
        }
        return param;
    }

    /**
     * Вычисление координат движения животного
     */
    public void doMove()
    {
        this.x = this.getMoveCoord(this.x, this.hard);
        this.y = this.getMoveCoord(this.y, this.hard);
    }
}






