/**
 * @author Sharafan Oksana
 * @date 10.01.2020
 * @package lesson10
 */
package lesson10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * нить отправляющая сообщения приходящие с консоли на сервер
 */
public class WriteMsg extends Thread{
    private BufferedWriter out;
    private ClientSomthing clientSomthing;
    private Date time;
    private String dtime;
    private SimpleDateFormat dt1;
    private BufferedReader inputUser;
    private String nickname;

    public WriteMsg(BufferedWriter out, ClientSomthing clientSomthing, BufferedReader inputUser, String nickname) {
        this.out = out;
        this.inputUser = inputUser;
        this.clientSomthing = clientSomthing;
        this.nickname = nickname;
    }

    @Override
    public void run() {
        while (true){
            String userWord;
            try {
                time = new Date(); // текущая дата
                dt1 = new SimpleDateFormat("HH:mm:ss"); // берем только время до секунд
                dtime = dt1.format(time); // время
                userWord = inputUser.readLine(); // сообщения с консоли
                if(userWord.equals("quit")){
                    out.write("quit" + "\n");
                    clientSomthing.downService(); // выход
                    break; // выходим из цикла если пришло "quit"
                } else {
                    out.write("(" + dtime + ") " + nickname + ": " + userWord + "\n"); // отправляем на сервер
                }
                out.flush(); // чистим
            }catch (IOException e){
                clientSomthing.downService(); // выход
            }
        }
    }
}
