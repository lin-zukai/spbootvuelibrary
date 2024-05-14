<template>
    <div class="jingmeiui-login">
        <transition enter-active-class="bounceIn" leave-active-class="bounceOut" :duration="{enter:800,leave:1000}">
            <div class="login-box">
                <div class="login-box-header">
                    <h2>{{ setting.title }}</h2>
                </div>
                <div class="login-box-body">
                    <form method="post" action="javascript:;" @submit="login">
                        <div class="form-group">
                            <el-input v-model="form.username" prefix-icon="el-icon-user-solid" placeholder="请输入账号" />
                        </div>
                        <div class="form-group">
                            <el-input v-model="form.pwd" type="password" prefix-icon="el-icon-lock" placeholder="请输入密码" />
                        </div>
                        <div class="form-group pagerandom">
                            <el-input v-model="form.pagerandom" prefix-icon="el-icon-lock" placeholder="请输入密码"> </el-input>
                            <e-img
                                alt="刷新验证码"
                                title="点击刷新验证码"
                                @click="loadCaptch"
                                :src="captchUrl"
                                style="cursor: pointer; padding-top: 10px; width: 60px; height: 30px; float: right"
                            ></e-img>
                        </div>
                        <div class="form-group">
                            <el-select v-model="form.cx" style="width: 100%">
                                <el-option :key="r" :value="r" :label="r" v-for="r in rules"></el-option>
                            </el-select>
                        </div>
                        <div class="form-group">
                            <el-button type="success" style="width: 100%" native-type="submit">登录</el-button>
                        </div>
                    </form>
                </div>
            </div>
        </transition>
    </div>
</template>
<style type="text/scss" lang="scss">
    .jingmeiui-login {
        width: 100%;
        height: 100%;
        background: url(./images/shuji.jpg) no-repeat;
        background-size: cover;
        padding-top: 100px;
        .login-box {
            width: 400px;
            margin: 0 auto;
            background: url("./images/tmbg-white.png");
            border-radius: 4px;
        }
        .login-box-header,
        .login-box-body {
            padding: 20px;
        }
        .login-box-header {
            text-align: center;
            h2 {
                margin: 0;
                padding: 0;
            }
        }
        .form-group {
            margin-bottom: 20px;
            input {
                background: url("./images/tmbg-white.png");
            }
        }
        .pagerandom {
            position: relative;
            img {
                position: absolute;
                right: 10px;
                top: 0px;
            }
        }
    }
</style>
<script>
    import setting from "@/setting";
    import api from "@/api";
    export default {
        name: "jingmeiui-login",
        data() {
            return {
                setting,
                captchUrl: "",
                loading: false,
                captchCode: "",
                form: {
                    username: "",
                    pwd: "",
                    cx: "管理员",
                    /* 验证码段 */
                    pagerandom: "",
                    a: "a",
                    /* 验证码段 */
                },
                rules: ["管理员", "用户", "图书管理员"],
            };
        },
        watch: {},
        computed: {},
        methods: {
            login() {
                this.loading = true;
                this.$store
                    .dispatch("user/login", this.form)
                    .then((res) => {
                        this.loading = false;
                        if (res.code == api.code.OK) {
                            this.$message.success("登录成功");
                            var redirect = this.$route.query.redirect;
                            if (redirect) {
                                this.$router.replace(redirect);
                            } else {
                                this.$router.replace("/admin/sy");
                            }
                        } else {
                            this.$message.error(res.msg);
                        }
                        if (res.code == 20) {
                            this.loadCaptch();
                        }
                    })
                    .catch((err) => {
                        this.loading = false;
                        this.$message.error(err.message);
                    });
            },
            loadCaptch() {
                api.captch().then((res) => {
                    console.log(res);
                    this.form.captchToken = res.token;
                    this.captchUrl = res.url;
                });
            },
        },
        created() {
            this.loadCaptch();
        },
        mounted() {},
        destroyed() {},
    };
</script>
