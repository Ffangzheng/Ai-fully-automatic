package com.fz.aifullyautomatic.controller;

import com.fz.aifullyautomatic.annotation.CustomReportAuth;
import com.fz.aifullyautomatic.common.BaseResponse;
import com.fz.aifullyautomatic.common.ResultUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * &#064;Author  fang
 * &#064;Date  2026/3/18 8:27
 * &#064;注释  健康性检查
 */
@RestController
@RequestMapping("/health")
public class health {

    @GetMapping("/")
    @CustomReportAuth("admi")
    @Operation(summary = "健康检查")
    public BaseResponse<String> healthCheck(){
        return ResultUtils.success("ok");
    }
}
