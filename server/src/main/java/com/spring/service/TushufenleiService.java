package com.spring.service;

import com.spring.entity.Tushufenlei;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface TushufenleiService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Tushufenlei> select();

    /**
     * 根据Tushufenlei类搜索数据
     * @param y
     * @return
     */
    public List<Tushufenlei> select(Tushufenlei y);

    /**
     * 根据主键获取图书分类一行数据
     * @param id
     * @return
     */
    public Tushufenlei find(Object id);

    /**
     * 根据图书分类获取图书分类类条件查询一行数据
     * @param id
     * @return
     */
    public Tushufenlei findEntity(Tushufenlei id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Tushufenlei> selectPage(Tushufenlei obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Tushufenlei> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入图书分类     * @param y
     * @return
     */
    public int insert(Tushufenlei y);

    /**
     * 更新图书分类     * @param y
     * @return
     */
    public int update(Tushufenlei y);
}
