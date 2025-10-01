import java.util.Scanner;
class HammingFull 
{
    public static void main(String[] args)
   {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of data bits: ");
        int dataBits = sc.nextInt();
        int parityBits = 0;
        while (Math.pow(2, parityBits) < dataBits + parityBits + 1) 
       {
            parityBits++;
        }
        int totalBits = dataBits + parityBits;
        int[] code = new int[totalBits + 1];
        int[] received = new int[totalBits + 1];
        System.out.println("Enter the data bits:");
        int dataIndex = 0;
        for (int i = 1; i <= totalBits; i++) 
        {
            if ((i & (i - 1)) == 0) continue;
            dataIndex++;
            code[i] = sc.nextInt();
        }

        for (int i = 0; i < parityBits; i++)
.     {
            int parityPos = (int) Math.pow(2, i);
            int sum = 0;
            for (int j = 1; j <= totalBits; j++) 
           {
                if ((j & parityPos) != 0) 
               {
                    sum += code[j];
                }
            }
            code[parityPos] = sum % 2;
        }
        System.out.print("The correct Hamming code is: ");
        for (int i = totalBits; i >= 1; i--) 
      {
            System.out.print(code[i]);
        }
        System.out.println();
        System.out.println("Enter the received code bits:");
        for (int i = totalBits; i >= 1; i--) 
       {
            received[i] = sc.nextInt();
        }
        int errorPos = 0;
        for (int i = 0; i < parityBits; i++) 
        {
            int parityPos = (int) Math.pow(2, i);
            int sum = 0;
            for (int j = 1; j <= totalBits; j++) 
           {
                if ((j & parityPos) != 0) 
               {
                    sum += received[j];
                }
            }
            if (sum % 2 != 0) 
           {
                errorPos += parityPos;
            }
        }
        if (errorPos == 0) 
.      {
            System.out.println("No error detected in received message.");
        } 
        else 
      {
            System.out.println("Error detected at position: " + errorPos);
            received[errorPos] = 1 - received[errorPos];
        }
        System.out.print("The corrected Hamming code is: ");
        for (int i = totalBits; i >= 1; i--) 
       {
            System.out.print(received[i]);
        }
    }
}
