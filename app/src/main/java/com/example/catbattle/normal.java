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

public class normal extends AppCompatActivity {
    private Context context;
    private Button stop;
    private ImageView orangeCircle_battle;
    private ImageView blackTriangle_battle;
    private ImageView blackStrip_battle;
    private ImageView rabbit;
    private TextView orangeCircle_HP;
    private TextView blackTriangle_HP;
    private TextView blackStrip_HP;
    private TextView rabbit_HP;
    private TextView turn;
    private ImageButton skill1;
    private ImageButton skill2;
    private ImageButton skill3;
    private int turnNumber = 1;
    private int orCircle_HP;
    private int orCircle_HP_now;
    private int orCircle_Attack;
    private int orCircle_Attack_temp;
    private int orCircle_SK1_Attack;
    private int orCircle_SK2_Heal;
    private int orCircle_SK2_cooltime;
    private int orCircle_SK2_cooltime_now;
    private int orCircle_SK3_Attack;
    private int orCircle_SK3_WeakenPercent;
    private int orCircle_SK3_Weaken;
    private int orCircle_SK3_cooltime;
    private int orCircle_SK3_cooltime_now;

    private int blTriangle_HP;
    private int blTriangle_HP_now;
    private int blTriangle_Attack;
    private int blTriangle_SK1_Attack;
    private int blTriangle_SK2_strengthen;
    private int orCircle_strengthen_Turn;
    private int blTriangle_strengthen_Turn;
    private int blStrip_strengthen_Turn;
    private int blTriange_SK2_Heal;
    private int blTriangle_SK2_cooltime;
    private int blTriangle_SK2_cooltime_now;
    private int blTriangle_SK3_Attack;
    private int blTriangle_SK3_cooltime;
    private int blTriangle_SK3_cooltime_now;

    private int blStrip_HP;
    private int blStrip_HP_now;
    private int blStrip_Attack;
    private int blStrip_SK1_Attack;
    private int blStrip_SK1_WeakenPercent;
    private int blStrip_SK1_WeakenTurn;
    private int blStrip_SK2_Heal;
    private int blStrip_SK2_StrengthenTurn;
    private int blStrip_SK2_cooltime;
    private int blStrip_SK2_cooltime_now;
    private int blStrip_SK3_Attack;
    private int blStrip_SK3_WeakenPercent;
    private int blStrip_SK3_WeakenTurn = 2;
    private int blStrip_SK3_Strengthen;
    private int blStrip_SK3_cooltime;
    private int blStrip_SK3_cooltime_now;

    private int ra_HP;
    private int ra_HP_now;
    private int ra_Attack;
    private int cantAction;
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
        setContentView(R.layout.activity_normal);
        getSupportActionBar().hide();

