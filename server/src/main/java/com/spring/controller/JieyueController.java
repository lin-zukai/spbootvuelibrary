package com.spring.controller;

import com.jntoo.db.*;
import com.jntoo.db.utils.*;
import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import com.spring.util.Info;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

/**
 * 借阅 */
@Controller
public class JieyueController extends BaseController {

    @Autowired
    private JieyueMapper dao;

    @Autowired
    private JieyueService service;

    @Autowired
    private TushuxinxiService serviceRead;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/jieyue_list")
    public String list() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据
        Example example = new Example(Jieyue.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        String where = " 1=1 "; // 创建初始条件为：1=1
        where += getWhere(); // 从方法中获取url 上的参数，并写成 sql条件语句
        criteria.andCondition(where); // 将条件写进上面的扩展条件类中
        if (sort.equals("desc")) { // 判断前台提交的sort 参数是否等于  desc倒序  是则使用倒序，否则使用正序
            example.orderBy(order).desc(); // 把sql 语句设置成倒序
        } else {
            example.orderBy(order).asc(); // 把 sql 设置成正序
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 获取前台提交的URL参数 page  如果没有则设置为1
        page = Math.max(1, page); // 取两个数的最大值，防止page 小于1
        List<Jieyue> list = service.selectPageExample(example, page, pagesize); // 获取当前页的行数
        // 生成统计语句
        Map total = Query.make("jieyue").field("(sum(jieyuejine)) sum_jieyuejine").where(where).find();
        // 将统计语句写给界面调用
        assign("total", total);

        // 将列表写给界面使用
        assign("totalCount", request.getAttribute("totalCount"));
        assign("list", list);
        assign("orderby", order); // 把当前排序结果写进前台
        assign("sort", sort); // 把当前排序结果写进前台
        return json(); // 将数据写给前端
    }

    public String getWhere() {
        _var = new LinkedHashMap(); // 重置数据
        String where = " ";
        // 判断URL 参数tushuxinxiid是否大于0
        if (Request.getInt("tushuxinxiid") > 0) {
            // 大于0 则写入条件
            where += " AND tushuxinxiid='" + Request.getInt("tushuxinxiid") + "' ";
        }
        // 以下也是一样的操作，判断是否符合条件，符合则写入sql 语句
        if (!Request.get("tushubianhao").equals("")) {
            where += " AND tushubianhao LIKE '%" + Request.get("tushubianhao") + "%' ";
        }
        if (!Request.get("tushumingcheng").equals("")) {
            where += " AND tushumingcheng LIKE '%" + Request.get("tushumingcheng") + "%' ";
        }
        if (!Request.get("tushufenlei").equals("")) {
            where += " AND tushufenlei ='" + Request.get("tushufenlei") + "' ";
        }
        if (!Request.get("jieyueren").equals("")) {
            where += " AND jieyueren LIKE '%" + Request.get("jieyueren") + "%' ";
        }
        return where;
    }

    /**
     * 发布人列表
     */
    @RequestMapping("/jieyue_list_faburen")
    public String listfaburen() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }
        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据

        Example example = new Example(Jieyue.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：发布人=当前登录用户
        String where = " faburen='" + request.getSession().getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<Jieyue> list = service.selectPageExample(example, page, pagesize);
        Map total = Query.make("jieyue").field("(sum(jieyuejine)) sum_jieyuejine").where(where).find();
        assign("total", total);
        assign("totalCount", request.getAttribute("totalCount"));
        assign("list", list);
        assign("orderby", order);
        assign("sort", sort);
        return json(); // 将数据写给前端
    }

