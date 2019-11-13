/**
 * @author Sharafan Oksana
 * @date 11.11.2019
 * @package lesson05
 */
package lesson05;

/**
 * ДЗ_5
 * Разработать программу – картотеку домашних животных. У каждого животного есть уникальный идентификационный номер,
 * кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * <p>
 * Реализовать:
 * <p>
 * -    метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной
 * ситуации)
 * -    поиск животного по его кличке (поиск должен быть эффективным)
 * -    изменение данных животного по его идентификатору
 * -    вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 */

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Иванов", 38, "муж");
        Person person2 = new Person("Петрова", 18, "жен");
        Person person3 = new Person("Скорых", 21, "муж");
        Person person4 = new Person("Сидоров", 38, "муж");
        Person person5 = new Person("Марков", 24, "муж");
        Person person6 = new Person("Воронин", 25, "муж");
        Person person7 = new Person("Ивановa", 38, "жен");
        Person person8 = new Person("Волков", 21, "муж");

        Pet pet1 = new Pet("Барсик", person1, 2);
        Pet pet2 = new Pet("Кузя", person2, 1.5);
        Pet pet3 = new Pet("Пушок", person3, 1);
        Pet pet4 = new Pet("Дружок", person4, 15);
        Pet pet5 = new Pet("Верный", person5, 36);
        Pet pet6 = new Pet("Кеша", person6, 0.4);
        Pet pet7 = new Pet("Барсик", person7, 2);
        Pet pet8 = new Pet("Гоша", person8, 0.3);

        PetColection petColection = new PetColection();
        petColection.addPet(pet7);
        petColection.addPet(pet8);
        petColection.addPet(pet1);
        petColection.addPet(pet2);
        petColection.addPet(pet3);
        petColection.addPet(pet4);
        petColection.addPet(pet5);
        petColection.addPet(pet6);

        petColection.printList();
        petColection.nicknameSearch();
        petColection.nicknameSearch();
        petColection.changeWeghtByID();
        petColection.printList();
    }
}
