<template>
    <div class="guihuan-add" v-loading="loading">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span class="title"> 添加归还</span>
            </div>
            <div class="form-database-form">
                <el-form :model="form" ref="formModel" label-width="130px" status-icon validate-on-rule-change>
                    <el-form-item v-if="isRead" label="图书编号" prop="tushubianhao"> {{ form.tushubianhao }} </el-form-item>

                    <el-form-item v-if="isRead" label="图书名称" prop="tushumingcheng"> {{ form.tushumingcheng }} </el-form-item>

                    <el-form-item v-if="isRead" label="图书分类" prop="tushufenlei">
                        <e-select-view module="tushufenlei" :value="form.tushufenlei" select="id" show="fenleimingcheng"></e-select-view>
                    </el-form-item>

                    <el-form-item v-if="isRead" label="图书架" prop="tushujia"> {{ form.tushujia }} </el-form-item>

                    <el-form-item v-if="isRead" label="发布人" prop="faburen"> {{ form.faburen }} </el-form-item>

                    <el-form-item v-if="isRead" label="借阅人" prop="jieyueren"> {{ form.jieyueren }} </el-form-item>

                    <el-form-item label="实际归还时间" prop="shijiguihuanshijian" :rules="[{required:true, message:'请填写实际归还时间'}]">
                        <el-date-picker v-model="form.shijiguihuanshijian" type="datetime" :editable="false" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期">
                        </el-date-picker>
                    </el-form-item>

                    <el-form-item label="备注" prop="beizhu"> <el-input type="textarea" v-model="form.beizhu"></el-input> </el-form-item>

                    <el-form-item label="还书人" prop="huanshuren"> <el-input v-model="form.huanshuren" readonly style="width: 250px"></el-input> </el-form-item>

                    <el-form-item v-if="btnText">
                        <el-button type="primary" @click="submit">{{ btnText }}</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </div>
</template>
<style type="text/scss" scoped lang="scss">
    .guihuan-add {
    }
</style>
<script>
    import api from "@/api";
    import rule from "@/utils/rule";
    import { extend } from "@/utils/extend";

    export default {
        name: "guihuan-add",
        data() {
            return {
                readMap: {},
                rule,
                loading: false,
                form: {
                    tushubianhao: "",
                    tushumingcheng: "",
                    tushufenlei: "",
                    tushujia: "",
                    faburen: this.$store.state.user.session.username,
                    jieyueren: this.$store.state.user.session.username,
                    shijiguihuanshijian: rule.date("Y-m-d H:i:s"),
                    beizhu: "",
                    huanshuren: this.$store.state.user.session.username,
                    jieyueid: 0,
                },
            };
        },
        watch: {},
        props: {
            isRead: {
                type: Boolean,
                default: true,
            },
            btnText: {
                type: String,
                default: "提交",
            },
        },

        computed: {},
        methods: {
            submit() {
                this.$refs.formModel
                    .validate()
                    .then((res) => {
                        if (this.loading) return;
                        this.loading = true;
                        var form = this.form;

                        this.$post(api.guihuan.insert, form)
                            .then((res) => {
                                this.loading = false;
                                if (res.code == api.code.OK) {
                                    this.$message.success("添加成功");
                                    this.$emit("success", res.data);
                                    this.$refs.formModel.resetFields();
                                    this.$router.go(-1);
                                } else {
                                    this.$message.error(res.msg);
                                }
                            })
                            .catch((err) => {
                                this.loading = false;
                                this.$message.error(err.message);
                            });
                    })
                    .catch((err) => {
                        console.log(err.message);
                    });
            },
            loadInfo() {
                var form = this.form;
                // 获取模块得数据
                this.loading = true;
                this.$post(api.guihuan.create, {
                    id: this.$route.query.id,
                })
                    .then((res) => {
                        this.loading = false;
                        if (res.code == api.code.OK) {
                            extend(this, res.data);
                            var readMap = res.data.readMap;
                            for (var i in form) {
                                if (readMap[i] && i != "id") {
                                    form[i] = res.data.readMap[i];
                                }
                            }
                            form.jieyueid = readMap.id;
                        } else {
                            this.$message.error(res.msg);
                            this.$router.go(-1);
                        }
                    })
                    .catch((err) => {
                        this.$message.error(err.message);
                        this.$router.go(-1);
                    });
            },
        },
        created() {
            this.loadInfo();
        },
        mounted() {},
        destroyed() {},
    };
</script>
