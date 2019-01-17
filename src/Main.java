import java.io.IOException;
import java.net.DatagramSocket;

public class Main {

    public static void main(String[] args) {
        String hostName = "localhost";
        int port = 8080;

        try {
            DatagramSocket socket = new DatagramSocket(port);
            Receiver receiver = new Receiver(socket);
            Thread receiverThread = new Thread(receiver);
            receiverThread.start();
            Sender sender = new Sender(hostName, port);
            sender.send("hello world\n");
            Thread.sleep(2000);
            receiverThread.interrupt();
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
