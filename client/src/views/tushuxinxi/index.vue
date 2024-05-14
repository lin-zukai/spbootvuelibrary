<template>
    <div v-loading="loading">
        <div>
            <e-container>
                <form action="javascript:;" @submit="searchSubmit" class="form-search">
                    <table class="jd-search">
                        <tbody>
                        <tr>
                            <td class="label">
                                图书分类
                            </td>
                            <td>
                                <p class="search-radio">

                                    <a href="javascript:;" @click="selectRadio('tushufenlei','')"
                                       :class="{active:!search.tushufenlei}">全部</a>

                                    <a href="javascript:;"
                                       v-for="r in maptushufenlei1"
                                       @click="selectRadio('tushufenlei',r.id)"
                                       :class="{active:search.tushufenlei == r.id}" v-text="r.fenleimingcheng">

                                    </a>

                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">
                                图书架
                            </td>
                            <td>
                                <p class="search-radio">

                                    <a href="javascript:;" @click="selectRadio('tushujia','')"
                                       :class="{active:!search.tushujia}">全部</a>

                                    <a href="javascript:;"
                                       :class="{active:search.tushujia == '电子图书架'}"
                                       @click="selectRadio('tushujia','电子图书架')">电子图书架</a>
                                    <a href="javascript:;"
                                       :class="{active:search.tushujia == '社区活动室图书架'}"
                                       @click="selectRadio('tushujia','社区活动室图书架')">社区活动室图书架</a>

                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">
                                图书名称
                            </td>
                            <td>
                                <el-input
                                        type="text" style="width: 150px"
                                        v-model="search.tushumingcheng"
                                        placeholder="请输入关键词">
                                </el-input>
                                <el-button type="success" @click="searchSubmit">搜索</el-button>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">
                                作者
                            </td>
                            <td>
                                <el-input
                                        type="text" style="width: 150px"
                                        v-model="search.zuozhe"
                                        placeholder="请输入关键词">


                                </el-input>
                                <el-button type="success" @click="searchSubmit">搜索</el-button>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">
                                出版社
                            </td>
                            <td>
                                <el-input
                                        type="text" style="width: 150px"
                                        v-model="search.chubanshe"
                                        placeholder="请输入关键词">

                                </el-input>

                                <el-button type="success" @click="searchSubmit">搜索</el-button>

                            </td>
                        </tr>

                        </tbody>
                    </table>
                </form>

                <el-row :gutter="30">
                    <el-col v-for="r in list" :md="6" :key="r.id" style="margin-bottom: 20px">
                        <e-module-xiezi :title="r.tushumingcheng" :image="r.tupian" :image-height="100"
                                        :is-scale="false" :to="'/tushuxinxidetail?id='+r.id"></e-module-xiezi>
                    </el-col>
                </el-row>

                <div style="margin-top: 10px; text-align: center">
                    <el-pagination @current-change="loadList" :current-page="page" :page-size="15"
                                   layout="total, sizes, prev, pager, next, jumper" :total="totalCount">
                    </el-pagination>
                </div>
            </e-container>
        </div>
    </div>
</template>
<style type="text/scss" scoped lang="scss"></style>
<script>
    import api from "@/api";
    import {extend} from "@/utils/extend";
    import objectDiff from "objectdiff";

    /**
     * 后台列表页面
     */
    export default {
        data() {
            return {
                loading: false,
                list: [],
                search: {
                    tushubianhao: "",

                    tushumingcheng: "",

                    tushufenlei: "",

                    tushujia: "",

                    tupian: "",

                    shipin: "",

                    zuozhe: "",

                    chubanshe: "",

                    jieyueyupeijin_start: "",
                    jieyueyupeijin_end: "",

                    meitianjiage_start: "",
                    meitianjiage_end: "",

                    jieyuecishu_start: "",
                    jieyuecishu_end: "",

                    faburen: "",

                    tushuzhuangtai: "",

                    tushuxiangqing: "",
                },
                page: 1, // 当前页
                pagesize: 12, // 页大小
                totalCount: 0, // 总行数
                total: {},

                maptushufenlei1: [],
            };
        },
        watch: {},
        computed: {},
        methods: {
            searchSubmit() {
                this.loadList(1);
            },
            loadList(page) {
                // 防止重新点加载列表
                if (this.loading) return;
                this.loading = true;
                this.page = page;
                // 筛选条件
                var filter = extend(true, {}, this.search, {page: page + "", pagesize: this.pagesize + ""});
                var diff = objectDiff.diff(filter, this.$route.query);
                if (diff.changed != "equal") {
                    // 筛选的条件不一致则更新链接
                    this.$router.replace({
                        // 更新query
                        path: this.$route.path,
                        query: filter,
                    });
                }
                this.$post(api.tushuxinxi.weblist, filter)
                    .then((res) => {
                        this.loading = false;
                        if (res.code == api.code.OK) {
                            extend(this, res.data);
                        } else {
                            this.$message.error(res.msg);
                        }
                    })
                    .catch((err) => {
                        this.loading = false;
                        this.$message.error(err.message);
                    });
            },
            selectRadio(target, name) {
                this.search[target] = name;
                this.searchSubmit(1);
            },
        },
        beforeRouteUpdate(to, form, next) {
            var search = extend(this.search, to.query);
            if (search.page) {
                this.page = Math.floor(to.query.page);
                delete search.page;
            }
            if (search.pagesize) {
                this.pagesize = Math.floor(to.query.pagesize);
                delete search.pagesize;
            }
            this.loadList(1);
            next();
        },
        created() {
            var search = extend(this.search, this.$route.query);
            if (search.page) {
                this.page = Math.floor(this.$route.query.page);
                delete search.page;
            }
            if (search.pagesize) {
                this.pagesize = Math.floor(this.$route.query.pagesize);
                delete search.pagesize;
            }
            this.loadList(this.page);
        },
        mounted() {
        },
        destroyed() {
        },
    };
</script>
