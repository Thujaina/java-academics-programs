import java.io.*;
import java.net.*;

public class TalkServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is waiting for a client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String clientMsg, serverMsg;
        while (true) {
            clientMsg = input.readLine(); // Receive from client
            if (clientMsg.equalsIgnoreCase("exit")) break;
            System.out.println("Client: " + clientMsg);

            System.out.print("You: ");
            serverMsg = keyboard.readLine(); // Send to client
            output.println(serverMsg);
            if (serverMsg.equalsIgnoreCase("exit")) break;
        }

        socket.close();
        serverSocket.close();
    }
}
