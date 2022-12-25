package dh.assistock.mail;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MailDAO {

    @Autowired
    SqlSession sqlSession;

    public List<MailDTO> mailList() {
        return sqlSession.selectList("Mail.selectMail");
    }

} //end of MailDAO class
