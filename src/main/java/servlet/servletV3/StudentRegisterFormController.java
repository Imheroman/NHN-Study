package servlet.servletV3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegisterFormController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return "redirect:/studentWeb/register.jsp";
    }
}
