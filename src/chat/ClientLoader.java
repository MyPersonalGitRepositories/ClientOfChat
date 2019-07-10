package chat;

import packet.OPacket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientLoader {

    private static Socket socket;

    public static void main(String[] args) {

        connect();
        handle();
        end();

    }

    public static void sendPacket(OPacket packet) {
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeShort(packet.getId());
            packet.write(dos);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void connect() {
        try {
            socket = new Socket("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle() {
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(117);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void end() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
