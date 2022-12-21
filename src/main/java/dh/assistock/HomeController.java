package dh.assistock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
    public class HomeController {

        public HomeController(){
            System.out.println("dh.assistock.HomeController created------");

        }// end of Test


        @RequestMapping("/")
        public ModelAndView home() {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("index");
            System.out.println(mav.toString());
            return mav;

        }//end of home
        @RequestMapping("/Pricing")
        public ModelAndView pricing() {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("/pricing/pricing");
            System.out.println(mav.toString());
            return mav;

        }

    @RequestMapping("/credit")
    public ModelAndView credit() {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/pricing/credit");
        System.out.println(mav.toString());
        return mav;

    }
    @RequestMapping("/dashboard")
    public ModelAndView dashborad() {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("dashboard/dashboard");
        System.out.println(mav.toString());
        return mav;

    }
    @RequestMapping("/dashboard/profile")
    public ModelAndView profile() {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("dashboard/profile");
        System.out.println(mav.toString());
        return mav;

    }

        @RequestMapping("/login/findAccountFailed")
        public ModelAndView loginFailed() {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("/member/findAccountFailed");
            System.out.println(mav.toString());
            return mav;

        }

        @RequestMapping("/about")
        public ModelAndView about() {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("about");
            System.out.println(mav.toString());
            return mav;
        }
    @RequestMapping("/userNews")
    public ModelAndView mail() {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("mailContent");
        System.out.println(mav.toString());
        return mav;

    }//end of home
} //end of dh.assistock.HomeController class
