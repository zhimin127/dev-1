package com.my.common.base;

import java.util.List;

public interface BaseDao<T> {

	public int save(T t);

	public List<T> findAll(T t);

	public T getById(String id);

}
