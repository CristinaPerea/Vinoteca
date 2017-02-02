package com.example.criperrui.baccus.controller.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.criperrui.baccus.R;
import com.example.criperrui.baccus.controller.fragment.WebFragment;
import com.example.criperrui.baccus.model.Wine;

/**
 * Created by criperrui on 14/03/2016.
 */

public class WebActivity extends FragmentContainerActivity {

    public static final String EXTRA_WINE = "biz.agbo.baccus.controller.WebActivity.extra_wine";

    @Override
    protected Fragment createFragment() {

        Bundle arguments = new Bundle();
        arguments.putSerializable(WebFragment.ARG_WINE, getIntent().getSerializableExtra(EXTRA_WINE));
        WebFragment fragment = new WebFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

/*public class WebActivity extends AppCompatActivity {

    public static final String EXTRA_WINE = "biz.agbo.baccus.controller.WebActivity.extra_wine";

    private static final String STATE_URL = "url";

    // Modelo
    private Wine mWine = null;

    // Vistas
    private WebView mBrowser = null;
    private ProgressBar mLoading = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_web);

        mWine = (Wine) getIntent().getSerializableExtra(EXTRA_WINE);

        // Asocio vista y controlador
        mBrowser = (WebView) findViewById(R.id.browser);
        mLoading = (ProgressBar) findViewById(R.id.loading);

        // Configuro vistas
        mBrowser.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mLoading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mLoading.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                mLoading.setVisibility(View.GONE);
            }
        });

        mBrowser.getSettings().setJavaScriptEnabled(true);
        mBrowser.getSettings().setBuiltInZoomControls(true);

        // Cargo la página web

        if (savedInstanceState == null || !savedInstanceState.containsKey(STATE_URL)) {
            mBrowser.loadUrl(mWine.getCompanyWeb());
        }
        else {
            mBrowser.loadUrl(savedInstanceState.getString(STATE_URL));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(STATE_URL, mBrowser.getUrl());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_web, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.menu_reload) {
            mBrowser.reload();

            return true;
        }

        return false;
    }
}*/
}
