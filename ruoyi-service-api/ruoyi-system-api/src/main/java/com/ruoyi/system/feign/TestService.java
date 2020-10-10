package com.ruoyi.system.feign;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ruoyi.common.constant.ServiceNameConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.feign.factory.RemoteDeptFallbackFactory;
import com.ruoyi.system.feign.sentinelFallback.TestServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户 Feign服务层
 *
 * @author zmr
 * @date 2019-05-20
 */
@FeignClient(name = ServiceNameConstants.SYSTEM_SERVICE,fallback = TestServiceFallback.class)
public interface TestService {
    /**
     * 查询部门列表
     */
    @GetMapping("dept/list")
    R list();
    @GetMapping("dept/test")
    R test();

    @GetMapping("dept/get/{deptId}")
    SysDept selectSysDeptByDeptId(@PathVariable("deptId") long deptId);
}
