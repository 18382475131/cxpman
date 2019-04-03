package com.nix.service.base;
import com.nix.util.SQLUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 11723
 */
public interface BaseService<M extends Object,ID extends Serializable>{

    /**
     * 保存对象M
     * @param m
     * */
    void save(M m);

    /**
     * 保存对象M
     * @param m
     * */
    M add(M m)  throws Exception;
    /**
     * 删除对象M
     * @param m
     * */
    void delete(M m);

    /**
     * 删除对象M
     * @param id
     * */
    void delete(ID id);

    /**
     * 批量删除对象M
     * @param ids
     * */
    void delete(ID[] ids);

    /**
     * 更新对象M
     * @param m
     * */
    M update(M m)  throws Exception;
    /**
     * 查找唯一对象M
     * @param id id值
     * @return 唯一对象
     * */
    M findById(ID id);

    /**
     * 查找部对象
     * @return 全部对象
     * */
    List<M> findAll();

    List<M> findByOneField(String field,String content);

    /**
     *
     * 查找某个相应条件的对象列表
     * @param page 列表分页页数
     * @param size 当前页需要查询对象的最大数量
     * @param order 查找对象时按照哪个字段排序
     * @param sort 排序时的排序方式（升序 降序）
     * @param conditionsSql 查找列表时的sql条件  sql语=语句里where后面的部分都写在改字符串里
     * @return 返回符合条件的对象列表 但查找失败时返回null
     * */
     List<M> list(String tables,Integer page,Integer size,String order,String sort,String conditionsSql);
     List<M> list(Integer page,Integer size,String order,String sort,String conditionsSql);

     List<M> select(String conditionsSql,Object ... param) ;

     List<M> select(boolean b,String tables,String conditionsSql,Object ... param);
}
