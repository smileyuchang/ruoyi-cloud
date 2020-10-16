package com.ruoyi.order.service;

import com.ruoyi.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "ruoyi-account")
public interface AccountService {
    @PostMapping(value = "account/decrease")
    R decrease(@RequestParam("userId") Long userId,
               @RequestParam("money") BigDecimal money);
}
