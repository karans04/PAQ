package com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.AlarmsMainListener;
import com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.model.AlarmsMainModel;
import com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.view.AlarmsMainView;
import com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.view.AlarmsMainViewInterface;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * Purpose - Controller for AlarmsMain. Provides logic for switching between list of alarms and
 *           individual alarm pages.
 */

public class AlarmsMainFragment extends Fragment implements AlarmsMainViewInterface.AlarmsMainViewListener{

    private AlarmsMainView mView;
    private AlarmsMainModel mModel;
    private AlarmsMainListener mListener;

    //Flag is true when AlarmsMainFragment is shown
    private boolean isScreenShow = false;

    public void setupFragment(AlarmsMainListener listner){
        mModel = new AlarmsMainModel();
        this.mListener = listner;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        mView = new AlarmsMainView(inflater, container, this);
        this.setAlarmsToListView();

        return mView.getRootView();
    }

    /**
     * Purpose - Get list of alarms from model.
     *
     * TODO - get alarms from database
     */
    private void setAlarmsToListView(){
        mView.setUpListView(mModel.getAlarmsEntityList());
    }

    @Override
    public void listTap(int i){
        mListener.moveToDetailFragment(mModel.getAlarmsEntityList().get(i));
    }

    public void setIsScreenShow(boolean isScreenShow){
        this.isScreenShow = isScreenShow;
    }

} //end of class
