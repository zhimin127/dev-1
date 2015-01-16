package com.my.common.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;


/**
 * 集合持久层的公用的增，删，改，查类 <T> 表示传入Model类
 * 
 * @author 
 * @version 1.01
 * @param <T>
 *            父类中查找子类定义的泛型信息
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport {
	/**
	 * @return 完整实体类型名称
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getClassName() {
		// 在父类中查找子类定义的泛型信息
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class) pt.getActualTypeArguments()[0];
		return clazz.getSimpleName().toString();
	}

	public int save(T t) {
		return getSqlSession().insert(this.getClassName() + ".add", t);
	}

	public void delete(String id) {
		getSqlSession().delete(this.getClassName() + ".deleteById", id);
	}

	@SuppressWarnings("unchecked")
	public T getById(String id) {
		return (T) getSqlSession().selectOne(this.getClassName() + ".getById", id);
	}

	public void modify(T t) {
		getSqlSession().update(this.getClassName() + ".update", t);
	}

	/*public List<T> query(PageView pageView, T t) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("paging", pageView);
		map.put("t", t);
		return getSqlSession().selectList(this.getClassName() + ".query", map);
	}*/

	public List<T> findAll(T t) {
		return getSqlSession().selectList(this.getClassName() + ".queryAll", t);
	}

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
