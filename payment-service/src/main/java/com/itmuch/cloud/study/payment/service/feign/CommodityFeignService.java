package com.itmuch.cloud.study.payment.service.feign;

import com.itmuch.cloud.study.common.base.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.remote.commodity-service}",path = "/rest/commodity")
public interface CommodityFeignService {

    @RequestMapping(value = "getPriceById",method = RequestMethod.GET)
    Result<Long> getPriceById(@RequestParam(value = "commodityId") Long commodityId);
}
