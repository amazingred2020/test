package com.senlainc.factory;

import com.senlainc.annotation.InjectComponent;
import com.senlainc.factory.config.ComponentFinder;
import com.senlainc.factory.config.SimpleComponentFinder;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ComponentFactory {

	private static ComponentFactory factory;
	private ComponentFinder componentFinder = new SimpleComponentFinder();
	
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
			 component = classForFind.newInstance();
			 for(Field field : Arrays.stream(classForFind.getDeclaredFields()).filter(field -> field.isAnnotationPresent(InjectComponent.class)).collect(Collectors.toList())) {
				if(field != null){
					return component;
				}
				else{
			 		field.setAccessible(true);
				 	field.set(component, componentFinder.getImplementation(field.getType()));
				}
			 }
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
			e.printStackTrace();
		}
		
		return component;
	}
}
