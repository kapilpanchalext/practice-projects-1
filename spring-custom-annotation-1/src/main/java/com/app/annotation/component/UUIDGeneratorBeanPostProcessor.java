package com.app.annotation.component;

import java.lang.reflect.Field;
import java.util.UUID;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.app.annotation.library.UUIDGenerator;

@Component
public class UUIDGeneratorBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		Field[] fields = bean.getClass().getDeclaredFields();
		
		for (Field field : fields) {
            if (field.isAnnotationPresent(UUIDGenerator.class)) {
                try {
                    field.setAccessible(true);
                    field.set(bean, UUID.randomUUID().toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }        
        return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {		
		return bean;
	}	
}
