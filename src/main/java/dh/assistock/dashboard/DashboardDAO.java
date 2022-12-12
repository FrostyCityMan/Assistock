package dh.assistock.dashboard;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardDAO {
    @Autowired
    SqlSession sqlSession;
} //end of DashBoardDAO class
