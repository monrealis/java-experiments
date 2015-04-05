package servlet3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class StartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent e) {
        e.getServletContext().setAttribute("startedAt", new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent e) {

    }
}
