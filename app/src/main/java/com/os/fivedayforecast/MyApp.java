package com.os.fivedayforecast;

import android.app.Application;
import android.content.Context;

/**
 * Created by Os on 27/03/2018.
 */

public class MyApp extends Application {
    final public static String TAG = "LOG_FiveDayForecast: ";

    private static MyApp appInstance;
    private static Context context;

    /**
     * @return instance of the Application
     */
    public static MyApp getAppInstance() {
        if (appInstance == null) {
            appInstance = new MyApp();
        }
        return appInstance;
    }

    /**
     * Returns Application Context that can be used in fragments
     * @return Application Context
     */
    public Context getAppContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }
}
