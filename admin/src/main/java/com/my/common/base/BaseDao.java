package com.my.common.base;

import java.util.List;

public interface BaseDao<T> {

	public int save(T t);

	public List<T> findAll();

	public T getById(String id);

}
