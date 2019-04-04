package com.nix.service.impl;

import com.nix.Exception.WebException;
import com.nix.common.cache.MemberCache;
import com.nix.jpa.BaseJpa;
import com.nix.jpa.MemberJpa;
import com.nix.model.MemberBaseModel;
import com.nix.service.MemberService;
import com.nix.service.base.BaseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author keray
 * @date 2019/04/03 17:47
 */
@Service
public class MemberServiceImpl extends BaseServiceImpl<MemberBaseModel,Integer> implements MemberService {

    @Resource
    private MemberJpa memberJpa;

    @Override
    public MemberBaseModel registered(MemberBaseModel user, HttpServletRequest request) throws Exception {
        add(user);
        user = findByUsername(user.getUsername());
        if (user != null) {
            request.getSession(true).setAttribute(MemberCache.USER_SESSION_KEY,user);
        }
        return user;
    }

    @Override
    public MemberBaseModel login(String username, String password, HttpServletRequest request) {
        MemberBaseModel user = MemberCache.currentUser();
        if (user == null) {
//            user = memberJpa.login(username,password);
            request.getSession(true).setAttribute(MemberCache.USER_SESSION_KEY,user);
        }
        return user;
    }

    @Override
    public MemberBaseModel findByUsername(String username) {
        return null;
    }

    @Override
    public MemberBaseModel add(MemberBaseModel memberBaseModel)  throws Exception{
        if (ADMIN_USERNAME.equals(memberBaseModel.getUsername())) {
            throw new WebException(401,"不能使用admin做完用户名");
        }
        return super.add(memberBaseModel);
    }

    @Override
    protected BaseJpa<MemberBaseModel,Integer> jpa() {
        return memberJpa;
    }
}