        context = this;
        stop = (Button)findViewById(R.id.stop);
        popup = (RelativeLayout)findViewById(R.id.popup);
        orangeCircle_battle = (ImageView)findViewById(R.id.orangeCircle_battle);
        blackTriangle_battle = (ImageView)findViewById(R.id.blackTriangle_battle);
        blackStrip_battle = (ImageView)findViewById(R.id.blackStrip_battle);
        rabbit = (ImageView)findViewById(R.id.rabbit);
        orangeCircle_HP = (TextView)findViewById(R.id.orangeCircle_HP);
        blackTriangle_HP = (TextView)findViewById(R.id.blackTriangle_HP);
        blackStrip_HP = (TextView)findViewById(R.id.blackStrip_HP);
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
            intent.setClass(normal.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private void start(){
        if(turnNumber == 1){
            if(orCircle_HP_now > 0) {
                turn.setText("現在是橘色圓型喵咪的回合:" + turnNumber);
                orangeCircle_battle.setImageResource(R.drawable.orange_circle_battle);
                skill1.setBackgroundResource(R.drawable.attack1);
                skill2.setBackgroundResource(R.drawable.heal);
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
                if(orCircle_SK2_cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.heal_10);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.heal_9);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.heal_8);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.heal_7);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.heal_6);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.heal_5);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.heal_4);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.heal_3);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.heal_2);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.heal_1);
                    skill2.setEnabled(false);
                }
                else if(orCircle_SK2_cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.heal);
                    skill2.setEnabled(true);
                }
                if(orCircle_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(orCircle_SK3_cooltime_now == 0){
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
            if(blTriangle_HP_now > 0){
                turn.setText("現在是黑色三角形喵咪的回合:" + turnNumber);
                blackTriangle_battle.setImageResource(R.drawable.black_triangle_battle);
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
                if(blTriangle_SK2_cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.strengthen_10);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.strengthen_9);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.strengthen_8);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.strengthen_7);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.strengthen_6);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.strengthen_5);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.strengthen_4);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.strengthen_3);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.strengthen_2);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.strengthen_1);
                    skill2.setEnabled(false);
                }
                else if(blTriangle_SK2_cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.strengthen);
                    skill2.setEnabled(true);
                }
                if(blTriangle_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(blTriangle_SK3_cooltime_now == 0){
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
            if(blStrip_HP_now > 0){
                turn.setText("現在黑色長條喵咪的回合:" + turnNumber);
                blackStrip_battle.setImageResource(R.drawable.black_strip_battle);
                skill1.setBackgroundResource(R.drawable.attack1);
                skill2.setBackgroundResource(R.drawable.heal);
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
                if(blStrip_SK2_cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.heal_10);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.heal_9);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.heal_8);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.heal_7);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.heal_6);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.heal_5);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.heal_4);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.heal_3);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.heal_2);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.heal_1);
                    skill2.setEnabled(false);
                }
                else if(blStrip_SK2_cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.heal);
                    skill2.setEnabled(true);
                }
                if(blStrip_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(blStrip_SK3_cooltime_now == 0){
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
                if(weakenTurn > 0 && weakenTurntrue == 0){
                    ra_Attack = ra_Attack - ra_Attack * (orCircle_SK3_Weaken / 100);
                    weakenTurntrue = 1;
                }
                else if(weakenTurn > 0 && weakenTurntrue == 1){
                    ra_Attack = ra_Attack - ra_Attack * (orCircle_SK3_Weaken / 100);
                    weakenTurntrue = 1;
                }
                else if(weakenTurn == 0 && weakenTurntrue == 1){
                    ra_Attack = ra_Attack + ra_Attack * (orCircle_SK3_Weaken / 100);
                    weakenTurntrue = 0;
                }

                orCircle_HP_now = orCircle_HP_now - ra_Attack;
                blTriangle_HP_now = blTriangle_HP_now - ra_Attack;
                blStrip_HP_now = blStrip_HP_now - ra_Attack;
                orangeCircle_HP.setText(orCircle_HP_now + "\n/" + orCircle_HP);
                blackTriangle_HP.setText(blTriangle_HP_now + "\n/" + blTriangle_HP);
                blackStrip_HP.setText(blStrip_HP_now + "\n/" + blStrip_HP);
                rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);

                if(orCircle_HP_now <= 0){
                    orangeCircle_HP.setText(0 + "\n/" + orCircle_HP);
                    orangeCircle_battle.setImageResource(R.drawable.background_white);
                }

                if(blTriangle_HP_now <= 0){
                    blackTriangle_HP.setText(0 + "\n/" + blTriangle_HP);
                    blackTriangle_battle.setImageResource(R.drawable.background_white);
                }

                if(blStrip_HP_now <= 0){
                    blackStrip_HP.setText(0 + "\n/" + blStrip_HP);
                    blackStrip_battle.setImageResource(R.drawable.background_white);
                }

                }
                if(orCircle_HP_now <= 0 || blTriangle_HP_now <= 0 || blStrip_HP_now <= 0){
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
                if(orCircle_HP_now > 0){
                    ra_HP_now = ra_HP_now - (orCircle_Attack * orCircle_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeCircle_battle.setImageResource(R.drawable.orange_circle);

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }
                    if(orCircle_SK2_cooltime_now > 0 && orCircle_SK2_cooltime_now <= orCircle_SK2_cooltime){
                        orCircle_SK2_cooltime_now--;
                    }
                    if(orCircle_SK3_cooltime_now > 0 && orCircle_SK3_cooltime_now <= orCircle_SK3_cooltime){
                        orCircle_SK3_cooltime_now--;
                    }
                    if(orCircle_strengthen_Turn > 0){
                        orCircle_strengthen_Turn--;
                    }
                    else if(orCircle_strengthen_Turn == 0){
                        orCircle_Attack = orCircle_Attack - ((100 + blTriangle_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(blTriangle_HP_now > 0){
                    ra_HP_now = ra_HP_now - (blTriangle_Attack * blTriangle_SK1_Attack / 100);
                    ra_HP_now = ra_HP_now - (blTriangle_Attack * blTriangle_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackTriangle_battle.setImageResource(R.drawable.black_triangle);

                    if(blTriangle_SK2_cooltime_now > 0 && blTriangle_SK3_cooltime_now <= blTriangle_SK3_cooltime){
                        blTriangle_SK3_cooltime_now--;
                    }

                    if(blTriangle_SK3_cooltime_now > 0 && blTriangle_SK3_cooltime_now <= blTriangle_SK3_cooltime){
                        blTriangle_SK3_cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(blTriangle_strengthen_Turn > 0){
                        blTriangle_strengthen_Turn--;
                    }
                    else if(blTriangle_strengthen_Turn == 0){
                        blTriangle_Attack = blTriangle_Attack - ((100 + blTriangle_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 3){
                if(blStrip_HP_now > 0){
                    for(int i = 0; i < blStrip_SK3_WeakenPercent; i++){
                        percent[i] = 1;
                    }
                    if(blStrip_SK3_WeakenPercent < 100){
                        for(int i = blStrip_SK3_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    cantAction = cantAction + percent[randomNumber];

                    ra_HP_now = ra_HP_now - (blStrip_Attack * blStrip_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackStrip_battle.setImageResource(R.drawable.black_strip);

                    if(blStrip_SK2_cooltime_now > 0 && blStrip_SK2_cooltime_now <= blStrip_SK2_cooltime){
                        blStrip_SK2_cooltime_now--;
                    }
                    if(blStrip_SK3_cooltime_now > 0 && blStrip_SK3_cooltime_now <= blStrip_SK3_cooltime){
                        blStrip_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(blStrip_strengthen_Turn > 0){
                        blStrip_strengthen_Turn--;
                    }
                    else if(blStrip_strengthen_Turn == 0){
                        blStrip_Attack = blStrip_Attack - ((100 + blTriangle_SK2_strengthen) / 100);
                    }
                    turnNumber++;
                    start();
                }

            }
        }
    };


    private View.OnLongClickListener setSkill1Text = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v){
            String skill1Text = "";
            if(turnNumber == 1){
                skill1Text = "對敵人造成" + orCircle_SK1_Attack + "%威力的攻擊";
            }
            else if(turnNumber == 2){
                skill1Text = "對敵人造成" + blTriangle_SK1_Attack + "%威力的2回攻擊";
            }
            else if(turnNumber == 3){
                skill1Text = "對敵人造成" + blStrip_SK1_Attack + "%威力的攻擊，" + blStrip_SK1_WeakenPercent + "%的機率讓敵人行動不能";
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
                if(orCircle_HP_now > 0){
                    if(orCircle_HP_now > 0){
                        orCircle_HP_now = orCircle_HP_now + orCircle_HP * orCircle_SK2_Heal / 100;
                    }

                    if(blTriangle_HP_now > 0){
                        blTriangle_HP_now = blTriangle_HP_now + blTriangle_HP * orCircle_SK2_Heal / 100;
                    }

                    if(blStrip_HP_now > 0){
                        blStrip_HP_now = blStrip_HP_now + blStrip_HP * orCircle_SK2_Heal / 100;
                    }

                    if(orCircle_HP_now > orCircle_HP){
                        orCircle_HP_now = orCircle_HP;
                    }
                    if(blTriangle_HP_now > blTriangle_HP){
                        blTriangle_HP_now = blTriangle_HP;
                    }
                    if(blStrip_HP_now > blStrip_HP){
                        blStrip_HP_now = blStrip_HP;
                    }
                    orangeCircle_HP.setText(orCircle_HP_now + "\n/" + orCircle_HP);
                    blackTriangle_HP.setText(blTriangle_HP_now + "\n/" + blTriangle_HP);
                    blackStrip_HP.setText(blStrip_HP_now + "\n/" + blStrip_HP);

                    orCircle_SK2_cooltime_now = orCircle_SK2_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeCircle_battle.setImageResource(R.drawable.orange_circle);

                    if(orCircle_SK2_cooltime_now > 0 && orCircle_SK2_cooltime_now < orCircle_SK2_cooltime){
                        orCircle_SK2_cooltime_now--;
                    }
                    if(orCircle_SK3_cooltime_now > 0 && orCircle_SK3_cooltime_now <= orCircle_SK3_cooltime){
                        orCircle_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(orCircle_strengthen_Turn > 0){
                        orCircle_strengthen_Turn--;
                    }
                    else if(orCircle_strengthen_Turn == 0){
                        orCircle_Attack = orCircle_Attack_temp;
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(blTriangle_HP_now > 0){
                    if(orCircle_HP_now > 0){
                        orCircle_HP_now = orCircle_HP_now + orCircle_HP * blTriange_SK2_Heal / 100;
                    }

                    if(blTriangle_HP_now > 0){
                        blTriangle_HP_now = blTriangle_HP_now + blTriangle_HP * blTriange_SK2_Heal / 100;
                    }

                    if(blStrip_HP_now > 0){
                        blStrip_HP_now = blStrip_HP_now + blStrip_HP * blTriange_SK2_Heal / 100;
                    }

                    if(orCircle_HP_now > orCircle_HP){
                        orCircle_HP_now = orCircle_HP;
                    }
                    if(blTriangle_HP_now > blTriangle_HP){
                        blTriangle_HP_now = blTriangle_HP;
                    }
                    if(blStrip_HP_now > blStrip_HP){
                        blStrip_HP_now = blStrip_HP;
                    }
                    orangeCircle_HP.setText(orCircle_HP_now + "\n/" + orCircle_HP);
                    blackTriangle_HP.setText(blTriangle_HP_now + "\n/" + blTriangle_HP);
                    blackStrip_HP.setText(blStrip_HP_now + "\n/" + blStrip_HP);

                    blTriangle_SK2_cooltime_now = blTriangle_SK2_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackTriangle_battle.setImageResource(R.drawable.black_triangle);

                    orCircle_Attack = orCircle_Attack * ((100 + blTriangle_SK2_strengthen) / 100);
                    blTriangle_Attack = blTriangle_Attack * ((100 + blTriangle_SK2_strengthen) / 100);
                    blStrip_Attack = blStrip_Attack * ((100 + blTriangle_SK2_strengthen) / 100);

                    orCircle_strengthen_Turn = 1;
                    blTriangle_strengthen_Turn = 1;
                    blStrip_strengthen_Turn = 1;

                    if(orCircle_SK2_cooltime_now > 0 && orCircle_SK2_cooltime_now < orCircle_SK2_cooltime){
                        orCircle_SK2_cooltime_now--;
                    }
                    if(orCircle_SK3_cooltime_now > 0 && orCircle_SK3_cooltime_now <= orCircle_SK3_cooltime){
                        orCircle_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0) {
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v, Gravity.CENTER_HORIZONTAL, 0, 0);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 3){
                if(blTriangle_HP_now > 0){
                    if(orCircle_HP_now > 0){
                        orCircle_HP_now = orCircle_HP_now + orCircle_HP * blStrip_SK2_Heal / 100;
                    }

                    if(blTriangle_HP_now > 0){
                        blTriangle_HP_now = blTriangle_HP_now + blTriangle_HP * blStrip_SK2_Heal / 100;
                    }

                    if(blStrip_HP_now > 0){
                        blStrip_HP_now = blStrip_HP_now + blStrip_HP * blStrip_SK2_Heal / 100;
                    }

                    if(orCircle_HP_now > orCircle_HP){
                        orCircle_HP_now = orCircle_HP;
                    }
                    if(blTriangle_HP_now > blTriangle_HP){
                        blTriangle_HP_now = blTriangle_HP;
                    }
                    if(blStrip_HP_now > blStrip_HP){
                        blStrip_HP_now = blStrip_HP;
                    }
                    orangeCircle_HP.setText(orCircle_HP_now + "\n/" + orCircle_HP);
                    blackTriangle_HP.setText(blTriangle_HP_now + "\n/" + blTriangle_HP);
                    blackStrip_HP.setText(blStrip_HP_now + "\n/" + blStrip_HP);

                    blTriangle_SK2_cooltime_now = blTriangle_SK2_cooltime;

                    if(orCircle_SK2_cooltime_now > 0){
                        orCircle_SK2_cooltime_now--;
                    }
                    if(orCircle_SK3_cooltime_now > 0){
                        orCircle_SK3_cooltime_now--;
                    }
                    if(blTriangle_SK2_cooltime_now > 0){
                        blTriangle_SK2_cooltime_now--;
                    }
                    if(blTriangle_SK3_cooltime_now > 0){
                        blTriangle_SK3_cooltime_now--;
                    }
                    if(blStrip_SK2_cooltime_now > 0){
                        blStrip_SK2_cooltime_now--;
                    }
                    if(blStrip_SK3_cooltime_now > 0){
                        blStrip_SK3_cooltime_now--;
                    }
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackStrip_battle.setImageResource(R.drawable.black_strip);

                    if(orCircle_SK2_cooltime_now > 0 && orCircle_SK2_cooltime_now < orCircle_SK2_cooltime){
                        orCircle_SK2_cooltime_now--;
                    }
                    if(orCircle_SK3_cooltime_now > 0 && orCircle_SK3_cooltime_now <= orCircle_SK3_cooltime){
                        orCircle_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0) {
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v, Gravity.CENTER_HORIZONTAL, 0, 0);
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
                skill2Text = "對我方全體回復" + orCircle_SK2_Heal + "%HP\ncool time:" + orCircle_SK2_cooltime + "回";
            }
            else if(turnNumber == 2){
                skill2Text = "對我方全員攻擊增加" + blTriangle_SK2_strengthen + "，且回復HP" + blTriange_SK2_Heal + "%\ncool time:" + blTriangle_SK2_cooltime + "回";
            }
            else if(turnNumber == 3){
                skill2Text = "回復我方全體最大HP的" + blStrip_SK2_Heal + "%，且100%機率減少我方cool time一回合\ncool time:" + blStrip_SK2_cooltime;
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
                if(orCircle_HP_now > 0){
                    ra_HP_now = ra_HP_now - orCircle_Attack * orCircle_SK3_Attack / 100;

                    for(int i = 0; i < orCircle_SK3_WeakenPercent; i++){
                        percent[i] = 1;
                    }
                    if(orCircle_SK3_WeakenPercent < 100){
                        for(int i = orCircle_SK3_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    weakenTurn = weakenTurn + percent[randomNumber];

                    orCircle_SK3_cooltime_now = orCircle_SK3_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeCircle_battle.setImageResource(R.drawable.orange_circle);
                    if(orCircle_SK2_cooltime_now > 0 && orCircle_SK2_cooltime_now <= orCircle_SK2_cooltime){
                        orCircle_SK3_cooltime_now--;
                    }
                    if(orCircle_SK3_cooltime_now > 0 && orCircle_SK3_cooltime_now < orCircle_SK3_cooltime){
                        orCircle_SK3_cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(blTriangle_HP_now > 0){
                    ra_HP_now = ra_HP_now - (blTriangle_Attack * blTriangle_SK3_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackTriangle_battle.setImageResource(R.drawable.black_triangle);

                    blTriangle_SK3_cooltime_now = blTriangle_SK3_cooltime;

                    if(blTriangle_SK2_cooltime_now > 0 && blTriangle_SK2_cooltime_now <= blTriangle_SK2_cooltime){
                        blTriangle_SK2_cooltime_now--;
                    }

                    if(blTriangle_SK3_cooltime_now > 0 && blTriangle_SK3_cooltime_now < blTriangle_SK3_cooltime){
                        blTriangle_SK3_cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(blTriangle_strengthen_Turn > 0){
                        blTriangle_strengthen_Turn--;
                    }
                    else if(blTriangle_strengthen_Turn == 0){
                        blTriangle_Attack = blTriangle_Attack - ((100 + blTriangle_SK2_strengthen) / 100);
                    }
                    turnNumber++;
                    start();
                }
            }
            else if(turnNumber == 3){
                if(blStrip_HP_now > 0){
                    for(int i = 0; i < blStrip_SK3_WeakenPercent; i++){
                        percent[i] = 2;
                    }
                    if(blStrip_SK3_WeakenPercent < 100){
                        for(int i = blStrip_SK3_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    cantHeal = cantHeal + percent[randomNumber];

                    ra_HP_now = ra_HP_now - (blStrip_Attack * blStrip_SK3_Attack / 100);
                    ra_HP_now = ra_HP_now - (blStrip_Attack * blStrip_SK3_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackStrip_battle.setImageResource(R.drawable.black_strip);

                    blStrip_SK3_cooltime_now = blStrip_SK3_cooltime;

                    if(orCircle_SK2_cooltime_now > 0){
                        orCircle_SK2_cooltime_now = orCircle_SK2_cooltime_now - 2;
                    }
                    if(orCircle_SK2_cooltime_now < 0){
                        orCircle_SK2_cooltime_now = 0;
                    }
                    if(orCircle_SK3_cooltime_now > 0){
                        orCircle_SK3_cooltime_now = orCircle_SK3_cooltime_now - 2;
                    }
                    if(orCircle_SK3_cooltime_now < 0){
                        orCircle_SK3_cooltime_now = 0;
                    }

                    if(blTriangle_SK2_cooltime_now > 0){
                        blTriangle_SK2_cooltime_now = blTriangle_SK2_cooltime_now - 2;
                    }
                    if(blTriangle_SK2_cooltime_now < 0){
                        blTriangle_SK2_cooltime_now = 0;
                    }
                    if(blTriangle_SK3_cooltime_now > 0){
                        blTriangle_SK3_cooltime_now = blTriangle_SK3_cooltime_now - 2;
                    }
                    if(blTriangle_SK3_cooltime_now < 0){
                        blTriangle_SK3_cooltime_now = 0;
                    }
                    if(blStrip_SK2_cooltime_now > 0){
                        blStrip_SK2_cooltime_now = blStrip_SK2_cooltime_now - 2;
                    }
                    if(blStrip_SK2_cooltime_now < 0){
                        blStrip_SK2_cooltime_now = 0;
                    }
                    if(blStrip_SK3_cooltime_now > 0){
                        blStrip_SK3_cooltime_now = blStrip_SK3_cooltime_now - 2;
                    }
                    if(blStrip_SK3_cooltime_now < 0){
                        blStrip_SK3_cooltime_now = 0;
                    }

                    if(blStrip_SK2_cooltime_now > 0 && blStrip_SK2_cooltime_now <= blStrip_SK2_cooltime){
                        blStrip_SK2_cooltime_now--;
                    }
                    if(blStrip_SK3_cooltime_now > 0 && blStrip_SK3_cooltime_now < blStrip_SK3_cooltime){
                        blStrip_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(blStrip_strengthen_Turn > 0){
                        blStrip_strengthen_Turn--;
                    }
                    else if(blStrip_strengthen_Turn == 0){
                        blStrip_Attack = blStrip_Attack - ((100 + blTriangle_SK2_strengthen) / 100);
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
                skill3Text = "對敵人造成" + orCircle_SK3_Attack + "%威力的攻擊，" + orCircle_SK3_WeakenPercent + "%的機率讓敵人攻擊減少50%\ncool time:" + orCircle_SK3_cooltime;
            }
            else if(turnNumber == 2){
                skill3Text = "對敵人造成" + blTriangle_SK3_Attack + "%威力的傷害";
            }
            else if(turnNumber == 3){
                skill3Text = "對敵人造成" + blStrip_SK3_Attack + "%威力的2回傷害，" + blStrip_SK3_WeakenPercent + "%的機率讓敵人回復不能2回合且我方cool time 減少2回合\ncool time:" + blStrip_SK3_cooltime;
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
        View view = LayoutInflater.from(context).inflate(R.layout.activity_normal_skill , null);
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
        money = money + 50000;
        editor.putInt("writeMoney" , money);
        editor.commit();

        TextView normal_state;
        TextView normal_money;
        Button normal_check;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_normal_state , null);
        state = new PopupWindow(view);
        state.setWidth(width * 4/5);
        state.setHeight(height * 3/7);
        state.setFocusable(false);

        normal_state = (TextView)view.findViewById(R.id.normal_state);
        normal_money = (TextView)view.findViewById(R.id.normal_money);
        normal_check = (Button)view.findViewById(R.id.normal_check);

        skill1.setVisibility(View.INVISIBLE);
        skill2.setVisibility(View.INVISIBLE);
        skill3.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

        normal_check.setOnClickListener(close);

        normal_state.setText("勝利");
        normal_money.setText("獲得50000G");
    }

    private void initPopupWindow_show_state_fail(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        TextView normal_state;
        TextView normal_money;
        Button normal_check;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_normal_state , null);
        state = new PopupWindow(view);
        state.setWidth(width * 4/5);
        state.setHeight(height * 3/7);
        state.setFocusable(false);

        normal_state = (TextView)view.findViewById(R.id.normal_state);
        normal_money = (TextView)view.findViewById(R.id.normal_money);
        normal_check = (Button)view.findViewById(R.id.normal_check);

        skill1.setVisibility(View.INVISIBLE);
        skill2.setVisibility(View.INVISIBLE);
        skill3.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

        normal_check.setOnClickListener(close);

        normal_state.setText("失敗");
        normal_money.setText("再提升喵咪的等級與技能吧");
    }

    private View.OnClickListener close = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            state.dismiss();
            Intent intent = new Intent();
            intent.setClass(normal.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        orCircle_HP = sharedPref.getInt("writeCharacter3HP" , 0);
        orCircle_HP_now = orCircle_HP;
        orCircle_Attack = sharedPref.getInt("writeCharacter3Attack" , 0);
        orCircle_Attack_temp = orCircle_Attack;
        orCircle_SK1_Attack = sharedPref.getInt("writeCharacter3Skill1_attack" , 0);
        orCircle_SK2_Heal = sharedPref.getInt("writeCharacter3Skill2_heal" , 0);
        orCircle_SK2_cooltime = sharedPref.getInt("writeCharacter3Skill2_cooltime" , 0);
        orCircle_SK2_cooltime_now = 0;
        orCircle_SK3_Attack = sharedPref.getInt("writeCharacter3Skill3_attack" , 0);
        orCircle_SK3_WeakenPercent = sharedPref.getInt("writeCharacter3Skill3_weakenPercent" , 0);
        orCircle_SK3_Weaken = sharedPref.getInt("writeCharacter3Skill3_weaken" , 0);
        orCircle_SK3_cooltime = sharedPref.getInt("writeCharacter3Skill3_cooltime" , 0);
        orCircle_SK3_cooltime_now = 0;

        blTriangle_HP = sharedPref.getInt("writeCharacter5HP" , 0);
        blTriangle_HP_now = blTriangle_HP;
        blTriangle_Attack = sharedPref.getInt("writeCharacter5Attack" , 0);
        blTriangle_SK1_Attack = sharedPref.getInt("writeCharacter5Skill1_attack" , 0);
        blTriangle_SK2_strengthen = sharedPref.getInt("writeCharacter5Skill2_strengthen" , 0);
        blTriange_SK2_Heal = sharedPref.getInt("writeCharacter5Skill2_heal" , 0);
        blTriangle_SK2_cooltime = sharedPref.getInt("writeCharacter5Skill2_cooltime" , 0);
        blTriangle_SK2_cooltime_now = 0;
        blTriangle_SK3_Attack = sharedPref.getInt("writeCharacter5Skill3_attack" , 0);
        blTriangle_SK3_cooltime = sharedPref.getInt("writeCharacter5Skill3_cooltime" , 0);
        blTriangle_SK3_cooltime_now = 0;

        blStrip_HP = sharedPref.getInt("writeCharacter11HP" , 0);
        blStrip_HP_now = blStrip_HP;
        blStrip_Attack = sharedPref.getInt("writeCharacter11Rank" , 0);
        blStrip_SK1_Attack = sharedPref.getInt("writeCharacter11Skill1_attack" , 0);
        blStrip_SK1_WeakenPercent = sharedPref.getInt("writeCharacter11Skill1_weakenPercent" , 0);
        blStrip_SK1_WeakenTurn = sharedPref.getInt("writeCharacter11Skill1_weakenTurn" , 0);
        blStrip_SK2_Heal = sharedPref.getInt("writeCharacter11Skill2_heal" , 0);
        blStrip_SK2_StrengthenTurn = sharedPref.getInt("writeCharacter11Skill2_strengthenTurn" , 0);
        blStrip_SK2_cooltime = sharedPref.getInt("writeCharacter11Skill2_cooltime" , 0);
        blStrip_SK2_cooltime_now = 0;
        blStrip_SK3_Attack = sharedPref.getInt("writeCharacter11Skill3_attack" , 0);
        blStrip_SK3_WeakenPercent = sharedPref.getInt("writeCharacter11Skill3_weakenPercent" , 0);
        blStrip_SK3_Strengthen = sharedPref.getInt("writeCharacter11Skill3_weakenTurn" , 0);
        blStrip_SK3_cooltime = sharedPref.getInt("writeCharacter11Skill3_cooltime" , 0);
        blStrip_SK3_cooltime_now = 0;
        ra_HP = sharedPref.getInt("writeRabbit2HP" , 0);
        ra_HP_now = ra_HP;
        ra_Attack = sharedPref.getInt("writeRabbkt2Attack" , 0);
        orangeCircle_HP.setText(orCircle_HP_now + "\n/" + orCircle_HP);
        blackTriangle_HP.setText(blTriangle_HP_now + "\n/" + blTriangle_HP);
        blackStrip_HP.setText(blStrip_HP_now + "\n/" + blStrip_HP);
        rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
    }
}