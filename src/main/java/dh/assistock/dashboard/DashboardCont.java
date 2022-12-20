package dh.assistock.dashboard;

import Crwaling.Now.CrwalingNowDTO2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
//        System.out.println(session.getAttribute("ID"));
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
                    System.out.println(dto);
                    dashboardDAO.Keywords(dto);
                    System.out.println("key: " + key + ", value: " + value + " ID: " + ID);
                }catch (Exception b){
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
                System.out.println(dto);
                dashboardDAO.deleteKeywords(dto);
                System.out.println("key: " + key + ", value: " + value + " ID: " + ID);

            });
        } catch (JsonProcessingException e) {
            System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");

        }

        return ResponseEntity.ok().build();

    }



    @RequestMapping(value = "/keywordNews", method = RequestMethod.POST)
    @ResponseBody
    public List<CrwalingNowDTO2> keywordNews(HttpServletRequest request,
                                            HttpServletResponse response){
        HttpSession session = request.getSession();
        String ID = session.getAttribute("ID").toString();
        List<CrwalingNowDTO2> list = new ArrayList<>();
        try {
            List<DashboardDTO> dashboardDTO = dashboardDAO.userKeywords(ID);
            if (dashboardDTO.size() > 0) {
                for (int i = 0; i < dashboardDTO.size(); i++) {
                    String keywords = dashboardDTO.get(i).getKeywords();
                    String Class = dashboardDTO.get(i).getClass1();
                    CrwalingNowDTO2 dto2 = null;
                    if (Class.equals("업종")) {
                        dto2 = new CrwalingNowDTO2("", keywords, "");
                    } else if (Class.equals("종목")) {
                        dto2 = new CrwalingNowDTO2(keywords, "", "");
                    } else if (Class.equals("국가")) {
                        dto2 = new CrwalingNowDTO2("", "", keywords);
                    }
                    // Add the elements of the list returned by dashboardDAO.keywordNews to the list object
//                    System.out.println(dashboardDAO.keywordNews(dto2).get(1).getURL_Now());
                    list.addAll(dashboardDAO.keywordNews(dto2));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");
        }
        System.out.println(list);
        return list;
    }


} //end of DashboardCont class
