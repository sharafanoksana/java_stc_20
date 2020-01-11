/**
 * @author Sharafan Oksana
 * @date 10.01.2020
 * @package lesson10
 */
package lesson10;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * нить чтения сообщений с сервера
 */
public class ReadMsg extends Thread{
    private BufferedReader in;
    private ClientSomthing clientSomthing;

    public ReadMsg(BufferedReader in, ClientSomthing clientSomthing) {
        this.clientSomthing = clientSomthing;
        this.in = in;
    }


    @Override
    public void run() {
        String str;
        try {
            while (true){
                str = in.readLine(); // ждем сообщения с сервера
                if(str.equals("quit")){
                    clientSomthing.downService(); // выход
                    break;
                }
                System.out.println(str); // пишем сообщение с сервера на консоль
            }
        }catch (IOException E){
            clientSomthing.downService();
        }
    }
}
