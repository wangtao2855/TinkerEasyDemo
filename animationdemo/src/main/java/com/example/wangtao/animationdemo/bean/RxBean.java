package com.example.wangtao.animationdemo.bean;

import java.util.List;

/**
 * Created by wangtao on 2018/6/5.
 */

public class RxBean {


    /**
     * code : 200
     * msg : ok
     * data : [{"id":"135","title":"2018.05星钻榜获奖名单新鲜出炉","description":"暗夜文学网2018.05星钻榜获奖榜单新鲜出炉，分为男频和女频榜单，获奖作品是VIP作品5月份星钻榜前5名，所得奖励将随稿费一同发放。","image":"http://img1.anyew.cn/zt/activitytype1_15280878750.jpg","status":"1","link":"http://m.anyew.cn/starrank/4/app/activity/rewardDial","addtime":"1528090170","type":"1","viewnum":"11人浏览","displayorder":"1","endtime":"0"},{"id":"132","title":"来和暗夜君聊聊天","description":"为了给您提供更好的服务，希望您能抽出几分钟时间，将您的感受和建议告诉我们，我们非常重视每位用户的宝贵意见！添加暗夜书友QQ友群：632250024，还有很多福利优先在群里发布，快来哦！","image":"http://img1.anyew.cn/zt/activitytype1_15264402580.jpg","status":"1","link":"https://wj.qq.com/s/2101250/7d78","addtime":"1526708480","type":"1","viewnum":"141人浏览","displayorder":"2","endtime":"0"},{"id":"111","title":"邀请好友，书券免费领！","description":"支持2.1.8及以上版本。参加活动必须先登录，否则领不到奖励哦，邀请领红包：200书券/人，多邀多得，最高可获得价值66元额外奖励哦！","image":"http://img1.anyew.cn/zt/activitytype1_15269516800.jpg","status":"1","link":"http://api.anyew.cn/activity/invite","addtime":"1526951680","type":"1","viewnum":"7524人浏览","displayorder":"3","endtime":"0"},{"id":"118","title":"读者专访：《蛇妻美人》读者--墨笔甜心","description":"墨笔甜心，神壕读者，一掷千金","image":"http://img1.anyew.cn/zt/activitytype2_15157494260.jpg","status":"1","link":"http://m.anyew.cn/hallfame/5/app/activity/rewardDial","addtime":"1515749426","type":"2","viewnum":"318人浏览","displayorder":"1","endtime":"0"},{"id":"120","title":"读者专访：《天命》读者--一身污浊自得其乐","description":"一身污浊自得其乐，神壕读者，一掷千金","image":"http://img1.anyew.cn/zt/activity_42839.jpg","status":"1","link":"http://m.anyew.cn/hallfame/3/app/activity/rewardDial","addtime":"1514256144","type":"2","viewnum":"202人浏览","displayorder":"1","endtime":"0"},{"id":"127","title":"花未眠","description":"曾有千万字写作经验，数十本作品，实力大神。擅长古言，总裁婚恋，第一次转型新媒体文，情感就如此丰富，令读者欲罢不能。代表作：《夜色未央》","image":"http://img1.anyew.cn/zt/activitytype2_15163549020.jpg","status":"1","link":"http://m.anyew.cn/hallfame/2/app/activity/rewardDial","addtime":"1516354902","type":"2","viewnum":"256人浏览","displayorder":"1","endtime":"0"}]
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
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 135
         * title : 2018.05星钻榜获奖名单新鲜出炉
         * description : 暗夜文学网2018.05星钻榜获奖榜单新鲜出炉，分为男频和女频榜单，获奖作品是VIP作品5月份星钻榜前5名，所得奖励将随稿费一同发放。
         * image : http://img1.anyew.cn/zt/activitytype1_15280878750.jpg
         * status : 1
         * link : http://m.anyew.cn/starrank/4/app/activity/rewardDial
         * addtime : 1528090170
         * type : 1
         * viewnum : 11人浏览
         * displayorder : 1
         * endtime : 0
         */

        private String id;
        private String title;
        private String description;
        private String image;
        private String status;
        private String link;
        private String addtime;
        private String type;
        private String viewnum;
        private String displayorder;
        private String endtime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getViewnum() {
            return viewnum;
        }

        public void setViewnum(String viewnum) {
            this.viewnum = viewnum;
        }

        public String getDisplayorder() {
            return displayorder;
        }

        public void setDisplayorder(String displayorder) {
            this.displayorder = displayorder;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }
    }
}
