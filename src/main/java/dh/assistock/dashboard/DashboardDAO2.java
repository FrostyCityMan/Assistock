package dh.assistock.dashboard;

import Crwaling.Now.CrwalingNowDTO2;
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

    public List<String> Material() {
        return sqlSession.selectList("Dashboard.Material");

    }

    public void Keywords(DashboardDTO dto) {
        sqlSession.insert("Dashboard.Keywords", dto);
    }

    public List<DashboardDTO> userKeywords(String ID) {
        return sqlSession.selectList("Dashboard.userKeywords", ID);
    }

    public void deleteKeywords(DashboardDTO dto) {
        sqlSession.delete("Dashboard.deleteKeywords", dto);
    }

    public List<CrwalingNowDTO2> keywordNews(CrwalingNowDTO2 dto2){
        return sqlSession.selectList("Dashboard.keywordNews", dto2);
    }
    
    public String imgUrl(String URL_Now){
        return sqlSession.selectOne("Dashboard.imgURL",URL_Now);
    }

} //end of DashboardDAO2 class
