/**
 * @author Sharafan Oksana
 * @date 10.01.2020
 * @package lesson10
 */
package lesson10;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientSomthing {
    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток чтения в сокет
    private BufferedReader inputUser; // поток чтения с консоли
    private String addr; //ip адрес клиента
    private int port; // порт соединения
    private String nickname; // имя клиента

    /**
     * для создания необходимо принять адрес и номер порта
     * @param addr
     * @param port
     */
    public ClientSomthing(String addr, int port) {
        this.addr = addr;
        this.port = port;
        try {
            this.socket = new Socket(addr, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            // потоки чтения из сокета / записи в сокет, и чтения с консоли
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressNickname(); // перед началом необходимо спросить имя
            new ReadMsg(in, this).start(); // нить читающая сообщения из сокета в бесконечном цикле
            new WriteMsg(out, this, inputUser, nickname).start(); // нить пишущая сообщения в сокет приходящие с консоли в бесконечном цикле
        } catch (IOException e) {
            // Сокет должен быть закрыт при любой
            // ошибке, кроме ошибки конструктора сокета:
            ClientSomthing.this.downService();
        }
        // В противном случае сокет будет закрыт
        // в методе run() нити.
    }

    /**
     * просьба ввести имя и отсылка эхо с приветсвием на сервер
     */
    private void pressNickname() {
        System.out.println("Введите свой nickname:");
        try {
            nickname = inputUser.readLine();
            out.write("Привет, " + nickname + "!\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * закрытие сокета
     */
    public void downService() {
        try {
            if (!socket.isClosed()){
                socket.close();
                in.close();
                out.close();
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}
