package me.coffee.imdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.rong.imkit.RongIM;

public class ChatActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

    }
    @Override
    protected void onDestroy() {
        RongIM.getInstance().logout();
        super.onDestroy();
    }
}
