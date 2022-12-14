package dh.assistock.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RequestMapping("/login")
@Controller
public class MemberCont {
    public MemberCont() {
        System.out.println("MemberCont Start");
    }

    @Autowired
    MemberDAO memberDAO;

    @Autowired
    MemberService memberService;

    @GetMapping()
    public ModelAndView loginform() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/member/loginForm");
        System.out.println(mav.toString());
        return mav;
    }


    //    Name_Register},Email},ID},PW},Class_Member},Date_Sub},Name_Member},Date_Join},Tel}
    //regist
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public int register(HttpServletRequest request, HttpServletResponse response) {
        MemberDTO dto = new MemberDTO(
                request.getParameter("Name_Register"),
                request.getParameter("Email"),
                request.getParameter("Regi_Id"),
                request.getParameter("Regi_PW"),
                request.getParameter("Class_Member"),
                new Date(),
                request.getParameter("Name_Member"),
                new Date(),
                request.getParameter("Tel")
        );

        return memberDAO.register(dto);
    }

    @RequestMapping(value = "/proc", method = RequestMethod.POST)
    @ResponseBody
    public String loginProc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String id = request.getParameter("Id");
        String pw = request.getParameter("PW");
        String rememberParam = request.getParameter("remember");
        boolean remember = rememberParam != null && rememberParam.equals("true");

        System.out.println(remember);

        // Check the login credentials
        MemberDTO dto = new MemberDTO(id, pw);
        MemberDTO login = memberDAO.login(dto);
        if (login == null) {
            // Login failed
            session.setAttribute("ID", null);
            session.setAttribute("PW", null);
            session.setAttribute("Class_Member", null);
            session.setAttribute("Name_Register", null);
            return null;
        } else {
            // Login succeeded
            if (remember) {
                // Create a cookie with the user's login information
                Cookie cookie = new Cookie("c_id", id);
                cookie.setMaxAge(604800); // Set the cookie's expiration time to 1 week
                // Add the cookie to the response
                response.addCookie(cookie);
            } else {
                // Remove the cookie if the user unchecks the box
                Cookie cookie = new Cookie("c_id", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

            // Set the session attributes with the user's information
            session.setAttribute("ID", login.getID());
            session.setAttribute("PW", login.getPW());
            session.setAttribute("Class_Member", login.getClass_Member());
            session.setAttribute("Name_Register", login.getName_Register());
            return login.getID();
        }
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }


    @RequestMapping(value={"/findID"},method = RequestMethod.POST)
    @ResponseBody
    public String findAccount(HttpServletRequest request, HttpServletResponse response) {
        String findAccount = "";
        String Email = request.getParameter("resetPassword");
        System.out.println(Email);
        String randPW = memberService.generateRandomPassword(10);
        System.out.println("?????? ????????????"+randPW);
        MemberDTO dto = new MemberDTO(randPW, Email);

            try {
                memberDAO.updatePW(dto);
                System.out.println(dto.getID());

            } catch (Exception e) {
                System.out.println(e.getClass().getName() + " ?????????" + e.getMessage() + " ????????? ??????");

            }


        MemberDTO sendPW = memberDAO.findAccount(Email);
        memberService.sendMail(sendPW);
        System.out.println("?????? ?????????"+sendPW.getEmail());
        System.out.println(dto.getID());
        return sendPW.getID();
    }
} //end of MemberCont class
