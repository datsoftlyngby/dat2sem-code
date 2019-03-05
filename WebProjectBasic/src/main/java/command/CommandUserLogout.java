package command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandUserLogout extends Command
{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("userloggedin") != null)
        {
            session.setAttribute("userloggedin", null);
            response.sendRedirect("index.jsp");
        }
    }
}