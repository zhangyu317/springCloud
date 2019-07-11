package com.zy;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter extends ZuulFilter{
	
//	private static Logger log = (Logger) LoggerFactory.getLogger(AccessFilter.class);
	/**
	 * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。pre代表会在请求被路由之前执行
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	
	/**
	 * 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来以此执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}
	
	/**
	 * 判断该过滤器是否需要执行。true代表该过滤器对所有的请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的具体逻辑。
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
//		log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		System.out.println("send "+ request.getMethod() + " request to " + request.getRequestURL().toString());
		
		Object accessToken =request.getParameter("accessToken");
		if(accessToken == null) {
//			log.warn("access token ok");
			System.out.println("access token is empty");
			//令zuul过滤该请求，不对其进行路由
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		System.out.println("access token is ok");
		return null;
	}

}
