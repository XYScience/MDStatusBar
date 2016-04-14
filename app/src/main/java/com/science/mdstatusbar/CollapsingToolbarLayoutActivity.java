package com.science.mdstatusbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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

        MDStatusBarCompat.setCollapsingToolbar(this, mCoordinatorLayout, mAppBarLayout, mImageView, mToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
