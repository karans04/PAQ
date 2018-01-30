package com.example.k3vn19.paq.screen.main.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.k3vn19.paq.R;
import com.example.k3vn19.paq.common.ContextManager;
import com.example.k3vn19.paq.common.Enums;
import com.example.k3vn19.paq.screen.main.MainViewPageAdapter;

/**
 * Created by k3vn19 on 1/29/2018.
 *
 * View for Main.
 */

public class MainView implements MainViewInterface, ViewPager.OnPageChangeListener {


    private View mRootView;
    private MainViewInterface.MainViewListener mListener;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private View tabAlarms;
    private View tabWorldClock;
    private View tabStopwatch;
    private View tabTimer;

    public MainView(LayoutInflater inflater, ViewGroup container, MainViewListener listener){
        mRootView = inflater.inflate(R.layout.view_main, container, false);
        this.mListener = listener;

        initialize(inflater);
    }

    private void initialize(LayoutInflater inflater){
        tabLayout = (TabLayout)mRootView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager)mRootView.findViewById(R.id.view_pager);
        toolbar = (Toolbar)mRootView.findViewById(R.id.toolbar);

        tabAlarms = inflater.inflate(R.layout.tab, null);
        tabWorldClock = inflater.inflate(R.layout.tab, null);
        tabStopwatch = inflater.inflate(R.layout.tab, null);
        tabTimer = inflater.inflate(R.layout.tab, null);
    }

    public void setUpTabs(Fragment[] fragments, String[] tabTitles, int defaultIndex, FragmentManager fm) {
        MainViewPageAdapter viewPagerAdapter = new MainViewPageAdapter(fm, fragments, tabTitles);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(ContextCompat.getColor(ContextManager.getInstance().getApplicationContext(),R.color.colorPrimary));

        tabLayout.getTabAt(Enums.TabPosition.ALARMS.getVal()).setCustomView(tabAlarms);
        tabLayout.getTabAt(Enums.TabPosition.WORLDCLOCK.getVal()).setCustomView(tabWorldClock);
        tabLayout.getTabAt(Enums.TabPosition.STOPWATCH.getVal()).setCustomView(tabStopwatch);
        tabLayout.getTabAt(Enums.TabPosition.TIMER.getVal()).setCustomView(tabTimer);

        ((ImageView) tabAlarms.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_controller_icon);
        ((ImageView) tabWorldClock.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_controller_icon);
        ((ImageView) tabStopwatch.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_controller_icon);
        ((ImageView) tabTimer.findViewById(R.id.tab_icon)).setImageResource(R.drawable.tab_controller_icon);

        ((TextView) tabAlarms.findViewById(R.id.tab_textview)).setText(R.string.alarmsText);
        ((TextView) tabWorldClock.findViewById(R.id.tab_textview)).setText(R.string.worldClockText);
        ((TextView) tabStopwatch.findViewById(R.id.tab_textview)).setText(R.string.stopWatchText);
        ((TextView) tabTimer.findViewById(R.id.tab_textview)).setText(R.string.timerText);

        tabLayout.getTabAt(defaultIndex).select();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    public Toolbar getToolbar() {return toolbar;}


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {

        Enums.TabPosition positionEnum = Enums.TabPosition.ALARMS;

        if(position == Enums.TabPosition.ALARMS.getVal()) {
            ((TextView) tabAlarms.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);
            ((TextView) tabWorldClock.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabStopwatch.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabTimer.findViewById(R.id.tab_textview)).setVisibility(View.GONE);

            positionEnum = Enums.TabPosition.ALARMS;

        } else if(position == Enums.TabPosition.WORLDCLOCK.getVal()) {
            ((TextView) tabAlarms.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabWorldClock.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);
            ((TextView) tabStopwatch.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabTimer.findViewById(R.id.tab_textview)).setVisibility(View.GONE);

            positionEnum = Enums.TabPosition.WORLDCLOCK;

        } else if(position == Enums.TabPosition.STOPWATCH.getVal()) {
            ((TextView) tabAlarms.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabWorldClock.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabStopwatch.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);
            ((TextView) tabTimer.findViewById(R.id.tab_textview)).setVisibility(View.GONE);

            positionEnum = Enums.TabPosition.STOPWATCH;

        } else if(position == Enums.TabPosition.TIMER.getVal()) {
            ((TextView) tabAlarms.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabWorldClock.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabStopwatch.findViewById(R.id.tab_textview)).setVisibility(View.GONE);
            ((TextView) tabTimer.findViewById(R.id.tab_textview)).setVisibility(View.VISIBLE);

            positionEnum = Enums.TabPosition.TIMER;

        }

        mListener.tabChanged(positionEnum);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setToolbarTitle(String title) {
        ((TextView)toolbar.findViewById(R.id.toolbar_title_textview)).setText(title);
    }


} //end of class
