package com.ruoyi.storage.controller;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping(value = "storage/decrease")
    public R decrease(@RequestParam("productId") Long productId,
                      @RequestParam("count") Integer count) {
        storageService.decrease(productId,count);
        return R.ok("扣减库存成功");
    }

}
