package com.nix.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author keray
 * @date 2019/04/04 11:18
 */
public interface BaseJpa<M extends Object,ID extends Serializable> extends JpaRepository<M,ID> {
    List<M> findByOneField(String field, String content);
    List<M> list(Integer page, Integer size, String order, String sort, String conditionsSql);
}
