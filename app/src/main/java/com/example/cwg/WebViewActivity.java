package com.example.cwg;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.Request;

public class WebViewActivity extends Activity {

    private String sign, saveSign, mDataUrl, mCurrentUrl, signNotice;
    private WebView mWebView;
    private Map<String, String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Map<String, String> map = new TreeMap<>();
        map.put("cid", "2");
        map.put("timestamp", MD5Utils.getTime());
        map.put("uuid", MD5Utils.getDeviceId(WebViewActivity.this));
        Map<String, String> resultMap = sortMapByKey(map);    //按Key进行排序
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
//            System.out.println("还哈哈哈或"+entry.getKey() + " " + entry.getValue());
            if (!TextUtils.isEmpty(sign)) {
                sign = sign + entry.getValue();
            } else {
                sign = entry.getValue();
            }
        }
        sign = sign + "7689ada01eed324d346996015cb9dbfb";
//        sign = "12" + MD5Utils.getTime() + "12cb0182-ec4e-4ce9-8a38-54248fbc9c18e10adc3949ba59abbe56e057f20f883e";
        mCurrentUrl = "http://devcwg.2cloo.com/user/login?cid=2&sign=" + MD5Utils.encrypt(sign) + "&timestamp=" + MD5Utils.getTime() + "&uuid="+MD5Utils.getDeviceId(WebViewActivity.this);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        //WebView Debug 模式的开启方法 上线的时候需要关闭或者注释掉
//        mWebView.setWebContentsDebuggingEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);                                            // 让浏览器支持用户自定义view
        mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);                  // 提高渲染的优先级
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setFocusableInTouchMode(true);
        mWebView.setFocusable(true);
        WebChromeClient webchromeclient = new WebChromeClient() {
            public boolean onJsAlert(WebView view, String url, String message,
                                     JsResult result) {
                Toast.makeText(WebViewActivity.this, message, Toast.LENGTH_LONG).show();
                result.confirm();
                return true;
            }
        };
        mWebView.setWebChromeClient(webchromeclient);

        //如果不设置WebViewClient，请求会跳转系统浏览器
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //该方法在Build.VERSION_CODES.LOLLIPOP以前有效，从Build.VERSION_CODES.LOLLIPOP起，建议使用shouldOverrideUrlLoading(WebView, WebResourceRequest)} instead
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242
                System.out.println("shouldOverrideUrlLoading---url" + url);

                if (url.toString().contains("cwg://close")) {
                    finish();
                    return true;
                } else if (url.toString().contains("cwg://payorder")) {
                    String cid = Uri.parse(url).getQueryParameter("cid");
                    String signURL = Uri.parse(url).getQueryParameter("sign");
                    String timestamp = Uri.parse(url).getQueryParameter("timestamp");
                    String amount = Uri.parse(url).getQueryParameter("amount");
                    String order_sn = Uri.parse(url).getQueryParameter("order_sn");
                    String backurl = Uri.parse(url).getQueryParameter("backurl");
                    String noticeurl = Uri.parse(url).getQueryParameter("noticeurl");
                    Map<String, String> map = new TreeMap<>();
                    map.put("cid", cid);
                    map.put("timestamp", timestamp);
                    map.put("amount", amount);
                    map.put("order_sn", order_sn);
                    map.put("backurl", backurl);
                    map.put("noticeurl", noticeurl);
                    Map<String, String> resultMap = sortMapByKey(map);    //按Key进行排序
                    for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                        if (!TextUtils.isEmpty(saveSign)) {
                            saveSign = saveSign + entry.getValue();
                        } else {
                            saveSign = entry.getValue();
                        }
                    }
                    saveSign = MD5Utils.encrypt(saveSign + "7689ada01eed324d346996015cb9dbfb");
//                    saveSign = MD5Utils.encrypt(amount + backurl + cid + noticeurl + order_sn + timestamp);
                    //当 App 处理完该支付请求时，通过该地址通知我方订单支付结果
