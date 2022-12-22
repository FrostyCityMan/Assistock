package Crwaling.Now;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
public class CrwalingNowDTO {

    @Builder
    public CrwalingNowDTO(String name_News, String name_Stock, String class_Item, String name_Country,
                          String URL_Now, String date_Now,
                          String head_Now, String entire_Now,
                          int score, String img) {
        this.Name_News = name_News;
        this.Name_Stock = name_Stock;
        this.Class_Item = class_Item;
        this.Name_Country = name_Country;
        this.URL_Now = URL_Now;
        this.Date_Now = date_Now;
        this.Head_Now = head_Now;
        this.Entire_Now = entire_Now;
        this.Score = score;
        this.Img = img;
    }

    public CrwalingNowDTO(String name_News, String name_Stock, String class_Item, String URL_Now, String head_Now, int score,String name_Country) {
        Name_News = name_News;
        Name_Stock = name_Stock;
        Class_Item = class_Item;
        this.URL_Now = URL_Now;
        Head_Now = head_Now;
        Score = score;
        Name_Country = name_Country;
    }
    private String Img;
    private String Name_News;
    private String Name_Stock;
    private String Class_Item;

    private String Name_Country;
    private String URL_Now;
    private String Date_Now;

    public CrwalingNowDTO(String date_Now, String entire_Now, String name_Stock) {
        Date_Now = date_Now;
        Entire_Now = entire_Now;
        Name_Stock = name_Stock;
    }

    private String Head_Now;
    private String Entire_Now;
    private String Word;
    private int Score;

    private Date Date_All;

    public CrwalingNowDTO(String name_News, String name_Stock, String class_Item, String URL_Now, String head_Now, String entire_Now, int score, String name_Country) {
        Name_News = name_News;
        Name_Stock = name_Stock;
        Class_Item = class_Item;
        this.URL_Now = URL_Now;
        Head_Now = head_Now;
        Entire_Now = entire_Now;
        Score = score;
        Name_Country = name_Country;
    }

    public CrwalingNowDTO(String word, int score) {
        Word = word;
        Score = score;
    }

    public CrwalingNowDTO(String name, String class_Item) {
        Name_Country = name;
        Class_Item = class_Item;
    }


} //end of CrwalingNowDTO class
