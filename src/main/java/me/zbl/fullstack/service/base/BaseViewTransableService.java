package me.zbl.fullstack.service.base;

import java.util.List;

/**
 * Generic business abstract classes that contain view conversion functionality
 *
 * @param < E> data query results entity class
 * @param < V> view class
 *
 * @author raviteja
 */
public abstract class BaseViewTransableService<E, V> {

  /**
   * Convert a data entity class object to a view class object
   *
   * @param entityList data entity class object collection
   *
   * @return view model class object collection
   */

  protected abstract List<V> transEntityToView(List<E> entityList);
}
