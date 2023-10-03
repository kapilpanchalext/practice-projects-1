package com.app.map.util;

import java.util.HashMap;
import java.util.Map;


public class AliasMap <K, V> {

//	private Map<K,V> map;
//	
//	public AliasMap() {
//        this.map = new HashMap<>();
//    }
//	
//	public void putKey(K key, V value) {
//		map.put(key, value);
//	}
//	
//	public V get(K key) {
//		return map.get(key);
//	}
	
	private final Map<K, K> aliases = new HashMap<>();
    private final Map<K, V> values = new HashMap<>();

    public void put(K key, V value) {
        values.put(key, value);
    }

    public void addAlias(K alias, K key) {
        aliases.put(alias, key);
    }

    public V get(K key) {
        K actualKey = aliases.getOrDefault(key, key);
        return values.get(actualKey);
    }
}
