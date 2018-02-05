package com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.model.DetailedAlarmModel;
import com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.view.DetailedAlarmInterface;
import com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.view.DetailedAlarmView;
import com.example.k3vn19.paq.utils.database.AlarmEntity;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * Purpose - Controller for DetailedAlarm. This package is for viewing specifics about alarms i.e.
 *           sequence, snooze, and intensity settings. The user will be able to edit alarm parameters
 *           and set alarms.
 */

public class DetailedAlarmFragment extends Fragment implements DetailedAlarmInterface.DetailedAlarmListener{

    private DetailedAlarmModel mModel;
    private DetailedAlarmView mView;


    public void setUpFragment(AlarmEntity alarmEntity){
        mModel = new DetailedAlarmModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle){
        mView = new DetailedAlarmView(inflater, container);
        mView.setListener(this);

        return mView.getRootView();
    }

    @Override
    public void setAlarm(){

    }

    @Override
    public void editAlarm(int index, AlarmEntity alarmEntity) {

    }

    @Override
    public void addAlarm(AlarmEntity alarmEntity) {

    }


}
