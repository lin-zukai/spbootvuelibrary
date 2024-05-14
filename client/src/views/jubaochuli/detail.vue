<template>
    <div class="jubaochuli-detail" v-loading="loading" ref="print">
        <el-page-header @back="goBack" content="详情页面"></el-page-header>
        <div class="admin-detail">
            <div class="detail detail-readmodule">
                <div class="detail-title">举报id：</div>
                <div class="detail-content">{{ map.jubaoid }}</div>
            </div>
            <div class="detail detail-readmodule">
                <div class="detail-title">图书信息id：</div>
                <div class="detail-content">{{ map.tushuxinxiid }}</div>
            </div>
            <div class="detail detail-text">
                <div class="detail-title">图书编号：</div>
                <div class="detail-content">{{ map.tushubianhao }}</div>
            </div>
            <div class="detail detail-longtext">
                <div class="detail-title">图书名称：</div>
                <div class="detail-content">{{ map.tushumingcheng }}</div>
            </div>
            <div class="detail detail-select">
                <div class="detail-title">图书分类：</div>
                <div class="detail-content">
                    <e-select-view module="tushufenlei" :value="map.tushufenlei" select="id" show="fenleimingcheng"></e-select-view>
                </div>
            </div>
            <div class="detail detail-select">
                <div class="detail-title">图书架：</div>
                <div class="detail-content">{{ map.tushujia }}</div>
            </div>
            <div class="detail detail-textuser">
                <div class="detail-title">发布人：</div>
                <div class="detail-content">{{ map.faburen }}</div>
            </div>
            <div class="detail detail-textuser">
                <div class="detail-title">举报人：</div>
                <div class="detail-content">{{ map.jubaoren }}</div>
            </div>
            <div class="detail detail-textuser">
                <div class="detail-title">处理人：</div>
                <div class="detail-content">{{ map.chuliren }}</div>
            </div>
            <div class="detail detail-textarea">
                <div class="detail-title">处理备注：</div>
                <div class="detail-content">{{ map.chulibeizhu }}</div>
            </div>
        </div>
        <div class="mt10">
            <el-button type="default" class="hidePrint" @click="$router.go(-1)"> 返回 </el-button>
            <el-button type="success" class="hidePrint" @click="$print"> 打印本页 </el-button>
        </div>
    </div>
</template>
<style type="text/scss" scoped lang="scss">
    .jubaochuli-detail {
        .admin-detail {
            display: flex;
            flex-wrap: wrap;
            margin-top: 30px;
            .detail {
                width: 50%;
                padding: 5px;
                display: flex;
                margin-bottom: 10px;
                border-bottom: 1px solid #DEDEDE;
                .detail-title {
                    width: 120px;
                    text-align: right;
                    flex-shrink: 0;
                }
                .detail-content {
                    flex-grow: 1;
                }
            }
            .detail.detail-images {
                width: 100%;
                flex-wrap: wrap;
                .detail-title {
                    display: none;
                }

                .detail-content {
                    width: 100%;
                    padding: 10px;
                }
            }
            .detail.detail-editor,
            .detail.detail-dataset {
                width: 100%;
                flex-wrap: wrap;
                .detail-title {
                    width: 100%;
                    padding: 10px;
                    margin-top: 10px;
                    background: #9a0606;
                    color: #ffffff;
                    text-align: left;
                }
                .detail-content {
                    padding: 10px;
                }
            }
        }
    }
</style>
<script>
    import api from "@/api";
    import { extend } from "@/utils/extend";

    export default {
        data() {
            return {
                loading: false,
                map: {},
            };
        },
        props: {
            id: {
                type: [String, Number],
                required: true,
            },
        },
        watch: {
            id: {
                handler() {
                    this.loadDetail();
                },
                immediate: true,
            },
        },
        computed: {},
        methods: {
            goBack() {
                this.$router.go(-1);
            },
            loadDetail() {
                if (this.loading) return;
                this.loading = true;
                this.$get(api.jubaochuli.detail, {
                    id: this.id,
                })
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
        },
        created() {},
        mounted() {},
        destroyed() {},
    };
</script>
