export default [
    {
        path: "yonghuadd",
        name: "IndexyonghuAdd",
        component: () => import("@/views/yonghu/webadd"),
        meta: { title: "用户添加" },
    },
    {
        path: "liuyanbanadd",
        name: "IndexliuyanbanAdd",
        component: () => import("@/views/liuyanban/webadd"),
        meta: { title: "留言板添加", authLogin: true, msg: true },
    },
    {
        path: "tushuxinxi",
        name: "IndextushuxinxiList",
        component: () => import("@/views/tushuxinxi/index"),
        meta: { title: "图书信息列表" },
    },
    {
        path: "tushuxinxidetail",
        name: "IndextushuxinxiDetail",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/tushuxinxi/webdetail"),
        meta: { title: "图书信息详情" },
    },
    {
        path: "jieyueadd",
        name: "IndexjieyueAdd",
        component: () => import("@/views/jieyue/webadd"),
        meta: { title: "借阅添加", authLogin: true, msg: true },
    },
    {
        path: "pinglunadd",
        name: "IndexpinglunAdd",
        component: () => import("@/views/pinglun/webadd"),
        meta: { title: "评论添加", authLogin: true, msg: true },
    },
    {
        path: "jubaoadd",
        name: "IndexjubaoAdd",
        component: () => import("@/views/jubao/webadd"),
        meta: { title: "举报添加", authLogin: true, msg: true },
    },
];
