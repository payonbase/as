package com.example.payonbase.myapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;
    private Fragment homeFragment = new HomeFragment();
    private Fragment optionFragment = new OptionFragment();
    private FragmentManager fm;
    private FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar= (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.user,"user"))
                .addItem(new BottomNavigationItem(R.drawable.tree, "tree"))
                .addItem(new BottomNavigationItem(R.drawable.ticket, "ticket"))
                .addItem(new BottomNavigationItem(R.drawable.home, "home"))//依次添加item,分别icon和名称
                .setFirstSelectedPosition(0)//设置默认选择item
                .initialise();//初始化

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0: addFragment(homeFragment);break;
                    case 1: addFragment(optionFragment);break;
                    case 2: addFragment(homeFragment);break;
                    case 3: addFragment(optionFragment);break;
                    default:addFragment(homeFragment);break;
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });

    }

    public void addFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout1, fragment, "tag");
        ft.commit();
    }
}
