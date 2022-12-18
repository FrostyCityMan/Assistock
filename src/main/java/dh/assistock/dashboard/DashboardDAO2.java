package dh.assistock.dashboard;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DashboardDAO2 {
    @Autowired
    SqlSession sqlSession;

    public int todayNewsCount() {
        return sqlSession.selectOne("Dashboard.todayNewsCount");
    }

    public double todayNewsAvg() {
        return sqlSession.selectOne("Dashboard.todayNewsAvg");
    }

    public List<String> class_Item() {
        return sqlSession.selectList("Dashboard.class(item)");

    }
    public List<String> name_stock() {
        return sqlSession.selectList("Dashboard.name(stock)");

    }


} //end of DashboardDAO2 class
