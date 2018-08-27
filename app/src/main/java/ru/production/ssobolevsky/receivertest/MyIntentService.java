package ru.production.ssobolevsky.receivertest;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by pro on 15.06.2018.
 */

public class MyIntentService extends IntentService {


    public static final String VALUE = "VALUE";

    public MyIntentService() {
        super("Intent");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        MySingleton.getInstance().changeState(intent.getStringExtra(VALUE));
        Intent broadcastIntent = new Intent(MainActivity.FILTER);
        broadcastIntent.putExtra(MyBroadcastReceiver.STATE, MySingleton.getInstance().getState());
        sendBroadcast(broadcastIntent);
    }

    public static Intent newIntent(Context context, String data) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.putExtra(VALUE, data);
        return intent;
    }
}
