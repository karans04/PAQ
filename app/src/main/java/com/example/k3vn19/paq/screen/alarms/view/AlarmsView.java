package com.example.k3vn19.paq.screen.alarms.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.k3vn19.paq.R;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * View for Alarms.
 */

public class AlarmsView implements AlarmsViewInterface {

    private View mRootView;

    public AlarmsView(LayoutInflater inflater, ViewGroup container){
        mRootView = inflater.inflate(R.layout.view_alarms, container, false);
    }

    @Override
    public View getRootView(){
        return mRootView;
    }

    public void changeContent(FragmentManager fragmentManager, Fragment fragment, boolean isAddToStack){
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right);

        ft.replace(R.id.alarms_base_container, fragment);

        //if add to stack, back button works
        if(isAddToStack){
            ft = ft.addToBackStack(null);
        }
        ft.commit();
    }
}
