package com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.model;

import com.example.k3vn19.paq.utils.database.AlarmEntity;

import java.util.ArrayList;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * Purpose - This is the model for DetailedAlarm. This class will get information for the AlarmEntity
 *           that is being accessed.
 *
 *  TODO - connect this to a database
 */

public class DetailedAlarmModel {

    private ArrayList<AlarmEntity> alarmEntityArrayList;

    //Currently using dumby values
    public  DetailedAlarmModel(){
        alarmEntityArrayList = new ArrayList<AlarmEntity>();
        AlarmEntity alarm = new AlarmEntity("time", "data");
        alarmEntityArrayList.add(alarm);
    }

    public ArrayList<AlarmEntity> getAlarmEntityArrayList(){return alarmEntityArrayList; }
}
