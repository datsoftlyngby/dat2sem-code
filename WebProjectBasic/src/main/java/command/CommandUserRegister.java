package command;

import database.connector.DataSourceMysql;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapper.UserMapper;

public class CommandUserRegister extends Command
{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(new DataSourceMysql().getDataSource());
        
        User user = userMapper.registerUser(username, password, 100, false);
        
        if (user == null)
        {
            request.setAttribute("errormessage", "User not registered...");
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
        else
        {
            session.setAttribute("userloggedin", user);
            response.sendRedirect("jsp/userinfo.jsp");
        }
    }
}