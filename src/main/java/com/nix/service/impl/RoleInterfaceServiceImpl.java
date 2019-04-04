package com.nix.service.impl;

import com.nix.jpa.BaseJpa;
import com.nix.jpa.RoleInterfaceJpa;
import com.nix.model.RoleInterfaceModel;
import com.nix.service.RoleInterfaceService;
import com.nix.service.base.BaseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author keray
 * @date 2019/04/03 17:49
 */
@Service
public class RoleInterfaceServiceImpl extends BaseServiceImpl<RoleInterfaceModel,Integer> implements RoleInterfaceService {
    @Resource
    private RoleInterfaceJpa roleInterfaceJpa;

    @Override
    protected BaseJpa<RoleInterfaceModel,Integer> jpa() {
        return roleInterfaceJpa;
    }
}
