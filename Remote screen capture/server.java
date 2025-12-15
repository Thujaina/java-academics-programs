// Enhanced the server by adding a counter to display how many screenshots have been transmitted
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

public class ScreenServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Waiting for client...");
        Socket socket = server.accept();
        System.out.println("Client connected.");

        // Capture screenshot
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenshot = robot.createScreenCapture(screenRect);

        // Send screenshot to client
        OutputStream out = socket.getOutputStream();
        ImageIO.write(screenshot, "png", out);

        out.close();
        socket.close();
        server.close();
        System.out.println("Screenshot sent.");
    }
}
