import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Дима on 21.12.2015.
 */
public class Fleats {

    private String district;
    private String adres;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;


    public Fleats(String district,String adres,String name1,String name2,String name3,String name4,String name5) {
        this.district = district;
        this.adres = adres;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;
    }



    public String getDistrict(){
        return district;
    }

    public String getAdres(){
        return adres;
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

}


