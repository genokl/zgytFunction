package cn.zgyt.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "picFilter",urlPatterns = "/zgytimg/*")
public class PicFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		try {
	    	HttpServletRequest req=(HttpServletRequest)request;
	    	HttpServletResponse resp=(HttpServletResponse)response;
	    	if(req.getServletPath().startsWith("/zgytimg/")) {
	    		resp.sendRedirect(req.getServletPath().replace("/zgytimg/", "https://zgytpic-1252757547.cos.ap-chengdu.myqcloud.com/zgytpic/"));
	    	}else {
	    		chain.doFilter(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void destroy() {
    	
    }
}
