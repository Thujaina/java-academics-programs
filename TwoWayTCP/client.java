import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 1234);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // Send to server
            System.out.print("You: ");
            String msg = userIn.readLine();
            out.println(msg);
            if (msg.equalsIgnoreCase("exit")) break;

            // Receive reply
            String reply = in.readLine();
            if (reply.equalsIgnoreCase("exit")) break;
            System.out.println("Server: " + reply);
        }

        s.close();
    }
}
