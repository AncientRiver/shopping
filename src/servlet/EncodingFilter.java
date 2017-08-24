package servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(
		urlPatterns = { 
				"/*", 
		}, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class EncodingFilter implements Filter {
	private String encoding=null;
	private FilterConfig config=null;
	
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.encoding=null;
		this.config=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(this.encoding != null){
			request.setCharacterEncoding(this.encoding);
			response.setContentType("text/html;charset="+this.encoding);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config=fConfig;
		this.encoding=fConfig.getInitParameter("encoding");//获得初始信息
	}

}
