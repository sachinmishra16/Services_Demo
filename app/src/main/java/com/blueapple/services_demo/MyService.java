package com.blueapple.services_demo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service
{

    int i=0,count=0;


    @Override
    public void onCreate()
    {
        super.onCreate();

        Intent notificationIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My Awesome App")
                .setContentText("Doing some work...")
                .setContentIntent(pendingIntent).build();

        startForeground(0, notification);


    }

    @Override
    public void onDestroy()
    {


        Toast.makeText(this, "service destroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {



        Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
      /*  Thread thread=new Thread();
        try {
            thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //new MyThread().execute();

        Thread thread=new Thread(new MyThread());
        thread.start();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    public class MyThread implements Runnable
    {

        @Override
        public void run() {

            synchronized (this)
            {

                try {
                    wait(10000);

                    Log.d("service_thread","service_thread");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

   /* public class MyThread extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d("check_background","hihihihihi");


            while (i<10)
            {

                Thread thread=new Thread();

                        count=count+1;
                        i++;

                        Log.d("count_check", String.valueOf(count));

                try {
                    thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            return null;
        }
    }*/

}
