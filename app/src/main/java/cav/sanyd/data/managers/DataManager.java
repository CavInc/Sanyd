package cav.sanyd.data.managers;

import android.content.Context;

import cav.sanyd.SanydApp;

public class DataManager {

    private static DataManager INSTANCE = null;

    private Context mContext;

    public static DataManager getInstance() {
        if (INSTANCE==null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public DataManager(){
        mContext = SanydApp.getContext();

    }




}