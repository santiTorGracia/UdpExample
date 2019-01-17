import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver implements Runnable {
    private final DatagramSocket socket;

    public Receiver(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            byte[] data = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(data, data.length);
            try{
                socket.receive(receivePacket);
                String message = new String(receivePacket.getData());
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
