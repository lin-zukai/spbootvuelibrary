export default [
    {
        label: "账号管理",
        to: "",
        children: [
            {
                label: "管理员账号管理",
                to: "/admin/admins",
            },
            {
                label: "管理员账号添加",
                to: "/admin/adminsadd",
            },
            {
                label: "密码修改",
                to: "/admin/mod",
            },
        ],
    },
    {
        label: "图书管理员管理",
        to: "",
        children: [
            {
                label: "图书管理员添加",
                to: "/admin/tushuguanliyuanadd",
            },
            {
                label: "图书管理员查询",
                to: "/admin/tushuguanliyuan",
            },
        ],
    },
    {
        label: "用户管理",
        to: "",
        children: [
            {
                label: "用户添加",
                to: "/admin/yonghuadd",
            },
            {
                label: "用户查询",
                to: "/admin/yonghu",
            },
        ],
    },
    {
        label: "系统管理",
        to: "",
        children: [
            {
                label: "轮播图添加",
                to: "/admin/lunbotuadd",
            },
            {
                label: "轮播图查询",
                to: "/admin/lunbotu",
            },
        ],
    },
];
