package com.ruoyi.account.controller;

import com.ruoyi.account.service.AccountService;
import com.ruoyi.common.core.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("account/decrease")
    public R decrease(@RequestParam("userId") Long userId,
                      @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        //return new CommonResult(200, "扣减账户余额成功");
        return R.ok("扣减账户余额成功");
    }


}
