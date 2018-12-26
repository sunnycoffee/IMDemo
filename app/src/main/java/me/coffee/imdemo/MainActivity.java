package me.coffee.imdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity {

    private static final String TOKEN1 = "0PlDAgLed5eipjiQRMKbgeNxHagpODLqrENrdkp70yhBRX6FpOksvRH5wotVqhwZOh8/E55DW9qdbR3TBY78jg==";
    private static final String TOKEN2 = "qKaoLwlgHAZfpnSikwgUP+NxHagpODLqrENrdkp70yhBRX6FpOksvUNs+GCGNJnDCDJmPPP68qXG/x0P7wqFmA==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                connect(TOKEN1);
                break;
            case R.id.btn2:
                connect(TOKEN2);
                break;
        }
    }

    private void connect(final String token) {

        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                toast("连接失败");
            }

            @Override
            public void onSuccess(String s) {
                toast("连接成功");
                String targetId = TOKEN1.equals(token) ? "user2" : "user1";
                RongIM.getInstance().startPrivateChat(MainActivity.this, targetId, targetId);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                toast("连接失败");
            }
        });


    }


    private void toast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
