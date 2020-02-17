package com.blueapple.services_demo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService
{

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService() {

        super("my_thread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        synchronized (this)
        {
            try {
                wait(5000);

                Handler handler=new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        Log.d("checkintentservice","checking intent");
                    }
                },100000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId)
    {

        Toast.makeText(this, "service start", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "service destroyed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate() {

        super.onCreate();
    }
}
