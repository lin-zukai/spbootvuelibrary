package com.spring.entity;

import com.spring.util.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "guihuan")
public class Guihuan implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "jieyueid")
    private Integer jieyueid;

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

    @Column(name = "faburen")
    private String faburen;

    @Column(name = "jieyueren")
    private String jieyueren;

    @Column(name = "shijiguihuanshijian")
    private String shijiguihuanshijian;

    @Column(name = "beizhu")
    private String beizhu;

    @Column(name = "huanshuren")
    private String huanshuren;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJieyueid() {
        return jieyueid;
    }

    public void setJieyueid(Integer jieyueid) {
        this.jieyueid = jieyueid;
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

    public String getFaburen() {
        return faburen;
    }

    public void setFaburen(String faburen) {
        this.faburen = faburen;
    }

    public String getJieyueren() {
        return jieyueren;
    }

    public void setJieyueren(String jieyueren) {
        this.jieyueren = jieyueren;
    }

    public String getShijiguihuanshijian() {
        return shijiguihuanshijian;
    }

    public void setShijiguihuanshijian(String shijiguihuanshijian) {
        this.shijiguihuanshijian = shijiguihuanshijian;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getHuanshuren() {
        return huanshuren;
    }

    public void setHuanshuren(String huanshuren) {
        this.huanshuren = huanshuren;
    }
}
