package servlet3;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/two")
public class FilterTwo implements Filter {
    @Override
    public void init(FilterConfig config) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException {
        resp.getWriter().write("Two");
    }

    @Override
    public void destroy() {
    }
}
