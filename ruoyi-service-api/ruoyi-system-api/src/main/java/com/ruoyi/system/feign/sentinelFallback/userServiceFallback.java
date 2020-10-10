package com.ruoyi.system.feign.sentinelFallback;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.feign.RemoteUserService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class userServiceFallback implements RemoteUserService {
    @Override
    public SysUser selectSysUserByUserId(long userId) {
        return null;
    }

    @Override
    public SysUser selectSysUserByUsername(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("和嘿嘿呵呵");
        return sysUser;
    }

    @Override
    public R updateUserLoginRecord(SysUser user) {
        return null;
    }

    @Override
    public Set<Long> selectUserIdsHasRoles(String roleIds) {
        return null;
    }

    @Override
    public Set<Long> selectUserIdsInDepts(String deptIds) {
        return null;
    }
}
