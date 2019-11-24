/**
 * @author Sharafan Oksana
 * @date 21.11.2019
 * @package lesson8
 */
package lesson8;

/**
 * Задание 1. Необходимо разработать класс, реализующий следующие методы:
 * void serialize (Object object, String file);
 * Object deSerialize(String file);
 * Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла.
 * Обязательна сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).
 * <p>
 * Задание 2. Предусмотреть работу c любыми типами полей (полями могут быть ссылочные типы).
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        //Serializator serializator = new Serializator();
        // serializator.serialize();

//        try (ObjectOutputStream oos =
//                     new ObjectOutputStream(new FileOutputStream("person.dat"))) {
//            Person p = new Person("Джон", 33, 178, true, new Pet("Пушок", 2));
//            oos.writeObject(p);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
        Pet cat = new Pet("Пушок", 2);
        Person tom = new Person("Tom", 35, 1.75, true);
        Serializer serializer = new Serializer();

        serializer.serialize(tom, "C:\\Users\\sharafan\\IdeaProjects\\java_stc_20\\person.txt");
        try {
            serializer.deSerialize("C:\\Users\\sharafan\\IdeaProjects\\java_stc_20\\person.txt");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        // запись в файл
//        try(DataOutputStream dos = new DataOutputStream(
//                new FileOutputStream("data.bin"))) {
//            // записываем значения
//            dos.writeUTF(tom.name);
//            dos.writeInt(tom.age);
//            dos.writeDouble(tom.height);
//            dos.writeBoolean(tom.married);
////            dos.write(cat.id);
////            dos.writeUTF(cat.nickname);
////            dos.write(cat.age);
//            System.out.println("Запись в файл произведена");
//        } catch(IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//         //обратное считывание из файла
//        try(DataInputStream dos = new DataInputStream(
//                new FileInputStream("data.bin"))) {
//            // записываем значения
//            String name = dos.readUTF();
//            int age = dos.readInt();
//            double height = dos.readDouble();
//            boolean married = dos.readBoolean();
////            String nickname = dos.readUTF();
////            int agePet = dos.readInt();
//            System.out.printf("Человека зовут: %s , его возраст: %d , его рост: %f метров, женат/замужем: %b ",
//            name, age, height, married
////                    ,nickname,agePet
//            );
//        } catch(IOException ex){
//            System.out.println(ex.getMessage());
//        }


//        try(ObjectOutputStream oos = new ObjectOutputStream(new
//                FileOutputStream("data.bin")))
//        {
//            Person p = new Person("Джон", 33, 178, true);
//            oos.writeObject(p);
//        }
//        catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//
//        try(ObjectInputStream ois = new ObjectInputStream(
//                new FileInputStream("person.dat"))) {
//            Person p = (Person)ois.readObject();
////            Pet c = (Pet)ois.readObject();
//            System.out.printf("Человека зовут: %s , его возраст: %d , его рост: %f метров, женат/замужем: %b",
//                    p.name, p.age, p.height, p.married
//            );
//        }
//        catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }

    }
}

