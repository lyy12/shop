package com.liuyuan.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liuyuan.gmall.bean.SkuInfo;
import com.liuyuan.gmall.service.ManageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
@CrossOrigin
@RestController
public class SkuController {

    @Reference
    ManageService manageService;

    @PostMapping("saveSkuInfo")
    public String  saveSkuInfo(@RequestBody SkuInfo skuInfo){
        manageService.saveSkuInfo(skuInfo);
        return  "success";
    }

}*/
