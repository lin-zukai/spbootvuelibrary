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

@Service("JubaochuliService")
public class JubaochuliServiceImpl implements JubaochuliService {

    @Resource
    private JubaochuliMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Jubaochuli> select() {
        return dao.select(null);
    }

    /**
     * 根据Jubaochuli类搜索数据
     * @param y
     * @return
     */
    public List<Jubaochuli> select(Jubaochuli y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取举报处理一行数据
     * @param id
     * @return
     */
    public Jubaochuli find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据举报处理获取举报处理类条件查询一行数据
     * @param id
     * @return
     */
    public Jubaochuli findEntity(Jubaochuli id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jubaochuli> selectPage(Jubaochuli obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Jubaochuli> list = select(obj);
        PageInfo<Jubaochuli> pageInfo = new PageInfo(list);
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
    public List<Jubaochuli> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Jubaochuli> list = dao.selectByExample(obj);
        PageInfo<Jubaochuli> pageInfo = new PageInfo(list);
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
     * 插入举报处理     * @param y
     * @return
     */
    public int insert(Jubaochuli y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新举报处理     * @param y
     * @return
     */
    public int update(Jubaochuli y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
