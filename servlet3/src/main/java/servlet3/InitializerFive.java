package servlet3;

import javax.servlet.Filter;
import static java.lang.System.out;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes({ ServletOne.class, Filter.class })
public class InitializerFive implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        out.println(set);
    }
}
