package com.example.roomapplication;

import android.app.Application;

import androidx.room.Room;

public class RoomApplication extends Application {
    private LocalDataSource localDataSource;
    private RoomApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        localDataSource = Room.databaseBuilder(getApplicationContext(), LocalDataSource.class, "person")
                .allowMainThreadQueries()
                .build();
        application = this;
    }

    public RoomApplication getInstance() {
        return application;
    }

    public LocalDataSource getLocalDataSource() {
        return localDataSource;
    }
}
