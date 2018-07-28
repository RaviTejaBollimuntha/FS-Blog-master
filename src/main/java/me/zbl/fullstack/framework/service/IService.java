package me.zbl.fullstack.framework.service;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service Basic Interface
 * Other Service Interfaces need to be inherited from this interface
 *
 * @param <T> entity type
 *
 * @author raviteja
 */
public interface IService<T> {

  /**
   * Insert
   *
   * @param model
   */
  void save(T model);

  /**
   * BULK INSERT
   *
   * @param models
   */
  void save(List<T> models);

  /**
   * Removed by primary key
   *
   * @param id primary key
   */
  void deleteById(Integer id);

  /**
   * Bulk delete
   *
   * @param ids e.g. " 1,2,3,4 “
   */
  void deleteByIds(String ids);

  /**
   * Update
   *
   * @param model
   */
  void update(T model);

  /**
   * Find by id
   *
   * @param id id
   *
   * @return entity
   */
  T findById(Integer id);

  /**
   * Lookup through a member property, value is subject to a unique constraint
   *
   * @param property property name
   * @param value property value
   *
   * @return entity
   *
   * @throws TooManyResultsException result set too large
   */
  T findBy(String property, Object value) throws TooManyResultsException;

  /**
   * Find by multiple IDs//eg: ids - > " 1,2,3,4”
   *
   * @param ids ids
   *
   * @return entity collection
   */
  List<T> findByIds(String ids);

  /**
   * Find by condition
   *
   * @param condition
   *
   * @return entity collection
   */
  List<T> findByCondition(Condition condition);

  /**
   * Get all
   *
   * @return entity collection
   */
  List<T> findAll();

  /**
   * Create conditions
   *
   * @return condition
   */
  Condition createCondition();
}
