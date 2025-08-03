import java.io.*;
import java.net.*;

public class SimplePingClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change to server IP if needed
        int port = 5000;

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server. Type 'ping' to send ping, 'exit' to quit.");

            String inputLine;
            while ((inputLine = userInput.readLine()) != null) {
                out.println(inputLine);
                if ("exit".equalsIgnoreCase(inputLine)) {
                    break;
                }
                String response = in.readLine();
                System.out.println("Server: " + response);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
