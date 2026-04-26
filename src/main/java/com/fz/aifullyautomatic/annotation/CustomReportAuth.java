package com.fz.aifullyautomatic.annotation;

import java.lang.annotation.*;

/**
 * @Author fang
 * @Date 2026/4/26 18:01
 * @注释
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomReportAuth {
    String value() default "";
}
