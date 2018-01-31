package com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.k3vn19.paq.R;
import com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.AlarmsMainViewListAdapter;
import com.example.k3vn19.paq.utils.database.AlarmEntity;

import java.util.ArrayList;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * Purpose - View for AlarmsMain, handles user input.
 */

public class AlarmsMainView implements AlarmsMainViewInterface, AdapterView.OnItemClickListener{

    private View mRootView;

    private ListView listView;

    private AlarmsMainViewListAdapter listViewAdapter;
    private AlarmsMainViewListener mListener;

    //constructor
    public AlarmsMainView(LayoutInflater inflater, ViewGroup container, AlarmsMainViewListener listener){
        mRootView = inflater.inflate(R.layout.view_alarms_list, container, false);
        listViewAdapter = new AlarmsMainViewListAdapter(inflater.getContext());

        this.mListener = listener;
        initialize();
    }

    /**
     * Purpose  Initialize the ListView
     */
    private void initialize(){
        listView = mRootView.findViewById(R.id.alarm_list);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    public void setUpListView(ArrayList<AlarmEntity> data){
        listViewAdapter.setData(data);
    }

    @Override
    public View getRootView(){
        return mRootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        mListener.listTap(i);
    }

} //end of class
