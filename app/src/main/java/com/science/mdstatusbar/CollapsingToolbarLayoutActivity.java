package com.science.mdstatusbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @author 幸运Science-陈土燊
 * @description
 * @email chentushen.science@gmail.com,274240671@qq.com
 * @data 2016/4/11
 */
public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    private CoordinatorLayout mCoordinatorLayout;
    private AppBarLayout mAppBarLayout;
    private ImageView mImageView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mImageView = (ImageView) findViewById(R.id.backdrop);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("CollapsingToolbar");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            mCoordinatorLayout.setFitsSystemWindows(false);
            mAppBarLayout.setFitsSystemWindows(false);
            mImageView.setFitsSystemWindows(false);
            mToolbar.setFitsSystemWindows(true);
            CollapsingToolbarLayout.LayoutParams lp = (CollapsingToolbarLayout.LayoutParams) mToolbar.getLayoutParams();
            lp.height = (int) (getStatusBarHeight(this) +
                    getResources().getDimension(R.dimen.abc_action_bar_default_height_material));
            mToolbar.setLayoutParams(lp);
            initKKStatus();
        }
    }

    private View statusBarView;

    private void initKKStatus() {
        ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
        statusBarView = contentView.getChildAt(0);
        //改变颜色时避免重复添加statusBarView
        if (statusBarView != null && statusBarView.getMeasuredHeight() == getStatusBarHeight(this)) {
            statusBarView.setBackgroundColor(Color.parseColor("#33000000"));
            return;
        }
        statusBarView = new View(this);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(this));
        statusBarView.setBackgroundColor(Color.parseColor("#33000000"));
        contentView.addView(statusBarView, lp);
        ViewCompat.setAlpha(statusBarView, 1);

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int maxScroll = appBarLayout.getTotalScrollRange();
                float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
                ViewCompat.setAlpha(statusBarView, percentage);
            }
        });
    }

    private static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
