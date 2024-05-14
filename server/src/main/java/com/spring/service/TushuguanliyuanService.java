package com.spring.service;

import com.spring.entity.Tushuguanliyuan;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface TushuguanliyuanService {
    public Tushuguanliyuan login(String username, String password);

    public boolean updatePassword(int id, String newPassword);

    /**
     * 获取所有数据
     * @return
     */
    public List<Tushuguanliyuan> select();

    /**
     * 根据Tushuguanliyuan类搜索数据
     * @param y
     * @return
     */
    public List<Tushuguanliyuan> select(Tushuguanliyuan y);

    /**
     * 根据主键获取图书管理员一行数据
     * @param id
     * @return
     */
    public Tushuguanliyuan find(Object id);

    /**
     * 根据图书管理员获取图书管理员类条件查询一行数据
     * @param id
     * @return
     */
    public Tushuguanliyuan findEntity(Tushuguanliyuan id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Tushuguanliyuan> selectPage(Tushuguanliyuan obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Tushuguanliyuan> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入图书管理员     * @param y
     * @return
     */
    public int insert(Tushuguanliyuan y);

    /**
     * 更新图书管理员     * @param y
     * @return
     */
    public int update(Tushuguanliyuan y);
}
