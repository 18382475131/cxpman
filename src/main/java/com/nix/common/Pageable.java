package com.nix.common;


import com.nix.service.base.BaseService;
import com.nix.util.SQLUtil;

import java.io.Serializable;
import java.util.List;

/**
 * @author Kiss
 * @date 2018/05/02 1:02
 * 分页插件
 */
public class Pageable<M extends Object> {
    private Integer page;
    private Integer limit;
    private String order;
    private String sort;
    private String field;
    private String value;
    private String conditionsSql;
    private BaseService baseService;
    private List list;
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getConditionsSql() {
        return conditionsSql;
    }

    public void setConditionsSql(String conditionsSql) {
        this.conditionsSql = conditionsSql;
    }
    public void setConditionsSql(String conditionsSql,Object ... values) {
        this.conditionsSql = SQLUtil.sqlFormat(conditionsSql,values);
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public List<M> getList(BaseService service) {
        baseService = service;
        list = service.list(page,limit,order,sort,conditionsSql);
        return list;
    }

    public Integer getCount() {
        return baseService.list(null,null,null,null,conditionsSql).size();
    }

}
