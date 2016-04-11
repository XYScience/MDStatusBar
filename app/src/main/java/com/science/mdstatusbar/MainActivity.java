package com.science.mdstatusbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Button mOrdinaryToolBar, mImageNoTransparent, mImageTransparent,
            mToolbarTabLayout, mDrawerToolbarTabLayout, mCollapsingCoolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            ViewGroup contentLayout = (ViewGroup) findViewById(android.R.id.content);
            contentLayout.getChildAt(0).setFitsSystemWindows(false);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initView();
    }

    private void initView() {
        mOrdinaryToolBar = (Button) findViewById(R.id.ordinary_toolBar);
        mImageNoTransparent = (Button) findViewById(R.id.image_transparent);
        mImageTransparent = (Button) findViewById(R.id.image_translucent);
        mToolbarTabLayout = (Button) findViewById(R.id.toolbar_tabLayout);
        mDrawerToolbarTabLayout = (Button) findViewById(R.id.drawer_toolbar_tabLayout);
        mCollapsingCoolbarLayout = (Button) findViewById(R.id.collapsing_toolbarLayout);
        mOrdinaryToolBar.setOnClickListener(this);
        mImageNoTransparent.setOnClickListener(this);
        mImageTransparent.setOnClickListener(this);
        mToolbarTabLayout.setOnClickListener(this);
        mDrawerToolbarTabLayout.setOnClickListener(this);
        mCollapsingCoolbarLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ordinary_toolBar:
                Intent intent1 = new Intent(MainActivity.this, OrdinaryToolBarActivity.class);
                startActivity(intent1);
                break;

            case R.id.image_transparent:
                Intent intent2 = new Intent(MainActivity.this, ImageTransparentActivity.class);
                startActivity(intent2);
                break;

            case R.id.image_translucent:
                Intent intent3 = new Intent(MainActivity.this, ImageTranslucentActivity.class);
                startActivity(intent3);
                break;

            case R.id.toolbar_tabLayout:
                Intent intent4 = new Intent(MainActivity.this, ToolbarTabLayoutActivity.class);
                startActivity(intent4);
                break;

            case R.id.drawer_toolbar_tabLayout:
                Intent intent5 = new Intent(MainActivity.this, DrawerToolbarTabLayoutActivity.class);
                startActivity(intent5);
                break;

            case R.id.collapsing_toolbarLayout:
                Intent intent6 = new Intent(MainActivity.this, CollapsingToolbarLayoutActivity.class);
                startActivity(intent6);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
