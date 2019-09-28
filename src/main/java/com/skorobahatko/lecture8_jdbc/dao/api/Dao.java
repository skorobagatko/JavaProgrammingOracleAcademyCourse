package com.skorobahatko.lecture8_jdbc.dao.api;

import com.skorobahatko.lecture8_jdbc.model.Entity;

import java.util.List;

public interface Dao<K, T extends Entity<K>> {

    List<T> getAll();

    T getById(K key);

    void save(T entity);

    void update(T entity);

    void delete(K key);

}
