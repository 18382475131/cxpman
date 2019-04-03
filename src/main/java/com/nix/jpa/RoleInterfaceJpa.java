package com.nix.jpa;

import com.nix.model.RoleInterfaceModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author keray
 * @date 2019/04/03 17:53
 */
public interface RoleInterfaceJpa extends JpaRepository<RoleInterfaceModel,Integer> {
}
