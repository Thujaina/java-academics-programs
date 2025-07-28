import java.io.*;
import java.net.*;
import java.net.InetAddress;
public class t_ip {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("IP Address: " + ip.getHostAddress());
    }
}
