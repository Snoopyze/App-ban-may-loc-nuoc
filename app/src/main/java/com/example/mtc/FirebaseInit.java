package com.example.mtc;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class FirebaseInit extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Khởi tạo Firebase
        FirebaseApp.initializeApp(this);
    }
}
