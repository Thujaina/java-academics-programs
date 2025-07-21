import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;
        try (Socket socket = new Socket(host, port);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to Echo Server at " + host + ":" + port);
            String inputLine;
            while (true) {
                System.out.print("Enter message (type 'exit' to quit): ");
                inputLine = userInput.readLine();
                out.println(inputLine);
                if ("exit".equalsIgnoreCase(inputLine)) {
                    break;
                }
                String response = in.readLine();
                System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
