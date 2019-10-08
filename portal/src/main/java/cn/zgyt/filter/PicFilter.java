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

import org.springframework.beans.factory.annotation.Autowired;

import cn.zgyt.util.PortalConfig;

@WebFilter(filterName = "picFilter",urlPatterns = "/zgytimg/*")
public class PicFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Autowired
	private PortalConfig config;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		try {
	    	HttpServletRequest req=(HttpServletRequest)request;
	    	HttpServletResponse resp=(HttpServletResponse)response;
	    	String servletPath = req.getServletPath();
	    	String picPath = config.getPICUrlHeader();
	    	String picRealPath = config.getPICRealPath();
	    	String replace = servletPath.replace(picPath, picRealPath);
	    	if(req.getServletPath().startsWith(config.getPICUrlHeader())) {
	    		resp.sendRedirect(servletPath.replace(picPath, picRealPath));
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
