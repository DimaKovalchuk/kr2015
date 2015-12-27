import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Дима on 22.12.2015.
 */
public class DatabaseFleats {

    private static String fileName = "doc.txt";
    private static File file = new File(fileName);

    //static Fleats[] databasefleats = new Fleats[10];

    static ArrayList<Fleats> databasefleats = new ArrayList<Fleats>();

    public static ArrayList<Fleats> read(String fileName) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        // exists("doc.txt");

        try {

            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {

                String district;

                while ((district = in.readLine()) != null) {

                    String adres = in.readLine();
                    String name1 = in.readLine();
                    String name2 = in.readLine();
                    String name3 = in.readLine();
                    String name4 = in.readLine();
                    String name5 = in.readLine();

                    Fleats fleats = new Fleats(district, adres, name1, name2, name3, name4, name5);
                    //databasefleats[i] = fleats;
                    databasefleats.add(fleats);
                    // i++;
                }
            } finally {

                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return databasefleats;
    }


    public static void write(String fileName,  ArrayList<Fleats> databasefleats) {

        File file = new File(fileName);


        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                for (int i = 0; i < databasefleats.size(); i++) {
                    out.println(databasefleats.get(i).getDistrict()+ "\r\n"
                            +databasefleats.get(i).getAdres() + "\r\n"
                            +databasefleats.get(i).getName1() + "\r\n"
                            +databasefleats.get(i).getName2() + "\r\n"
                            +databasefleats.get(i).getName3()  + "\r\n"
                            +databasefleats.get(i).getName4() + "\r\n"
                            +databasefleats.get(i).getName5());
                }

            } finally {

                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }


