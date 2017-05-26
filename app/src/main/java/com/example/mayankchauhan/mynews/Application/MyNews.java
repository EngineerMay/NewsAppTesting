package com.example.mayankchauhan.mynews.Application;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by mayankchauhan on 15/04/17.
 */

public class MyNews extends Application {

    private static MyNews mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

        if (!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
    public static MyNews getInstance() {
        return mApplication;
    }
}
