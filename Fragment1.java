package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment implements View.OnClickListener{

    private TextView fragment_tv_1;
    private TextView fragment_tv_2;
    private TextView fragment_tv_3;
    private TextView fragment_tv_4;
    private TextView fragment_tv_5;
    private TextView fragment_tv_6;
    private TextView fragment_tv_7;
    private TextView fragment_tv_8;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, null, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragment_tv_1 = (TextView) view.findViewById(R.id.fragment_tv_1);
        fragment_tv_2 = (TextView) view.findViewById(R.id.fragment_tv_2);
        fragment_tv_3 = (TextView) view.findViewById(R.id.fragment_tv_3);
        fragment_tv_4 = (TextView) view.findViewById(R.id.fragment_tv_4);
        fragment_tv_5 = (TextView) view.findViewById(R.id.fragment_tv_5);
        fragment_tv_6 = (TextView) view.findViewById(R.id.fragment_tv_6);
        fragment_tv_7 = (TextView) view.findViewById(R.id.fragment_tv_7);
        fragment_tv_8 = (TextView) view.findViewById(R.id.fragment_tv_8);

        //赋值
        fragment_tv_1.setText("OKHttPGet");
        fragment_tv_2.setText("OKHttPPost");
        fragment_tv_3.setText("xUtils3");
        fragment_tv_4.setText("Retrofit2");
        fragment_tv_5.setText("Fresco");
        fragment_tv_6.setText("Glide");
        fragment_tv_7.setText("greenDao");
        fragment_tv_8.setText("RxJava");

        //设置点击事情
        fragment_tv_1.setOnClickListener(this);
        fragment_tv_2.setOnClickListener(this);
        fragment_tv_3.setOnClickListener(this);
        fragment_tv_4.setOnClickListener(this);
        fragment_tv_5.setOnClickListener(this);
        fragment_tv_6.setOnClickListener(this);
        fragment_tv_7.setOnClickListener(this);
        fragment_tv_8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_tv_1:
            case R.id.fragment_tv_2:
                Intent intent = new Intent(getActivity(),OKHttp.class);
                startActivity(intent);
                break;
            case R.id.fragment_tv_3:
                break;
            case R.id.fragment_tv_4:
                break;
            case R.id.fragment_tv_5:
                break;
            case R.id.fragment_tv_6:
                break;
            case R.id.fragment_tv_7:
                break;
            case R.id.fragment_tv_8:
                break;
        }
    }
}
