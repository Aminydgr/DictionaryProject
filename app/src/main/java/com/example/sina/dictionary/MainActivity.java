package com.example.sina.dictionary;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    MainFragment mainFragment = new MainFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
mainFragment.setContext(this);
        fragmentManager.beginTransaction().replace(R.id.frameLayout, mainFragment).commit();
    }
}
