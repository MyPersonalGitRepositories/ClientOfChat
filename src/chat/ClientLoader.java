package chat;

import packet.OPacket;
import packet.PacketAuthorize;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientLoader {

    private static Socket socket;

    public static void main(String[] args) {

        connect();
        handle();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
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
        sendPacket(new PacketAuthorize("Max " + System.currentTimeMillis()));
    }

    private static void end() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
