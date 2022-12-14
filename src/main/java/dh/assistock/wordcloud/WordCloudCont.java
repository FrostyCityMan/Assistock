package dh.assistock.wordcloud;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class WordCloudCont {
    @Autowired
    WordCloudDAO wordCloudDAO;

    //워드 클라우드
    @RequestMapping(value = "/wordCloud", method = RequestMethod.POST)
    @ResponseBody
    public void sendData(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        try {
            Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

            String date = request.getParameter("datelist");
            System.out.println(request.getParameter("datelist"));

            SimpleDateFormat convert = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");

            Date date2 = convert.parse(date);
            System.out.println(date2);

            String NewDate = dateFormat.format(date2);

            System.out.println(NewDate);
            System.out.println( request.getParameter("select_class"));
            WordCloudDTO dto2 = new WordCloudDTO(
                    NewDate,
                    request.getParameter("select_class")
            );
//        Date newstime =formatter.parse(date);
            List<WordCloudDTO> list = wordCloudDAO.WordCloud(dto2);
            System.out.println(list.size()+"개");
            JSONArray jsonArray = new JSONArray();

            for (int a = 0; a < 50; a++) {
                WordCloudDTO dto = list.get(a);
                JSONObject Object = new JSONObject();
                Object.put("x", dto.getWord_Analysis());
                Object.put("value", dto.getWord_Count());
                jsonArray.add(Object);
            }


            response.setContentType("application/json;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.print(jsonArray.toJSONString());
        }catch (Exception e) {
            System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생---------------");
        }
    }//end of word cloud
} //end of WordCloudCont class
