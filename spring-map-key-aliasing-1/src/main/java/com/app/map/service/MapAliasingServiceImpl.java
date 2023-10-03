package com.app.map.service;

import org.springframework.stereotype.Service;

import com.app.map.util.AliasMap;

@Service
public class MapAliasingServiceImpl implements MapAliasingService {

	@Override
	public void MapKeyAlias() {		
//		AliasMap<String, Integer> aliasMap = new AliasMap<>();
//		
//		// Adding values and aliases
//		aliasMap.putKey("key1", 42);
//		aliasMap.putKey("alias1", aliasMap.get("key1"));
//		
//		// Retrieving values
//		int value1 = aliasMap.get("key1");     // Retrieves 42
//		int value2 = aliasMap.get("alias1");   // Retrieves 42
//		
//		System.err.println("VALUE 1: " + value1);
//		System.err.println("VALUE 2: " + value2);
//		
//		// Updating values
//		aliasMap.putKey("key1", 55);
//		int updatedValue1 = aliasMap.get("key1");
//		int updatedValue2 = aliasMap.get("alias1");
//		
//		System.err.println("UPDATED VALUE: " + updatedValue1);
//		System.err.println("UPDATED VALUE: " + updatedValue2);
		
		AliasMap<String, Integer> aliasMap = new AliasMap<>();

        // Adding values
        aliasMap.put("key1", 42);

        // Creating an alias
        aliasMap.addAlias("alias1", "key1");
        aliasMap.addAlias("alias2", "key1");

        // Retrieving values
        int value1 = aliasMap.get("key1");     // Retrieves 42
        int value2 = aliasMap.get("alias1");   // Retrieves 42
        int value3 = aliasMap.get("alias2");
        
        System.err.println("VALUE 1: " + value1);
        System.err.println("VALUE 2: " + value2);
        System.err.println("VALUE 3: " + value3);

        // Updating values
        aliasMap.put("key1", 55);
        int updatedValue1 = aliasMap.get("key1");     // Retrieves 55
        int updatedValue2 = aliasMap.get("alias1");   // Retrieves 55
        int updatedValue3 = aliasMap.get("alias2");
        
        System.err.println("UPDATED VALUE 1: " + updatedValue1);
        System.err.println("UPDATED VALUE 2: " + updatedValue2);
        System.err.println("UPDATED VALUE 3: " + updatedValue3);
	}
}
