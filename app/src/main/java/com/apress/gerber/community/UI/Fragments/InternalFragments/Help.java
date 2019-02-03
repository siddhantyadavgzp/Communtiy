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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.apress.gerber.community.Interface.OnResponseRequest;
import com.apress.gerber.community.R;
import com.apress.gerber.community.Utlity.PHPConstant;
import com.apress.gerber.community.Utlity.RequestHandler;

public class Help extends Fragment implements OnResponseRequest {
    private View viewContainer;
    private WebView webview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewContainer=inflater.inflate(R.layout.i_help,container,false);
//        webview  =viewContainer.findViewById(R.id.webView);
//        webview.setWebViewClient(new WebViewClient());
//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.getSettings().setDomStorageEnabled(true);
//        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
//        webview.loadUrl("http://192.168.43.150/hoodly/test.php?a=roorkee_anime&b=thefuck&c=1");

        return viewContainer;
    }


    @Override
    public boolean response() {
return false;
    }
}
