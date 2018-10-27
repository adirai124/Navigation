package com.example.aditya.navigation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     Toolbar toolbar = findViewById(R.id.toolbar);
     setSupportActionBar(toolbar);
      drawer = findViewById(R.id.drawer_layout);
      NavigationView navigationView = findViewById(R.id.nav_view);
      navigationView.setNavigationItemSelectedListener(this);
      toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
      drawer.addDrawerListener(toggle);
      toggle.syncState();
      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new home_fragment()).commit();
      /*bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                switch (Item.getItemId()){
                    case R.id.camera:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new add_fragment()).commit();
                        break;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new add_fragment()).commit();
                        break;
                    case R.id.photos:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new home_fragment()).commit();
                        break;
                    case R.id.calander:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new calander_fragment()).commit();
                        break;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new settings_fragment()).commit();
                        break;

                }

                return true;
            }

      });*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.add_person_side:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new add_fragment()).commit();
                break;
            case R.id.home_side:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new home_fragment()).commit();
                break;
            case R.id.mail_side:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new mail_fragment()).commit();
                break;
            case R.id.search_side:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new search_fragment()).commit();
                break;
            case R.id.setting_side:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new settings_fragment()).commit();
                break;
            case R.id.share_side:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new share_fragment()).commit();
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

}
