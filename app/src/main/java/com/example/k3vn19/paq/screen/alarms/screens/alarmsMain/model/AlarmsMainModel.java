package com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.model;

import com.example.k3vn19.paq.utils.database.AlarmEntity;

import java.util.ArrayList;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * Purpose - Model for AlarmsMain. Currently gets dumby value,
 * TODO - should retrieve info from database.
 */

public class AlarmsMainModel {

    private ArrayList<AlarmEntity> alarmsEntityList;

    public AlarmsMainModel(){
        AlarmEntity dumby = new AlarmEntity("time", "date");
        alarmsEntityList = new ArrayList<>();
        alarmsEntityList.add(dumby);
    }

    public ArrayList<AlarmEntity> getAlarmsEntityList(){
        return alarmsEntityList;
    }
}
