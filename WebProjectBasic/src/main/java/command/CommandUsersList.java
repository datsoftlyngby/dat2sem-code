package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import database.connector.DataSourceMysql;
import mapper.UserMapper;
import entity.User;

public class CommandUsersList extends Command
{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userloggedin");
        if(user == null || !user.isAdmin())
        {
            request.setAttribute("errormessage", "Only allowed for admins...");
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
        
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(new DataSourceMysql().getDataSource());

        request.setAttribute("users", userMapper.getUsers());
        request.getRequestDispatcher("/jsp/userslist.jsp").forward(request, response);
    }
}