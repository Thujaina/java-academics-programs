import java.net.*;
import java.io.*;
class SlidingServer 
{
    public static void main(String[] args) 
   {
        try 
       {
            ServerSocket sersoc = new ServerSocket(500);
            Socket soc = sersoc.accept();
            BufferedReader socIn = new BufferedReader(
            new InputStreamReader(soc.getInputStream()));
            PrintStream socOut = new PrintStream(soc.getOutputStream());
            int a;
            int p = Integer.parseInt(socIn.readLine());
            for (int i = 1; i <= p; ++i) 
            {
                System.out.println("Sending frame no: " + i);
                socOut.println(i);
                System.out.println("Waiting for acknowledgement...");
                Thread.sleep(5000);
                a = Integer.parseInt(socIn.readLine());
                System.out.println("Received acknowledgement for frame no: " + i + " as " + a);
            }
        }
        catch (IOException e) 
        {
            System.out.println(e);
        } 
       catch (InterruptedException e) 
       {
            System.out.println(e);
        }
    }
}
