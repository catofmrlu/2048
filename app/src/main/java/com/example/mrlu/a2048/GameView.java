package com.example.mrlu.a2048;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;


/**
 * Created by Mr Lu on 2016/11/17.
 */

public class GameView extends GridLayout {


    ///

    public GameView(Context context) {
        super(context);
        initGame();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGame();
    }

    public GameView(Context context, AttributeSet arrs, int defStyle) {
        super(context);
        initGame();
    }


    private void initGame() {
        setColumnCount(4);
        setBackgroundColor(0xffffcccc);
        setOnTouchListener(new OnTouchListener() {
            private float startX, startY;
            private float offsetX, offsetY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        gameOver();

                        offsetX = event.getX() - startX;
                        offsetY = event.getY() - startY;
                        if (Math.abs(offsetX) > Math.abs(offsetY)) {
                            if (Math.abs(offsetX) < -3) {
                                moveLeft();
                                System.out.println("----左");


                            } else if (offsetX > 3) {
                                moveRight();
                                System.out.println("----右");
                            }
                        } else {
                            if (offsetY < -3) {
                                moveUp();
                                System.out.println("----上");
                            } else if (offsetY > 3) {
                                moveDown();
                                System.out.println("----下");
                            }
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    //定义用户向右滑动响应函数
    private void moveRight(){
        boolean flage = false;
        for (int y = 0; y < 4; y++){
            for (int x = 3; x >= 0; x--){
                for (int x1 = x - 1; x1 >= 0; x1--){
                    //当同一行为空时，不需处理
                    if (cards[x1][y].getNumber() > 0){
                        if (cards[x][y].getNumber() < 2){
                            //将前一张卡片的值移动到当前卡片
                            cards[x][y].setNumber(cards[x1][y].getNumber());
                            cards[x1][y].setNumber(0);
                            x++;
                            flage = true;
                            score += 2;

                        }else if (cards[x][y].getNumber() == cards[x1][y].getNumber()){
                            cards[x][y].setNumber(cards[x][y].getNumber() * 2);
                            score += cards[x][y].getNumber();
                            cards[x1][y].setNumber(0);
                            flage = true;
                        }
                        break;
                    }
                }
            }
        }

        if (flage){
            createRandomCard();
        }
    }


    private void moveLeft(){
        boolean flage = false;
        for (int y = 0; y < 4; y++){
            for (int x = 0; x >= 4; x++){
                for (int x1 = x + 1; x1 < 4; x1++){
                    //当同一行为空时，不需处理
                    if (cards[x1][y].getNumber() > 0){
                        if (cards[x][y].getNumber() < 2){
                            //将前一张卡片的值移动到当前卡片
                            cards[x][y].setNumber(cards[x1][y].getNumber());
                            cards[x1][y].setNumber(0);
                            x--;
                            flage = true;
                            score += 2;

                        }else if (cards[x][y].getNumber() == cards[x1][y].getNumber()){
                            cards[x][y].setNumber(cards[x][y].getNumber() * 2);
                            score += cards[x][y].getNumber();
                            cards[x1][y].setNumber(0);
                            flage = true;
                        }
                        break;
                    }
                }
            }
        }

        if (flage){
            createRandomCard();
        }
    }

    private void moveDown(){
        boolean flage = false;
        for (int x = 0; x < 4; x++){
            for (int y = 3; y >= 0; y--){
                for (int y1 = y - 1; y1 >= 0; y1--){
                    //当同一行为空时，不需处理
                    if (cards[x][y1].getNumber() > 0){
                        if (cards[x][y].getNumber() < 2){
                            //将前一张卡片的值移动到当前卡片
                            cards[x][y].setNumber(cards[x][y1].getNumber());
                            cards[x][y1].setNumber(0);
                            y++;
                            flage = true;
                            score += 2;

                        }else if (cards[x][y].getNumber() == cards[x][y1].getNumber()){
                            cards[x][y].setNumber(cards[x][y].getNumber() * 2);
                            score += cards[x][y].getNumber();
                            cards[x][y1].setNumber(0);
                            flage = true;
                        }
                        break;
                    }
                }
            }
        }

        if (flage){
            createRandomCard();
        }
    }

    private void moveUp(){
        boolean flage = false;
        for (int x = 0; x < 4; x++){
            for (int y = 0; y < 4; y++){
                for (int y1 = y + 1; y1 < 4; y1++){
                    //当同一行为空时，不需处理
                    if (cards[x][y1].getNumber() > 0){
                        if (cards[x][y].getNumber() < 2){
                            //将前一张卡片的值移动到当前卡片
                            cards[x][y].setNumber(cards[x][y1].getNumber());
                            cards[x][y1].setNumber(0);
                            y--;
                            flage = true;
                            score += 2;

                        }else if (cards[x][y].getNumber() == cards[x][y1].getNumber()){
                            cards[x][y].setNumber(cards[x][y].getNumber() * 2);
                            score += cards[x][y].getNumber();
                            cards[x][y1].setNumber(0);
                            flage = true;
                        }
                        break;
                    }
                }
            }
        }

        if (flage){
            createRandomCard();
        }
    }
}
