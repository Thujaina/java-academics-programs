📄 One-Way Chat Program using Java Sockets (TCP)

📘 Description

This is a simple implementation of a one-way communication system using Java socket programming over TCP.

The Server sends a series of messages to the Client.
The Client receives and displays these messages.
Communication stops when the server sends the keyword "exit".
🛠️ Technologies Used

Language: Java
Networking API: java.net.Socket, java.net.ServerSocket
Input/Output: PrintWriter, BufferedReader
📁 Files

File Name	Description
Server.java	Listens for client and sends messages
Client.java	Connects to server and receives messages
💡 How to Compile and Run

1️⃣ Compile Both Files:
javac Server.java
javac Client.java
2️⃣ Run the Server First:
java Server
3️⃣ In a New Terminal, Run the Client:
java Client
✅ Output Example (Client Side):

From Server: Hello client!
From Server: Welcome to server!
🔍 Program Flow

Server.java
Starts a server socket on port 1234.
Waits for client connection.
Sends three messages including "exit" to signal the end.
Client.java
Connects to the server on localhost and port 1234.
Reads and prints each message until "exit" is received.
Closes the socket connection.
📌 Note

Must run both programs from the same directory.
Ensure no other process is using port 1234.
This is a one-way communication program (Server → Client only).
🧠 Concepts Covered

TCP socket programming
ServerSocket and Socket
Input/output streams
Client-server architecture basics

