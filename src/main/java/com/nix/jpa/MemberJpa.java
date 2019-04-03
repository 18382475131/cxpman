package com.nix.jpa;

import com.nix.model.MemberBaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 11723
 */
public interface MemberJpa extends JpaRepository<MemberBaseModel, Integer> {
//    /**
//     * 用户登录
//     * @param username
//     * @param password
//     * @return
//     * */
//
//    @Query(value = "select MemberBaseModel from MemberBaseModel u where u.username=:username and u.password=:password")
//    MemberBaseModel login(@Param("username") String username, @Param("password") String password);
}
