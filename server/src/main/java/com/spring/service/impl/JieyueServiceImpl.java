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

@Service("JieyueService")
public class JieyueServiceImpl implements JieyueService {

    @Resource
    private JieyueMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Jieyue> select() {
        return dao.select(null);
    }

    /**
     * 根据Jieyue类搜索数据
     * @param y
     * @return
     */
    public List<Jieyue> select(Jieyue y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取借阅一行数据
     * @param id
     * @return
     */
    public Jieyue find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据借阅获取借阅类条件查询一行数据
     * @param id
     * @return
     */
    public Jieyue findEntity(Jieyue id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Jieyue> selectPage(Jieyue obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Jieyue> list = select(obj);
        PageInfo<Jieyue> pageInfo = new PageInfo(list);
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
    public List<Jieyue> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Jieyue> list = dao.selectByExample(obj);
        PageInfo<Jieyue> pageInfo = new PageInfo(list);
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
     * 插入借阅     * @param y
     * @return
     */
    public int insert(Jieyue y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新借阅     * @param y
     * @return
     */
    public int update(Jieyue y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
