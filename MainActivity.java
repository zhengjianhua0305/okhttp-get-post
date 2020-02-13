package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FrameLayout fl_main;
    private TextView tv_1,tv_2,tv_3,tv_4;

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FindViewById
        fl_main = (FrameLayout) findViewById(R.id.fl_main);
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        tv_4 = (TextView) findViewById(R.id.tv_4);

        tv_1.setOnClickListener(this);
        tv_2.setOnClickListener(this);
        tv_3.setOnClickListener(this);
        tv_4.setOnClickListener(this);


        //初始化Fragment
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        //设置默认页面
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main,fragment1).commitAllowingStateLoss();
        tv_1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,fragment1).commitAllowingStateLoss();
                tv_1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                tv_2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv_3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv_4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.tv_2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,fragment2).commitAllowingStateLoss();
                tv_2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                tv_1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv_3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv_4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.tv_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,fragment3).commitAllowingStateLoss();
                tv_3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                tv_1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv_2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv_4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.tv_4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,fragment4).commitAllowingStateLoss();
                tv_4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                tv_1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv_2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                tv_3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;
        }
    }
}
