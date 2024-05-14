package com.spring.service;

import com.spring.entity.Jubao;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface JubaoService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Jubao> select();

    /**
     * 根据Jubao类搜索数据
     * @param y
     * @return
     */
    public List<Jubao> select(Jubao y);

    /**
     * 根据主键获取举报一行数据
     * @param id
     * @return
     */
    public Jubao find(Object id);

    /**
     * 根据举报获取举报类条件查询一行数据
     * @param id
     * @return
     */
    public Jubao findEntity(Jubao id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jubao> selectPage(Jubao obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jubao> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入举报     * @param y
     * @return
     */
    public int insert(Jubao y);

    /**
     * 更新举报     * @param y
     * @return
     */
    public int update(Jubao y);
}
