package me.coffee.imdemo;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * 应用实例
 *
 * @author kongfei
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this,null,false);
    }
}
