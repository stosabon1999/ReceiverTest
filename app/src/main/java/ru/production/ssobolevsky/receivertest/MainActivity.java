package ru.production.ssobolevsky.receivertest;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String FILTER = "SOBOLEVSKY";

    private TextView mText;

    private Button mButton;

    private MyBroadcastReceiver mMyBroadcastReceiver;

    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListeners();
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mMyBroadcastReceiver, mIntentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mMyBroadcastReceiver);
    }

    private void init() {
        mMyBroadcastReceiver = new MyBroadcastReceiver(new ViewCallBackImpl());
        mIntentFilter = new IntentFilter(FILTER);
        mText = findViewById(R.id.tv_broadcast_state);
        mButton = findViewById(R.id.b_start_service_and_broadcast);
    }

    private void initListeners() {
        mButton.setOnClickListener(new MyButtonClickListener());
    }


    private class MyButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            startService(MyIntentService.newIntent(MainActivity.this, String.valueOf((int)  (Math.random() * 6))));
        }
    }

    private class ViewCallBackImpl implements ViewCallback {

        @Override
        public void onStatusChanged(String newStatus) {
            mText.setText(newStatus);
        }
    }

}
