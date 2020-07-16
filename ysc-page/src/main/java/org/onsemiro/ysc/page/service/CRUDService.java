package org.onsemiro.ysc.page.service;

import java.io.Serializable;
import java.util.List;

import org.onsemiro.ysc.page.domain.Domain;

public interface CRUDService<T extends Domain, ID extends Serializable> {
	
	T get(ID id);
	
	List<T> getList();
	
	boolean regist(T domain);

	boolean update(T domain);
	
	boolean delete(ID id);
	
}
