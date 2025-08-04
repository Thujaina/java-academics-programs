import java.io.*;
import java.net.*;

public class TalkClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String clientMsg, serverMsg;
        while (true) {
            System.out.print("You: ");
            clientMsg = keyboard.readLine(); // Send to server
            output.println(clientMsg);
            if (clientMsg.equalsIgnoreCase("exit")) break;

            serverMsg = input.readLine(); // Receive from server
            if (serverMsg.equalsIgnoreCase("exit")) break;
            System.out.println("Server: " + serverMsg);
        }

        socket.close();
    }
}
