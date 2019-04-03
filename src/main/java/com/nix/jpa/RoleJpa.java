package com.nix.jpa;

import com.nix.model.RoleBaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author keray
 * @date 2019/04/03 17:52
 */
public interface RoleJpa extends JpaRepository<RoleBaseModel,Integer> {
}
