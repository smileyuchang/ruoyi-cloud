package com.ruoyi.order.service;

import com.ruoyi.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ruoyi-storage")
public interface StorageService {

    @PostMapping("storage/decrease")
    R decrease(@RequestParam("productId") Long productId,
               @RequestParam("count") Integer count);

}
