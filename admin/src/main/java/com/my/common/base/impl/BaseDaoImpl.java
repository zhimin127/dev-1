package com.my.common.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 集合持久层的公用的增，删，改，查类 <T> 表示传入<数据模型>类， 父类中查找子类定义的泛型信息
 */

public class BaseDaoImpl<T> extends SqlSessionDaoSupport {

	/**
	 * @return <数据模型>类名
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String getClassName() {
		// 在父类中查找子类定义的泛型信息
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class) pt.getActualTypeArguments()[0];
		return clazz.getSimpleName().toString();
	}

	private String getMapperNamespace() {
		return this.getClassName() + "Mapper";
	}

	public int save(T t) {
		return getSqlSession().insert(this.getMapperNamespace() + ".insert", t);
	}

	public void delete(String id) {
		getSqlSession().delete(this.getMapperNamespace() + ".deleteById", id);
	}

	@SuppressWarnings("unchecked")
	public T findById(String id) {
		return (T) getSqlSession().selectOne(this.getMapperNamespace() + ".findById", id);
	}

	public void modify(T t) {
		getSqlSession().update(this.getMapperNamespace() + ".modify", t);
	}

	public List<T> findByT(T model) {
		return getSqlSession().selectList(this.getClassName() + ".findByT", model);
	}

	public List<T> findAll() {
		return getSqlSession().selectList(this.getMapperNamespace() + ".findAll");
	}

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
