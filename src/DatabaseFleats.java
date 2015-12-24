import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;

/**
 * Created by Дима on 22.12.2015.
 */
public class DatabaseFleats {

    File file = new File("doc.txt");

    Fleats[]  databasefleats = new Fleats [(int) (file.length()/(162))];

    public Fleats[] ReadFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile("doc.bin", "r");

            for (int i = 0; i < databasefleats.length; i++) {
                    file.seek(i*162);
                    String district = file.readUTF();
                    String street = file.readUTF();
                    int home = file.readInt();
                    int fleat = file.readInt();
                    String name1 = file.readUTF();
                    String name2 = file.readUTF();
                    String name3 = file.readUTF();
                    String name4 = file.readUTF();
                    String name5 = file.readUTF();

                Fleats  fleats = new Fleats(district, street,home,fleat,name1,name2,name3,name4,name5);
                databasefleats[i] = fleats;
            }

        return databasefleats;


    }

    public void Writeinfile(Fleats databasefleats[])throws IOException{

            file.exists();
            new File("doc.bin").delete();


        RandomAccessFile file = new RandomAccessFile("doc.bin", "rw");
        //try {file.seek(file.length());
        for (int i = 0; i < databasefleats.length; i++) {
            file.seek(i*162);
            file.writeUTF(databasefleats[i].getDistrict());
            file.writeUTF(databasefleats[i].getStreet());
            file.writeInt(databasefleats[i].getHome());
            file.writeInt(databasefleats[i].getFleat());
            file.writeUTF(databasefleats[i].getName1());
            file.writeUTF(databasefleats[i].getName2());
            file.writeUTF(databasefleats[i].getName3());
            file.writeUTF(databasefleats[i].getName4());
            file.writeUTF(databasefleats[i].getName5());

        }

        file.close();
    }

    public Object[][]  getData()  {

        try {
            ReadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] data = new String [databasefleats.length][9];

        for (int i = 0; i < databasefleats.length; i++) {

            data [i][0]=databasefleats[i].getDistrict();
            data [i][1]=databasefleats[i].getStreet();
            data [i][2]=databasefleats[i].getHome();
            data [i][3]=databasefleats[i].getFleat();
            data [i][4]=databasefleats[i].getName1();
            data [i][5]=databasefleats[i].getName2();
            data [i][6]=databasefleats[i].getName3();
            data [i][7]=databasefleats[i].getName4();
            data [i][8]=databasefleats[i].getName5();

        }

        return data;
    }




    }


