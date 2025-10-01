import java.util.*;
public class CRCcheck 
{
    static String divide(String msg, String div)
   {
        char[] a = msg.toCharArray();
        int n = div.length();
        for (int i = 0; i <= a.length - n; i++) 
        {
            if (a[i] == '1') 
           {
                for (int j = 0; j < n; j++) 
                {
                    a[i + j] = (a[i + j] == div.charAt(j)) ? '0' : '1';
                }
            }
        }
        return new String(a).substring(a.length - n + 1);
    }
    public static void main(String[] args) 
.  {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Message: ");
        String msg = sc.next();
        System.out.print("Enter Divisor: ");
        String div = sc.next();
     
        String zeros = new String(new char[div.length() - 1]).replace('\0', '0');
        String appended = msg + zeros;
        String rem = divide(appended, div);
        String code = msg + rem;
        System.out.println("\n--- Sender Side ---");
        System.out.println("Divisor   : " + div);
        System.out.println("Appended  : " + appended);
        System.out.println("Remainder : " + rem);
        System.out.println("Codeword  : " + code);
        System.out.print("\nEnter Received Code: ");
        String recv = sc.next();
        String syn = divide(recv, div);
        System.out.println("\n--- Receiver Side ---");
        System.out.println("Divisor   : " + div);
        System.out.println("Received  : " + recv);
        System.out.println("Syndrome  : " + syn);
        String checkZeros = new String(new char[div.length() - 1]).replace('\0', '0');
        System.out.println(syn.equals(checkZeros) ? "No Error" : "Error Detected!");
    }
}
