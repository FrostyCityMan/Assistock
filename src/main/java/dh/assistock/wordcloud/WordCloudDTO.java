package dh.assistock.wordcloud;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WordCloudDTO {
    public WordCloudDTO(String date, String word_Analysis, int word_Count, String class_News) {
        Date = date;
        Word_Analysis = word_Analysis;
        Word_Count = word_Count;
        Class_News = class_News;
    }

    private String Date;
    private String Word_Analysis;
    private int Word_Count;
    private String Class_News;

    public WordCloudDTO(String date, String class_News) {
        Date = date;
        Class_News = class_News;
    }
} //end of WordCloudDTO class
