package com.fz.aifullyautomatic.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;

/**
 * @Author fang
 * @Date 2026/4/26 19:22
 * @注释 全局拦截器接口
 */
public interface AnnotationHandler {
    Class<? extends Annotation> supportAnnotation();

    boolean handle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) throws Exception;
}
