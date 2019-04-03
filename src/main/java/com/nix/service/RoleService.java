package com.nix.service;

import com.nix.model.MemberBaseModel;
import com.nix.model.RoleBaseModel;
import com.nix.model.RoleInterfaceModel;
import com.nix.service.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author keray
 * @date 2019/04/03 17:28
 */
@Service
public interface RoleService extends BaseService<RoleBaseModel,Integer> {
    RoleBaseModel findByName(String name);
    boolean roleHaveTheInterface(RoleBaseModel roleModel, RoleInterfaceModel roleInterfaceModel);
    RoleBaseModel createRoleModelByInterfacesId(RoleBaseModel roleModel, Integer[] roleInterfaceId);

}
