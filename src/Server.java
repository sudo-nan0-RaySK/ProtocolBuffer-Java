import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String args[]) throws Exception{

        ServerSocket serverSocket= new ServerSocket(3001);
        File file= new File("protox.txt");

        System.out.println("Prompt : Server is listening...");

        while(true){

            Socket sock = serverSocket.accept();
            byte[] byteArray= new byte[(int) file.length()];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));

            bufferedInputStream.read(byteArray,0,byteArray.length);
            OutputStream os = sock.getOutputStream();
            os.write(byteArray,0,byteArray.length);
            os.flush();
            sock.close();

        }

    }
}
