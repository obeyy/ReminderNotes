package com.example.mypc.reminder_notes;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.reminder_notes.Firebase.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mNavTitle;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private NavigationView mNavigationView;
    private View mNavHeader;
    private Toolbar mToolbar;
    private FragmentManager mFragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        this.setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFragmentManager = getSupportFragmentManager();
        Bundle args = new Bundle();
        args.putString("Type", "All");
        Fragment main = new MainFragment();
        main.setArguments(args);
        mFragmentManager.beginTransaction().add(R.id.content_frame, main).commit();
        setupDrawer();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawer() {
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        mNavHeader = mNavigationView.getHeaderView(0);
        mNavTitle = (TextView) mNavHeader.findViewById(R.id.name);

        mNavTitle.setText(mActivityTitle);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    case R.id.nav_anggota:
                        mDrawerLayout.closeDrawers();
                        Toast.makeText(getApplicationContext(), "Showing Anggota", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, AnggotaActivity.class);
                        startActivity(i);
                        break;

                    case R.id.nav_logout:
                        mDrawerLayout.closeDrawers();
                        Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(in);
                        finish();
                        break;

                    case R.id.nav_tanggal:
                        mDrawerLayout.closeDrawers();
                        Toast.makeText(getApplicationContext(), "show tanggal", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, TanggalActivity.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
                return true;
            }

            ;
        });
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    public void reloadView(String type) {
        Bundle args = new Bundle();
        args.putString("Type", type);
        Fragment main = new MainFragment();
        main.setArguments(args);
        mFragmentManager.beginTransaction().replace(R.id.content_frame, main).commit();
    }
}