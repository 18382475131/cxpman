package com.nix.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @author Kiss
 * @date 2018/05/01 18:59
 * 角色
 */
@Entity
public class RoleBaseModel implements Serializable {

    @Id
    private Integer id;
    private String name;
    private String value;

    //角色允许的接口列表
    @Transient
    private List<RoleInterfaceModel> roleInterfaces;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public List<RoleInterfaceModel> getRoleInterfaces() {
        return roleInterfaces;
    }

    public void setRoleInterfaces(List<RoleInterfaceModel> roleInterfaces) {
        this.roleInterfaces = roleInterfaces;
    }
}
