package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttp extends AppCompatActivity implements View.OnClickListener{

    private Button btn_get;
    private Button btn_post;
    private TextView tv_show;

    //声明客户端
    private OkHttpClient client ;

    private static final int Get = 1;
    private static final int Post =2 ;

    //声明线程显示消息
    private Handler handler;

    public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        //FindViewById
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_post = (Button) findViewById(R.id.btn_post);
        tv_show = (TextView) findViewById(R.id.tv_show);
        //设置点击事件
        btn_get.setOnClickListener(this);
        btn_post.setOnClickListener(this);
        client = new OkHttpClient();

        //Handler更新UI
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case Get:
                    case Post:
                        tv_show.setText((String)msg.obj);
                        break;
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get://使用原生的OKHttp请求网络数据，get
                getDataFromGet();
                break;
            case R.id.btn_post://使用原生的OKHttp请求网络数据，post
                getDateFromPost();
                break;
        }
    }

    //定义get子线程方法，线程执行耗时任务
    private void getDataFromGet(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = get("https://www.baidu.com/");
                    Log.i("---get",result);
                    Message msg = Message.obtain();
                    msg.what = Get;
                    msg.obj = result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //定义子线程post方法，线程执行耗时任务
    private void getDateFromPost(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = post("http://www.baidu.com","");
                    Log.i("---post",result);
                    Message msg = new Message();
                    msg.what = Post;
                    msg.obj = result;
                    handler.sendMessage(msg);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //定义访问的get方法
    private String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    //定义访问的post方法
    private String post(String url,String json) throws IOException {
        RequestBody body = RequestBody.create(JSON,json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().toString();
    }
}
