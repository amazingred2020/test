package com.senlainc.container.factory.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public class SimpleComponentFinder implements ComponentFinder{

	private Reflections reflection;
	private Map<Class, Class> interfaceAndImplementation;
	
	public SimpleComponentFinder(String packageToScan) {
		this.reflection = new Reflections(packageToScan);
		this.interfaceAndImplementation = new HashMap<Class, Class>();
	}

	public void checkImplementationMap(){
		for (Map.Entry<Class, Class> entry : interfaceAndImplementation.entrySet()){
			System.out.println("Интерфейс - "+entry.getKey()+", реализация - "+entry.getValue());
		}

	}
	
	@Override
	public <T> Class<? extends T> getImplementation(Class<T> interfaceClass) {
		return interfaceAndImplementation.computeIfAbsent(interfaceClass, findClass -> {
			Set<Class<? extends T>> implementations = reflection.getSubTypesOf(interfaceClass);
			
			if(implementations.size() != 1) {
				System.out.println("Существует не одна реализация интерфейса "+interfaceClass.getName());
				throw new RuntimeException();
			}

			return implementations.stream().findAny().get();
		});
	}

}
