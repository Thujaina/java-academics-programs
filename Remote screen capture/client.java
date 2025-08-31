import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ScreenClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000); // Change to server IP if remote
        InputStream in = socket.getInputStream();

        // Receive image
        BufferedImage img = ImageIO.read(in);

        // Show image in a window
        JFrame frame = new JFrame("Remote Screenshot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setVisible(true);

        in.close();
        socket.close();
    }
}
