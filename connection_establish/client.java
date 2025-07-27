import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 1234);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        String msg;
        while (!(msg = in.readLine()).equals("exit")) {
            System.out.println("From Server: " + msg);
        }

        s.close();
    }
}

