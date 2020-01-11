/**
 * @author Sharafan Oksana
 * @date 10.01.2020
 * @package lesson10
 */
package lesson10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
    public static final int PORT = 8080;
    public static List<ServerSomthing> serverList = new LinkedList<>();// список всех нитей - экземпляров
    // сервера, слушающих каждый своего клиента
    public static Story story; // история переписки

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        story = new Story();
        System.out.println("Server Started");
        try {
            while (true){
                // Блокируется до возникновения нового соединения:
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerSomthing(socket)); // добавить новое соединенние в список
                }catch (IOException e){
                    // Если завершится неудачей, закрывается сокет, в противном случае, нить закроет его:
                    socket.close();
                }

            }
        }finally {
            server.close();
        }
    }
}
