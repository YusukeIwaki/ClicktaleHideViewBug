package io.github.yusukeiwaki.clicktalehideviewbug;

import android.app.Application;
import android.util.Log;

import com.clicktale.clicktalesdk.Clicktale;
import com.clicktale.clicktalesdk.ClicktaleCallback;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Clicktale.start(this, new ClicktaleCallback() {
            @Override
            public void onSessionURLCreated(String s) {
                Log.d("SampleApplication", "onSessionURLCreated: " + s);
            }

            @Override
            public void onSessionIDCreated(String s) {
                Log.d("SampleApplication", "onSessionIDCreated: " + s);
            }
        }, getString(R.string.clicktale_access_key), getString(R.string.clicktale_secret_key));
        Clicktale.setDevMode(BuildConfig.DEBUG);
    }
}
