package com.fz.aifullyautomatic.config;

import com.fz.aifullyautomatic.annotation.CustomReportAuth;
import com.fz.aifullyautomatic.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @Author fang
 * @Date 2026/4/26 17:55
 * @注释 拦截器配置类
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {
    private final List<AnnotationHandler> annotationHandlers;

    public GlobalInterceptor(List<AnnotationHandler> annotationHandlers) {
        this.annotationHandlers = annotationHandlers;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 不是Controller方法，直接放行
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }
        for (AnnotationHandler annotationHandler : annotationHandlers) {
            Class<? extends Annotation> annotationType = annotationHandler.supportAnnotation();
            Annotation  annotation = getAnnotation(handlerMethod, annotationType);
            if (annotation != null){
                return annotationHandler.handle(request, response, handlerMethod);
            }
        }
        return true;

    }
    // 工具方法：获取 方法/类 上的注解
    private Annotation getAnnotation(HandlerMethod method, Class<? extends Annotation> annoClass) {
        Annotation a = method.getMethodAnnotation(annoClass);
        if (a == null) {
            a = AnnotationUtils.findAnnotation(method.getBeanType(), annoClass);
        }
        return a;
    }
}