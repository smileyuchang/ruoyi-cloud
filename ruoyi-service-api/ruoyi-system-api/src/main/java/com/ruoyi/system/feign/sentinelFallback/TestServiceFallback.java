package com.ruoyi.system.feign.sentinelFallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.feign.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceFallback implements TestService {

    @Override
    public R list() {
        return R.error("限流了");
    }

    @Override
    public R test() {
        return R.error("限流了");
    }

    @Override
    public SysDept selectSysDeptByDeptId(long deptId) {

        return null;
    }
}
