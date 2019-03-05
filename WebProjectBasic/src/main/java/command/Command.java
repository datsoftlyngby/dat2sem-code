package command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public abstract class Command
{
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public static Command from(HttpServletRequest request)
    {
        Command c;
        
        String origin = request.getParameter("command");
        
        Map<String, Command> commands = Map.of(
            "userregister", new CommandUserRegister(),
            "userlogin", new CommandUserLogin(),
            "userlogout", new CommandUserLogout(),
            "userslist", new CommandUsersList(),
            "userdetails", new CommandUserDetails()
        );

        c = commands.getOrDefault(origin, new CommandUnknown());
        
        return c;
    }
}