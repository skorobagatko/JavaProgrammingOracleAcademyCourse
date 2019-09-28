package com.skorobahatko.lecture8_jdbc.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class BeanMapper {

    private static BeanMapper instance;
    private static Mapper mapper;


    private BeanMapper() {
        mapper = new DozerBeanMapper();
    }

    public static synchronized BeanMapper getInstance() {
        if (instance == null) {
            instance = new BeanMapper();
        }
        return instance;
    }

    public <T> T singleMapper(Object from, Class<T> toClass) {
        T map = mapper.map(from, toClass);
        return map;
    }

    public <E, T> List<T> listMapToList(Iterable<E> iterable, Class<T> toClass) {
        List<T> list = new ArrayList<>();

        for (E e : iterable) {
            list.add(mapper.map(e, toClass));
        }

        return list;
    }
}
