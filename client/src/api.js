import http from "@/utils/ajax/http";
import { extend } from "@/utils/extend";

const api = {
    code: {
        OK: 0,
    },
    user: {
        login: "authLogin.do?ac=login",
        tokenLogin: "tokenLogin.do",
        logout: "logout.do",
    },
    checkUpdate: "sh.do",
    editorPassword: "editPassword",
    checkField: "checkno.do",
    dbQuery: "/db/query",
    dbSelect: "/db/select",

    payment: "payment.do",

    captch() {
        var url = "captcha.do?rd=" + Math.floor(Math.random() * 100000);
        return new Promise((resolve, reject) => {
            http.get(url).then((res) => {
                var url = res.data;
                resolve(url);
            }, reject);
        });
    },
    search: {
        select: "selectUpdateSearch.do",
        table: "tableAjax.do?a=table",
        selectView: "selectView.do",
        all: "selectAll.do",
    },
    attachment: {
        uploadUrl: "upload_re.do",
        upload(file) {
            return new Promise((resolve, reject) => {
                var formdata = new FormData();
                formdata.append("fujian", file, file.name || "tmp.png");
                http.post(api.attachment.uploadUrl, formdata)
                    .then((res) => {
                        if (res.code == api.code.OK) {
                            resolve(res.data);
                        } else {
                            reject(res.msg);
                        }
                    })
                    .catch((err) => {
                        reject(err.message);
                    });
            });
        },
    },
    admins: {
        list: "admins_list.do",
        insert: "adminsinsert.do",
        update: "adminsupdate.do",
        delete: "admins_delete.do",
        detail: "admins_detail.do",
        create: "admins_add.do",
        edit: "admins_updt.do",
    },
    yonghu: {
        list: "yonghu_list.do",
        insert: "yonghuinsert.do",
        update: "yonghuupdate.do",
        delete: "yonghu_delete.do",
        detail: "yonghu_detail.do",
        create: "yonghu_add.do",
        edit: "yonghu_updt.do",
    },
    liuyanban: {
        list: "liuyanban_list.do",
        insert: "liuyanbaninsert.do",
        update: "liuyanbanupdate.do",
        delete: "liuyanban_delete.do",
        detail: "liuyanban_detail.do",
        create: "liuyanban_add.do",
        edit: "liuyanban_updt.do",
        listliuyanren: "liuyanban_list_liuyanren.do",
    },
    lunbotu: {
        list: "lunbotu_list.do",
        insert: "lunbotuinsert.do",
        update: "lunbotuupdate.do",
        delete: "lunbotu_delete.do",
        detail: "lunbotu_detail.do",
        create: "lunbotu_add.do",
        edit: "lunbotu_updt.do",
    },
    tushufenlei: {
        list: "tushufenlei_list.do",
        insert: "tushufenleiinsert.do",
        update: "tushufenleiupdate.do",
        delete: "tushufenlei_delete.do",
        detail: "tushufenlei_detail.do",
        create: "tushufenlei_add.do",
        edit: "tushufenlei_updt.do",
    },
    tushuxinxi: {
        list: "tushuxinxi_list.do",
        insert: "tushuxinxiinsert.do",
        update: "tushuxinxiupdate.do",
        delete: "tushuxinxi_delete.do",
        detail: "tushuxinxi_detail.do",
        create: "tushuxinxi_add.do",
        edit: "tushuxinxi_updt.do",
        listfaburen: "tushuxinxi_list_faburen.do",
        weblist: "tushuxinxilist.do",
        webdetail: "tushuxinxidetail.do",
    },
    jieyue: {
        list: "jieyue_list.do",
        insert: "jieyueinsert.do",
        update: "jieyueupdate.do",
        delete: "jieyue_delete.do",
        detail: "jieyue_detail.do",
        create: "jieyue_add.do",
        edit: "jieyue_updt.do",
        listfaburen: "jieyue_list_faburen.do",
        listjieyueren: "jieyue_list_jieyueren.do",
    },
    guihuan: {
        list: "guihuan_list.do",
        insert: "guihuaninsert.do",
        update: "guihuanupdate.do",
        delete: "guihuan_delete.do",
        detail: "guihuan_detail.do",
        create: "guihuan_add.do",
        edit: "guihuan_updt.do",
        listfaburen: "guihuan_list_faburen.do",
        listjieyueren: "guihuan_list_jieyueren.do",
    },
    pinglun: {
        list: "pinglun_list.do",
        insert: "pingluninsert.do",
        update: "pinglunupdate.do",
        delete: "pinglun_delete.do",
        detail: "pinglun_detail.do",
        create: "pinglun_add.do",
        edit: "pinglun_updt.do",
        listpinglunren: "pinglun_list_pinglunren.do",
    },
    jubao: {
        list: "jubao_list.do",
        insert: "jubaoinsert.do",
        update: "jubaoupdate.do",
        delete: "jubao_delete.do",
        detail: "jubao_detail.do",
        create: "jubao_add.do",
        edit: "jubao_updt.do",
        listfaburen: "jubao_list_faburen.do",
        listjubaoren: "jubao_list_jubaoren.do",
    },
    jubaochuli: {
        list: "jubaochuli_list.do",
        insert: "jubaochuliinsert.do",
        update: "jubaochuliupdate.do",
        delete: "jubaochuli_delete.do",
        detail: "jubaochuli_detail.do",
        create: "jubaochuli_add.do",
        edit: "jubaochuli_updt.do",
        listfaburen: "jubaochuli_list_faburen.do",
        listjubaoren: "jubaochuli_list_jubaoren.do",
        listchuliren: "jubaochuli_list_chuliren.do",
    },
    tushuguanliyuan: {
        list: "tushuguanliyuan_list.do",
        insert: "tushuguanliyuaninsert.do",
        update: "tushuguanliyuanupdate.do",
        delete: "tushuguanliyuan_delete.do",
        detail: "tushuguanliyuan_detail.do",
        create: "tushuguanliyuan_add.do",
        edit: "tushuguanliyuan_updt.do",
    },
};

export default api;
