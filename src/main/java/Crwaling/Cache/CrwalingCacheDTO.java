package Crwaling.Cache;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CrwalingCacheDTO {

    public CrwalingCacheDTO(String name_Stock, String class_Item) {
        Name_Stock = name_Stock;
        Class_Item = class_Item;
    }

    private String Name_News;
    private String Name_Stock;
    private String Class_Item;
    private String URL_Now;
    private String Date_Now;
    private String Head_Now;
    private String Largest1_Now;
    private int Largest1_Now_number;
    private String Largest2_Now;
    private int Largest2_Now_number;
    private String Largest3_Now;
    private int Largest3_Now_number;
    private String Largest4_Now;
    private int Largest4_Now_number;
    private String Largest5_Now;
    private int Largest5_Now_number;
    private String Entire_Now;
    private int Entire_Now_number;
    private String Class_News;
    private String Img;

    public CrwalingCacheDTO(String name_News, String URL_Now, String date_Now,
                            String head_Now, String largest1_Now, int largest1_Now_number,
                            String largest2_Now, int largest2_Now_number, String largest3_Now,
                            int largest3_Now_number, String largest4_Now, int largest4_Now_number,
                            String largest5_Now, int largest5_Now_number, String entire_Now,
                            int entire_Now_number, String class_News, String img) {
        Name_News = name_News;
        this.URL_Now = URL_Now;
        Date_Now = date_Now;
        Head_Now = head_Now;
        Largest1_Now = largest1_Now;
        Largest1_Now_number = largest1_Now_number;
        Largest2_Now = largest2_Now;
        Largest2_Now_number = largest2_Now_number;
        Largest3_Now = largest3_Now;
        Largest3_Now_number = largest3_Now_number;
        Largest4_Now = largest4_Now;
        Largest4_Now_number = largest4_Now_number;
        Largest5_Now = largest5_Now;
        Largest5_Now_number = largest5_Now_number;
        Entire_Now = entire_Now;
        Entire_Now_number = entire_Now_number;
        Class_News = class_News;
        Img = img;
    }

} //end of CrwalingDTO class
