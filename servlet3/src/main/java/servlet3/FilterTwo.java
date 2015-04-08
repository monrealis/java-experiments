package servlet3;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(value = "/two", initParams = @WebInitParam(name = "text", value = "Text"))
public class FilterTwo implements Filter {
    private FilterConfig config;
    @Override
    public void init(FilterConfig config) {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException {
        resp.getWriter().write("Two. " + config.getInitParameter("text"));
    }

    @Override
    public void destroy() {
    }
}
