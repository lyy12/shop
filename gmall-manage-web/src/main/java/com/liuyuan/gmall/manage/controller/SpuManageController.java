package com.liuyuan.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liuyuan.gmall.bean.SpuInfo;
import com.liuyuan.gmall.service.ManageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SpuManageController {

    @Reference
    private ManageService manageService;

    // http://localhost:8082/spuList?catalog3Id=63 实体类对象封装
    @RequestMapping("spuList")
    public List<SpuInfo> spuList(SpuInfo spuInfo){
        return manageService.getSpuList(spuInfo);
    }

    @RequestMapping("saveSpuInfo")
    public void saveSpuInfo(@RequestBody SpuInfo spuInfo){

        if (spuInfo!=null){
            // 调用保存
            manageService.saveSpuInfo(spuInfo);
        }


    }

}
