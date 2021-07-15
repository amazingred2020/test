package com.senlainc.factory.config;

public interface ComponentFinder {

	<T> Class<? extends T> getImplementation(Class<T> interfaceClass);
	void checkImplementationMap();
}
