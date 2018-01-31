package com.example.k3vn19.paq.screen.alarms.screens.alarmsMain.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.k3vn19.paq.R;
import com.example.k3vn19.paq.utils.database.AlarmEntity;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * Purpose - This is the "alarm card" that will display basic info about the alarm.
 */

public class AlarmsMainViewRow extends LinearLayout {

    private TextView time;
    private TextView date;

    public AlarmsMainViewRow(Context context){
        super(context);
        initializeView(context);
    }

    public AlarmsMainViewRow(Context context, AttributeSet set){
        super(context, set);
        initializeView(context);
    }

    public AlarmsMainViewRow(Context context, AttributeSet set, int defStyle){
        super(context, set, defStyle);
        initializeView(context);
    }

    public void initializeView(Context context){
        View.inflate(context, R.layout.customview_alarms_list_view_row, this);

        //values to display on the card
        time = this.findViewById(R.id.alarms_list_row_time);
        date = this.findViewById(R.id.alarms_list_row_date);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
    }

    public void setData(AlarmEntity data){
        time.setText(data.getTime());
        String toSet = "" + data.getDate();
        date.setText(toSet);
    }
}
