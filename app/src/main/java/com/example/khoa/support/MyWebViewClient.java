package com.example.khoa.support;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by ka on 11/25/2015.
 */
public class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().equals("https://www.google.com/?gws_rd=ssl")) {
            // This is my web site, so do not override; let my WebView load the page
            return false;
        }
        return true;
    }
}
