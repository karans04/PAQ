package com.example.k3vn19.paq.screen.alarms.screens.detailedAlarm.view;

import com.example.k3vn19.paq.common.ViewBaseInterface;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * Purpose - Interface for DetailedAlarm. Provides DetailedAlarmListener/communication between MVC classes of
 *           DetailedAlarm.
 */

public interface DetailedAlarmInterface extends ViewBaseInterface {

    interface DetailedAlarmListener{
        void setAlarm();
    }

    void setListener(DetailedAlarmListener listener);
}