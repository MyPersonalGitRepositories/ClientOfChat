import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private static Socket socket;

    public static void main(String[] args) {

        connect();
        end();

    }

    private static void connect() {
        try {
            socket = new Socket("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle() {

    }

    private static void end() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
