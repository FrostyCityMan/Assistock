package dh.assistock.dashboard;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardDAO2 {
    @Autowired
    SqlSession sqlSession;
    public int todayNewsCount(){
        return sqlSession.selectOne("Dashboard.todayNewsCount");
    }


} //end of DashboardDAO2 class
