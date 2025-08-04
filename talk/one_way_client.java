import java.io.*;
import java.net.*;

public class TalkClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message;

        while ((message = input.readLine()) != null) {
            if (message.equalsIgnoreCase("exit")) break;
            System.out.println("Server: " + message);
        }

        socket.close();
    }
}
