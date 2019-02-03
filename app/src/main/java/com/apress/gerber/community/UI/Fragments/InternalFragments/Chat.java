package com.apress.gerber.community.UI.Fragments.InternalFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.apress.gerber.community.Interface.OnResponseRequest;
import com.apress.gerber.community.R;

public class Chat extends Fragment  {
    private View viewContainer;
    private WebView webview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContainer = inflater.inflate(R.layout.i_chat, container, false);
        webview = viewContainer.findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview.loadUrl("http://192.168.43.150/hoodly/mchat.php?a=roorkee_anime&b=siddhant");

        return viewContainer;
    }
}

