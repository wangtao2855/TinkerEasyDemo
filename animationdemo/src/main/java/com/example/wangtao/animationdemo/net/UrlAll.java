//package com.example.wangtao.animationdemo.net;
//
//import com.example.wangtao.animationdemo.utils.Md5Util;
//import com.lzy.okgo.OkGo;
//
//import java.util.Comparator;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
///**
// * Created by wangtao on 2018/6/6.
// */
//
///**
// * 计算token
// */
//public class UrlAll {
//
//
//    public static String getUrlOne(String url, Map map, String name) {
//        StringBuilder stringBuilder = new StringBuilder();
//        LinkedHashMap<String, List<String>> urlParamsMap = OkGo.get(url).params(map).getParams().urlParamsMap;
//        Map<String, String> mapTree = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        for (Map.Entry<String, List<String>> set : urlParamsMap.entrySet()) {
//            String key = set.getKey();
//            String value = set.getValue().get(0);
//            mapTree.put(key, value);
//        }
//        for (Map.Entry map11 : mapTree.entrySet()) {
//            stringBuilder.append(map11.getValue().toString() + map11.getKey().toString());
//        }
//        stringBuilder.append("huiwendidi");
//        stringBuilder.append(name);
//        String md5 = Md5Util.md5(stringBuilder.toString());
//        return md5;
//    }
//
//}
