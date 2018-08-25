package com.example.adiphong.rx2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneFragment oneFragment = OneFragment.newInstance();
        String tag = "OneFragment";
        replaceFragment(oneFragment, tag);
    }

    public void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragment, fragment, tag)
                .addToBackStack(tag)
                .commitAllowingStateLoss();
    }

}
