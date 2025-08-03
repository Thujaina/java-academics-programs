import java.io.*;
import java.net.*;

public class SimplePingServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                System.out.println("Client connected.");

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if ("ping".equalsIgnoreCase(inputLine)) {
                        out.println("pong");
                    } else if ("exit".equalsIgnoreCase(inputLine)) {
                        out.println("bye");
                        break;
                    } else {
                        out.println("unknown command");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
