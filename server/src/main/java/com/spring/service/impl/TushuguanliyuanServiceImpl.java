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

@Service("TushuguanliyuanService")
public class TushuguanliyuanServiceImpl implements TushuguanliyuanService {

    @Resource
    private TushuguanliyuanMapper dao;

    public Tushuguanliyuan login(String username, String password) {
        Tushuguanliyuan user = new Tushuguanliyuan();
        user.setZhanghao(username);
        user.setMima(password);

        return this.dao.login(user);
    }

    public boolean updatePassword(int id, String newPassword) {
        Tushuguanliyuan user = new Tushuguanliyuan();
        user.setId(id);
        user.setMima(newPassword);
        int i = this.dao.updateByPrimaryKeySelective(user);
        return i == 1;
    }

    /**
     * 获取所有数据
     * @return
     */
    public List<Tushuguanliyuan> select() {
        return dao.select(null);
    }

    /**
     * 根据Tushuguanliyuan类搜索数据
     * @param y
     * @return
     */
    public List<Tushuguanliyuan> select(Tushuguanliyuan y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取图书管理员一行数据
     * @param id
     * @return
     */
    public Tushuguanliyuan find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据图书管理员获取图书管理员类条件查询一行数据
     * @param id
     * @return
     */
    public Tushuguanliyuan findEntity(Tushuguanliyuan id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Tushuguanliyuan> selectPage(Tushuguanliyuan obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Tushuguanliyuan> list = select(obj);
        PageInfo<Tushuguanliyuan> pageInfo = new PageInfo(list);
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
    public List<Tushuguanliyuan> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Tushuguanliyuan> list = dao.selectByExample(obj);
        PageInfo<Tushuguanliyuan> pageInfo = new PageInfo(list);
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
     * 插入图书管理员     * @param y
     * @return
     */
    public int insert(Tushuguanliyuan y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新图书管理员     * @param y
     * @return
     */
    public int update(Tushuguanliyuan y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
