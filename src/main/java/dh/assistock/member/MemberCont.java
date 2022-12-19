package dh.assistock.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public String loginProc(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        MemberDTO dto = new MemberDTO(
                request.getParameter("Id").trim(),
                request.getParameter("PW").trim()
        );
        MemberDTO login = memberDAO.login(dto);
        if (login == null) {
            session.setAttribute("ID", null);
            session.setAttribute("PW", null);
            session.setAttribute("Class_Member", null);
            session.setAttribute("Name_Register", null);
            return login.getID();
//            loginFailed();
        } else {
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
        System.out.println("바뀐 비밀번호"+randPW);
        MemberDTO dto = new MemberDTO(randPW, Email);

            try {
                memberDAO.updatePW(dto);
                System.out.println(dto.getID());

            } catch (Exception e) {
                System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");

            }


        MemberDTO sendPW = memberDAO.findAccount(Email);
        memberService.sendMail(sendPW);
        System.out.println("바뀐 이메일"+sendPW.getEmail());
        System.out.println(dto.getID());
        return sendPW.getID();
    }
} //end of MemberCont class
