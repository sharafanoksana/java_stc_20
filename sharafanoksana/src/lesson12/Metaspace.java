/**
 * @author Sharafan Oksana
 * @date 08.01.2020
 * @package lesson12
 */
package lesson12;

public class Metaspace {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception{
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("demo.Generated " + i).toClass();
            System.out.println(c.toString());
        }
    }
}
