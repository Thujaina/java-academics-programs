import java.io.*;
import java.net.*;

public class RCEclient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1000);

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Enter command: ");
        String command = keyboard.readLine();

        out.println(command);  // send to server

        socket.close();
    }
}
