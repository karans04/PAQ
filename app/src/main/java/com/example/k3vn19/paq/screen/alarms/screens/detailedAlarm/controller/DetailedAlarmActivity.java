package com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.model.DetailedAlarmModel;
import com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.view.DetailedAlarmInterface;
import com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.view.DetailedAlarmView;
import com.example.k3vn19.paq.utils.database.AlarmEntity;

/**
 * Created by k3vn19 on 2/5/2018.
 *
 * Purpose - Controller for DetailedAlarm. This package is for viewing specifics about alarms i.e.
 *           sequence, snooze, and intensity settings. The user will be able to edit alarm parameters
 *           and set alarms.
 */

public class DetailedAlarmActivity extends AppCompatActivity implements DetailedAlarmInterface.DetailedAlarmListener {

    private DetailedAlarmModel mModel;
    private DetailedAlarmView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("DetailedAlarmActivity", "onCreate=====================");
        mModel = new DetailedAlarmModel();
        mView = new DetailedAlarmView(LayoutInflater.from(this), null);
        mView.setListener(this);

        setContentView(mView.getRootView());

    }

    @Override
    public void setAlarm(){
        //make call to mModel to update database
    }

    @Override
    public void editAlarm(int index, AlarmEntity alarmEntity) {
        //make call to mModel to update database
    }

    @Override
    public void addAlarm(AlarmEntity alarmEntity) {
        //make call to mModel to update database
    }
}
