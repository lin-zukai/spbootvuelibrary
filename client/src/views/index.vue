<template>
    <div v-loading="loading">
        <div>
            <e-container>
                <el-carousel indicator-position="outside" height="420px">
                    <el-carousel-item v-for="item in bhtList" :key="item.id">
                        <div style="background-size: cover" @click="$goto(item.url)" :style="{'background-image': 'url('+item.image+')',width:'100%', height: '420px'}"></div>
                    </el-carousel-item>
                </el-carousel>
            </e-container>
        </div>
        <div>
            <e-container>
                <e-module-widget-title title="热门排行">
                    <div class="paoche">
                        <el-row class="ul_model" :gutter="20">
                            <el-col :md="4" class="li_model" :key="r.id" v-for="r in tushuxinxilist1">
                                <div class="li_model">
                                    <router-link :to="{path:'/tushuxinxidetail',query:{id:r.id}}" class="img_model">
                                        <e-img-box :src="r.tupian" pb="120"></e-img-box>
                                    </router-link>
                                    <div class="d_model">
                                        <div class="brand_model">
                                            <router-link :to="{path:'/tushuxinxidetail',query:{id:r.id}}" class="a_cen"> {{ $substr(r.tushumingcheng,15) }} </router-link>
                                        </div>
                                        <div class="tit_model">
                                            <p>借阅次数 {{ r.jieyuecishu }}</p>
                                        </div>
                                    </div>
                                </div>
                            </el-col>
                        </el-row>
                    </div></e-module-widget-title
                >
            </e-container>
        </div>
        <div>
            <e-container>
                <e-module-widget-title title="新书上架">
                    <div class="paoche">
                        <el-row class="ul_model" :gutter="20">
                            <el-col :md="6" class="li_model" :key="r.id" v-for="r in tushuxinxilist2">
                                <div class="li_model">
                                    <router-link :to="{path:'/tushuxinxidetail',query:{id:r.id}}" class="img_model">
                                        <e-img-box :src="r.tupian" pb="120"></e-img-box>
                                    </router-link>
                                    <div class="d_model">
                                        <div class="brand_model">
                                            <router-link :to="{path:'/tushuxinxidetail',query:{id:r.id}}" class="a_cen"> {{ $substr(r.tushumingcheng,15) }} </router-link>
                                        </div>
                                        <div class="tit_model">
                                            <p>借阅次数 {{ r.jieyuecishu }}</p>
                                        </div>
                                    </div>
                                </div>
                            </el-col>
                        </el-row>
                    </div></e-module-widget-title>
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
                loading: false,
                bhtList: [],
                tushuxinxilist1: [],
                tushuxinxilist2: [],
            };
        },
        watch: {},
        computed: {},
        methods: {
            loadPageData() {
                if (this.loading) return;
                this.loading = true;
                this.$get("/index")
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
        created() {
            this.loadPageData();
        },
        mounted() {},
        destroyed() {},
    };
</script>
