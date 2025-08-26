import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // Receive from client
            String msg = in.readLine();
            if (msg.equalsIgnoreCase("exit")) break;
            System.out.println("Client: " + msg);

            // Send reply
            System.out.print("You: ");
            String reply = userIn.readLine();
            out.println(reply);
            if (reply.equalsIgnoreCase("exit")) break;
        }

        s.close();
        ss.close();
    }
}
