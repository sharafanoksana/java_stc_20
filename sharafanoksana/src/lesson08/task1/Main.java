/**
 * @author Sharafan Oksana
 * @date 28.11.2019
 * @package lesson08.task1
 */
package lesson08.task1;

import lesson08.Person;
import lesson08.Pet;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Задание 1. Необходимо разработать класс, реализующий следующие методы:
 * <p>
 * void serialize (Object object, String file);
 * <p>
 * Object deSerialize(String file);
 * <p>
 * Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла. Обязательна
 * сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Pet pet = new Pet("Шарик", 2);
        Person tom = new Person("Tom", 35, 1.75, true);
        SerializePerson serializePerson = new SerializePerson();
        serializePerson.serialize(tom, "Person.txt");
        Person p = (Person) serializePerson.deSerialize("Person.txt");
        System.out.println(p.toString());
    }
}

