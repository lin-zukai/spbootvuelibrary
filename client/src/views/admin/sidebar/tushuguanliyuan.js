export default [
    {
        label: "图书信息管理",
        to: "",
        children: [
            {
                label: "图书分类添加",
                to: "/admin/tushufenleiadd",
            },
            {
                label: "图书分类查询",
                to: "/admin/tushufenlei",
            },
            {
                label: "图书信息添加",
                to: "/admin/tushuxinxiadd",
            },
            {
                label: "图书信息查询",
                to: "/admin/tushuxinxi",
            },
        ],
    },
    {
        label: "借阅归还管理",
        to: "",
        children: [
            {
                label: "借阅查询",
                to: "/admin/jieyue",
            },
            {
                label: "归还查询",
                to: "/admin/guihuan",
            }, {
                label: "借阅统计",
                to: "/admin/shouyitongji",
            },
        ],
    },
    {
        label: "评论举报管理",
        to: "",
        children: [
            {
                label: "评论查询",
                to: "/admin/pinglun",
            },
            {
                label: "举报查询",
                to: "/admin/jubao",
            },
            {
                label: "举报处理查询",
                to: "/admin/jubaochuli",
            },
            {
                label: "留言查询",
                to: "/admin/liuyanban",
            },
        ],
    },
    {
        label: "个人中心",
        to: "",
        children: [
            {
                label: "修改个人资料",
                to: "/admin/tushuguanliyuanupdtself",
            },
            {
                label: "修改密码",
                to: "/admin/mod",
            },
        ],
    },
];
