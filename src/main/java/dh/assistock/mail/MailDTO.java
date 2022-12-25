package dh.assistock.mail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MailDTO {

    public MailDTO( String ID, String email) {
        this.ID = ID;
        Email = email;
    }

    private String ID;
    private String Email;
    private String MailOK;

} //end of MailDTO class
