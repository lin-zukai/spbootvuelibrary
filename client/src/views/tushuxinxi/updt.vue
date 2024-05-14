<template>
    <div class="tushuxinxi-add" v-loading="loading">
        <el-card class="box-card">
            <div slot="header" class="clearfix updt">
                <el-page-header @back="$router.go(-1)" content="编辑图书信息"> </el-page-header>
            </div>
            <div class="form-database-form">
                <el-form :model="form" ref="formModel" label-width="130px" status-icon validate-on-rule-change>
                    <el-form-item label="图书编号" prop="tushubianhao" :rules="[{required:true, message:'请填写图书编号'}]">
                        <el-input type="text" placeholder="输入图书编号" style="width: 250px" v-model="form.tushubianhao" />
                    </el-form-item>

                    <el-form-item label="图书名称" prop="tushumingcheng" required :rules="[{required:true, message:'请填写图书名称'}]">
                        <el-input type="text" placeholder="输入图书名称" style="width: 450px" v-model="form.tushumingcheng" />
                    </el-form-item>

                    <el-form-item label="图书分类" prop="tushufenlei" required :rules="[{required:true, message:'请填写图书分类'}]">
                        <el-select v-model="form.tushufenlei"><e-select-option type="option" module="tushufenlei" value="id" label="fenleimingcheng"></e-select-option></el-select>
                    </el-form-item>

                    <el-form-item label="图书架" prop="tushujia" required :rules="[{required:true, message:'请填写图书架'}]">
                        <el-select v-model="form.tushujia"
                            ><el-option label="电子图书架" value="电子图书架"></el-option>
                            <el-option label="社区活动室图书架" value="社区活动室图书架"></el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="图片" prop="tupian" required :rules="[{required:true, message:'请填写图片'}]">
                        <e-upload-image v-model="form.tupian"></e-upload-image>
                    </el-form-item>

                    <el-form-item label="视频" prop="shipin" required :rules="[{required:true, message:'请填写视频'}]">
                        <e-upload-file v-model="form.shipin"></e-upload-file>
                    </el-form-item>

                    <el-form-item label="作者" prop="zuozhe" required :rules="[{required:true, message:'请填写作者'}]">
                        <el-input type="text" placeholder="输入作者" style="width: 250px" v-model="form.zuozhe" />
                    </el-form-item>

                    <el-form-item label="出版社" prop="chubanshe" required :rules="[{required:true, message:'请填写出版社'}]">
                        <el-input type="text" placeholder="输入出版社" style="width: 250px" v-model="form.chubanshe" />
                    </el-form-item>

                    <el-form-item
                        label="借阅预赔金"
                        prop="jieyueyupeijin"
                        required
                        :rules="[{required:true, message:'请填写借阅预赔金'}, {validator:rule.checkNumber, message:'输入一个有效数字'}, {validator:rule.checkMin, value:1}]"
                    >
                        <el-input type="number" placeholder="输入借阅预赔金" style="width: 250px" v-model.number="form.jieyueyupeijin" />
                    </el-form-item>

                    <el-form-item
                        label="每天价格"
                        prop="meitianjiage"
                        required
                        :rules="[{required:true, message:'请填写每天价格'}, {validator:rule.checkNumber, message:'输入一个有效数字'}, {validator:rule.checkMin, value:0}]"
                    >
                        <el-input type="number" placeholder="输入每天价格" style="width: 250px" v-model.number="form.meitianjiage" />
                    </el-form-item>

                    <el-form-item label="发布人" prop="faburen"> <el-input v-model="form.faburen" readonly style="width: 250px"></el-input> </el-form-item>

                    <el-form-item label="图书详情" prop="tushuxiangqing"> <e-editor v-model="form.tushuxiangqing"></e-editor> </el-form-item>

                    <el-form-item v-if="btnText">
                        <el-button type="primary" @click="submit">{{ btnText }}</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </div>
</template>
<style type="text/scss" scoped lang="scss">
    .tushuxinxi-add {
    }
</style>
<script>
    import api from "@/api";
    import rule from "@/utils/rule";
    import { extend } from "@/utils/extend";

    export default {
        name: "tushuxinxi-add",
        data() {
            return {
                rule,
                loading: false,
                form: {
                    tushubianhao: rule.getID(),
                    tushumingcheng: "",
                    tushufenlei: "",
                    tushujia: "",
                    tupian: "",
                    shipin: "",
                    zuozhe: "",
                    chubanshe: "",
                    jieyueyupeijin: "",
                    meitianjiage: "",
                    faburen: this.$store.state.user.session.username,
                    tushuxiangqing: "",

                    issh: "否",
                },
            };
        },
        watch: {
            id: {
                handler() {
                    this.loadInfo();
                },
            },
        },
        props: {
            isRead: {
                type: Boolean,
                default: true,
            },
            btnText: {
                type: String,
                default: "提交",
            },
            id: {
                type: [String, Number],
                required: true,
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

                        this.$post(api.tushuxinxi.update, form)
                            .then((res) => {
                                this.loading = false;
                                if (res.code == api.code.OK) {
                                    this.$message.success("添加成功");
                                    this.$emit("success", res.data);
                                    this.$refs.formModel.resetFields();
                                    this.loadInfo();
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
                // 更新数据,获取数据
                this.loading = true;
                var form = this.form;
                this.$post(api.tushuxinxi.edit, {
                    id: this.id,
                })
                    .then((res) => {
                        this.loading = false;
                        if (res.code == api.code.OK) {
                            extend(this, res.data);
                            this.form = res.data.mmm;
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
