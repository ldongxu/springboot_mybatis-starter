package com.example.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(getRequestInfo(request));
        return true;
    }

    private String getRequestInfo(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        StringBuilder sb = new StringBuilder("uri:");
        sb.append(request.getRequestURI());
        sb.append(", param:");
        StringBuilder psb = new StringBuilder();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            if (psb.length() > 0) {
                psb.append("&");
            }
            psb.append(entry.getKey()).append("=").append(arrToString(entry.getValue()));
        }
        sb.append(psb);
        return sb.toString();
    }

    private String arrToString(String[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
