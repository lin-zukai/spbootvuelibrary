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

@Service("GuihuanService")
public class GuihuanServiceImpl implements GuihuanService {

    @Resource
    private GuihuanMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Guihuan> select() {
        return dao.select(null);
    }

    /**
     * 根据Guihuan类搜索数据
     * @param y
     * @return
     */
    public List<Guihuan> select(Guihuan y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取归还一行数据
     * @param id
     * @return
     */
    public Guihuan find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据归还获取归还类条件查询一行数据
     * @param id
     * @return
     */
    public Guihuan findEntity(Guihuan id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Guihuan> selectPage(Guihuan obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Guihuan> list = select(obj);
        PageInfo<Guihuan> pageInfo = new PageInfo(list);
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
    public List<Guihuan> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Guihuan> list = dao.selectByExample(obj);
        PageInfo<Guihuan> pageInfo = new PageInfo(list);
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
     * 插入归还     * @param y
     * @return
     */
    public int insert(Guihuan y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新归还     * @param y
     * @return
     */
    public int update(Guihuan y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
