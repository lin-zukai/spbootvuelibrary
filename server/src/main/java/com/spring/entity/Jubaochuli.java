package com.spring.entity;

import com.spring.util.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jubaochuli")
public class Jubaochuli implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "jubaoid")
    private Integer jubaoid;

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

    @Column(name = "jubaoren")
    private String jubaoren;

    @Column(name = "chulibeizhu")
    private String chulibeizhu;

    @Column(name = "chuliren")
    private String chuliren;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJubaoid() {
        return jubaoid;
    }

    public void setJubaoid(Integer jubaoid) {
        this.jubaoid = jubaoid;
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

    public String getJubaoren() {
        return jubaoren;
    }

    public void setJubaoren(String jubaoren) {
        this.jubaoren = jubaoren;
    }

    public String getChulibeizhu() {
        return chulibeizhu;
    }

    public void setChulibeizhu(String chulibeizhu) {
        this.chulibeizhu = chulibeizhu;
    }

    public String getChuliren() {
        return chuliren;
    }

    public void setChuliren(String chuliren) {
        this.chuliren = chuliren;
    }
}
