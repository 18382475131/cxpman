package com.nix.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 11723
 * 用户
 */


@Entity
@Table(indexes = {@Index(name = "username_index",columnList = "username",unique = true)})
public class MemberBaseModel implements Serializable {

    @Id
    private Integer id;
    @Column(length = 50)
    private String username;
    private String password;
    private Integer age;
    private Boolean sex;
    private String name;
    //电话
    private String phone;
    //账户余额
    private BigDecimal balance;
    //头像
    private String img;

    //用户角色
    @Transient
    private RoleBaseModel role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public RoleBaseModel getRole() {
        return role;
    }

    public void setRole(RoleBaseModel role) {
        this.role = role;
    }

    public Boolean getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "MemberBaseModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", img='" + img + '\'' +
                ", role=" + role +
                '}';
    }

    @JsonIgnore
    public String getRoleValue() {
        return getRole().getValue();
    }
}