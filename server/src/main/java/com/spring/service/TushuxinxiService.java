package com.spring.service;

import com.spring.entity.Tushuxinxi;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface TushuxinxiService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Tushuxinxi> select();

    /**
     * 根据Tushuxinxi类搜索数据
     * @param y
     * @return
     */
    public List<Tushuxinxi> select(Tushuxinxi y);

    /**
     * 根据主键获取图书信息一行数据
     * @param id
     * @return
     */
    public Tushuxinxi find(Object id);

    /**
     * 根据图书信息获取图书信息类条件查询一行数据
     * @param id
     * @return
     */
    public Tushuxinxi findEntity(Tushuxinxi id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Tushuxinxi> selectPage(Tushuxinxi obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Tushuxinxi> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入图书信息     * @param y
     * @return
     */
    public int insert(Tushuxinxi y);

    /**
     * 更新图书信息     * @param y
     * @return
     */
    public int update(Tushuxinxi y);
}
