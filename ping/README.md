🟢 Simple Java Ping Program

This is a basic TCP client-server application in Java that simulates a ping mechanism. The client sends messages like "ping" or "exit", and the server replies accordingly.

📂 Files Included

SimplePingServer.java – Listens for client connections and responds to "ping", "exit", or unknown commands.
SimplePingClient.java – Connects to the server and sends commands typed by the user.

⚙️ How It Works

When the client sends ping → server replies pong.
When the client sends exit → server replies bye and both sides close the connection.
Any other input → server replies with unknown.

🧪 Example Output
Client:
Connected to server. Type 'ping' or 'exit'.
ping
Server: pong
hello
Server: unknown
exit
Server: bye

Server:
Server started. Waiting for client...
Client connected.

✅ Features

Simple socket communication using TCP
Command recognition on the server side
Clean shutdown using "exit"
Beginner-friendly code with comments

💻 How to Run

1. Compile both files:
javac SimplePingServer.java
javac SimplePingClient.java
2. Start the server:
java SimplePingServer
3. Start the client (in another terminal):
java SimplePingClient

📌 Requirements

JDK 8 or above
Java-compatible terminal (Linux, macOS, or Windows)
Optional: Two machines in the same network (use IP address instead of localhost)

📚 Learning Purpose

This project helps you understand:
TCP socket communication in Java
Client-server architecture
Input/output stream handling
Basic command protocol design
