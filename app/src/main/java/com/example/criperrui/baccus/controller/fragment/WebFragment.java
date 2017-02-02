package com.example.criperrui.baccus.controller.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.criperrui.baccus.R;
import com.example.criperrui.baccus.model.Wine;

/**
 * Created by criperrui on 23/03/2016.
 */
public class WebFragment extends android.support.v4.app.Fragment{
    public static final String ARG_WINE = "biz.agbo.baccus.controller.fragment.WebFragment.EXTRA_WINE";

    private static final String STATE_URL = "url";

    // Modelo
    private Wine mWine = null;

    // Vistas
    private WebView mBrowser = null;
    private ProgressBar mLoading = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_web, container, false);

        mWine = (Wine) getArguments().getSerializable(ARG_WINE);

        // Asocio vista y controlador
        mBrowser = (WebView)root.findViewById(R.id.browser);
        mLoading = (ProgressBar)root.findViewById(R.id.loading);

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

        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(STATE_URL, mBrowser.getUrl());
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_web, menu);

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
}
