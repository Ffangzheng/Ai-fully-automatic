package com.fz.aifullyautomatic.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fang
 * @Date 2026/3/18 8:27
 * @注释
 */
@RestController
@RequestMapping("/health")
public class health {

    @GetMapping("/")
    @Operation(summary = "健康检查")
    public String healthCheck(){
        return "ok";
    }
}
