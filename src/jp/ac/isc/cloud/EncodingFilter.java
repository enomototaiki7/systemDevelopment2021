package jp.ac.isc.cloud;

import java.io.*;

import javax.servlet.*;

public class EncodingFilter implements Filter{

	private String encoding = null;

	@Override
	public void init(FilterConfig config)throws ServletException{
		encoding = config.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {
		encoding = null;
	}

}
