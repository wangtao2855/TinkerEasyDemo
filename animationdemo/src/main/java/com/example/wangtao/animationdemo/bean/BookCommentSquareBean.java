package com.example.wangtao.animationdemo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtao on 2018/5/9.
 */

public class BookCommentSquareBean {


    /**
     * code : 200
     * msg : ok
     * data : [{"logo":"http://test.img1.didiyd.com/user_logo/0/11/11_cg.jpg","nickname":"界王神大人","message":"好看","dateline":"2018-04-19 13:33","title":"她唇之下","imagefname":"http://test.img1.didiyd.com/book/0/1889/11889_lp.jpg","articleid":"11889","postcount":"5","pid":"169869","like_num":"2","grade":"3.3","is_like":"0","replyNum":"0","money":"0"},{"logo":"http://test.img1.didiyd.com/user_logo/0/35/35_bd.jpg","nickname":"我爱王漂亮👵🏻","message":"最后一条","dateline":"2018-02-24 15:20","title":"赌石之王","imagefname":"http://test.img1.didiyd.com/book/0/364/10364_nw.jpg","articleid":"10364","postcount":"58","pid":"169757","like_num":"1","grade":"0","is_like":"0","replyNum":"1","money":"0"},{"logo":"http://test.img1.didiyd.com/images/photonone.jpg","nickname":"哈哈","message":"233334**","dateline":"2018-04-11 14:53","title":"血棺","imagefname":"http://test.img1.didiyd.com/book/0/43/10043_dn.jpg","articleid":"10043","postcount":"14","pid":"169838","like_num":"1","grade":"5","is_like":"0","replyNum":"0","money":"0"},{"logo":"http://test.img1.didiyd.com/user_logo/0/3/3_mt.jpg","nickname":"123","message":"123123","dateline":"2018-04-13 11:17","title":"鬼夫如玉","imagefname":"http://test.img1.didiyd.com/book/0/1683/11683_ru.jpg","articleid":"11683","postcount":"1","pid":"169842","like_num":"1","grade":"0","is_like":"0","replyNum":"5","money":"0"},{"logo":"http://test.img1.didiyd.com/images/photonone.jpg","nickname":"kanguolaohu001","message":"好看，哈哈","dateline":"2018-04-19 13:42","title":"她唇之下","imagefname":"http://test.img1.didiyd.com/book/0/1889/11889_lp.jpg","articleid":"11889","postcount":"5","pid":"169870","like_num":"1","grade":"3.3","is_like":"0","replyNum":"0","money":"0"},{"logo":"http://test.img1.didiyd.com/user_logo/0/11/11_cg.jpg","nickname":"界王神大人","message":"你好啊","dateline":"2018-04-20 15:31","title":"我的老千生涯","imagefname":"http://test.img1.didiyd.com/book/0/1138/11138_lx.jpg","articleid":"11138","postcount":"2","pid":"169879","like_num":"1","grade":"1","is_like":"0","replyNum":"5","money":"0"},{"logo":"http://test.img1.didiyd.com/user_logo/0/3/3_mt.jpg","nickname":"123","message":"31313","dateline":"2018-04-28 16:17","title":"蛇王冥妻","imagefname":"http://test.img1.didiyd.com/book/0/1985/11985_bn.jpg","articleid":"11985","postcount":"1","pid":"169940","like_num":"1","grade":"0","is_like":"0","replyNum":"0","money":"0"},{"logo":"http://test.img1.didiyd.com/user_logo/0/35/35_bd.jpg","nickname":"我爱王漂亮👵🏻","message":"5","dateline":"2018-02-24 15:13","title":"赌石之王","imagefname":"http://test.img1.didiyd.com/book/0/364/10364_nw.jpg","articleid":"10364","postcount":"58","pid":"169728","like_num":"0","grade":"0","is_like":"0","replyNum":"0","money":"0"},{"logo":"http://test.img1.didiyd.com/user_logo/0/35/35_bd.jpg","nickname":"我爱王漂亮👵🏻","message":"5","dateline":"2018-02-24 15:13","title":"赌石之王","imagefname":"http://test.img1.didiyd.com/book/0/364/10364_nw.jpg","articleid":"10364","postcount":"58","pid":"169729","like_num":"0","grade":"0","is_like":"0","replyNum":"0","money":"0"},{"logo":"http://test.img1.didiyd.com/user_logo/0/35/35_bd.jpg","nickname":"我爱王漂亮👵🏻","message":"5","dateline":"2018-02-24 15:13","title":"赌石之王","imagefname":"http://test.img1.didiyd.com/book/0/364/10364_nw.jpg","articleid":"10364","postcount":"58","pid":"169730","like_num":"0","grade":"0","is_like":"0","replyNum":"0","money":"0"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        if (data == null) {
            return new ArrayList<>();
        }
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * logo : http://test.img1.didiyd.com/user_logo/0/11/11_cg.jpg
         * nickname : 界王神大人
         * message : 好看
         * dateline : 2018-04-19 13:33
         * title : 她唇之下
         * imagefname : http://test.img1.didiyd.com/book/0/1889/11889_lp.jpg
         * articleid : 11889
         * postcount : 5
         * pid : 169869
         * like_num : 2
         * grade : 3.3
         * is_like : 0
         * replyNum : 0
         * money : 0
         */

        private String logo;
        private String nickname;
        private String message;
        private String dateline;
        private String title;
        private String imagefname;
        private String articleid;
        private String postcount;
        private String pid;
        private String like_num;
        private String grade;
        private String is_like;
        private String replyNum;
        private String money;
        private String author;
        private String vip_level;
        private String level;
        private String is_svip = "0";

        public String getIs_svip() {
            return is_svip == null ? "0" : is_svip;
        }

        public void setIs_svip(String is_svip) {
            this.is_svip = is_svip;
        }

        public String getLevel() {
            return level == null ? "" : level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getAuthor() {
            return author == null ? "" : author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getLogo() {
            return logo == null ? "" : logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getNickname() {
            return nickname == null ? "" : nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMessage() {
            return message == null ? "" : message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDateline() {
            return dateline == null ? "" : dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getTitle() {
            return title == null ? "" : title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImagefname() {
            return imagefname == null ? "" : imagefname;
        }

        public void setImagefname(String imagefname) {
            this.imagefname = imagefname;
        }

        public String getArticleid() {
            return articleid == null ? "" : articleid;
        }

        public void setArticleid(String articleid) {
            this.articleid = articleid;
        }

        public String getPostcount() {
            return postcount == null ? "" : postcount;
        }

        public void setPostcount(String postcount) {
            this.postcount = postcount;
        }

        public String getPid() {
            return pid == null ? "" : pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getLike_num() {
            return like_num == null ? "" : like_num;
        }

        public void setLike_num(String like_num) {
            this.like_num = like_num;
        }

        public String getGrade() {
            return grade == null ? "" : grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getIs_like() {
            return is_like == null ? "" : is_like;
        }

        public void setIs_like(String is_like) {
            this.is_like = is_like;
        }

        public String getReplyNum() {
            return replyNum == null ? "" : replyNum;
        }

        public void setReplyNum(String replyNum) {
            this.replyNum = replyNum;
        }

        public String getMoney() {
            return money == null ? "" : money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getVip_level() {
            return vip_level == null ? "" : vip_level;
        }

        public void setVip_level(String vip_level) {
            this.vip_level = vip_level;
        }


    }
}
