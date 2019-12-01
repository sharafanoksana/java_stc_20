/**
 * @author Sharafan Oksana
 * @date 01.12.2019
 * @package lesson08.task1
 */
package lesson08.task1;

import lesson08.Person;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

public class SerializePerson {
    /**
     * Метод десериализует объект Person
     *
     * @param file - имя файла, в котором сохранен объект
     * @return ооъект Person
     */
    public Object deSerialize(String file) {

        Person person = new Person();
        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
             BufferedReader br = new BufferedReader(isr)) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] wordArray = line.split(":");
                for (int i = 0; i < wordArray.length; i++) {
                    switch (wordArray[i]) {
                        case "name":
                            person.setName(wordArray[i + 1]);
                            break;
                        case "age":
                            person.setAge(Integer.parseInt(wordArray[i + 1]));
                            break;
                        case "height":
                            person.setHeight(Double.parseDouble(wordArray[i + 1]));
                            break;
                        case "married":
                            person.setMarried(Boolean.parseBoolean(wordArray[i + 1]));
                            break;
                        case "country":
                            person.setCountry(wordArray[i + 1]);
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return person;
    }

    /**
     * метод сериализует объект Person
     *
     * @param object - объект для сериализации
     * @param file   - имя файла, в котором будет сохранен объект
     */
    public void serialize(Object object, String file) throws NoSuchFieldException, IllegalAccessException {
        Class personClass = object.getClass();

        Field personName = personClass.getDeclaredField("name");
        personName.setAccessible(true);
        String personNameValue = (String) personName.get(object);

        Field personAge = personClass.getDeclaredField("age");
        personAge.setAccessible(true);
        int personAgeValue = personAge.getInt(object);

        Field personHeight = personClass.getDeclaredField("height");
        personHeight.setAccessible(true);
        double personHeightValue = personHeight.getDouble(object);

        Field personMarried = personClass.getDeclaredField("married");
        personMarried.setAccessible(true);
        boolean personMarriedValue = personMarried.getBoolean(object);

        Field personCountry = personClass.getDeclaredField("country");
        personCountry.setAccessible(true);
        String personCountryValue = (String) personCountry.get(object);

//        Field personPetValue = petClass.getDeclaredField("id");
//        personPetValue.setAccessible(true);
//        int petId = personPetValue.getInt(object.getClass());
//        System.out.println(petId + " ");


//        Field[] declaredField = personClass.getDeclaredFields();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));) {
            // чтение полей класса:
//            for (Field field : declaredField) {
//                writer.write(field + "\n");
//                System.out.println(field);
//            }

            writer.write("name:" + personNameValue + "\n");
            writer.write("age:" + personAgeValue + "\n");
            writer.write("height:" + personHeightValue + "\n");
            writer.write("married:" + personMarriedValue + "\n");
            writer.write("country:" + personCountryValue + "\n");
//            writer.write(String.valueOf(personPetValue));
//            System.out.println(personPetValue);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
