/**
 * @author Sharafan Oksana
 * @date 09.11.2019
 * @package lesson03.task02
 */
package lesson03.task02;

import java.util.*;

/**
 * Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.
 * У класса должен быть метод addObject, добавляющий объект в коллекцию.
 * У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
 * Должен быть метод dump, выводящий содержимое коллекции в строку.
  */
public class ObjectBox {
    protected ArrayList<Number> listObj;

    public <Object> ObjectBox(Object[] objects) {
        this.listObj = new ArrayList<Number>((Collection<? extends Number>) Arrays.asList(objects));
    }

    /**
     * Метод добавляет объект в коллекцию listObj
     * @param o - oбъект для добавления
     * @return this.listObj - коллекция с добавленным элементом
     */
    public List<? extends Object> addObject(Object o){
        this.listObj.add((Number) o);
        return this.listObj;
    }

    /**
     * Метод проверяет наличие объекта в коллекции и при наличии удаляющий его
     * @param value
     * @return
     */
    public <T> List<? extends Object> deleteObject(Object value){
        for (Iterator<? super Number> iter = this.listObj.iterator(); iter.hasNext();){
            if (iter.next().equals(value)){
                iter.remove();
                System.out.println("Элемент: " + value + " - удален!");
            }
        }
        return this.listObj;
    }

    /**
     * выводит содержимое коллекции в строку
     */
    public void dump(){
        this.listObj.toString();
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "listObj=" + listObj +
                '}';
    }
}
