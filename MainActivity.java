package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager =  getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)  ;
        setContentView(R.layout.activity_main);
        replaceFragment(new Main());
    }

    void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.yuvalFragmentHolder,fragment);
        fragmentTransaction.commit();
    }

    public void moveToSecondFrag() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.yuvalFragmentHolder,new Secondary()).commit();

    }
}