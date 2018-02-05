package com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.k3vn19.paq.R;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * Purpose - View for DetailedAlarm, handles user input for DetailedAlarm page.
 */

public class DetailedAlarmView implements DetailedAlarmInterface, View.OnClickListener{

    private SeekBar sb_numSnooze;
    private SeekBar sb_snoozeLength;
    private SeekBar sb_intensity;
    private SeekBar sb_seqLength;

    private final int MAXNUMSNOOZE = 3;
    private final int MAXSNOOZELENGTH = 10;
    private final int MAXINTENSITY = 5;
    private final int MAXSEQLENGTH = 7;

    //private final int MINNUMSNOOZE = 0; TODO - set these as the min values for seekbars
    //private final int MINSNOOZELENGTH = 0;
    //private final int MININTENSITY = 1;
    //private final int MINSEQLENGTH = 0;

    private TextView tv_numSnooze;
    private TextView tv_snoozeLength;
    private TextView tv_intensity;
    private TextView tv_seqLength;

    private TimePicker timePicker;


    private TextView cancelButton;

    private View mRootView;
    private DetailedAlarmListener listener;

    public DetailedAlarmView(LayoutInflater inflater, ViewGroup container){
        mRootView = inflater.inflate(R.layout.view_detailed_alarm, container, false);

        initialize();
    }

    /**
     * Purpose - Initialize the seekbars, timepicker, textviews and button.
     */
    private void initialize(){

        //seekbars
        sb_numSnooze = mRootView.findViewById(R.id.sb_numSnooze);
        sb_numSnooze.setMax(MAXNUMSNOOZE);

        sb_snoozeLength = mRootView.findViewById(R.id.sb_snoozeDuration);
        sb_snoozeLength.setMax(MAXSNOOZELENGTH);

        sb_intensity = mRootView.findViewById(R.id.sb_intensity);
        sb_intensity.setMax(MAXINTENSITY);

        sb_seqLength = mRootView.findViewById(R.id.sb_seqLength);
        sb_seqLength.setMax(MAXSEQLENGTH);

        //Textviews
        tv_intensity = mRootView.findViewById(R.id.tv_intensity);
        tv_numSnooze = mRootView.findViewById(R.id.tv_numSnooze);
        tv_seqLength = mRootView.findViewById(R.id.tv_seqLength);
        tv_snoozeLength = mRootView.findViewById(R.id.tv_snoozeDuration);

        //timepicker
        timePicker = mRootView.findViewById(R.id.detailed_timePicker);

        //buttons
        //createAlarm = mRootView.findViewById(R.id.bt_confirm);
        //createAlarm.setOnClickListener(this);

        intializeSeekerListeners();
    }

    /**
     * Purpose - set onSeekBarChangeListeners on all seekers to track values
     */
    private void intializeSeekerListeners() {

        sb_seqLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String toShow = "" + i;
                Log.d("DetailedAlaramView", "seekBarSeqLength " + i + " ===========");
                tv_seqLength.setText(toShow);
            }

            @Override //not used
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override //not used
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sb_intensity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String toShow = "" + i;
                tv_intensity.setText(toShow);
            }

            @Override //not used
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override //not used
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sb_snoozeLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String toShow = "" + i;
                tv_snoozeLength.setText(toShow);
            }

            @Override //not used
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override //not used
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sb_numSnooze.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String toShow = "" + i;
                tv_numSnooze.setText(toShow);
            }

            @Override //not used
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override //not used
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    @Override
    public void setListener(DetailedAlarmListener listener) {
        this.listener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }


    @Override
    public void onClick(View view){
        //when confirm button clicked, get values of all seekbars and send the info to the database
        //and also send the info to the MCU to set alarm
    }
} //end of class

