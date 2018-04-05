package com.example.suman.i_remotedemo.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.fragments.ContentFragment;
import com.example.suman.i_remotedemo.fragments.HomeFragment;
import com.example.suman.i_remotedemo.fragments.OnHandItemsFragment;
import com.example.suman.i_remotedemo.fragments.WarehouseInventoryFragment;
import com.example.suman.i_remotedemo.utils.Preferences;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static Fragment mFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        SharedPreferences preferences = getSharedPreferences(Preferences.preferenceName, MODE_PRIVATE);
        if (!preferences.getBoolean(Preferences.loggedIn, false)) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (mFragment == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.frame_layout, mFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //if (mFragment == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.frame_layout, mFragment);
            fragmentTransaction.commit();
        //}
    }

    @Override
    protected void onResume() {
        super.onResume();
        //if (mFragment == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.frame_layout, mFragment);
            fragmentTransaction.commit();
        //}
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

    @Override
    protected void onPause() {
        super.onPause();
        /*if (isFinishing()) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().remove(mFragment).commit();
        }*/
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.frame_layout, mFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_on_hand_items) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mFragment = new OnHandItemsFragment();
            fragmentTransaction.replace(R.id.frame_layout, mFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_warehouse_inventory) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mFragment = new WarehouseInventoryFragment();
            fragmentTransaction.replace(R.id.frame_layout, mFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_order_status) {

        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        } else if(id == R.id.nav_help){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