//                    noticeGet(noticeurl);
                    //支付完成/取消后在WebView中跳转到该地址，有则跳转，无则不跳转
                    System.out.println("SaveSign---" + saveSign + "---signURL" + signURL);
                    if (saveSign.equals(signURL)) {
                        Map<String, String> map1 = new TreeMap<>();
                        map1.put("cid", cid);
                        map1.put("timestamp", timestamp);
                        map1.put("order_sn", order_sn);
                        map1.put("txn_no", "11");
                        map1.put("amount", amount);
                        map1.put("state", "1");
                        Map<String, String> resultMap1 = sortMapByKey(map1);    //按Key进行排序
                        for (Map.Entry<String, String> entry : resultMap1.entrySet()) {
                            if (!TextUtils.isEmpty(signNotice)) {
                                signNotice = signNotice + entry.getValue();
                            } else {
                                signNotice = entry.getValue();
                            }
                        }
                        signNotice = MD5Utils.encrypt(signNotice + "7689ada01eed324d346996015cb9dbfb");
//                        signNotice = MD5Utils.encrypt(amount + "12" + order_sn + "1" + timestamp + "11e10adc3949ba59abbe56e057f20f883e");
                        mDataUrl = "http://devcwg.2cloo.com/api/payorder/notice?cid=" + cid + "&sign=" + signNotice + "&timestamp=" + timestamp + "&order_sn=" + order_sn + "&txn_no=11&amount=" + amount + "&state=1";
                        requestGet(mDataUrl, backurl);
                    }
                    return true;
                } else if (url.toString().contains("cwg://login")) {
                    String refer = Uri.parse(url).getQueryParameter("refer");
                    if (!TextUtils.isEmpty(refer)) {
                        mWebView.loadUrl(refer);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), OtherActivity.class);
                        intent.putExtra("flag", "登入界面");
                        startActivity(intent);
                    }
                    return true;
                } else if (url.toString().contains("cwg://pay")) {
                    Intent intent = new Intent(getApplicationContext(), OtherActivity.class);
                    intent.putExtra("flag", "充值`界面");
                    startActivity(intent);
                    return true;
                }

                try {
                    if(url.startsWith("weixin://") || url.startsWith("alipays://") ||
                            url.startsWith("mailto://") || url.startsWith("tel://")
                        //其他自定义的scheme
                            ) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
                    return false;
                }
                return false;
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242
                String url = String.valueOf(request.getUrl());
                if (url.toString().contains("cwg://close")) {
                    finish();
                    return true;
                } else if (url.toString().contains("cwg://payorder")) {
                    String cid = Uri.parse(url).getQueryParameter("cid");
                    String signURL = Uri.parse(url).getQueryParameter("sign");
                    String timestamp = Uri.parse(url).getQueryParameter("timestamp");
                    String amount = Uri.parse(url).getQueryParameter("amount");
                    String order_sn = Uri.parse(url).getQueryParameter("order_sn");
                    String backurl = Uri.parse(url).getQueryParameter("backurl");
                    String noticeurl = Uri.parse(url).getQueryParameter("noticeurl");
                    Map<String, String> map = new TreeMap<>();
                    map.put("cid", cid);
                    map.put("timestamp", timestamp);
                    map.put("amount", amount);
                    map.put("order_sn", order_sn);
                    map.put("backurl", backurl);
                    map.put("noticeurl", noticeurl);
                    Map<String, String> resultMap = sortMapByKey(map);    //按Key进行排序
                    for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                        if (!TextUtils.isEmpty(saveSign)) {
                            saveSign = saveSign + entry.getValue();
                        } else {
                            saveSign = entry.getValue();
                        }
                    }
                    saveSign = MD5Utils.encrypt(saveSign + "7689ada01eed324d346996015cb9dbfb");
//                    saveSign = MD5Utils.encrypt(amount + backurl + cid + noticeurl + order_sn + timestamp);
                    //当 App 处理完该支付请求时，通过该地址通知我方订单支付结果
//                    noticeGet(noticeurl);
                    //支付完成/取消后在WebView中跳转到该地址，有则跳转，无则不跳转
                    System.out.println("SaveSign---" + saveSign + "---signURL" + signURL);
                    if (saveSign.equals(signURL)) {
                        Map<String, String> map1 = new TreeMap<>();
                        map1.put("cid", cid);
                        map1.put("timestamp", timestamp);
                        map1.put("order_sn", order_sn);
                        map1.put("txn_no", "11");
                        map1.put("amount", amount);
                        map1.put("state", "1");
                        Map<String, String> resultMap1 = sortMapByKey(map1);    //按Key进行排序
                        for (Map.Entry<String, String> entry : resultMap1.entrySet()) {
                            if (!TextUtils.isEmpty(signNotice)) {
                                signNotice = signNotice + entry.getValue();
                            } else {
                                signNotice = entry.getValue();
                            }
                        }
                        signNotice = MD5Utils.encrypt(signNotice + "" +
                                "7689ada01eed324d346996015cb9dbfb");
//                        signNotice = MD5Utils.encrypt(amount + "12" + order_sn + "1" + timestamp + "11e10adc3949ba59abbe56e057f20f883e");
                        mDataUrl = "http://devcwg.2cloo.com/api/payorder/notice?cid=" + cid + "&sign=" + signNotice + "&timestamp=" + timestamp + "&order_sn=" + order_sn + "&txn_no=11&amount=" + amount + "&state=1";
                        requestGet(mDataUrl, backurl);
                    }
                    return true;
                } else if (url.toString().contains("cwg://login")) {
                    String refer = Uri.parse(url).getQueryParameter("refer");
                    if (!TextUtils.isEmpty(refer)) {
                        mWebView.loadUrl(refer);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), OtherActivity.class);
                        intent.putExtra("flag", "登入界面");
                        startActivity(intent);
                    }
                    return true;
                } else if (url.toString().contains("cwg://pay")) {
                    Intent intent = new Intent(getApplicationContext(), OtherActivity.class);
                    intent.putExtra("flag", "充值`界面");
                    startActivity(intent);
                    return true;
                }

                try {
                    if(url.startsWith("weixin://") || url.startsWith("alipays://") ||
                            url.startsWith("mailto://") || url.startsWith("tel://")
                        //其他自定义的scheme
                            ) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
                    return false;
                }
                return false;
            }

        });
        System.out.println("mCurrentUrl-----" + mCurrentUrl);
        mWebView.loadUrl(mCurrentUrl);
    }

    private void requestGet(final String url, final String backURl) {

        OkHttpClientManager.getInstance().getAsyn(url, new OkHttpClientManager.StringCallback() {

            @Override
            public void onFailure(Request request, IOException e) {
                //  LogUtils.info("getBookShelf:"+"failure:"+e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.getInt("code");
                    String msg = object.getString("msg");
                    if (code == 1) {
                        if (!TextUtils.isEmpty(backURl)) {
                            mWebView.loadUrl(backURl);
                        } else {
                            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    //比较器类
    public static class MapKeyComparator implements Comparator<String> {
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }else{
            onBackPressed();
            return false;
        }
    }
}