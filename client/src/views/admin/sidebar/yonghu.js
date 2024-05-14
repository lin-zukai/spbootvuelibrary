export default [
    {
        label: "图书信息管理",
        to: "",
        children: [
            {
                label: "图书添加",
                to: "/admin/tushuxinxiadd",
            },
            {
                label: "图书查询",
                to: "/admin/tushuxinxi_faburen",
            },
        ],
    },
    {
        label: "图书借阅管理",
        to: "",
        children: [
            {
                label: "我的借阅查询",
                to: "/admin/jieyue_jieyueren",
            },
            {
                label: "我的还书查询",
                to: "/admin/guihuan_jieyueren",
            },
            {
                label: "别人借我的",
                to: "/admin/jieyue_faburen",
            },
            {
                label: "别人还我的",
                to: "/admin/guihuan_faburen",
            },{
                label: "收益账单统计",
                to: "/admin/shouyitongjifaburen",
            },{
                label: "支出账单统计",
                to: "/admin/shouyitongjijieyueren",
            },
        ],
    },
    {
        label: "个人中心",
        to: "",
        children: [
            {
                label: "修改个人资料",
                to: "/admin/yonghuupdtself",
            },
            {
                label: "修改密码",
                to: "/admin/mod",
            },
            {
                label: "我的留言",
                to: "/admin/liuyanban_liuyanren",
            },
            {
                label: "我的评论",
                to: "/admin/pinglun_pinglunren",
            },
            {
                label: "我的举报记录",
                to: "/admin/jubao_jubaoren",
            },
            {
                label: "举报处理查询",
                to: "/admin/jubaochuli_jubaoren",
            },
        ],
    },
];
