package com.cj.demo.common.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class SessionFilter implements Filter {

    //标示符：表示当前用户未登录
    String NO_LOGIN = "您还未登录";

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] wholeWithUrls = new String[]{"/demo/login/page","/demo/loginAction/toLogin"};

    String[] endsWithUrls = new String[]{".css",".js",".jpg",".gif",".png",".map"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        if (!isNeedFilter(uri)) { //不需要过滤直接传给下一个过滤器
             filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if(session!=null&&session.getAttribute("user") != null){
                // System.out.println("user:"+session.getAttribute("user"));
                filterChain.doFilter(request, response);
            }else{
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
                    response.getWriter().write(this.NO_LOGIN);
                }else{
                    //重定向到登录页
                    response.sendRedirect(request.getContextPath()+"/login/page");
                }
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isNeedFilter(String uri){
        //遍历完整路径
        for (String wholeUrl : wholeWithUrls) {
            if(uri.equals(wholeUrl)) {
                return false;
            }
        }
        //遍历后缀名
        for (String endUrl : endsWithUrls) {
            if(uri.endsWith(endUrl)) {
                return false;
            }
        }
        return true;
    }

}
