/**
 * @author Sharafan Oksana
 * @date 08.01.2020
 * @package lesson12
 */
package lesson12;


import java.util.ArrayList;
import java.util.List;

public class HeapError {

    public static void main(String[] args) {
        List<String>myList = new ArrayList<>();
        myList.add("л");
        for (int i = 0; i < myList.size(); i++) {
            if(myList.get(i).contains("л")){
                myList.add(myList.get(i));
            }
        }
    }
}
