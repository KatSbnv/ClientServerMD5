import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;

public class server {


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                ServerSocket ss = new ServerSocket(8080);
                Socket socket = ss.accept();
                System.out.println("Server: Connected with a client ");


                DataInputStream is = new DataInputStream(socket.getInputStream());
                System.out.println("Server read: " + is.readUTF());


            } catch (IOException ex) {

                System.out.println("Server: exception's thrown " + ex);
            }
        }).start();

        new Thread(() -> {
            new client();
        }).start();

    }

    public class MD5 {
        public String getHash(String str) throws Exception {


            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());

            byte[] dataBytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < dataBytes.length; i++) {
                sb.append(Integer.toString((dataBytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();


        }
    }
}