import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        byte[] buf = new byte[1024];

        while (true) {
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            socket.receive(p);
            String msg = new String(p.getData(), 0, p.getLength());
            System.out.println("Client: " + msg);
            if (msg.equalsIgnoreCase("exit")) break;

            String reply = in.readLine();
            socket.send(new DatagramPacket(reply.getBytes(), reply.length(), p.getAddress(), p.getPort()));
            if (reply.equalsIgnoreCase("exit")) break;
        }
        socket.close();
    }
}
