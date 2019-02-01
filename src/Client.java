import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] argv) throws Exception {

        Socket sock = new Socket("127.0.0.1", 3001);
        byte[] mybytearray = new byte[1024];

        System.out.println("Prompt : Client is now up!");

        InputStream is = sock.getInputStream();
        FileOutputStream fos = new FileOutputStream("pr.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int bytesRead = is.read(mybytearray, 0, mybytearray.length);

        bos.write(mybytearray, 0, bytesRead);
        bos.close();
        sock.close();

        AddressBookProtos.AddressBook addressBook= AddressBookProtos.AddressBook.newBuilder()
                .mergeFrom(new FileInputStream("pr.txt")).build();

        System.out.println(addressBook);

    }
}