package com.example.mrlu.a2048;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.*;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    TextView score_show;
    GameView gv;
    TextView new_game;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int num = msg.arg1;
            score_show.setText(num + "");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score_show = (TextView) findViewById(R.id.tv_score);
        gv = (GameView) findViewById(R.id.gv_show);
        new_game = (TextView) findViewById(R.id.tv_newGame);
        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gv.gameStart();
                gv.score = 0;
            }
        });

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.arg1 = gv.score;
                handler.sendMessage(msg);
            }
        }, 80, 150);
        score_show.setText(100 + "");
    }




}
