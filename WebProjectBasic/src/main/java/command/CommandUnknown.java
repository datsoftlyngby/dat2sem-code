package command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUnknown extends Command
{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("errormessage", "Unknown command...");
        request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
}
