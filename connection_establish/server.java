import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        Socket s = ss.accept();
        
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("Hello client!");
        out.println("Welcome to server!");
        out.println("exit");

        s.close();
        ss.close();
    }
}

