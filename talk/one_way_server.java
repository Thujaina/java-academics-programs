import java.io.*;
import java.net.*;

public class TalkServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String message;
        while (true) {
            System.out.print("Enter message to client: ");
            message = keyboard.readLine();
            output.println(message);

            if (message.equalsIgnoreCase("exit")) break;
        }

        socket.close();
        serverSocket.close();
    }
}
