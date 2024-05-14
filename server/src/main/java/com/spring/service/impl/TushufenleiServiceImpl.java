package com.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import java.util.*;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("TushufenleiService")
public class TushufenleiServiceImpl implements TushufenleiService {

    @Resource
    private TushufenleiMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Tushufenlei> select() {
        return dao.select(null);
    }

    /**
     * 根据Tushufenlei类搜索数据
     * @param y
     * @return
     */
    public List<Tushufenlei> select(Tushufenlei y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取图书分类一行数据
     * @param id
     * @return
     */
    public Tushufenlei find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据图书分类获取图书分类类条件查询一行数据
     * @param id
     * @return
     */
    public Tushufenlei findEntity(Tushufenlei id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Tushufenlei> selectPage(Tushufenlei obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Tushufenlei> list = select(obj);
        PageInfo<Tushufenlei> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Tushufenlei> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Tushufenlei> list = dao.selectByExample(obj);
        PageInfo<Tushufenlei> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id) {
        return dao.deleteByPrimaryKey(id);
    }

    /**
     * 插入图书分类     * @param y
     * @return
     */
    public int insert(Tushufenlei y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新图书分类     * @param y
     * @return
     */
    public int update(Tushufenlei y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
