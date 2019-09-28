package com.liuyuan.gmall.service;

import com.liuyuan.gmall.bean.SkuLsInfo;
import com.liuyuan.gmall.bean.SkuLsParams;
import com.liuyuan.gmall.bean.SkuLsResult;

public interface ListService {

    /**
     * 保存数据到es 中！
     * @param skuLsInfo
     */
    void saveSkuLsInfo(SkuLsInfo skuLsInfo);

    /**
     * 检索数据
     * @param skuLsParams
     * @return
     */
    SkuLsResult search(SkuLsParams skuLsParams);

    /**
     * 记录每个商品被访问的次数
     * @param skuId
     */
    void incrHotScore(String skuId);
}