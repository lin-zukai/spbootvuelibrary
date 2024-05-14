<template>
    <div class="tushuxinxi-detail" v-loading="loading">
        <div>
            <e-container>
                <div class="bilibili" style="background: #FFFFFF">
                    <div class="plp-l">
                        <div class="player-module">
                            <div class="stardust-player">
                                <div class="player">
                                    <div class="bilibili-player relative">
                                        <div class="bilibili-player-area">
                                            <div class="bilibili-player-video-wrap">
                                                <e-video :src="map.shipin"></e-video>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="plp-r">
                        <div class="media-wrapper" style="color: #535353">
                            <h1 v-text="map.tushumingcheng"></h1>
                            <div class="tool-bar clearfix">
                                <div class="like-info">
                                    <span>图书编号 : {{ map.tushubianhao }}</span>
                                </div>
                                <div class="like-info">
                                    <span>图书分类 : <e-select-view module="tushufenlei" :value="map.tushufenlei" select="id" show="fenleimingcheng"></e-select-view></span>
                                </div>
                                <div class="like-info">
                                    <span>图书架 : {{ map.tushujia }}</span>
                                </div>
                                <div class="like-info">
                                    <span>作者 : {{ map.zuozhe }}</span>
                                </div>
                                <div class="like-info">
                                    <span>出版社 : {{ map.chubanshe }}</span>
                                </div>
                                <div class="like-info">
                                    <span>借阅预赔金 : {{ map.jieyueyupeijin }}</span>
                                </div>
                                <div class="like-info">
                                    <span>每天价格 : {{ map.meitianjiage }}</span>
                                </div>
                                <div class="like-info">
                                    <span>借阅次数 : {{ map.jieyuecishu }}</span>
                                </div>
                                <div class="like-info">
                                    <span>发布人 : {{ map.faburen }}</span>
                                </div>
                                <div class="like-info">
                                    <span>图书状态 : {{ map.tushuzhuangtai }}</span>
                                </div>

                                <el-button @click="$goto('/jieyueadd?id='+map.id)" v-if="map.tushuzhuangtai == '可借阅'" type="success" icon="el-icon-plus"
                                           size="mini"> 借阅
                                </el-button>

                                <el-button @click="$goto('/jubaoadd?id='+map.id)" type="success" icon="el-icon-plus"
                                           size="mini"> 举报
                                </el-button>
                            </div>

                            <div class="media-info clearfix">
                                <div class="media-right">
                                    <div class="media-desc">{{ $substr(map.tushuxiangqing , 120) }}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </e-container>
        </div>
        <div>
            <e-container>
                <e-comments module="tushuxinxi" :lists="comments" :biaoti="map.tushumingcheng" user="yonghu" headimg="touxiang" :is-reply="false" name="xingming"> </e-comments>
            </e-container>
        </div>
    </div>
</template>
<style type="text/scss" scoped lang="scss"></style>
<script>
    import api from "@/api";
    import { extend } from "@/utils/extend";
    import jdk from "@/utils/extend";
    export default {
        data() {
            return {
                loading: false, // 加载

                map: {
                    tushubianhao: "",
                    tushumingcheng: "",
                    tushufenlei: "",
                    tushujia: "",
                    tupian: "",
                    shipin: "",
                    zuozhe: "",
                    chubanshe: "",
                    jieyueyupeijin: "",
                    meitianjiage: "",
                    jieyuecishu: "",
                    faburen: "",
                    tushuzhuangtai: "",
                    tushuxiangqing: "",
                },
                comments: [],
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
            loadDetail() {
                if (this.loading) return;
                this.loading = true;
                this.$get(api.tushuxinxi.webdetail, {
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
