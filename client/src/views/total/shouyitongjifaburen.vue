<template>
    <div v-loading="loading">
        <div>
            <el-form action="javascript:;" @submit="loadXiaoshouejieyue" inline>
                <el-form-item label="时间">
                    <el-date-picker v-model="jieyueshijian_start" type="date" value-format="yyyy-MM-dd"> </el-date-picker>
                    至
                    <el-date-picker v-model="jieyueshijian_end" type="date" value-format="yyyy-MM-dd"> </el-date-picker>
                </el-form-item>

                <el-form-item>
                    <el-button type="success" @click="loadXiaoshouejieyue">搜索</el-button>
                </el-form-item>
            </el-form>

            <table class="table">
                <thead>
                    <tr>
                        <th>图书名称</th>
                        <th>收益金额</th>

                    </tr>
                </thead>
                <tbody>
                    <tr v-for="v in jieyueList">
                        <td>{{ v.tushumingcheng }}</td>
                        <td>{{ v.sum_jieyuejine }}</td>

                    </tr>
                </tbody>
            </table>

            <div style="height: 400px" ref="jieyueline"></div>
        </div>
    </div>
</template>
<style type="text/scss" scoped lang="scss"></style>
<script>
    import api from "@/api";
    import { extend } from "@/utils/extend";
    import jdk from "@/utils/extend";
    import DB from "@/utils/db";

    import echarts from "echarts";

    export default {
        data() {
            return {
                loading: false,
                search: [],
                jieyueshijian_start: "",
                jieyueshijian_end: "",
                jieyueList: [],
            };
        },
        watch: {},
        computed: {},
        methods: {
            loadPageData() {
                if (this.loading) return;
                this.loading = true;
                this.$get("/shouyitongji")
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
            loadXiaoshouejieyue() {
                var where = " 1=1 ";
                if (!jdk.empty(this.jieyueshijian_start)) {
                    where += " AND m.jieyueshijian>'" + this.jieyueshijian_start + "' ";
                }
                if (!jdk.empty(this.jieyueshijian_end)) {
                    where += " AND m.jieyueshijian<'" + this.jieyueshijian_end + "' ";
                }

                var session = this.$store.state.user.session;
                if(session.cx == '用户'){
                    where += " AND (faburen='"+session.username+"' ) "
                }


                var sql = `SELECT SUM(m.jieyuejine) sum_jieyuejine,m.tushumingcheng,COUNT(m.id) count  FROM jieyue as m  WHERE ${where} GROUP BY m.tushumingcheng ORDER BY SUM(m.jieyuejine) DESC`;
                DB.select(sql).then((res) => {
                    if (res.code == 0) {
                        this.handlerOptionsjieyue(res.data);
                        this.jieyueList = res.data;
                    }
                });
            },
            handlerOptionsjieyue(lists) {
                var el = this.$refs.jieyueline;
                var chart = echarts.init(el);
                chart.setOption({
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {
                            type: "cross",
                        },
                    },
                    grid: {
                        right: "20%",
                    },
                    toolbox: {
                        feature: {
                            dataView: { show: true, readOnly: false },
                            restore: { show: true },
                            saveAsImage: { show: true },
                        },
                    },
                    legend: {
                        data: ["收益"],
                    },
                    xAxis: [
                        {
                            type: "category",
                            axisTick: {
                                alignWithLabel: true,
                            },
                            // prettier-ignore
                            data: lists.map(s=>s.tushumingcheng),
                        },
                    ],
                    yAxis: [{ type: "value", name: "借阅金额", position: "left" }],
                    series: [
                        {
                            name: "收益",
                            type: "bar",
                            data: lists.map((s) => parseFloat(s.sum_jieyuejine)),
                        },
                    ],
                });
            },
        },
        created() {

            this.loadXiaoshouejieyue();
        },
        mounted() {},
        destroyed() {},
    };
</script>
