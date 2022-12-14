package dh.assistock.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAO {

@Autowired
SqlSession sqlSession;

    public int register(MemberDTO dto) {
        return sqlSession.insert("Member.insert",dto);
    }

    public MemberDTO login(MemberDTO dto) {

        return sqlSession.selectOne("Member.login",dto);
    }
//
    public MemberDTO findAccount(String Email){
        return sqlSession.selectOne("Member.findAccount",Email);
    }

    public int updatePW(MemberDTO dto){
        return sqlSession.update("Member.updatePW",dto);
    }

    public List<MemberDTO>mailList(){
        return sqlSession.selectList("Member.mailList");
    }

} //end of MemberDAO class
