import java.net.*;
import java.io.*;
class SlidingClient 
{
    public static void main(String[] args) 
   {
        try 
       {
            Socket soc = new Socket("Localhost", 500);
            PrintStream socOut = new PrintStream(soc.getOutputStream());
            BufferedReader socIn = new BufferedReader(
            new InputStreamReader(soc.getInputStream()) );
            BufferedReader keyIn = new BufferedReader(
            new InputStreamReader(System.in) );
            int flag = 0;
            System.out.print("Enter number of frames needed: ");
            int c = Integer.parseInt(keyIn.readLine());
            socOut.println(c);
            int i, j = 0;
            while (j < c) 
            {
                i = Integer.parseInt(socIn.readLine());
                System.out.println("Received frame no: " + i);
                System.out.println("Sending acknowledgement for frame no: " + i);
                socOut.println(i);
                j++;
            }
        } 
        catch (Exception e) 
       {
            System.out.println(e);
        }
    }
}
