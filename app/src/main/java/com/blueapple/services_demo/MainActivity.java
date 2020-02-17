package com.blueapple.services_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_start,btn_stop,btn_check;
    int i,count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start=findViewById(R.id.btn_startserviceid);

        btn_stop=findViewById(R.id.btn_stopserviceid);
        btn_check=findViewById(R.id.btn_checkid);



        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "nothing", Toast.LENGTH_SHORT).show();
                while (i<1000)
                {

/*

                    Thread thread=new Thread();


                    count=count+1;
                    i++;

                    Log.d("count_main", String.valueOf(count));

                    try {
                        thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

*/

                }
            }
        });

        btn_stop.setOnClickListener(this);
        btn_start.setOnClickListener(this);


        /*btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,MyService.class);
                startService(intent);
            }
        });*/

      /*  btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }
        });*/
    }
/*
    public void startService(View view) {
        Intent intent=new Intent(MainActivity.this,MyService.class);
        startService(intent);

    }

    public void stopService(View view) {

        Intent intent=new Intent(MainActivity.this,MyService.class);
        stopService(intent);

    }*/

    @Override
    public void onClick(View v)
    {


        switch (v.getId())
        {
            case  R.id.btn_startserviceid:
               Intent intent=new Intent(MainActivity.this,MyService.class);
                //Intent intent=new Intent(MainActivity.this,MyIntentService.class);
               startService(intent);
               break;


            case R.id.btn_stopserviceid:
                Intent intent_stop=new Intent(MainActivity.this,MyService.class);
                //Intent intent_stop=new Intent(MainActivity.this,MyIntentService.class);
                stopService(intent_stop);
                break;

             default:
                 Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();


        }


    }
}
