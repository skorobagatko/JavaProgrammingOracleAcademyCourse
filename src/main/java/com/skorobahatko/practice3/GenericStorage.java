package com.skorobahatko.practice3;

public interface GenericStorage<K, V> {

    K add(V value);
    V get(K key);
    void update(K key, V value);
    boolean remove(K key);

}
