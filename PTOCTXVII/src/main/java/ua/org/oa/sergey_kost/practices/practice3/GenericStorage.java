package ua.org.oa.sergey_kost.practices.practice3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface GenericStorage<K, V> {
    K create(V value);

    V read(K key);

    Node<Integer, V> update(K key, V value);

    boolean delete(K key);


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Node<K, V> {
        private K key;
        private V value;
    }
}
