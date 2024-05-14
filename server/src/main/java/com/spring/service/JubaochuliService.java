package com.spring.service;

import com.spring.entity.Jubaochuli;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface JubaochuliService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Jubaochuli> select();

    /**
     * 根据Jubaochuli类搜索数据
     * @param y
     * @return
     */
    public List<Jubaochuli> select(Jubaochuli y);

    /**
     * 根据主键获取举报处理一行数据
     * @param id
     * @return
     */
    public Jubaochuli find(Object id);

    /**
     * 根据举报处理获取举报处理类条件查询一行数据
     * @param id
     * @return
     */
    public Jubaochuli findEntity(Jubaochuli id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jubaochuli> selectPage(Jubaochuli obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jubaochuli> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入举报处理     * @param y
     * @return
     */
    public int insert(Jubaochuli y);

    /**
     * 更新举报处理     * @param y
     * @return
     */
    public int update(Jubaochuli y);
}
