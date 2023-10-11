package com.xiaoxin.DormitoryAffairsBack.controller;

import com.xiaoxin.DormitoryAffairsBack.common.Result;
import com.xiaoxin.DormitoryAffairsBack.entity.User;
import com.xiaoxin.DormitoryAffairsBack.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//对当前接口类设置标签，本接口类为存放不需要权限验证的接口类，例如登录注册等等
@Api(tags="无权限接口列表")
@RestController
public class WebController {
    @Autowired
    IUserService userService;
    @GetMapping(value = "/")
    @ApiOperation(value ="版本校验接口")
    public String version() {
        String ver = "DormitoryAffairs-back-0.0.1-SNAPSHOT";  // 应用版本号
        Package aPackage = WebController.class.getPackage();
        String title = aPackage.getImplementationTitle();
        String version = aPackage.getImplementationVersion();
        if (title != null && version != null) {
            ver = String.join("-", title, version);
        }
        return ver;
    }
    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口")
    public Result login(@RequestBody User user) {
        User res = userService.login(user);
        return Result.success(res);
    }




}
