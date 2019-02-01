import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class Serializer {
    public static void main(String args[])throws Exception{
        String email = "j@baeldung.com";
        int id = new Random().nextInt();
        String name = "Michael Program";
        String number = "01234567890";
        AddressBookProtos.Person person =
                AddressBookProtos.Person.newBuilder()
                        .setId(id)
                        .setName(name)
                        .setEmail(email)
                        .addNumbers(number)
                        .build();

        AddressBookProtos.AddressBook addressBook
                = AddressBookProtos.AddressBook.newBuilder().addPeople(person).build();
        FileOutputStream fos = new FileOutputStream("protox.txt");
        addressBook.writeTo(fos);// Serialization

        AddressBookProtos.AddressBook deserialized = AddressBookProtos.AddressBook.newBuilder()
                .mergeFrom(new FileInputStream("protox.txt")).build();//Deserialize

        System.out.println(deserialized);
    }
}

