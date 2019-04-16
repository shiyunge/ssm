package com.fable.dataReceiver.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HTTP请求跨域拦截器
 *
 * @author afeey
 */
public class HttpCrossOriginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(HttpCrossOriginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String referer = request.getHeader("Referer");
        String path = request.getServletPath();
        log.debug("referer:{}, path:{}", referer, path);

        //Ajax跨域访问
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Control-Allow-Headers,Authorization,X-Requested-With,clientType");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if ("OPTIONS".equals(request.getMethod())) {
            return false;
        }

        return true;
    }

}
