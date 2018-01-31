package com.example.k3vn19.paq.screen.alarms.screens.alarmsMain;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.view.AlarmsMainViewRow;
import com.example.k3vn19.paq.utils.database.AlarmEntity;

import java.util.ArrayList;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * Purpose - Adapter for AlarmsMain.
 */

public class AlarmsMainViewListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<AlarmEntity> data = new ArrayList<>();

    public AlarmsMainViewListAdapter(Context context){this.context = context;}

    public void setData(ArrayList<AlarmEntity> data){
        this.data = data;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount(){ return data.size();}

    @Override
    public Object getItem(int i){return data.get(i);}

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup group){
        if(view == null){
            AlarmsMainViewRow row = new AlarmsMainViewRow(context);
            row.setData(data.get(i));
            return row;
        }
        else{
            ((AlarmsMainViewRow)view).setData(data.get(i));
            return view;
        }
    }
}
