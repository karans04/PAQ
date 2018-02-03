package com.example.k3vn19.paq.screen.main.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.k3vn19.paq.R;
import com.example.k3vn19.paq.common.Enums;
import com.example.k3vn19.paq.screen.alarms.controller.AlarmsFragment;
import com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.controller.DetailedAlarmActivity;
import com.example.k3vn19.paq.screen.main.model.MainModel;
import com.example.k3vn19.paq.screen.main.view.MainView;
import com.example.k3vn19.paq.screen.main.view.MainViewInterface;
import com.example.k3vn19.paq.screen.stopwatch.StopwatchFragment;
import com.example.k3vn19.paq.screen.timer.TimerFragment;
import com.example.k3vn19.paq.screen.worldclock.WorldClockFragment;

/**
 * Created by k3vn19 on 1/29/2018.
 *
 * Controller for Main Page
 */

public class MainActivity extends AppCompatActivity implements MainViewInterface.MainViewListener{

    private AlarmsFragment alarmsFragment;
    private WorldClockFragment worldClockFragment;
    private StopwatchFragment stopwatchFragment;
    private TimerFragment timerFragment;

    private Enums.TabPosition currentTabPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "onCreate()-before tabs=================");

        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate()- model=================");


        MainModel mModel;
        mModel = new MainModel();
        MainView mView = new MainView(LayoutInflater.from(this), null, this);

        Log.d("MainActivity", "onCreate() fragment[] =================");

        Fragment[] fragments = new Fragment[4];
        alarmsFragment = new AlarmsFragment();
        worldClockFragment = new WorldClockFragment();
        stopwatchFragment = new StopwatchFragment();
        timerFragment = new TimerFragment();

        Log.d("MainActivity", "onCreate()-after fragment[]=================");

        fragments[Enums.TabPosition.ALARMS.getVal()] = alarmsFragment;
        fragments[Enums.TabPosition.WORLDCLOCK.getVal()] = stopwatchFragment;
        fragments[Enums.TabPosition.STOPWATCH.getVal()] = stopwatchFragment;
        fragments[Enums.TabPosition.TIMER.getVal()] = timerFragment;

        Log.d("MainActivity", "onCreate()-setup tabs=================");

        mView.setUpTabs(fragments, mModel.tabTitles,0,getSupportFragmentManager());
        currentTabPosition = Enums.TabPosition.ALARMS;
        setContentView(mView.getRootView());

        Log.d("MainActivity", "onCreate()-after tabs=================");

        invalidateOptionsMenu(); //bug somewhere here
        setSupportActionBar(mView.getToolbar());
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        mView.setToolbarTitle(getString(R.string.app_name));

        Log.d("MainActivity", "onCreate() - complete=================");

    }

    /*
    private void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }
    private void goToMain() {
        startActivity(new Intent(this, MainActivity.class));
    }
    private void goToSignup() {
        startActivity(new Intent(this, SignupActivity.class));
    }
    */

    @Override
    public void tabChanged(Enums.TabPosition position) {

        currentTabPosition = position;

        /*
        if(position == Enums.TabPosition.ALARMS) {
            alarmsFragment.isScreenShow(true);
            worldClockFragment.isScreenShow(false);
            stopwatchFragment.isScreeenShow(false);
            timerFragment.isScreenShow(false);

        } else if(position == Enums.TabPosition.WORLDCLOCK) {
            alarmsFragment.isScreenShow(false);
            worldClockFragment.isScreenShow(true);
            stopwatchFragment.isScreeenShow(false);
            timerFragment.isScreenShow(false);

        } else if(position == Enums.TabPosition.STOPWATCH) {
            alarmsFragment.isScreenShow(false);
            worldClockFragment.isScreenShow(false);
            stopwatchFragment.isScreeenShow(true);
            timerFragment.isScreenShow(false);

        } else if(position == Enums.TabPosition.TIMER) {
            alarmsFragment.isScreenShow(false);
            worldClockFragment.isScreenShow(false);
            stopwatchFragment.isScreeenShow(false);
            timerFragment.isScreenShow(true);
        }
         */
    }

    @Override
    public void onBackPressed() {
        Fragment fragment;

        if(currentTabPosition == Enums.TabPosition.ALARMS) {
            fragment = alarmsFragment;
        } else if(currentTabPosition == Enums.TabPosition.WORLDCLOCK){
            fragment = worldClockFragment;
        } else if(currentTabPosition == Enums.TabPosition.STOPWATCH){
            fragment = stopwatchFragment;
        } else{
            fragment = timerFragment;
        }

        if(fragment.getChildFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            fragment.getChildFragmentManager().popBackStack();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Fragment fragment = null;

        switch(id) {
            case R.id.add_alarm_icon:
                Intent detailedAlarmActivity = new Intent(MainActivity.this, DetailedAlarmActivity.class);
                startActivity(detailedAlarmActivity);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}//end of class
