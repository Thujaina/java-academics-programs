# Simple Java Socket Echo Program

This project demonstrates a simple echo server and client using Java sockets. The echo server listens for incoming connections and sends back any message it receives from the client, prefixed with "Echo: ". The client connects to the server, sends messages, and receives responses.

## Files

- `EchoServer.java`: The server program. It listens for client connections and echoes received messages.
- `EchoClient.java`: The client program. It connects to the server, sends user input, and displays the echoed response.

## How It Works

1. **Server Side (`EchoServer.java`):**
    - Listens on port `12345` for incoming client connections.
    - Accepts a client connection and waits for messages.
    - For each message received, it sends back "Echo: [message]".
    - If the client sends "exit", the connection is closed.

2. **Client Side (`EchoClient.java`):**
    - Connects to the server at `localhost` on port `12345`.
    - Reads input from the user and sends it to the server.
    - Displays the server's response.
    - If the user enters "exit", the client disconnects.

## How to Run

1. **Compile the programs** (in your terminal or command prompt):

    ```bash
    javac EchoServer.java
    javac EchoClient.java
    ```

2. **Start the server**:

    ```bash
    java EchoServer
    ```

3. **Start the client in a separate terminal**:

    ```bash
    java EchoClient
    ```

4. **Use the client**:
    - Type a message and press Enter.
    - The server will echo back the message.
    - Type "exit" to close the client connection.

## Notes

- Both programs should run on the same machine for simplicity, but you can change `host` in `EchoClient.java` to the server's IP address if running on different machines.
- Make sure port `12345` is not blocked by your firewall.

## Example Output

**Client:**
```
Connected to Echo Server at localhost:12345
Enter message (type 'exit' to quit): Hello
Server response: Echo: Hello
Enter message (type 'exit' to quit): How are you?
Server response: Echo: How are you?
Enter message (type 'exit' to quit): exit
```

**Server:**
```
Echo Server is running on port 12345
Client connected: /127.0.0.1
Received: Hello
Received: How are you?
Received: exit
Client disconnected.
```

---

This example gives you a clear understanding of basic socket programming and echo communication in Java.
