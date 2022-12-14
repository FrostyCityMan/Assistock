package dh.assistock.wordcloud;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class WordCloudDAO {

    @Autowired
    SqlSession sqlSession;

    public List<WordCloudDTO> WordCloud(WordCloudDTO dto2){
        return sqlSession.selectList("WordCloud.WordCloud",dto2);
    }

    public List<Date> datelist(){
        return sqlSession.selectList("WordCloud.datelist");
    }
} //end of HomeDAO class
