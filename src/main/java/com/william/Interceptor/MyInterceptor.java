package com.william.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();

//        if (request.getRequestURI().contains("login")){
//            return true;
//        }
//
//        if (httpSession.getAttribute("userLoinIngo")!=null){
//            return true;
//        }
//
//        System.out.println("拦截了");
//        request.getRequestDispatcher("/WEB-INF/templates/login.html").forward(request,response);
        return true;
    }

}
