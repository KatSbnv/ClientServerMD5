import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.io.*;

public class client {


    public client(){
        try {
            Socket clientSocket = new Socket("LocalHost", 8080);
            DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());

            os.writeUTF("Im a coder");

            clientSocket.close();
        } catch (IOException ex) {
            System.out.println("Didn't work! " + ex);
        }


    }

}