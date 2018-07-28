package me.zbl.fullstack.framework.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * Mapper Basic Interface
 * Other Mapper interfaces need to integrate this interface
 *
 * @param <T> entity type
 * @author raviteja
 * This interface cannot be scanned, otherwise an error occurs
 */
public interface IMyMapper<T> extends
        Mapper<T>,
        MySqlMapper<T>,
        DeleteByIdsMapper<T>,
        ConditionMapper<T>,
        ExampleMapper<T>,
        SelectByIdsMapper<T> {
}
