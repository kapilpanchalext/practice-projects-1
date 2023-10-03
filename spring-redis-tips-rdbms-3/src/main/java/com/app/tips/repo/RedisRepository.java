package com.app.tips.repo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.app.tips.bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class RedisRepository {

	@Autowired
	private RedisTemplate<String, Object> template;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public Student addToHashMap(String key, String hashId, Student student) {
		Field[] fields = student.getClass().getDeclaredFields();
        
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String fieldName = field.getName();
                Object fieldValue = field.get(student);
                if (Objects.nonNull(fieldValue)) {                	
                	 template.opsForHash().put(key, fieldName, fieldValue.toString());
                }               
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return student;
	}
	
	public Student getFromHashMap(String key) {
		Field[] fields = Student.class.getDeclaredFields();
        Map<String, String> fieldValues = new HashMap<>();

        for (Field field : fields) {
            String fieldName = field.getName();
            String value = (String) template.opsForHash().get(key, fieldName);
            fieldValues.put(fieldName, value);
        }

        try {
            return objectMapper.convertValue(fieldValues, Student.class);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
	}
}
