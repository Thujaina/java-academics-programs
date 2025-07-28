# Java Program to Find IP Address of the Local Host

## 📝 Aim
To write a Java program to retrieve and display the IP address of the local host using the `InetAddress` class.

---

## 🧾 Description
This program uses the `java.net.InetAddress` class to find the IP address of the machine on which it is run. It demonstrates basic networking in Java and how to access the IP information of the local system.

---

## 📂 File Name
`t_ip.java`

---

## 🧠 Concepts Used
- Java Networking (`java.net` package)
- `InetAddress` class
- `getLocalHost()` method
- `getHostAddress()` method

---

## 💻 Code

```java
import java.net.InetAddress;

public class t_ip {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("IP Address: " + ip.getHostAddress());
    }
}
⚙️ How to Compile and Run

javac t_ip.java
java t_ip
📌 Sample Output

IP Address: 192.168.1.5
(Note: The IP address may vary depending on your machine.)

📚 Usage

To understand Java's networking capabilities.
To fetch system-level network information.
As a basic building block for socket programming and network-based applications.
✅ Result

The program successfully retrieves and displays the IP address of the local host system.
