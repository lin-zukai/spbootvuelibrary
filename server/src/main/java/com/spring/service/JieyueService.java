package com.spring.service;

import com.spring.entity.Jieyue;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface JieyueService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Jieyue> select();

    /**
     * 根据Jieyue类搜索数据
     * @param y
     * @return
     */
    public List<Jieyue> select(Jieyue y);

    /**
     * 根据主键获取借阅一行数据
     * @param id
     * @return
     */
    public Jieyue find(Object id);

    /**
     * 根据借阅获取借阅类条件查询一行数据
     * @param id
     * @return
     */
    public Jieyue findEntity(Jieyue id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jieyue> selectPage(Jieyue obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jieyue> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入借阅     * @param y
     * @return
     */
    public int insert(Jieyue y);

    /**
     * 更新借阅     * @param y
     * @return
     */
    public int update(Jieyue y);
}
