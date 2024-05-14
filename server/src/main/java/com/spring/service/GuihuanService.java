package com.spring.service;

import com.spring.entity.Guihuan;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface GuihuanService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Guihuan> select();

    /**
     * 根据Guihuan类搜索数据
     * @param y
     * @return
     */
    public List<Guihuan> select(Guihuan y);

    /**
     * 根据主键获取归还一行数据
     * @param id
     * @return
     */
    public Guihuan find(Object id);

    /**
     * 根据归还获取归还类条件查询一行数据
     * @param id
     * @return
     */
    public Guihuan findEntity(Guihuan id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Guihuan> selectPage(Guihuan obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Guihuan> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入归还     * @param y
     * @return
     */
    public int insert(Guihuan y);

    /**
     * 更新归还     * @param y
     * @return
     */
    public int update(Guihuan y);
}
