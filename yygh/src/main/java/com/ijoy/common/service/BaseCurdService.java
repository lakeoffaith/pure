package com.ijoy.common.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;




public interface BaseCurdService<T> {
	static final Logger LOGGER=LogManager.getLogger(BaseCurdService.class);
	
	public void save(T t);

	public void delete(Long id);
	public void update(T t);
	public T get(Long id);
	
}
