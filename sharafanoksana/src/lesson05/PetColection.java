/**
 * @author Sharafan Oksana
 * @date 11.11.2019
 * @package lesson05
 */
package lesson05;

import java.util.*;

public class PetColection {
    Set<Pet> pets = new HashSet<Pet>();

    public PetColection() {
        this.pets = pets;
    }

    /**
     * метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной
     * ситуации)
     *
     * @param pet
     */
    public Set<Pet> addPet(Pet pet) {
        this.pets.add(pet);
        return this.pets;
    }

    /**
     * поиск животного по его кличке (поиск должен быть эффективным)
     */
    public void nicknameSearch() {
        boolean b = false;
        System.out.println("Поиск питомца по кличке.\nВведите кличку животного:");
        Scanner scanner = new Scanner(System.in);
        String nickname = scanner.next();
        System.out.println("Запущен поиск питомца по кличке: " + nickname);
        for (Iterator<Pet> it = pets.iterator(); it.hasNext(); ) {
            Pet pet = it.next();
            if (pet.getNickname().equals(nickname)) {
                b = true;
                System.out.println("Найдено совпадение: " + pet.toString());
            }
        }
        if (b == false) {
            System.out.println("Совпадений не найдено!");
        }
    }

    /**
     * изменение данных животного по его идентификатору
     *
     * @return
     */
    public void changeWeghtByID() {
        System.out.println("Изменение данных животного по идентификатору. \nВведите id питомца:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Pet petcheng = null;
        for (Iterator<Pet> it = pets.iterator(); it.hasNext(); ) {
            petcheng = it.next();
            if (petcheng.getId() == id) {
                System.out.println("Найдено совпадение по id: " + petcheng.toString());
                System.out.println("Введите новый вес животного");
                Double newWeight = scanner.nextDouble();
                petcheng.setWeight(newWeight);
                scanner.close();
                System.out.println(petcheng.toString());
            }
        }
    }

    /**
     * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
     */
    public void printList() {
        System.out.println("Вывод на экран списка животных в отсортированном порядке. " +
                "Поля для сортировки –  хозяин, кличка животного, вес:");
        ComparePets comparator = new ComparePets();
        ArrayList<Pet> petArrayList = new ArrayList<>();
        petArrayList.addAll(pets);
        Collections.sort(petArrayList, comparator);
        for (Pet set : petArrayList) {
            System.out.println(set);
        }
    }

    @Override
    public String toString() {
        return "PetFileCabinet{" +
                "pets=" + pets +
                '}';
    }
}
