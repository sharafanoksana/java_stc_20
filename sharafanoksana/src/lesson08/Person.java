/**
 * @author Sharafan Oksana
 * @date 21.11.2019
 * @package lesson8
 */
package lesson08;

import java.lang.reflect.Field;

public class Person {

    private String name;
    private int age;
    private double height;
    private boolean married;
    private String country = "Russia";
//    Pet pet;

    public Person(String name, int age, double height, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
//        this.pet = pet;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person() {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
//        this.pet = pet;
    }

//    public Pet getPet() {
//        return pet;
//    }
//
//    public void setPet(Pet pet) {
//        this.pet = pet;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

//    public void serialazePet(){
//        Class<?> petClass = pet.getClass();
//        try {
//            Field personPetValue = petClass.getDeclaredField("id");
//            personPetValue.setAccessible(true);
//            int petId = personPetValue.getInt(pet.getClass());
//            System.out.println("petId = " + petId);
//        }catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", married=" + married +
                ", country='" + country + '\'' +
                '}';
    }
}
