package com.nix.service;

import com.nix.model.MemberBaseModel;
import com.nix.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 11723
 */
@Service
public interface MemberService extends BaseService<MemberBaseModel,Integer> {
    String ADMIN_USERNAME = "admin";
    MemberBaseModel registered(MemberBaseModel user, HttpServletRequest request) throws Exception;
    MemberBaseModel login(String username, String password, HttpServletRequest request);
    MemberBaseModel findByUsername(String username);
}
