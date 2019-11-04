/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task03
 */
package lesson02.task03;

import java.util.Random;

enum Sex {MAN, WOMAN};
public class Person {
    private int age;
    private Sex sex;
    private String name;

    public Person() {
        this.age = generateAge();
        this.sex = generateSex();
        this.name = generateName();
    }

    public int getAge() {
        return this.age;
    }

    public Sex getSex() {
        return this.sex;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return  "Person{" +
                "sex=" + sex +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * метод генерирует воздраст
     * @return age - возвращает сгенирированное число от 0-100
     */
    private int generateAge() {
        Random rAge = new Random();
        age = rAge.nextInt(101);
        return age;
    }

    /**
     * метод генерирует пол персоны
     * @return значение enum Sex
     */
    private Sex generateSex(){
        Random rSex = new Random();
        boolean bSex = rSex.nextBoolean();
        if (true != bSex) {
            return this.sex= Sex.WOMAN;
        }
        else {this.sex = Sex.MAN;}
        return this.sex;
    }

    /**
     * метод генерирует имя персоны
     * @return строку имени
     */

    private String generateName(){
        Random generator = new Random();
        int nameLenght = generator.nextInt(8);
        String alphabet = "абвгдежзклмнопрстуфхцчшщьыэюя";
        int lenAlphabet = alphabet.length();
        StringBuilder sb = new StringBuilder(nameLenght);
        // к nameLenght прибавляет 2 для создания имен в диапазоне от 2 - 10  букв
        for (int i = 0; i < nameLenght + 2 ; i++) {
            int randomIdx = generator.nextInt(lenAlphabet);
            char letter = alphabet.charAt(randomIdx);
            sb.append(letter);
        }
        return sb.toString();
    }
}


