package com.ruoyi.system.feign.factory;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.feign.RemoteDeptService;
import com.ruoyi.system.feign.TestService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestServiceFallbackFactory  implements FallbackFactory<TestService> {
    @Override
    public TestService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new TestService()
        {

            @Override
            public R list() {
                return null;
            }

            @Override
            public R test() {
                return null;
            }

            @Override
            public SysDept selectSysDeptByDeptId(long deptId)
            {
                return null;
            }
        };
    }
}
