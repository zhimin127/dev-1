package com.my.common.base;

import java.util.List;

/**
 * 集合持久层的公用的增，删，改，查类 <T> 表示传入<数据模型>类
 * 
 * @author ma
 * @version 1.0
 * @param <数据模型>
 * 
 */

public interface BaseDao<T> {

	/**
	 * 保存 <数据模型>
	 * 
	 * @param <数据模型>
	 * @return <数据模型>ID
	 */
	public int save(T model);

	/**
	 * 根据 <数据模型> 修改 <数据模型>
	 * 
	 * @param model
	 */
	public void modify(T model);

	/**
	 * 根据id删除<数据模型>
	 * 
	 * @param id
	 */
	public void delete(String id);

	/**
	 * 根据id查询<数据模型>
	 * 
	 * @param id
	 * @return <数据模型>
	 */
	public T findById(String id);

	/**
	 * 查询 所有的 <数据模型>
	 * 
	 * @return <数据模型>集合
	 */
	public List<T> findAll();

	/**
	 * 根据 <数据模型>条件查询
	 * 
	 * @param model
	 *            <数据模型>
	 * @return <数据模型>集合
	 */
	public List<T> findByT(T model);

	/**
	 * 根据 <数据模型>条件分页查询
	 * 
	 * @param model
	 *            <数据模型>
	 * @return <数据模型>集合
	 */
	public List<T> findPageByT(T model, int page, int pageSize);
}
