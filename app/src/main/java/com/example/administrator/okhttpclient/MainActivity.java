package com.example.administrator.okhttpclient;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView tv;
    private ProgressBar mProgerssBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.csdn.net/";
//               OkHttpUtils.get().url(url).build()
//               .execute(new StringCallback() {
//                   @Override
//                   public void onError(Call call, Exception e, int id) {
//
//                   }
//
//                   @Override
//                   public void onResponse(String response, int id) {
//                    tv.setText(response);
//                   }
//               });
//
//
                OkHttpUtils.get().url(url).build().execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(),"gson-2.2.1.jar") {

                    public void inProgress(float progress){
                        mProgerssBar.setProgress((int) (100*progress));
                    }


                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG","onError:"+e.getMessage());
                    }


                    public void onResponse(File response, int id) {
                    Log.e("TAG","onResponse"+response.getAbsolutePath());
                    }
                });


           }

    });
}
}
