package Crwaling.Now;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CrwalingNowDTO2 {
    public CrwalingNowDTO2(String name_Stock, String class_Item, String name_Country, String date) {
        Name_Stock = name_Stock;
        Class_Item = class_Item;
        Name_Country = name_Country;
        Date = date;
    }

    private String Name_News;
    private String Name_Stock;
    private String Class_Item;
    private String URL_Now;
    private String Name_Country;
    private String Head_Now;
    private int Score;

    private String Img;
    private String Date;
    public CrwalingNowDTO2(String name_News, String name_Stock, String class_Item, String URL_Now,  String head_Now, int score, String name_Country,String img) {
        Name_News = name_News;
        Name_Stock = name_Stock;
        Class_Item = class_Item;
        this.URL_Now = URL_Now;
        Head_Now = head_Now;
        Score = score;
        Name_Country = name_Country;
        Img = img;
    }
} //end of CrwalingNowDTO2 class
