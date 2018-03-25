package cav.sanyd;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SanydApp extends Application {

    private static Context sContext;
    private static SharedPreferences sPreferense;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        sPreferense = PreferenceManager.getDefaultSharedPreferences(sContext);
    }

    public static Context getContext() {
        return sContext;
    }

    public static SharedPreferences getPreferense() {
        return sPreferense;
    }
}