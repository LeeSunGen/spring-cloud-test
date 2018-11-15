package com.itmuch.cloud.study.order.service.feign;

import com.itmuch.cloud.study.common.base.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.remote.commodity-service}",path = "/rest")
public interface CommodityFeignService {

    /**
     * 根据商品id获取商品库存数量
     * @param commodityId
     * @return
     */
    @RequestMapping(value = "/commodity/getCountById",method = RequestMethod.GET)
    Result<Integer> getCommodityCountById(@RequestParam(value = "commodityId") Long commodityId);

    /**
     * 根据商品id更新商品库存
     * @param commodityId
     * @param amount
     * @return
     */
    @RequestMapping(value = "/commodity/updateStock",method = RequestMethod.GET)
    Result<Boolean> updateStockByCommodityId(@RequestParam("commodityId") Long commodityId, @RequestParam("amount") Integer amount);
}
