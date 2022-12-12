package dh.assistock.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dashboard")
@Controller
public class DashboardCont {

    //
    public DashboardCont(){
        System.out.println("DashboardCont Start--------");
    }
    @Autowired
   DashboardDAO dashboardDAO;
} //end of DashboardCont class
