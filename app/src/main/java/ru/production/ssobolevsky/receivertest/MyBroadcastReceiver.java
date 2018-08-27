package ru.production.ssobolevsky.receivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by pro on 15.06.2018.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    public static final String STATE = "STATE";

    private ViewCallback mViewCallback;

    public MyBroadcastReceiver(ViewCallback viewCallback) {
        mViewCallback = viewCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mViewCallback.onStatusChanged(intent.getStringExtra(STATE));
    }


}
