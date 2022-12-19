package dh.assistock.dashboard;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class DashboardDTO {
    public DashboardDTO(String ID, String keywords, String class1) {
        this.ID = ID;
        Keywords = keywords;
        Class1 = class1;
    }

    private String ID;
    private String Keywords;
    private String Class1;


} //end of DashboardDTO class