    /**
     * 借阅人列表
     */
    @RequestMapping("/jieyue_list_jieyueren")
    public String listjieyueren() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }
        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据

        Example example = new Example(Jieyue.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：借阅人=当前登录用户
        String where = " jieyueren='" + request.getSession().getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<Jieyue> list = service.selectPageExample(example, page, pagesize);
        Map total = Query.make("jieyue").field("(sum(jieyuejine)) sum_jieyuejine").where(where).find();
        assign("total", total);
        assign("totalCount", request.getAttribute("totalCount"));
        assign("list", list);
        assign("orderby", order);
        assign("sort", sort);
        return json(); // 将数据写给前端
    }

    @RequestMapping("/jieyue_add")
    public String add() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id"); // 根据id 获取 图书信息模块中的数据
        Tushuxinxi readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        assign("readMap", readMap);

        return json(); // 将数据写给前端
    }

    @RequestMapping("/jieyue_updt")
    public String updt() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Jieyue mmm = service.find(id);
        assign("mmm", mmm);
        assign("updtself", 0);

        return json(); // 将数据写给前端
    }

    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/jieyueinsert")
    public String insert() {
        _var = new LinkedHashMap(); // 重置数据
        String tmp = "";
        Jieyue post = new Jieyue(); // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setTushuxinxiid(Request.getInt("tushuxinxiid"));

        post.setTushubianhao(Request.get("tushubianhao"));

        post.setTushumingcheng(Request.get("tushumingcheng"));

        post.setTushufenlei(Request.get("tushufenlei"));

        post.setTushujia(Request.get("tushujia"));

        post.setMeitianjiage(Request.getDouble("meitianjiage"));

        post.setFaburen(Request.get("faburen"));

        post.setJieyuebianhao(Request.get("jieyuebianhao"));

        post.setJieyueshijian(Request.get("jieyueshijian"));

        post.setGuihuanshijian(Request.get("guihuanshijian"));

        post.setJieyuetianshu(Request.getInt("jieyuetianshu"));

        post.setJieyuejine(Request.getDouble("jieyuejine"));

        post.setJieyuezhuangtai(Request.get("jieyuezhuangtai"));

        post.setJieyueren(Request.get("jieyueren"));

        post.setTushuxinxiid(Request.getInt("tushuxinxiid"));
        post.setIszf("否");

        service.insert(post); // 插入数据
        int charuid = post.getId().intValue();
        Query.execute("UPDATE jieyue SET jieyuetianshu=(TIMESTAMPDIFF(DAY , jieyueshijian,guihuanshijian)+1) WHERE id='" + charuid + "'");

        Query.execute("UPDATE jieyue SET jieyuejine=(jieyuetianshu*meitianjiage) WHERE id='" + charuid + "'");

        Query.execute("update tushuxinxi set tushuzhuangtai='借阅中'  where id='" + request.getParameter("tushuxinxiid") + "'");

        Query.execute("update tushuxinxi set jieyuecishu=jieyuecishu+1  where id='" + request.getParameter("tushuxinxiid") + "'");

        if (isAjax()) {
            return jsonResult(post);
        }
        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 更新内容
     * @return
     */
    @RequestMapping("/jieyueupdate")
    public String update() {
        _var = new LinkedHashMap(); // 重置数据
        // 创建实体类
        Jieyue post = new Jieyue();
        // 将前台表单数据填充到实体类
        if (!Request.get("tushuxinxiid").equals("")) post.setTushuxinxiid(Request.getInt("tushuxinxiid"));
        if (!Request.get("tushubianhao").equals("")) post.setTushubianhao(Request.get("tushubianhao"));
        if (!Request.get("tushumingcheng").equals("")) post.setTushumingcheng(Request.get("tushumingcheng"));
        if (!Request.get("tushufenlei").equals("")) post.setTushufenlei(Request.get("tushufenlei"));
        if (!Request.get("tushujia").equals("")) post.setTushujia(Request.get("tushujia"));
        if (!Request.get("meitianjiage").equals("")) post.setMeitianjiage(Request.getDouble("meitianjiage"));
        if (!Request.get("faburen").equals("")) post.setFaburen(Request.get("faburen"));
        if (!Request.get("jieyuebianhao").equals("")) post.setJieyuebianhao(Request.get("jieyuebianhao"));
        if (!Request.get("jieyueshijian").equals("")) post.setJieyueshijian(Request.get("jieyueshijian"));
        if (!Request.get("guihuanshijian").equals("")) post.setGuihuanshijian(Request.get("guihuanshijian"));
        if (!Request.get("jieyuetianshu").equals("")) post.setJieyuetianshu(Request.getInt("jieyuetianshu"));
        if (!Request.get("jieyuejine").equals("")) post.setJieyuejine(Request.getDouble("jieyuejine"));
        if (!Request.get("jieyuezhuangtai").equals("")) post.setJieyuezhuangtai(Request.get("jieyuezhuangtai"));
        if (!Request.get("jieyueren").equals("")) post.setJieyueren(Request.get("jieyueren"));

        post.setId(Request.getInt("id"));
        service.update(post); // 更新数据
        int charuid = post.getId().intValue();
        Query.execute("UPDATE jieyue SET jieyuetianshu=(TIMESTAMPDIFF(DAY , jieyueshijian,guihuanshijian)+1) WHERE id='" + request.getParameter("id") + "'");

        Query.execute("UPDATE jieyue SET jieyuejine=(jieyuetianshu*meitianjiage) WHERE id='" + request.getParameter("id") + "'");

        if (isAjax()) {
            return jsonResult(post);
        }

        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     *  后台详情
     */
    @RequestMapping("/jieyue_detail")
    public String detail() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        Jieyue map = service.find(id); // 根据前台url 参数中的id获取行数据
        assign("map", map); // 把数据写到前台
        return json(); // 将数据写给前端
    }

    /**
     *  删除
     */
    @RequestMapping("/jieyue_delete")
    public String delete() {
        _var = new LinkedHashMap(); // 重置数据
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id"); // 根据id 删除某行数据
        Map map = Query.make("jieyue").find(id);

        service.delete(id); // 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer")); //弹出删除成功，并跳回上一页
    }
}
