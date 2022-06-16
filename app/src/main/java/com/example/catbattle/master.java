package com.example.catbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class master extends AppCompatActivity {
    private Context context;
    private Button stop;
    private ImageView whiteTriangle_battle;
    private ImageView orangeTriangle_battle;
    private ImageView whiteStrip_battle;
    private ImageView rabbit;
    private TextView whiteTriangle_HP;
    private TextView orangeTriangle_HP;
    private TextView whiteStrip_HP;
    private TextView rabbit_HP;
    private TextView turn;
    private ImageButton skill1;
    private ImageButton skill2;
    private ImageButton skill3;
    private int turnNumber = 1;
    private int whTriangle_HP;
    private int whTriangle_HP_now;
    private int whTriangle_Attack;
    private int whTriangle_SK1_Attack;
    private int whTriangle_SK2_strengthen;
    private int whTriangle_Strengthen_Turn;
    private int orTriangle_Strengthen_Turn;
    private int whStrip_Strengthen_Turn;
    private int whTriangle_SK2_cooltime;
    private int whTriangle_SK2_cooltime_now;
    private int whTriangle_SK3_Attack;
    private int whTriangle_SK3_WeakenPercent;
    private int whTriangle_SK3_Weaken;
    private int whTriangle_SK3_cooltime;
    private int whTriangle_SK3_cooltime_now;

    private int orTriangle_HP;
    private int orTriangle_HP_now;
    private int orTriangle_Attack;
    private int orTriangle_SK1_Attack;
    private int orTriangle_SK1_Strengthen;
    private int whTriangle_Strengthen_Turn_or;
    private int orTriangle_Strengthen_Turn_or;
    private int whStrip_Strengthen_Turn_or;
    private int orTriangle_SK2_strengthen;
    private int whTriangle_Strengthen_or2;
    private int orTriangle_Strengthen_or2;
    private int whStrip_Strengthen_or2;
    private int orTriangle_SK2_heal;
    private int orTriangle_SK2_cooltime;
    private int orTriangle_SK2_cooltime_now;
    private int orTriangle_SK3_Attack;
    private int orTriangle_SK3_StrengthenPercent;
    private int orTriangle_SK3_heal;
    private int orTriangle_SK3_cooltime;
    private int orTriangle_SK3_cooltime_now;

    private int whStrip_HP;
    private int whStrip_HP_now;
    private int whStrip_Attack;
    private int whStrip_SK1_Attack;
    private int whStrip_SK1_StrengthenPercent;
    private int whStrip_SK2_Attack;
    private int whStrip_SK2_cooltime;
    private int whStrip_SK2_cooltime_now;
    private int whStrip_SK3_Attack;
    private int whStrip_SK3_WeakenPercent;
    private int whStrip_SK3_WeakenTurn;
    private int whStrip_SK3_cooltime;
    private int whStrip_SK3_cooltime_now;

    private int ra_HP;
    private int ra_HP_now;
    private int ra_Attack;
    private int cantAction;
    private int heal;
    private int cantHeal;
    private int weakenTurn;
    private int weakenTurntrue;
    private RelativeLayout popup;
    private int randomNumber;
    private int[] percent = new int[100];
    private boolean isSkill1LongPressed = false;
    private PopupWindow skill_Content = null;
    private PopupWindow state = null;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        getSupportActionBar().hide();

        context = this;
        stop = (Button)findViewById(R.id.stop);
        popup = (RelativeLayout)findViewById(R.id.popup);
        whiteTriangle_battle = (ImageView)findViewById(R.id.whiteTriangle_battle);
        orangeTriangle_battle = (ImageView)findViewById(R.id.orangeTriange_battle);
        whiteStrip_battle = (ImageView)findViewById(R.id.whiteStrip_battle);
        rabbit = (ImageView)findViewById(R.id.rabbit);
        whiteTriangle_HP = (TextView)findViewById(R.id.whiteTriange_HP);
        orangeTriangle_HP = (TextView)findViewById(R.id.orangeTriangle_HP);
        whiteStrip_HP = (TextView)findViewById(R.id.whiteStrip_HP);
        rabbit_HP = (TextView)findViewById(R.id.rabbit_HP);
        turn = (TextView)findViewById(R.id.turn);
        skill1 = (ImageButton)findViewById(R.id.skill1);
        skill2 = (ImageButton)findViewById(R.id.skill2);
        skill3 = (ImageButton)findViewById(R.id.skill3);

        stop.setOnClickListener(goToHome);

        onLoad();
        start();
    }

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(master.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private void start(){
        if(turnNumber == 1){
            if(whTriangle_HP_now > 0) {
                turn.setText("現在是白色三角形喵咪的回合:" + turnNumber);
                whiteTriangle_battle.setImageResource(R.drawable.white_triangle_battle);
                skill1.setBackgroundResource(R.drawable.attack1);
                skill2.setBackgroundResource(R.drawable.strengthen);
                skill3.setBackgroundResource(R.drawable.attack3);
                skill1.setOnClickListener(useSkill1);
                skill1.setOnLongClickListener(setSkill1Text);
                skill1.setOnTouchListener(closeSkill1Text);
                skill2.setOnClickListener(useSkill2);
                skill2.setOnLongClickListener(setSkill2Text);
                skill2.setOnTouchListener(closeSkill2Text);
                skill3.setOnClickListener(useSkill3);
                skill3.setOnLongClickListener(setSkill3Text);
                skill3.setOnTouchListener(closeSkill3Text);
                if(whTriangle_SK2_cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.strengthen_10);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.strengthen_9);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.strengthen_8);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.strengthen_7);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.strengthen_6);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.strengthen_5);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.strengthen_4);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.strengthen_3);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.strengthen_2);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.strengthen_1);
                    skill2.setEnabled(false);
                }
                else if(whTriangle_SK2_cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.strengthen);
                    skill2.setEnabled(true);
                }
                if(whTriangle_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(whTriangle_SK3_cooltime_now == 0){
                    skill3.setBackgroundResource(R.drawable.attack3);
                    skill3.setEnabled(true);
                }
            }
            else{
                turnNumber++;
                start();
            }
        }
        else if(turnNumber == 2){
            if(orTriangle_HP_now > 0){
                turn.setText("現在是橘色三角形喵咪的回合:" + turnNumber);
                orangeTriangle_battle.setImageResource(R.drawable.orange_triangle_battle);
                skill1.setBackgroundResource(R.drawable.attack1);
                skill2.setBackgroundResource(R.drawable.strengthen);
                skill3.setBackgroundResource(R.drawable.attack3);
                skill1.setOnClickListener(useSkill1);
                skill1.setOnLongClickListener(setSkill1Text);
                skill1.setOnTouchListener(closeSkill1Text);
                skill2.setOnClickListener(useSkill2);
                skill2.setOnLongClickListener(setSkill2Text);
                skill2.setOnTouchListener(closeSkill2Text);
                skill3.setOnClickListener(useSkill3);
                skill3.setOnLongClickListener(setSkill3Text);
                skill3.setOnTouchListener(closeSkill3Text);
                if(orTriangle_SK2_cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.strengthen_10);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.strengthen_9);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.strengthen_8);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.strengthen_7);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.strengthen_6);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.strengthen_5);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.strengthen_4);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.strengthen_3);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.strengthen_2);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.strengthen_1);
                    skill2.setEnabled(false);
                }
                else if(orTriangle_SK2_cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.strengthen);
                    skill2.setEnabled(true);
                }
                if(orTriangle_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(orTriangle_SK3_cooltime_now == 0){
                    skill3.setBackgroundResource(R.drawable.attack3);
                    skill3.setEnabled(true);
                }
            }
            else{
                turnNumber++;
                start();
            }
        }
        else if(turnNumber == 3){
            if(whStrip_HP_now > 0){
                turn.setText("現在白色長條喵咪的回合:" + turnNumber);
                whiteStrip_battle.setImageResource(R.drawable.white_strip_battle);
                skill1.setBackgroundResource(R.drawable.attack1);
                skill2.setBackgroundResource(R.drawable.attack2);
                skill3.setBackgroundResource(R.drawable.attack3);
                skill1.setOnClickListener(useSkill1);
                skill1.setOnLongClickListener(setSkill1Text);
                skill1.setOnTouchListener(closeSkill1Text);
                skill2.setOnClickListener(useSkill2);
                skill2.setOnLongClickListener(setSkill2Text);
                skill2.setOnTouchListener(closeSkill2Text);
                skill3.setOnClickListener(useSkill3);
                skill3.setOnLongClickListener(setSkill3Text);
                skill3.setOnTouchListener(closeSkill3Text);
                if(whStrip_SK2_cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.attack2_10);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.attack2_9);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.attack2_8);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.attack2_7);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.attack2_6);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.attack2_5);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.attack2_4);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.attack2_3);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.attack2_2);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.attack2_1);
                    skill2.setEnabled(false);
                }
                else if(whStrip_SK2_cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.attack2);
                    skill2.setEnabled(true);
                }
                if(whStrip_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(whStrip_SK3_cooltime_now == 0){
                    skill3.setBackgroundResource(R.drawable.attack3);
                    skill3.setEnabled(true);
                }
            }
            else{
                turnNumber++;
                start();
            }
        }
        else if(turnNumber == 4){
            if(ra_HP_now > 0){
                if(cantAction > 0){
                    turnNumber = 1;
                    cantAction--;
                    start();
                }
                else{
                    if(cantHeal == 0){
                        ra_HP_now = ra_HP_now + ra_HP * 10 / 100;
                        if(ra_HP_now > ra_HP){
                            ra_HP_now = ra_HP;
                        }
                    }
                    else{
                        cantHeal--;
                    }

                    whTriangle_HP_now = whTriangle_HP_now - ra_Attack;
                    orTriangle_HP_now = orTriangle_HP_now - ra_Attack;
                    whStrip_HP_now = whStrip_HP_now - ra_Attack;
                    whiteTriangle_HP.setText(whTriangle_HP_now + "\n/" + whTriangle_HP);
                    orangeTriangle_HP.setText(orTriangle_HP_now + "\n/" + orTriangle_HP);
                    whiteStrip_HP.setText(whStrip_HP_now + "\n/" + whStrip_HP);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);

                    if(whTriangle_HP_now <= 0){
                        whiteTriangle_HP.setText(0 + "\n/" + whTriangle_HP);
                        whiteTriangle_battle.setImageResource(R.drawable.background_white);
                    }

                    if(orTriangle_HP_now <= 0){
                        orangeTriangle_HP.setText(0 + "\n/" + orTriangle_HP);
                        orangeTriangle_battle.setImageResource(R.drawable.background_white);
                    }

                    if(whStrip_HP_now <= 0){
                        whiteStrip_HP.setText(0 + "\n/" + whStrip_HP);
                        whiteStrip_battle.setImageResource(R.drawable.background_white);
                    }

                }
                if(whTriangle_HP_now <= 0 || orTriangle_HP_now <= 0 || whStrip_HP_now <= 0){
                    initPopupWindow_show_state_fail();
                    state.showAtLocation(popup , Gravity.CENTER_HORIZONTAL , 0 , 0);
                }
                turnNumber = 1;
                start();
            }
        }
    }

    private View.OnClickListener useSkill1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(turnNumber == 1){
                if(whTriangle_HP_now > 0){
                    ra_HP_now = ra_HP_now - (whTriangle_Attack * whTriangle_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteTriangle_battle.setImageResource(R.drawable.white_triangle);

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }
                    if(whTriangle_SK2_cooltime_now > 0 && whTriangle_SK2_cooltime_now <= whTriangle_SK2_cooltime){
                        whTriangle_SK2_cooltime_now--;
                    }
                    if(whTriangle_SK3_cooltime_now > 0 && whTriangle_SK3_cooltime_now <= whTriangle_SK3_cooltime){
                        whTriangle_SK3_cooltime_now--;
                    }
                    if(whTriangle_Strengthen_Turn > 0){
                        whTriangle_Strengthen_Turn--;
                    }
                    else if(whTriangle_Strengthen_Turn == 0){
                        whTriangle_Attack = whTriangle_Attack - ((100 + whTriangle_SK2_strengthen) / 100);
                    }

                    if(whTriangle_Strengthen_Turn_or > 0){
                        whTriangle_Strengthen_Turn_or--;
                    }
                    else if(whTriangle_Strengthen_Turn_or == 0){
                        whTriangle_Attack = whTriangle_Attack - ((100 + orTriangle_SK1_Strengthen) / 100);
                    }

                    if(whTriangle_Strengthen_or2 > 0){
                        whTriangle_Strengthen_or2--;
                    }
                    else if(whTriangle_Strengthen_or2 == 0){
                        whTriangle_Attack = whTriangle_Attack - ((100 + orTriangle_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(orTriangle_HP_now > 0){
                    ra_HP_now = ra_HP_now - (orTriangle_Attack * orTriangle_SK1_Attack / 100);
                    ra_HP_now = ra_HP_now - (orTriangle_Attack * orTriangle_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeTriangle_battle.setImageResource(R.drawable.orange_triangle);

                    if(orTriangle_SK2_cooltime_now > 0 && orTriangle_SK3_cooltime_now <= orTriangle_SK3_cooltime){
                        orTriangle_SK3_cooltime_now--;
                    }

                    if(orTriangle_SK3_cooltime_now > 0 && orTriangle_SK3_cooltime_now <= orTriangle_SK3_cooltime){
                        orTriangle_SK3_cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    whTriangle_Attack = whTriangle_Attack * ((100 + orTriangle_SK1_Strengthen) / 100);
                    orTriangle_Attack = orTriangle_Attack * ((100 + orTriangle_SK1_Strengthen) / 100);
                    whStrip_Attack = whStrip_Attack * ((100 + orTriangle_SK1_Strengthen) / 100);

                    whTriangle_Strengthen_Turn_or = 1;
                    orTriangle_Strengthen_Turn_or = 1;
                    whStrip_Strengthen_Turn_or = 1;

                    if(orTriangle_Strengthen_Turn > 0){
                        orTriangle_Strengthen_Turn--;
                    }
                    else if(orTriangle_Strengthen_Turn == 0){
                        orTriangle_Attack = orTriangle_Attack - ((100 + whTriangle_SK2_strengthen) / 100);
                    }

                    if(orTriangle_Strengthen_or2 > 0){
                        whTriangle_Strengthen_or2--;
                    }
                    else if(orTriangle_Strengthen_or2 == 0){
                        orTriangle_Attack = orTriangle_Attack - ((100 + orTriangle_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 3){
                if(whStrip_HP_now > 0){
                    for(int i = 0; i < whStrip_SK1_StrengthenPercent; i++){
                        percent[i] = 1;
                    }
                    if(whStrip_SK1_StrengthenPercent < 100){
                        for(int i = whStrip_SK1_StrengthenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    if(whTriangle_SK2_cooltime_now > 0){
                        whTriangle_SK2_cooltime_now = whTriangle_SK2_cooltime_now - percent[randomNumber];
                    }
                    if(whTriangle_SK3_cooltime_now > 0){
                        whTriangle_SK3_cooltime_now = whTriangle_SK3_cooltime_now - percent[randomNumber];
                    }

                    if(orTriangle_SK2_cooltime_now > 0){
                        orTriangle_SK2_cooltime_now = orTriangle_SK2_cooltime_now - percent[randomNumber];
                    }
                    if(orTriangle_SK3_cooltime_now > 0){
                        orTriangle_SK3_cooltime_now = orTriangle_SK2_cooltime_now - percent[randomNumber];
                    }

                    if(whStrip_SK2_cooltime_now > 0){
                        whStrip_SK2_cooltime_now = whStrip_SK2_cooltime_now - percent[randomNumber];
                    }
                    if(whStrip_SK3_cooltime_now > 0){
                        whStrip_SK3_cooltime_now = whStrip_SK3_cooltime_now - percent[randomNumber];
                    }

                    ra_HP_now = ra_HP_now - (whStrip_Attack * whStrip_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteStrip_battle.setImageResource(R.drawable.white_strip);

                    if(whStrip_SK2_cooltime_now > 0 && whStrip_SK2_cooltime_now <= whStrip_SK2_cooltime){
                        whStrip_SK2_cooltime_now--;
                    }
                    if(whStrip_SK3_cooltime_now > 0 && whStrip_SK3_cooltime_now <= whStrip_SK3_cooltime){
                        whStrip_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(whStrip_Strengthen_Turn > 0){
                        whStrip_Strengthen_Turn--;
                    }
                    else if(whStrip_Strengthen_Turn == 0){
                        whStrip_Attack = whStrip_Attack - ((100 + whTriangle_SK2_strengthen) / 100);
                    }

                    if(whStrip_Strengthen_Turn_or > 0){
                        whStrip_Strengthen_Turn_or--;
                    }
                    else if(whStrip_Strengthen_Turn_or == 0){
                        whStrip_Attack = whStrip_Attack - ((100 + orTriangle_SK1_Strengthen) / 100);
                    }

                    if(whStrip_Strengthen_or2 > 0){
                        whStrip_Strengthen_or2--;
                    }
                    else if(whStrip_Strengthen_or2 == 0){
                        whStrip_Attack = whStrip_Attack - ((100 + orTriangle_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
        }
    };


    private View.OnLongClickListener setSkill1Text = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v){
            String skill1Text = "";
            if(turnNumber == 1){
                skill1Text = "對敵人造成" + whTriangle_SK1_Attack + "%威力的攻擊";
            }
            else if(turnNumber == 2){
                skill1Text = "對敵人造成" + orTriangle_SK1_Attack + "%威力的2回攻擊，對我方全員攻擊增加" + orTriangle_SK1_Strengthen + "%一回合";
            }
            else if(turnNumber == 3){
                skill1Text = "對敵人造成" + whStrip_SK1_Attack + "%威力的攻擊，" + whStrip_SK1_StrengthenPercent + "%的機率讓我方全員cool time 減少一回合";
            }
            isSkill1LongPressed = true;
            initPopupWindow_show_skill_text(skill1Text);
            skill_Content.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
            return true;
        }
    };

    private View.OnTouchListener closeSkill1Text = new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v , MotionEvent pEvent){
            if(pEvent.getAction() == MotionEvent.ACTION_UP){
                if(isSkill1LongPressed){
                    skill_Content.dismiss();
                    isSkill1LongPressed = false;
                }
            }
            return false;
        }
    };

    private View.OnClickListener useSkill2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(turnNumber == 1){
                if(whTriangle_HP_now > 0){
                    whTriangle_Attack = whTriangle_Attack * ((100 + whTriangle_SK2_strengthen) / 100);
                    orTriangle_Attack = orTriangle_Attack * ((100 + whTriangle_SK2_strengthen) / 100);
                    whStrip_Attack = whStrip_Attack * ((100 + whTriangle_SK2_strengthen) / 100);

                    whTriangle_Strengthen_Turn_or = 1;
                    orTriangle_Strengthen_Turn_or = 1;
                    whStrip_Strengthen_Turn_or = 1;

                    whTriangle_SK2_cooltime_now = whTriangle_SK2_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteTriangle_battle.setImageResource(R.drawable.white_triangle);

                    if(whTriangle_SK2_cooltime_now > 0 && whTriangle_SK2_cooltime_now < whTriangle_SK2_cooltime){
                        whTriangle_SK2_cooltime_now--;
                    }
                    if(whTriangle_SK3_cooltime_now > 0 && whTriangle_SK3_cooltime_now <= whTriangle_SK3_cooltime){
                        whTriangle_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(whTriangle_Strengthen_Turn_or > 0){
                        whTriangle_Strengthen_Turn_or--;
                    }
                    else if(whTriangle_Strengthen_Turn_or == 0){
                        whTriangle_Attack = whTriangle_Attack - ((100 + orTriangle_SK1_Strengthen) / 100);
                    }

                    if(whTriangle_Strengthen_or2 > 0){
                        whTriangle_Strengthen_or2--;
                    }
                    else if(whTriangle_Strengthen_or2 == 0){
                        whTriangle_Attack = whTriangle_Attack - ((100 + orTriangle_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(orTriangle_HP_now > 0){
                    if(whTriangle_HP_now > 0){
                        whTriangle_HP_now = whTriangle_HP_now + whTriangle_HP * orTriangle_SK2_heal / 100;
                    }

                    if(orTriangle_HP_now > 0){
                        orTriangle_HP_now = orTriangle_HP_now + orTriangle_HP_now * orTriangle_SK2_heal / 100;
                    }

                    if(whStrip_HP_now > 0){
                        whStrip_HP_now = whStrip_HP_now + whStrip_HP * orTriangle_SK2_heal / 100;
                    }

                    if(whTriangle_HP_now > whTriangle_HP){
                        whTriangle_HP_now = whTriangle_HP;
                    }
                    if(orTriangle_HP_now > orTriangle_HP){
                        orTriangle_HP_now = orTriangle_HP;
                    }
                    if(whStrip_HP_now > whStrip_HP){
                        whStrip_HP_now = whStrip_HP;
                    }
                    whiteTriangle_HP.setText(whTriangle_HP_now + "\n/" + whTriangle_HP);
                    orangeTriangle_HP.setText(orTriangle_HP_now + "\n/" + orTriangle_HP);
                    whiteStrip_HP.setText(whStrip_HP_now + "\n/" + whStrip_HP);

                    orTriangle_SK2_cooltime_now = orTriangle_SK2_cooltime;

                    whTriangle_Attack = whTriangle_Attack * ((100 + orTriangle_SK2_strengthen) / 100);
                    orTriangle_Attack = orTriangle_Attack * ((100 + orTriangle_SK2_strengthen) / 100);
                    whStrip_Attack = whStrip_Attack * ((100 + orTriangle_SK2_strengthen) / 100);

                    whTriangle_Strengthen_or2 = 1;
                    orTriangle_Strengthen_or2 = 1;
                    whStrip_Strengthen_or2 = 1;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeTriangle_battle.setImageResource(R.drawable.orange_triangle);

                    if(orTriangle_SK2_cooltime_now > 0 && orTriangle_SK2_cooltime_now < orTriangle_SK2_cooltime){
                        orTriangle_SK2_cooltime_now--;
                    }
                    if(orTriangle_SK3_cooltime_now > 0 && orTriangle_SK3_cooltime_now <= orTriangle_SK3_cooltime){
                        orTriangle_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0) {
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v, Gravity.CENTER_HORIZONTAL, 0, 0);
                    }

                    if(orTriangle_Strengthen_Turn > 0){
                        orTriangle_Strengthen_Turn--;
                    }
                    else if(orTriangle_Strengthen_Turn == 0){
                        orTriangle_Attack = orTriangle_Attack - ((100 + whTriangle_SK2_strengthen) / 100);
                    }

                    if(whTriangle_Strengthen_Turn_or > 0){
                        whTriangle_Strengthen_Turn_or--;
                    }
                    else if(whTriangle_Strengthen_Turn_or == 0){
                        orTriangle_Attack = orTriangle_Attack - ((100 + orTriangle_SK1_Strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 3){
                if(whStrip_HP_now > 0){
                    ra_HP_now = ra_HP_now - whStrip_Attack * whStrip_SK2_Attack / 100;

                    whStrip_SK2_cooltime_now = whStrip_SK2_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteStrip_battle.setImageResource(R.drawable.white_strip);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);

                    whStrip_SK2_cooltime_now = whStrip_SK2_cooltime;

                    if(whStrip_SK2_cooltime_now > 0 && whStrip_SK2_cooltime_now < whStrip_SK2_cooltime){
                        whStrip_SK2_cooltime_now--;
                    }
                    if(whStrip_SK3_cooltime_now > 0 && whStrip_SK3_cooltime_now <= whStrip_SK3_cooltime){
                        whStrip_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0) {
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v, Gravity.CENTER_HORIZONTAL, 0, 0);
                    }

                    if(whStrip_Strengthen_Turn > 0){
                        whStrip_Strengthen_Turn--;
                    }
                    else if(whStrip_Strengthen_Turn == 0){
                        whStrip_Attack = whStrip_Attack - ((100 + whTriangle_SK2_strengthen) / 100);
                    }

                    if(whStrip_Strengthen_Turn_or > 0){
                        whStrip_Strengthen_Turn_or--;
                    }
                    else if(whStrip_Strengthen_Turn_or == 0){
                        whStrip_Attack = whStrip_Attack - ((100 + orTriangle_SK1_Strengthen) / 100);
                    }

                    if(whStrip_Strengthen_or2 > 0){
                        whStrip_Strengthen_or2--;
                    }
                    else if(whStrip_Strengthen_or2 == 0){
                        whStrip_Attack = whStrip_Attack - ((100 + orTriangle_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
        }
    };


    private View.OnLongClickListener setSkill2Text = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v){
            String skill2Text = "";
            if(turnNumber == 1){
                skill2Text = "對我方全體攻擊增加" + whTriangle_SK2_strengthen + "%2回合\ncool time:" + whTriangle_SK2_cooltime + "回";
            }
            else if(turnNumber == 2){
                skill2Text = "對我方全員攻擊增加" + orTriangle_SK2_strengthen + "%一回合，且回復HP" + orTriangle_SK2_heal + "%\ncool time:" + orTriangle_SK2_cooltime + "回";
            }
            else if(turnNumber == 3){
                skill2Text = "對敵人造成" + whStrip_SK2_Attack + "%的傷害\ncool time:" + whStrip_SK2_cooltime + "回";
            }
            isSkill1LongPressed = true;
            initPopupWindow_show_skill_text(skill2Text);
            skill_Content.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
            return true;
        }
    };

    private View.OnTouchListener closeSkill2Text = new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v , MotionEvent pEvent){
            if(pEvent.getAction() == MotionEvent.ACTION_UP){
                if(isSkill1LongPressed){
                    skill_Content.dismiss();
                    isSkill1LongPressed = false;
                }
            }
            return false;
        }
    };

    private View.OnClickListener useSkill3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(turnNumber == 1){
                if(whTriangle_HP_now > 0){
                    ra_HP_now = ra_HP_now - whTriangle_Attack * whTriangle_SK3_Attack / 100;
                    ra_HP_now = ra_HP_now - whTriangle_Attack * whTriangle_SK3_Attack / 100;
                    ra_HP_now = ra_HP_now - whTriangle_Attack * whTriangle_SK3_Attack / 100;

                    for(int i = 0; i < whTriangle_SK3_WeakenPercent; i++){
                        percent[i] = 1;
                    }
                    if(whTriangle_SK3_WeakenPercent < 100){
                        for(int i = whTriangle_SK3_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    cantAction = cantAction + percent[randomNumber];

                    whTriangle_SK3_cooltime_now = whTriangle_SK2_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteTriangle_battle.setImageResource(R.drawable.white_triangle);
                    if(whTriangle_SK2_cooltime_now > 0 && whTriangle_SK2_cooltime_now <= whTriangle_SK2_cooltime){
                        whTriangle_SK3_cooltime_now--;
                    }
                    if(whTriangle_SK3_cooltime_now > 0 && whTriangle_SK3_cooltime_now < whTriangle_SK3_cooltime){
                        whTriangle_SK3_cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(whTriangle_Strengthen_Turn > 0){
                        whTriangle_Strengthen_Turn--;
                    }
                    else if(whTriangle_Strengthen_Turn == 0){
                        whTriangle_Attack = whTriangle_Attack - ((100 + whTriangle_SK2_strengthen) / 100);
                    }

                    if(whTriangle_Strengthen_Turn_or > 0){
                        whTriangle_Strengthen_Turn_or--;
                    }
                    else if(whTriangle_Strengthen_Turn_or == 0){
                        whTriangle_Attack = whTriangle_Attack - ((100 + orTriangle_SK1_Strengthen) / 100);
                    }

                    if(whTriangle_Strengthen_or2 > 0){
                        whTriangle_Strengthen_or2--;
                    }
                    else if(whTriangle_Strengthen_or2 == 0){
                        whTriangle_Attack = whStrip_Attack - ((100 + orTriangle_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(orTriangle_HP_now > 0){
                    ra_HP_now = ra_HP_now - (orTriangle_Attack * orTriangle_SK3_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeTriangle_battle.setImageResource(R.drawable.orange_triangle);

                    for(int i = 0; i < orTriangle_SK3_StrengthenPercent; i++){
                        percent[i] = 10;
                    }
                    if(orTriangle_SK3_StrengthenPercent < 100){
                        for(int i = orTriangle_SK3_StrengthenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);
                    heal = heal + percent[randomNumber];

                    if(whTriangle_HP_now > 0){
                        whTriangle_HP_now = whTriangle_HP_now + whTriangle_HP * heal / 100;
                    }

                    if(orTriangle_HP_now > 0){
                        orTriangle_HP_now = orTriangle_HP_now + orTriangle_HP * heal / 100;
                    }

                    if(whStrip_HP_now > 0){
                        whStrip_HP_now = whStrip_HP_now + whStrip_HP * heal / 100;
                    }

                    whiteTriangle_HP.setText(whTriangle_HP_now + "\n/" + whTriangle_HP);
                    orangeTriangle_HP.setText(orTriangle_HP_now + "\n/" + orTriangle_HP);
                    whiteStrip_HP.setText(whStrip_HP_now + "\n/" + whStrip_HP);

                    orTriangle_SK3_cooltime_now = orTriangle_SK3_cooltime;

                    if(orTriangle_SK2_cooltime_now > 0 && orTriangle_SK2_cooltime_now <= orTriangle_SK2_cooltime){
                        orTriangle_SK2_cooltime_now--;
                    }

                    if(orTriangle_SK3_cooltime_now > 0 && orTriangle_SK3_cooltime_now < orTriangle_SK3_cooltime){
                        orTriangle_SK3_cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(orTriangle_Strengthen_Turn > 0){
                        orTriangle_Strengthen_Turn--;
                    }
                    else if(orTriangle_Strengthen_Turn == 0){
                        orTriangle_Attack = orTriangle_Attack - ((100 + whTriangle_SK2_strengthen) / 100);
                    }

                    if(orTriangle_Strengthen_Turn_or > 0){
                        orTriangle_Strengthen_Turn_or--;
                    }
                    else if(orTriangle_Strengthen_Turn_or == 0){
                        orTriangle_Attack = orTriangle_Attack - ((100 + orTriangle_SK1_Strengthen) / 100);
                    }

                    if(orTriangle_Strengthen_or2 > 0){
                        orTriangle_Strengthen_or2--;
                    }
                    else if(orTriangle_Strengthen_or2 == 0){
                        orTriangle_Attack = orTriangle_Attack - ((100 + orTriangle_SK2_strengthen) / 100);
                    }
                    turnNumber++;
                    start();
                }
            }
            else if(turnNumber == 3){
                if(whStrip_HP_now > 0){
                    for(int i = 0; i < whStrip_SK3_WeakenPercent; i++){
                        percent[i] = 2;
                    }
                    if(whStrip_SK3_WeakenPercent < 100){
                        for(int i = whStrip_SK3_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    cantHeal = cantHeal + percent[randomNumber];

                    for(int i = 0; i < 10; i++){
                        ra_HP_now = ra_HP_now - (whStrip_Attack * whStrip_SK3_Attack / 100);
                    }


                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteStrip_battle.setImageResource(R.drawable.white_strip);

                    whStrip_SK3_cooltime_now = whStrip_SK3_cooltime;

                    if(whStrip_SK2_cooltime_now > 0 && whStrip_SK2_cooltime_now <= whStrip_SK2_cooltime){
                        whStrip_SK2_cooltime_now--;
                    }
                    if(whStrip_SK3_cooltime_now > 0 && whStrip_SK3_cooltime_now < whStrip_SK3_cooltime){
                        whStrip_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(whStrip_Strengthen_Turn > 0){
                        whStrip_Strengthen_Turn--;
                    }
                    else if(whStrip_Strengthen_Turn == 0){
                        whStrip_Attack = whStrip_Attack - ((100 + whTriangle_SK2_strengthen) / 100);
                    }

                    if(whStrip_Strengthen_Turn_or > 0){
                        whStrip_Strengthen_Turn_or--;
                    }
                    else if(whStrip_Strengthen_Turn_or == 0){
                        whStrip_Attack = whStrip_Attack - ((100 + orTriangle_SK1_Strengthen) / 100);
                    }

                    if(whStrip_Strengthen_or2 > 0){
                        whStrip_Strengthen_or2--;
                    }
                    else if(whStrip_Strengthen_or2 == 0){
                        whStrip_Attack = whStrip_Attack - ((100 + orTriangle_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
        }
    };

    private View.OnLongClickListener setSkill3Text = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v){
            String skill3Text = "";
            if(turnNumber == 1){
                skill3Text = "對敵人造成" + whTriangle_SK3_Attack + "%威力的3回攻擊，" + whTriangle_SK3_WeakenPercent + "%的機率讓其行動不能1回合\ncool time:" + whTriangle_SK2_cooltime + "回";
            }
            else if(turnNumber == 2){
                skill3Text = "對敵人造成" + orTriangle_SK3_Attack + "%威力的傷害，" + orTriangle_SK3_StrengthenPercent + "%的機率回復我方全員HP10%\ncool time:" + orTriangle_SK3_cooltime + "回";
            }
            else if(turnNumber == 3){
                skill3Text = "對敵人造成" + whStrip_SK3_Attack + "%威力的10回傷害，" + whStrip_SK3_WeakenPercent + "%的機率讓敵人回復不能2回合\ncool time:" + whStrip_SK3_cooltime + "回";
            }
            isSkill1LongPressed = true;
            initPopupWindow_show_skill_text(skill3Text);
            skill_Content.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
            return true;
        }
    };

    private View.OnTouchListener closeSkill3Text = new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v , MotionEvent pEvent){
            if(pEvent.getAction() == MotionEvent.ACTION_UP){
                if(isSkill1LongPressed){
                    skill_Content.dismiss();
                    isSkill1LongPressed = false;
                }
            }
            return false;
        }
    };
    private void initPopupWindow_show_skill_text(String skillText){
        int height        = getWindowManager().getDefaultDisplay().getHeight();
        int width         = getWindowManager().getDefaultDisplay().getWidth();
        TextView skill_details;
        TextView skill_content;
        View view = LayoutInflater.from(context).inflate(R.layout.activity_master_skill , null);
        skill_Content = new PopupWindow(view);
        skill_Content.setWidth(width * 4/5);
        skill_Content.setHeight(height * 3/7);
        skill_Content.setFocusable(false);

        skill_content = (TextView)view.findViewById(R.id.skill_content);
        skill_details = (TextView)view.findViewById(R.id.skill_details);
        skill_content.setText(skillText);
        //skill_details.setText(turnNumber);
    }

    private void initPopupWindow_show_state(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();
        int money  = sharedPref.getInt("writeMoney" , 0);
        money = money + 100000;
        editor.putInt("writeMoney" , money);
        editor.commit();

        TextView master_state;
        TextView master_money;
        Button master_check;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_master_state , null);
        state = new PopupWindow(view);
        state.setWidth(width * 4/5);
        state.setHeight(height * 3/7);
        state.setFocusable(false);

        master_state = (TextView)view.findViewById(R.id.master_state);
        master_money = (TextView)view.findViewById(R.id.master_money);
        master_check = (Button)view.findViewById(R.id.master_check);

        skill1.setVisibility(View.INVISIBLE);
        skill2.setVisibility(View.INVISIBLE);
        skill3.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

        master_check.setOnClickListener(close);

        master_state.setText("勝利");
        master_money.setText("獲得100000G");
    }

    private void initPopupWindow_show_state_fail(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        TextView master_state;
        TextView master_money;
        Button master_check;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_master_state , null);
        state = new PopupWindow(view);
        state.setWidth(width * 4/5);
        state.setHeight(height * 3/7);
        state.setFocusable(false);

        master_state = (TextView)view.findViewById(R.id.master_state);
        master_money = (TextView)view.findViewById(R.id.master_money);
        master_check = (Button)view.findViewById(R.id.master_check);

        skill1.setVisibility(View.INVISIBLE);
        skill2.setVisibility(View.INVISIBLE);
        skill3.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

        master_check.setOnClickListener(close);

        master_state.setText("失敗");
        master_money.setText("再提升喵咪的等級與技能吧");
    }

    private View.OnClickListener close = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            state.dismiss();
            Intent intent = new Intent();
            intent.setClass(master.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        whTriangle_HP = sharedPref.getInt("writeCharacter4HP" , 0);
        whTriangle_HP_now = whTriangle_HP;
        whTriangle_Attack = sharedPref.getInt("writeCharacter4Attack" , 0);
        whTriangle_SK1_Attack = sharedPref.getInt("writeCharacter4Skill1_attack" , 0);
        whTriangle_SK2_strengthen = sharedPref.getInt("writeCharacter4Skill2_strengthen" , 0);
        whTriangle_SK2_cooltime = sharedPref.getInt("writeCharacter4Skill2_cooltime" , 0);
        whTriangle_SK2_cooltime_now = 0;
        whTriangle_SK3_Attack = sharedPref.getInt("writeCharacter4Skill3_attack" , 0);
        whTriangle_SK3_WeakenPercent = sharedPref.getInt("writeCharacter4Skill3_weakenPercent" , 0);
        whTriangle_SK3_Weaken = sharedPref.getInt("writeCharacter4Skill3_weakenTurn" , 0);
        whTriangle_SK3_cooltime = sharedPref.getInt("writeCharacter4Skill3_cooltime" , 0);
        whTriangle_SK3_cooltime_now = 0;

        orTriangle_HP = sharedPref.getInt("writeCharacter6HP" , 0);
        orTriangle_HP_now = orTriangle_HP;
        orTriangle_Attack = sharedPref.getInt("writeCharacter6Attack" , 0);
        orTriangle_SK1_Attack = sharedPref.getInt("writeCharacter6Skill1_attack" , 0);
        orTriangle_SK1_Strengthen = sharedPref.getInt("writeCharacter6Skill1_strengthen" , 0);
        orTriangle_SK2_strengthen = sharedPref.getInt("writeCharacter6Skill2_strengthen" , 0);
        orTriangle_SK2_heal = sharedPref.getInt("writeCharacter6Skill2_heal" , 0);
        orTriangle_SK2_cooltime = sharedPref.getInt("writeCharacter6Skill2_cooltime" , 0);
        orTriangle_SK2_cooltime_now = 0;
        orTriangle_SK3_Attack = sharedPref.getInt("writeCharacter6Skill3_attack" , 0);
        orTriangle_SK3_StrengthenPercent = sharedPref.getInt("writeCharacter6Skill3_strengthenPercent" , 0);
        orTriangle_SK3_heal = sharedPref.getInt("writeCharacter6Skill3_heal" , 0);
        orTriangle_SK3_cooltime = sharedPref.getInt("writeCharacter6Skill3_cooltime" , 0);
        orTriangle_SK3_cooltime_now = 0;

        whStrip_HP = sharedPref.getInt("writeCharacter10HP" , 0);
        whStrip_HP_now = whStrip_HP;
        whStrip_Attack = sharedPref.getInt("writeCharacter10Attack" , 0);
        whStrip_SK1_Attack = sharedPref.getInt("writeCharacter10Skill1_attack" , 0);
        whStrip_SK1_StrengthenPercent = sharedPref.getInt("writeCharacter10Skill1_strengthenPercent" , 0);
        whStrip_SK2_Attack = sharedPref.getInt("writeCharacter10Skill2_attack" , 0);
        whStrip_SK2_cooltime = sharedPref.getInt("writeCharacter10Skill2_cooltime" , 0);
        whStrip_SK2_cooltime_now = 0;
        whStrip_SK3_Attack = sharedPref.getInt("writeCharacter10Skill3_attack" , 0);
        whStrip_SK3_WeakenPercent = sharedPref.getInt("writeCharacter10Skill3_weakenPercent" , 0);
        whStrip_SK3_cooltime = sharedPref.getInt("writeCharacter10Skill3_cooltime" , 0);
        whStrip_SK3_cooltime_now = 0;
        ra_HP = sharedPref.getInt("writeRabbit4HP" , 0);
        ra_HP_now = ra_HP;
        ra_Attack = sharedPref.getInt("writeRabbit4Attack" , 0);
        whiteTriangle_HP.setText(whTriangle_HP_now + "\n/" + whTriangle_HP);
        orangeTriangle_HP.setText(orTriangle_HP_now + "\n/" + orTriangle_HP);
        whiteStrip_HP.setText(whStrip_HP_now + "\n/" + whStrip_HP);
        rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
    }
}