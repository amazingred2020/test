package com.senlainc.container.factory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.senlainc.container.annotation.InjectComponent;
import com.senlainc.container.factory.config.ComponentFinder;
import com.senlainc.container.factory.config.SimpleComponentFinder;

public class ComponentFactory {

	private static ComponentFactory factory;
	private ComponentFinder componentFinder = new SimpleComponentFinder("com.senlainc.app");
	
	private ComponentFactory() {
	}
	
	public static ComponentFactory getInstance() {
		if (factory == null){
			factory = new ComponentFactory();
		}
		return factory;
	}

	public ComponentFinder getComponentFinder() {
		return componentFinder;
	}

	public <T> T getComponent(Class<T> componentClass) {
		Class<? extends T> classForFind = componentClass; 
		if(classForFind.isInterface()) {
			classForFind = componentFinder.getImplementation(classForFind);
		}
		T component = null;
		try {
			 component = classForFind.getDeclaredConstructor().newInstance();
			 for(Field field : Arrays.stream(classForFind.getDeclaredFields()).filter(field -> field.isAnnotationPresent(InjectComponent.class)).collect(Collectors.toList())) {
				 field.setAccessible(true);
				 field.set(component, componentFinder.getImplementation(field.getType()));
			 }
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return component;
	}
}
