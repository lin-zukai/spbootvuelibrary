package com.spring.entity;

import com.spring.util.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jieyue")
public class Jieyue implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "tushuxinxiid")
    private Integer tushuxinxiid;

    @Column(name = "tushubianhao")
    private String tushubianhao;

    @Column(name = "tushumingcheng")
    private String tushumingcheng;

    @Column(name = "tushufenlei")
    private String tushufenlei;

    @Column(name = "tushujia")
    private String tushujia;

    @Column(name = "meitianjiage")
    private Double meitianjiage;

    @Column(name = "faburen")
    private String faburen;

    @Column(name = "jieyuebianhao")
    private String jieyuebianhao;

    @Column(name = "jieyueshijian")
    private String jieyueshijian;

    @Column(name = "guihuanshijian")
    private String guihuanshijian;

    @Column(name = "jieyuetianshu")
    private Integer jieyuetianshu;

    @Column(name = "jieyuejine")
    private Double jieyuejine;

    @Column(name = "jieyuezhuangtai")
    private String jieyuezhuangtai;

    @Column(name = "jieyueren")
    private String jieyueren;

    private String iszf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getGuihuanCount() {
        return Query.make("guihuan").where("jieyueid", id).count();
    }

    public Integer getTushuxinxiid() {
        return tushuxinxiid;
    }

    public void setTushuxinxiid(Integer tushuxinxiid) {
        this.tushuxinxiid = tushuxinxiid;
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

    public Double getMeitianjiage() {
        return meitianjiage;
    }

    public void setMeitianjiage(Double meitianjiage) {
        this.meitianjiage = meitianjiage;
    }

    public String getFaburen() {
        return faburen;
    }

    public void setFaburen(String faburen) {
        this.faburen = faburen;
    }

    public String getJieyuebianhao() {
        return jieyuebianhao;
    }

    public void setJieyuebianhao(String jieyuebianhao) {
        this.jieyuebianhao = jieyuebianhao;
    }

    public String getJieyueshijian() {
        return jieyueshijian;
    }

    public void setJieyueshijian(String jieyueshijian) {
        this.jieyueshijian = jieyueshijian;
    }

    public String getGuihuanshijian() {
        return guihuanshijian;
    }

    public void setGuihuanshijian(String guihuanshijian) {
        this.guihuanshijian = guihuanshijian;
    }

    public Integer getJieyuetianshu() {
        return jieyuetianshu;
    }

    public void setJieyuetianshu(Integer jieyuetianshu) {
        this.jieyuetianshu = jieyuetianshu;
    }

    public Double getJieyuejine() {
        return jieyuejine;
    }

    public void setJieyuejine(Double jieyuejine) {
        this.jieyuejine = jieyuejine;
    }

    public String getJieyuezhuangtai() {
        return jieyuezhuangtai;
    }

    public void setJieyuezhuangtai(String jieyuezhuangtai) {
        this.jieyuezhuangtai = jieyuezhuangtai;
    }

    public String getJieyueren() {
        return jieyueren;
    }

    public void setJieyueren(String jieyueren) {
        this.jieyueren = jieyueren;
    }

    public String getIszf() {
        return iszf;
    }

    public void setIszf(String iszf) {
        this.iszf = iszf;
    }
}
