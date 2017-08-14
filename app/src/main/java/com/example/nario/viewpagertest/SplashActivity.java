package com.example.nario.viewpagertest;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class SplashActivity extends Activity {
    private TextView tv_version_name;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        initUI();
        initData();

        handler = new Handler();
        // 延迟SPLASH_DISPLAY_LENGHT时间然后跳转到MainActivity
        //Main activity 初始化
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,
                        MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        }, 2500);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return  true;
        }
        return  super.onKeyDown(keyCode, event);

    }


    private void initData() {
        // 应用版本名称
        tv_version_name.setText("版本名：" + getVersionName());
    }

    /**
     * 获取版本名称：清单文件中
     *
     * @return 应用版本名称 返回null代表有异常
     */
    private String getVersionName() {
        // 1.管理者对象packageManager
        PackageManager pm = getPackageManager();
        // 2.从包的管理者对象中，获取指定包名的基本信息（版本名称，版本号）
        try {
            PackageInfo packageInfo = pm.getPackageInfo(getPackageName(), 0);
            // 3.获取版本名称
            return packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 初始化UI方法 alt+shift+j
     */
    private void initUI() {

        tv_version_name = (TextView) findViewById(R.id.tv_version_name);
    }
}