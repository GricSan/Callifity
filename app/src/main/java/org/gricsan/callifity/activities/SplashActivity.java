package org.gricsan.callifity.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    private Intent mStartMainActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStartMainActivityIntent = new Intent(this, MainActivity.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startActivity(mStartMainActivityIntent);
    }
}
