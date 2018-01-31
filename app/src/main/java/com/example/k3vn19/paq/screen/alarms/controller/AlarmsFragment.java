package com.example.k3vn19.paq.screen.alarms.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.AlarmsMainListener;
import com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.controller.AlarmsMainFragment;
import com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.controller.DetailedAlarmFragment;
import com.example.k3vn19.paq.screen.alarms.view.AlarmsView;
import com.example.k3vn19.paq.utils.database.AlarmEntity;

/**
 * Created by k3vn19 on 1/29/2018.
 *
 * Controller for Alarms.
 */

public class AlarmsFragment extends Fragment implements AlarmsMainListener{

    AlarmsView mView;
    AlarmsMainFragment alarmsMainFragment;
    DetailedAlarmFragment detailedAlarmFragment;

    //This flag is true when this screen is shown
    private boolean isScreenShow = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceBundle){

        mView = new AlarmsView(inflater, container);

        //set initial fragment
        alarmsMainFragment = new AlarmsMainFragment();
        alarmsMainFragment.setupFragment(this);
        mView.changeContent(getChildFragmentManager(), alarmsMainFragment, false);

        return mView.getRootView();
    }

    /**
     * This method handles whether this screen is going to be displayed or not
     *
     */
    public void isScreenShow(boolean isScreenShow) {
        this.isScreenShow = isScreenShow;
        if(alarmsMainFragment != null) {
            alarmsMainFragment.setIsScreenShow(isScreenShow);
        }
    }


    /**
     * Purpose - move from main to detail fragment
     * @param data - AlarmEntity to be passed into Detailed Fragment.
     */
    public void moveToDetailFragment(AlarmEntity data){
        Log.d("AlarmsFragment", "==============moveToDetailFragment============");
        detailedAlarmFragment = new DetailedAlarmFragment();
        //detailedAlarmFragment.setUpFragment(data, this, true);
        mView.changeContent(getChildFragmentManager(), detailedAlarmFragment, true);
    }


} //end of class
