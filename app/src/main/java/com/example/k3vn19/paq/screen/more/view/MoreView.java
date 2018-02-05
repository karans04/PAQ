package com.example.k3vn19.paq.screen.more.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.k3vn19.paq.R;

/**
 * Created by k3vn19 on 2/5/2018.
 *
 * Purpose - Handles user input for More package.
 */

public class MoreView implements MoreViewInterface, View.OnClickListener{

    private View mRootView;

    private Button bt_About;
    private Button bt_Connect;
    private Button bt_FAQ;
    private Button bt_Report;

    private MoreViewListener mListener;

    public MoreView(LayoutInflater inflater, ViewGroup container, MoreViewListener listener){
        mRootView = inflater.inflate(R.layout.view_more, container, false);

        this.mListener = listener;

        initialize();
    }

    /**
     * Purpose - Initialize buttons and set listeners.
     */
    private void initialize(){
        bt_About = mRootView.findViewById(R.id.bt_About);
        bt_Connect = mRootView.findViewById(R.id.bt_ConnectDevice);
        bt_FAQ = mRootView.findViewById(R.id.bt_FAQ);
        bt_Report = mRootView.findViewById(R.id.bt_ReportProblem);

        bt_About.setOnClickListener(this);
        bt_Connect.setOnClickListener(this);
        bt_FAQ.setOnClickListener(this);
        bt_Report.setOnClickListener(this);
    }

    @Override
    public View getRootView(){
        return mRootView;
    }

    @Override
    public void onClick(View view){

        int viewID = view.getId();

        switch(viewID){
            case R.id.bt_About:
                //go to aboutDevice activity
                mListener.goToAbout();
                break;
            case R.id.bt_ConnectDevice:
                //go to connectdevice activity
                mListener.goToConnectDevice();
                break;
            case R.id.bt_FAQ:
                //go to faq activity
                mListener.goToFAQ();
                break;
            case R.id.bt_ReportProblem:
                //go to report activity
                mListener.goToReport();
                break;
        }
    }

}
