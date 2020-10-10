package com.ruoyi.auth.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.feign.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试sentinel限流、熔断
 */
@RestController
public class TestControlelr {
    @Autowired
    TestService testService;


    /**
     * 限流测试
     * @return
     */
    /**
     * sentinel限流持久化配置 ，流控效果：快速失败（注：QPS:每秒请求数）
     * {
     *         "resource": "sentinel-testFeign",
     *         "limitApp": "default",
     *         "grade": 1,
     *         "count": 1,
     *         "strategy": 0,
     *         "controlBehavior": 0,
     *         "clusterMode": false
     *     }
     */
    @RequestMapping("/testFeign")
    @SentinelResource(value = "sentinel-testFeign",blockHandler = "testFeignException")
    public R test (){
        return  testService.test();
    }

    public R  testFeignException(BlockException blockException){
        return R.error("服务限流");
    }

    @RequestMapping("/testFeign2")
    public SysDept test2 (){
        return  testService.selectSysDeptByDeptId(100);
    }
    @RequestMapping("/testFeign4")
    public SysDept testFeign4 (){
        return  testService.selectSysDeptByDeptId(100);
    }

    @RequestMapping("/testFeign3")
    public R test3 (){
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {   e.printStackTrace();
            return R.error("大发大水井坊");
        }
        return  testService.list();
    }
}
