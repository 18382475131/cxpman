package com.nix.service.base;

import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;
import java.util.List;

/**
 * @author 11723
 */
public abstract class BaseServiceImpl<M extends Object,ID extends Serializable> implements BaseService<M,ID>{

    protected abstract JpaRepository<M,ID> jpa();

    @Override
    public void save(M o) {
        jpa().save(o);
    }

    @Override
    public void delete(M o) {
        jpa().delete(o);
    }

    @Override
    public M update(M o)  throws Exception{
        return jpa().saveAndFlush(o);
    }

    @Override
    public M findById(ID id) {
//        return jpa().findOne();
        return jpa().getOne(id);
    }

    @Override
    public List<M> findAll() {
        return jpa().findAll();
    }

    @Override
    public M add(M m)  throws Exception{
        return jpa().save(m);
    }

    @Override
    public void delete(ID id) {
        jpa().deleteById(id);
    }

    @Override
    public void delete(ID[] ids) {
        for (ID id:ids) {
            delete(id);
        }
    }

    @Override
    public List<M> findByOneField(String field, String content) {
        return jpa().findAll();
    }

    @Override
    public List<M> list(String tables, Integer page, Integer size, String order, String sort, String conditionsSql) {
        return null;
    }

    @Override
    public List<M> list(Integer page, Integer size, String order, String sort, String conditionsSql) {
        return null;
    }

    @Override
    public List<M> select(String conditionsSql, Object... param) {
        return null;
    }

    @Override
    public List<M> select(boolean b, String tables, String conditionsSql, Object... param) {
        return null;
    }
}
