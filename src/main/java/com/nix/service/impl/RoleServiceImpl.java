package com.nix.service.impl;

import com.nix.jpa.RoleJpa;
import com.nix.model.RoleBaseModel;
import com.nix.model.RoleInterfaceModel;
import com.nix.service.RoleService;
import com.nix.service.base.BaseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author keray
 * @date 2019/04/03 17:50
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleBaseModel,Integer> implements RoleService {

    @Resource
    private RoleJpa roleJpa;

    public RoleBaseModel findByName(String name) {
        try {
//            return roleMapper.findByOneField("name",name).get(0);
            return null;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoleBaseModel add(RoleBaseModel model) throws Exception{
        super.add(model);
        for (RoleInterfaceModel roleInterfaceModel:model.getRoleInterfaces()) {
//            roleMapper.insertRoleMiddleInterface(model.getId(),roleInterfaceModel.getId());
        }
        return model;
    }

    /**
     * 判断当前用户是否有某接口的权限
     * */
    public boolean roleHaveTheInterface(RoleBaseModel roleModel, RoleInterfaceModel roleInterfaceModel) {
        try {
            for (RoleInterfaceModel interfaceModel:roleModel.getRoleInterfaces()) {
                if (interfaceModel.getUrl().equals(roleInterfaceModel.getUrl())) {
                    return true;
                }
            }
        } catch ( Exception e) {
        }
        return false;
    }

    @Override
    public RoleBaseModel update(RoleBaseModel model) throws Exception {
        List<RoleInterfaceModel> before = findById(model.getId()).getRoleInterfaces();
        List<RoleInterfaceModel> now = model.getRoleInterfaces();
        for (RoleInterfaceModel deleteModel:before) {
//            roleMapper.deleteRoleMiddleInterface(model.getId(),deleteModel.getId());
        }
        for (RoleInterfaceModel deleteModel:now) {
//            roleMapper.insertRoleMiddleInterface(model.getId(),deleteModel.getId());
        }
        return super.update(model);
    }

    public RoleBaseModel createRoleModelByInterfacesId(RoleBaseModel roleModel, Integer[] roleInterfaceId) {
        ArrayList<RoleInterfaceModel> roleInterfaceModels = new ArrayList<>();
        if (roleInterfaceId != null && roleInterfaceId.length > 0) {
            for (Integer id:roleInterfaceId) {
                RoleInterfaceModel model = new RoleInterfaceModel();
                model.setId(id);
                roleInterfaceModels.add(model);
            }
            roleModel.setRoleInterfaces(roleInterfaceModels);
        }
        return roleModel;
    }

    @Override
    protected JpaRepository<RoleBaseModel,Integer> jpa() {
        return roleJpa;
    }
}
