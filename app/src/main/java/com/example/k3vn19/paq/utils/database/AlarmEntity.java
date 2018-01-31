package com.example.k3vn19.paq.utils.database;

/**
 * Created by k3vn19 on 1/30/2018.
 *
 * AlarmEntity is the object that will have all the info about a single alarm.
 */

public class AlarmEntity {

    private String time = ""; //temp member variables so everything compiles
    private String date = "";

    private String key = ""; //for if we use Firebase

    //Default consructor
    public AlarmEntity(){}

    public AlarmEntity(String time, String date){
        this.time = time;
        this.date = date;
    }

    //Getters and Setters
    public String getTime(){return this.time;}
    public void setTime(String input){this.time = input;}

    public String getDate(){return this.date;}
    public void setDate(String input){this.date = input;}
}
