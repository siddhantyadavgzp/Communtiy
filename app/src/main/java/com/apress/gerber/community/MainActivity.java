package com.apress.gerber.community;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apress.gerber.community.UI.Fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new LoginFragment()).commit();
        }
    }
}