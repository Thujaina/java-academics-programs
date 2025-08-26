import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        byte[] buf = new byte[1024];

        while (true) {
            String msg = in.readLine();
            socket.send(new DatagramPacket(msg.getBytes(), msg.length(), ip, 5000));
            if (msg.equalsIgnoreCase("exit")) break;

            DatagramPacket p = new DatagramPacket(buf, buf.length);
            socket.receive(p);
            String reply = new String(p.getData(), 0, p.getLength());
            System.out.println("Server: " + reply);
            if (reply.equalsIgnoreCase("exit")) break;
        }
        socket.close();
    }
}
