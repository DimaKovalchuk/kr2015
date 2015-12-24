import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Дима on 21.12.2015.
 */
public class Fleats {

    private String district;
    private String street;
    private int home;
    private int fleat;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;


    public Fleats(String district,String street, int home, int fleat,String name1,String name2,String name3,String name4,String name5) {
        this.district = district;
        this.street = street;
        this.home = home;
        this.fleat = fleat;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;
    }



    public String getDistrict(){
        return district;
    }

    public String getStreet(){
        return street;
    }

    public String getName1(){
        return name1;
    }

    public String getName2(){
        return name2;
    }

    public String getName3(){
        return name3;
    }

    public String getName4() {
        return name4;
    }

    public String getName5() {
        return name4;
    }

    public int getHome(){
        return home;
    }

    public int getFleat(){
        return fleat;
    }

/**
    public void print(){

        System.out.println(getName()+" "+getCountry()+" "+getIndate().get(Calendar.DAY_OF_MONTH)+"."
                +getIndate().get(Calendar.MONTH)+"."+getIndate().get(Calendar.YEAR)+
                " - "+getOutdate().get(Calendar.DAY_OF_MONTH)+"."+getOutdate().get(Calendar.MONTH)+"."+
                getOutdate().get(Calendar.YEAR)+" "+
                " "+getCoast()+" "+getNumbers());
    }
     **/

  /**  public void Writeinfile(Tour t)throws IOException{
        RandomAccessFile file = new RandomAccessFile("doc.bin", "rw");
        try {file.seek(file.length());


            file.writeUTF(t.getName());
            file.writeUTF(t.getCountry());
            file.writeLong((t.getIndate().getTime()));
            file.writeLong((t.getOutdate().getTime()));
            file.writeInt((t.getCoast()));
            file.writeInt((t.getNumbers()));


        } catch (NullPointerException e) {

        }
        file.close();
    }**/

}


