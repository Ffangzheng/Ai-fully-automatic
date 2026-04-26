package com.fz.aifullyautomatic.filter;

import cn.hutool.core.bean.BeanException;
import com.fz.aifullyautomatic.annotation.CustomReportAuth;
import com.fz.aifullyautomatic.config.AnnotationHandler;
import com.fz.aifullyautomatic.dict.UserAuth;
import com.fz.aifullyautomatic.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;

/**
 * @Author fang
 * @Date 2026/4/26 19:30
 * @注释
 */
@Component
public class AuthInterceptor implements AnnotationHandler {
    @Override
    public Class<? extends Annotation> supportAnnotation() {
        return CustomReportAuth.class;
    }

    @Override
    public boolean handle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) throws Exception {
        CustomReportAuth customReportAuth = handler.getMethodAnnotation(CustomReportAuth.class);
        String value = customReportAuth.value();
        if (value.equals(UserAuth.SUPER_ADMIN)){
            return true;
        }
        throw new BusinessException(401, "没有访问权限");
    }
}
