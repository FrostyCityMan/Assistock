package dh.assistock.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        System.out.println(dashboardDAO.todayNewsCount());
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

} //end of DashboardCont class
