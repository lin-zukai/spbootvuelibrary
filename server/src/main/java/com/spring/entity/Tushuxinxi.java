package com.spring.entity;

import com.spring.util.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tushuxinxi")
public class Tushuxinxi implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "tushubianhao")
    private String tushubianhao;

    @Column(name = "tushumingcheng")
    private String tushumingcheng;

    @Column(name = "tushufenlei")
    private String tushufenlei;

    @Column(name = "tushujia")
    private String tushujia;

    @Column(name = "tupian")
    private String tupian;

    @Column(name = "shipin")
    private String shipin;

    @Column(name = "zuozhe")
    private String zuozhe;

    @Column(name = "chubanshe")
    private String chubanshe;

    @Column(name = "jieyueyupeijin")
    private Double jieyueyupeijin;

    @Column(name = "meitianjiage")
    private Double meitianjiage;

    @Column(name = "jieyuecishu")
    private Integer jieyuecishu;

    @Column(name = "faburen")
    private String faburen;

    @Column(name = "tushuzhuangtai")
    private String tushuzhuangtai;

    @Column(name = "tushuxiangqing")
    private String tushuxiangqing;

    private String issh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getJieyueCount() {
        return Query.make("jieyue").where("tushuxinxiid", id).count();
    }

    public Long getJubaoCount() {
        return Query.make("jubao").where("tushuxinxiid", id).count();
    }

    public String getTushubianhao() {
        return tushubianhao;
    }

    public void setTushubianhao(String tushubianhao) {
        this.tushubianhao = tushubianhao;
    }

    public String getTushumingcheng() {
        return tushumingcheng;
    }

    public void setTushumingcheng(String tushumingcheng) {
        this.tushumingcheng = tushumingcheng;
    }

    public String getTushufenlei() {
        return tushufenlei;
    }

    public void setTushufenlei(String tushufenlei) {
        this.tushufenlei = tushufenlei;
    }

    public String getTushujia() {
        return tushujia;
    }

    public void setTushujia(String tushujia) {
        this.tushujia = tushujia;
    }

    public String getTupian() {
        return tupian;
    }

    public void setTupian(String tupian) {
        this.tupian = tupian;
    }

    public String getShipin() {
        return shipin;
    }

    public void setShipin(String shipin) {
        this.shipin = shipin;
    }

    public String getZuozhe() {
        return zuozhe;
    }

    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe;
    }

    public String getChubanshe() {
        return chubanshe;
    }

    public void setChubanshe(String chubanshe) {
        this.chubanshe = chubanshe;
    }

    public Double getJieyueyupeijin() {
        return jieyueyupeijin;
    }

    public void setJieyueyupeijin(Double jieyueyupeijin) {
        this.jieyueyupeijin = jieyueyupeijin;
    }

    public Double getMeitianjiage() {
        return meitianjiage;
    }

    public void setMeitianjiage(Double meitianjiage) {
        this.meitianjiage = meitianjiage;
    }

    public Integer getJieyuecishu() {
        return jieyuecishu;
    }

    public void setJieyuecishu(Integer jieyuecishu) {
        this.jieyuecishu = jieyuecishu;
    }

    public String getFaburen() {
        return faburen;
    }

    public void setFaburen(String faburen) {
        this.faburen = faburen;
    }

    public String getTushuzhuangtai() {
        return tushuzhuangtai;
    }

    public void setTushuzhuangtai(String tushuzhuangtai) {
        this.tushuzhuangtai = tushuzhuangtai;
    }

    public String getTushuxiangqing() {
        return tushuxiangqing;
    }

    public void setTushuxiangqing(String tushuxiangqing) {
        this.tushuxiangqing = tushuxiangqing;
    }

    public String getIssh() {
        return issh;
    }

    public void setIssh(String issh) {
        this.issh = issh;
    }
}
