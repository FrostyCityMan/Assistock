package dh.assistock.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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



} //end of DashboardCont class
