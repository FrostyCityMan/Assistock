package dh.assistock.dashboard;

import Crwaling.Now.CrwalingNowDTO2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@RequestMapping("/dashboard")
@Controller
public class DashboardCont {

    //
    public DashboardCont() {
        System.out.println("DashboardCont Start--------");
    }

    @Autowired
    DashboardDAO2 dashboardDAO;

    @RequestMapping(value = "/count", method = RequestMethod.POST)
    @ResponseBody
    public int todayNewsCount(HttpServletRequest request,
                              HttpServletResponse response)
            throws Exception {

        return dashboardDAO.todayNewsCount();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public List<String> class_Item(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {
        return dashboardDAO.class_Item();
    }

    @RequestMapping(value = "/search2", method = RequestMethod.POST)
    @ResponseBody
    public List<String> name_stock(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {
        return dashboardDAO.name_stock();
    }

    @RequestMapping(value = "/search3", method = RequestMethod.POST)
    @ResponseBody
    public List<String> Material(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {
        return dashboardDAO.Material();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(HttpServletRequest request, @RequestBody HashMap<Object, Object> data) {
        HttpSession session = request.getSession();
        String ID = session.getAttribute("ID").toString();
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(data);
            data.forEach((key, value) -> {
                try {
//            Put the key and value in the DTO.
                    DashboardDTO dto = new DashboardDTO(
                            ID,
                            value.toString(),
                            key.toString()
                    );
                    dashboardDAO.Keywords(dto);
                } catch (Exception b) {
                    System.out.println(b.getClass().getName() + " 예외가" + b.getMessage() + " 때문에 발생");

                }
            });

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> delete(HttpServletRequest request, @RequestBody HashMap<Object, Object> data) {
        HttpSession session = request.getSession();
        String ID = session.getAttribute("ID").toString();
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(data);
            data.forEach((key, value) -> {
                DashboardDTO dto = new DashboardDTO(
                        ID,
                        value.toString(),
                        key.toString()
                );
                dashboardDAO.deleteKeywords(dto);

            });
        } catch (JsonProcessingException e) {
            System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");

        }

        return ResponseEntity.ok().build();

    }


    @RequestMapping(value = "/keywordNews", method = RequestMethod.POST)
    @ResponseBody
    public List<CrwalingNowDTO2> keywordNews(HttpServletRequest request,
                                             HttpServletResponse response) {
        HttpSession session = request.getSession();
        String ID = session.getAttribute("ID").toString();
        String date = request.getParameter("date");

        Map<String, String[]> parameters = request.getParameterMap();
        String parameterName = null;
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            parameterName = entry.getKey();
        }

        List<CrwalingNowDTO2> list = new ArrayList<>();
        try {
            List<DashboardDTO> dashboardDTO = dashboardDAO.userKeywords(ID);
            if (dashboardDTO.size() > 0) {
                for (int i = 0; i < dashboardDTO.size(); i++) {
                    String keywords = dashboardDTO.get(i).getKeywords();
                    String Class = dashboardDTO.get(i).getClass1();
                    CrwalingNowDTO2 dto2 = null;
                    if (Class.equals("업종")) {
                        dto2 = new CrwalingNowDTO2("", keywords, "", parameterName);
                    } else if (Class.equals("종목")) {
                        dto2 = new CrwalingNowDTO2(keywords, "", "", parameterName);
                    } else if (Class.equals("국가")) {
                        dto2 = new CrwalingNowDTO2("", "", keywords, parameterName);
                    }
                    // Add the elements of the list returned by dashboardDAO.keywordNews to the list object
                    list.addAll(dashboardDAO.keywordNews(dto2));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");
        }
        return list;
    }

    @RequestMapping(value = "/Newstext", method = RequestMethod.POST)
    @ResponseBody
    public String Newstext(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {
        // Get the text sent through the AJAX request
        String text = request.getParameter("text");


        String url = text;

        Document subDoc = Jsoup.connect(url).get();

        Elements bElement = subDoc.getElementsByAttributeValue("class", "media_end_head_top");

        Element contentElement = subDoc.getElementById("dic_area");
        String content = contentElement != null ? contentElement.html() : null;

        return content;
    }

    @RequestMapping(value = "/maxNews", method = RequestMethod.POST)
    @ResponseBody
    public List<CrwalingNowDTO2> maxNews(HttpServletRequest request,
                                         HttpServletResponse response) {

        List<CrwalingNowDTO2> list = dashboardDAO.maxNews();
        return list;
    }

    @RequestMapping(value = "/maxNews2", method = RequestMethod.POST)
    @ResponseBody
    public List<CrwalingNowDTO2> maxNews2(HttpServletRequest request,
                                          HttpServletResponse response) {

        List<CrwalingNowDTO2> list = dashboardDAO.maxNews2();
        return list;
    }

    //    mailsave
    @RequestMapping(value = "/mailsave", method = RequestMethod.POST)
    @ResponseBody
    public void mail(HttpServletRequest request,
                     HttpServletResponse response
    ) {
        HttpSession session = request.getSession();
        String ID =  "'"+session.getAttribute("ID").toString()+"'";
        Map<String, String[]> parameters = request.getParameterMap();
        String parameterName = null;
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            parameterName ="'"+ entry.getKey()+"'";
        }
        DashboardDTO dto= new DashboardDTO(ID,parameterName);
        dashboardDAO.mailcheck(dto);
    }


} //end of DashboardCont class
