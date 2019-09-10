package com.liuyuan.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liuyuan.gmall.bean.*;
import com.liuyuan.gmall.service.ManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//跨域问题解决的三种情况1.协议不同，2.ip不同，3.端口号不同

@CrossOrigin
@RestController
public class ManageController {
    //这里用@Autowired是不行的，因为根本就不是一个容器
    @Reference
    ManageService manageService;
    //查询一级分类列表
    @PostMapping("getCatalog1")
    public List<BaseCatalog1> getBaseCatalog1List(){
        return manageService.getCatalog1List();
    }
    //根据一级分类id查询二级分类列表
    @PostMapping("getCatalog2")
    public List<BaseCatalog2> getBaseCatalog2(String catalog1Id){

        List<BaseCatalog2> baseCatalog2List = manageService.getCatalog2List(catalog1Id);
        return baseCatalog2List;
    }
    //查询二级分类id查询三级分类列表
    @PostMapping("getCatalog3")
    public List<BaseCatalog3> getBaseCatalog3List(String catalog2Id){
        return manageService.getCatalog3List(catalog2Id);
    }

    @GetMapping("attrInfoList")
    public List<BaseAttrInfo> getBaseAttrInfoList(String catalog3Id){
        List<BaseAttrInfo> attrList = manageService.getBaseAttrInfoList(catalog3Id);
        return attrList;
    }

    @PostMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){

        manageService.saveAttrInfo(baseAttrInfo);
        return  "success";

    }

    @PostMapping("getAttrValueList")
    public List<BaseAttrValue>  getAttrValueList(String attrId){
        //这里我只需要取到平台属性就可以了，里面自然会有所有的平台属性值，在这里，我通过平台属性id查询平台属性
        BaseAttrInfo baseAttrInfo = manageService.getBaseAttrInfo(attrId);
        //平台属性里有平台属性列表，者皆可以获取进行返回。
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();

        return attrValueList;

    }
    //根据三级分类获取所有的spu列表，在存spuInfo的时候，就要指定spuInfo隶属于某个三级分类
    @GetMapping("spuList")
    public List<SpuInfo> getSpuList(String catalog3Id){
        return manageService.getSpuList(catalog3Id);
    }

    //获取销售属性列表
    @PostMapping("baseSaleAttrList")
    public List<BaseSaleAttr> getBaseSaleAttrList(){
        return manageService.getBaseSaleAttrList();
    }

    //保存spu信息
    @PostMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody SpuInfo spuInfo){
        manageService.saveSpuInfo(spuInfo);
        return "success";
    }

    //根据spuid查询图片列表
    @GetMapping("spuImageList")
    public List<SpuImage> getSpuImageList(String spuId){
        return manageService.getSpuImageList(spuId);

    }

    //根据spuid查询销售属性
    @GetMapping("spuSaleAttrList")
    public  List<SpuSaleAttr> getSpuSaleAttrList(String spuId){
        return  manageService.getSpuSaleAttrList(spuId);
    }

}
