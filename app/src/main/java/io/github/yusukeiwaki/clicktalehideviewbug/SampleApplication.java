package io.github.yusukeiwaki.clicktalehideviewbug;

import android.app.Application;

import io.repro.android.Repro;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Repro.setup(this, getString(R.string.repro_app_token));
        Repro.startRecording();
    }
}
