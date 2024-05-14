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
 * 举报处理 */
@Controller
public class JubaochuliController extends BaseController {

    @Autowired
    private JubaochuliMapper dao;

    @Autowired
    private JubaochuliService service;

    @Autowired
    private JubaoService serviceRead;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/jubaochuli_list")
    public String list() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据
        Example example = new Example(Jubaochuli.class); //  创建一个扩展搜索类
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
        List<Jubaochuli> list = service.selectPageExample(example, page, pagesize); // 获取当前页的行数

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
        // 判断URL 参数jubaoid是否大于0
        if (Request.getInt("jubaoid") > 0) {
            // 大于0 则写入条件
            where += " AND jubaoid='" + Request.getInt("jubaoid") + "' ";
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
        if (!Request.get("jubaoren").equals("")) {
            where += " AND jubaoren LIKE '%" + Request.get("jubaoren") + "%' ";
        }
        if (!Request.get("chulibeizhu").equals("")) {
            where += " AND chulibeizhu LIKE '%" + Request.get("chulibeizhu") + "%' ";
        }
        if (!Request.get("chuliren").equals("")) {
            where += " AND chuliren LIKE '%" + Request.get("chuliren") + "%' ";
        }
        return where;
    }

    /**
     * 发布人列表
     */
    @RequestMapping("/jubaochuli_list_faburen")
    public String listfaburen() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }
        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据

        Example example = new Example(Jubaochuli.class); //  创建一个扩展搜索类
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

        List<Jubaochuli> list = service.selectPageExample(example, page, pagesize);
        assign("totalCount", request.getAttribute("totalCount"));
        assign("list", list);
        assign("orderby", order);
        assign("sort", sort);
        return json(); // 将数据写给前端
    }

    /**
     * 举报人列表
     */
    @RequestMapping("/jubaochuli_list_jubaoren")
    public String listjubaoren() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }
        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据

        Example example = new Example(Jubaochuli.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：举报人=当前登录用户
        String where = " jubaoren='" + request.getSession().getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<Jubaochuli> list = service.selectPageExample(example, page, pagesize);
        assign("totalCount", request.getAttribute("totalCount"));
        assign("list", list);
        assign("orderby", order);
        assign("sort", sort);
        return json(); // 将数据写给前端
    }

    /**
     * 处理人列表
     */
    @RequestMapping("/jubaochuli_list_chuliren")
    public String listchuliren() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }
        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据

        Example example = new Example(Jubaochuli.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：处理人=当前登录用户
        String where = " chuliren='" + request.getSession().getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<Jubaochuli> list = service.selectPageExample(example, page, pagesize);
        assign("totalCount", request.getAttribute("totalCount"));
        assign("list", list);
        assign("orderby", order);
        assign("sort", sort);
        return json(); // 将数据写给前端
    }

    @RequestMapping("/jubaochuli_add")
    public String add() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id"); // 根据id 获取 举报模块中的数据
        Jubao readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        assign("readMap", readMap);

        return json(); // 将数据写给前端
    }

    @RequestMapping("/jubaochuli_updt")
    public String updt() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Jubaochuli mmm = service.find(id);
        assign("mmm", mmm);
        assign("updtself", 0);

        return json(); // 将数据写给前端
    }

    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/jubaochuliinsert")
    public String insert() {
        _var = new LinkedHashMap(); // 重置数据
        String tmp = "";
        Jubaochuli post = new Jubaochuli(); // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setJubaoid(Request.getInt("jubaoid"));

        post.setTushuxinxiid(Request.getInt("tushuxinxiid"));

        post.setTushubianhao(Request.get("tushubianhao"));

        post.setTushumingcheng(Request.get("tushumingcheng"));

        post.setTushufenlei(Request.get("tushufenlei"));

        post.setTushujia(Request.get("tushujia"));

        post.setFaburen(Request.get("faburen"));

        post.setJubaoren(Request.get("jubaoren"));

        post.setChulibeizhu(Request.get("chulibeizhu"));

        post.setChuliren(Request.get("chuliren"));

        post.setJubaoid(Request.getInt("jubaoid"));

        service.insert(post); // 插入数据
        int charuid = post.getId().intValue();
        Query.execute("update jubao set jubaozhuangtai='已处理' where id='" + request.getParameter("jubaoid") + "'");

        if (isAjax()) {
            return jsonResult(post);
        }
        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 更新内容
     * @return
     */
    @RequestMapping("/jubaochuliupdate")
    public String update() {
        _var = new LinkedHashMap(); // 重置数据
        // 创建实体类
        Jubaochuli post = new Jubaochuli();
        // 将前台表单数据填充到实体类
        if (!Request.get("jubaoid").equals("")) post.setJubaoid(Request.getInt("jubaoid"));
        if (!Request.get("tushuxinxiid").equals("")) post.setTushuxinxiid(Request.getInt("tushuxinxiid"));
        if (!Request.get("tushubianhao").equals("")) post.setTushubianhao(Request.get("tushubianhao"));
        if (!Request.get("tushumingcheng").equals("")) post.setTushumingcheng(Request.get("tushumingcheng"));
        if (!Request.get("tushufenlei").equals("")) post.setTushufenlei(Request.get("tushufenlei"));
        if (!Request.get("tushujia").equals("")) post.setTushujia(Request.get("tushujia"));
        if (!Request.get("faburen").equals("")) post.setFaburen(Request.get("faburen"));
        if (!Request.get("jubaoren").equals("")) post.setJubaoren(Request.get("jubaoren"));
        if (!Request.get("chulibeizhu").equals("")) post.setChulibeizhu(Request.get("chulibeizhu"));
        if (!Request.get("chuliren").equals("")) post.setChuliren(Request.get("chuliren"));

        post.setId(Request.getInt("id"));
        service.update(post); // 更新数据
        int charuid = post.getId().intValue();

        if (isAjax()) {
            return jsonResult(post);
        }

        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     *  后台详情
     */
    @RequestMapping("/jubaochuli_detail")
    public String detail() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        Jubaochuli map = service.find(id); // 根据前台url 参数中的id获取行数据
        assign("map", map); // 把数据写到前台
        return json(); // 将数据写给前端
    }

    /**
     *  删除
     */
    @RequestMapping("/jubaochuli_delete")
    public String delete() {
        _var = new LinkedHashMap(); // 重置数据
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id"); // 根据id 删除某行数据
        Map map = Query.make("jubaochuli").find(id);

        service.delete(id); // 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer")); //弹出删除成功，并跳回上一页
    }
}
