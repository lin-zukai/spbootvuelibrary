<template>
    <div class="jingmeiui-index">
        <div class="header bg-main">
            <div class="logo margin-big-left fadein-top">
                <h1>
                    <img src="./images/y.jpg" class="radius-circle rotate-hover" style="width: 50px; height: 50px; border-radius: 50%" alt="" />
                    {{ setting.title }}
                </h1>
            </div>
            <div class="head-l">

                <el-button type="primary" icon="fa fa-setting" @click="$goto('/admin/sy')" size="mini">后台主页</el-button>
                <el-button type="danger" icon="fa fa-setting" @click="logout" size="mini">退出登录</el-button>
            </div>
        </div>
        <div class="leftnav">
            <div class="leftnav-title">
                <strong><span class="icon-list"></span>菜单列表</strong>
            </div>
            <div class="leftnav-list" id="leftNav">
                <div class="leftnav-box" v-for="(v,k) in menus" :key="k">
                    <h2 :class="{on:k==active}" @click="active = k==active ? -1 : k"><span class="el-icon-user-solid"></span> {{ v.label }}</h2>
                    <collapse-transition :duration="{enter:800,leave:1000}">
                        <ul class="active" v-show="active == k">
                            <li v-for="(c,j) in v.children" :key="j">
                                <router-link :to="c.to"><span class="fa fa-caret-right"></span> {{ c.label }}</router-link>
                            </li>
                        </ul>
                    </collapse-transition>
                </div>
            </div>
        </div>
        <ul class="bread">
            <li><router-link to="/admin/sy" class="fa fa-home syHome"> 首页</router-link></li>
            <li v-show="$route.meta && $route.meta.title"><a href="javascript:;" target="right" id="a_leader_txt2"> {{ $route.meta.title }} </a></li>
        </ul>
        <div class="admin">
            <router-view></router-view>
        </div>
    </div>
</template>
<style type="text/scss" lang="scss">
    .jingmeiui-index {
        width: 100%;
        height: 100%;
        background: #f2f9fd;
        .header {
            height: 70px;
            overflow: hidden;
            background: url(./images/bg.jpg) no-repeat 0 -1000px;
            background-size: cover;
            .logo {
                float: left;
                color: #FFF;
                margin-top: 10px;
                line-height: 45px;
                h1,
                .h1 {
                    font-size: 24px;
                    margin: 0px;
                    padding: 0;
                }
            }
            .logo img {
                float: left;
                margin-right: 10px;
            }
            .head-l {
                float: left;
                margin-top: 17px;
                margin-left: 15px;
            }
        }
        .leftnav {
            width: 180px;
            position: fixed;
            top: 70px;
            left: 0px;
            bottom: 0px;
            .leftnav-title {
                height: 41px;
                background: url(./images/bg.jpg) no-repeat 0 -1000px;
                color: #FFF;
                padding-left: 22px;
                font-size: 14px;
                line-height: 50px;
            }
            .leftnav-title span {
                margin-right: 10px;
            }
            .leftnav-list {
                position: absolute;
                top: 41px;
                left: 0px;
                right: 0px;
                bottom: 0px;
                overflow: hidden;
                overflow-y: auto;
            }
            .leftnav-box {
            }
            h2 {
                padding: 10px 0 10px 22px;
                margin: 0;
                transition: all 0.1s ease-in-out;
                display: block;
                cursor: pointer;
                font-weight: bold;
                font-size: 14px;
                border-top: 1px solid #b5cfd9;
            }
            h2.on {
                color: #09c;
            }
            h2 span {
                margin-right: 10px;
            }
            ul {
                border-top: 1px solid #b5cfd9;
                padding: 10px 0;
                opacity: 1;
                margin: 0;
            }
            ul li a {
                display: block;
                padding-left: 30px;
                line-height: 30px;
            }
            ul li span {
                margin-right: 8px;
            }
        }
        .bread {
            border-radius: 4px;
            padding: 8px 15px;
            font-size: 12px;
            margin-bottom: 15px;
            color: #999;
        }
        .bread {
            margin-left: 190px;
            margin-top: 4px;
        }
        .bread li {
            float: left;
            display: inline-block;
        }
        .bread li:after {
            content: "\002f";
            padding: 0 8px;
            color: #ddd;
        }
        .admin {
            background: #fff;
            position: fixed;
            border-left: solid 1px #b5cfd9;
            right: 0;
            bottom: 0;
            top: 110px;
            left: 180px;
            padding: 15px;
            overflow-x: hidden;
            overflow-y: auto;
            border-top: 1px solid #b5cfd9;
            .iframe {
                width: 100%;
                height: 98%;
                overflow: hidden;
                overflow-y: auto;
                border: none;
            }
        }
    }
</style>
<script>
    import api from "@/api";
    import setting from "@/setting";
    import menu from "@/views/admin/sidebar";
    import CollapseTransition from "./collapseTransition";

    export default {
        name: "jingmeiui-index",
        components: { CollapseTransition },
        data() {
            return {
                setting,
                active: 0,
            };
        },
        watch: {},
        computed: {
            menus() {
                var cx = this.$session.cx;
                return menu[cx];
            },
        },
        methods: {
            logout() {
                this.$confirm("确定退出登录？", "确认信息").then(() => {
                    // 退出登录
                    this.$store
                        .dispatch("user/logout")
                        .then((res) => {
                            if (res.code == api.code.OK) {
                                this.$message.success("退出登录成功");
                                this.$router.replace("/index");
                            } else {
                                this.$message.error(res.msg);
                            }
                        })
                        .catch((err) => {
                            this.$message.error(err.message);
                        });
                });
            },
        },
        created() {},
        mounted() {
            var menus = this.menus;
            var active = -1;
            var path = this.$route.path;

            for (var i in menus) {
                var ci = menus[i];
                for (var j in ci.children) {
                    var v = ci.children[j];
                    if (v.to == path) {
                        active = i;
                        break;
                    }
                }
                if (active != -1) break;
            }
            if (active != -1) {
                this.active = active;
            }
        },
        destroyed() {},
    };
</script>
