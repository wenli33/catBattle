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

public class hard extends AppCompatActivity {
    private Context context;
    private Button stop;
    private ImageView whiteCircle_battle;
    private ImageView whiteCarton_battle;
    private ImageView orangeStrip_battle;
    private ImageView rabbit;
    private TextView whiteCircle_HP;
    private TextView whiteCarton_HP;
    private TextView orangeStrip_HP;
    private TextView rabbit_HP;
    private TextView turn;
    private ImageButton skill1;
    private ImageButton skill2;
    private ImageButton skill3;
    private int turnNumber = 1;
    private int whCircle_HP;
    private int whCircle_HP_now;
    private int whCircle_Attack;
    private int whCircle_SK1_Attack;
    private int whCircle_SK2_Heal;
    private int whCircle_SK2_cooltime;
    private int whCircle_SK2_cooltime_now;
    private int whCircle_SK3_Attack;
    private int whCircle_SK3_cooltime;
    private int whCircle_SK3_cooltime_now;

    private int whCarton_HP;
    private int whCarton_HP_now;
    private int whCarton_Attack;
    private int whCarton_SK1_Attack;
    private int whCarton_SK2_strengthen;
    private int whCircle_strengthen_Turn;
    private int whCarton_strengthen_Turn;
    private int orStrip_strengthen_Turn;
    private int whCarton_SK2_cooltime;
    private int whCarton_SK2_cooltime_now;
    private int whCarton_SK3_Attack;
    private int whCarton_SK3_WeakenPercent;
    private int whCarton_SK3_cooltime;
    private int whCarton_SK3_cooltime_now;

    private int orStrip_HP;
    private int orStrip_HP_now;
    private int orStrip_Attack;
    private int orStrip_SK1_Attack;
    private int orStrip_SK1_WeakenPercent;
    private int orStrip_SK1_Weaken;
    private int orStrip_SK1_WeakenTurn;
    private int orStrip_SK2_Heal;
    private int orStrip_SK3_Attack;
    private int orStrip_SK3_WeakenPercent;
    private int orStrip_SK3_WeakenTurn;
    private int orStrip_SK3_cooltime;
    private int orStrip_SK3_cooltime_now;

    private int ra_HP;
    private int ra_HP_now;
    private int ra_Attack;
    private int ra_Attack_temp;
    private int cantAction;
    private int cantHeal;
    private int weakenTurn;
    private int weakenTurntrue = 0;
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
        setContentView(R.layout.activity_hard);
        getSupportActionBar().hide();

        context = this;
        stop = (Button)findViewById(R.id.stop);
        popup = (RelativeLayout)findViewById(R.id.popup);
        whiteCircle_battle = (ImageView)findViewById(R.id.whiteCircle_battle);
        whiteCarton_battle = (ImageView)findViewById(R.id.whiteCarton_battle);
        orangeStrip_battle = (ImageView)findViewById(R.id.orangeStrip_battle);
        rabbit = (ImageView)findViewById(R.id.rabbit);
        whiteCircle_HP = (TextView)findViewById(R.id.whiteCircle_HP);
        whiteCarton_HP = (TextView)findViewById(R.id.whiteCarton_HP);
        orangeStrip_HP = (TextView)findViewById(R.id.orangeStrip_HP);
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
            intent.setClass(hard.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private void start(){
        if(turnNumber == 1){
            if(whCircle_HP_now > 0) {
                turn.setText("現在是白色圓型喵咪的回合:" + turnNumber);
                whiteCircle_battle.setImageResource(R.drawable.white_circle_battle);
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
                if(whCircle_SK2_cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.heal_10);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.heal_9);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.heal_8);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.heal_7);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.heal_6);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.heal_5);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.heal_4);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.heal_3);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.heal_2);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.heal_1);
                    skill2.setEnabled(false);
                }
                else if(whCircle_SK2_cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.heal);
                    skill2.setEnabled(true);
                }
                if(whCircle_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(whCircle_SK3_cooltime_now == 0){
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
            if(whCarton_HP_now > 0){
                turn.setText("現在是白色紙箱喵咪的回合:" + turnNumber);
                whiteCarton_battle.setImageResource(R.drawable.white_carton_battle);
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
                if(whCarton_SK2_cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.strengthen_10);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.strengthen_9);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.strengthen_8);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.strengthen_7);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.strengthen_6);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.strengthen_5);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.strengthen_4);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.strengthen_3);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.strengthen_2);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.strengthen_1);
                    skill2.setEnabled(false);
                }
                else if(whCarton_SK2_cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.strengthen);
                    skill2.setEnabled(true);
                }
                if(whCarton_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(whCarton_SK3_cooltime_now == 0){
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
            if(orStrip_HP_now > 0){
                if(whCircle_HP_now > 0 && whCircle_HP_now <= whCircle_HP){
                    whCircle_HP_now = whCircle_HP_now + whCircle_HP * orStrip_SK2_Heal / 100;
                }
                if(whCarton_HP_now > 0 && whCarton_HP_now <= whCarton_HP){
                    whCarton_HP_now = whCarton_HP_now + whCarton_HP * orStrip_SK2_Heal / 100;
                }

                if(orStrip_HP_now > 0 && orStrip_HP_now <= orStrip_HP) {
                    orStrip_HP_now = orStrip_HP_now + orStrip_HP * orStrip_SK2_Heal / 100;
                }

                if(whCircle_HP_now > whCircle_HP){
                    whCircle_HP_now = whCircle_HP;
                }
                if(whCarton_HP_now > whCarton_HP){
                    whCarton_HP_now = whCarton_HP;
                }
                if(orStrip_HP_now > orStrip_HP){
                    orStrip_HP_now = orStrip_HP;
                }
                whiteCircle_HP.setText(whCircle_HP_now + "\n/" + whCircle_HP);
                whiteCarton_HP.setText(whCarton_HP_now + "\n/" + whCarton_HP);
                orangeStrip_HP.setText(orStrip_HP_now + "\n/" + orStrip_HP);
                turn.setText("現在橘色長條喵咪的回合:" + turnNumber);
                orangeStrip_battle.setImageResource(R.drawable.orange_strip_battle);
                skill1.setBackgroundResource(R.drawable.attack1);
                skill2.setBackgroundResource(R.drawable.auto);
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
                if(orStrip_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(orStrip_SK3_cooltime_now == 0){
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
                    if(cantHeal > 0){
                        cantHeal--;
                        ra_HP_now = ra_HP_now - (ra_HP * 5 / 100);
                    }

                    ra_HP_now = ra_HP_now + (ra_HP * 10 / 100);
                    if(ra_HP_now >= ra_HP){
                        ra_HP_now = ra_HP;
                    }
                    ra_Attack = ra_Attack_temp;
                    if(weakenTurn > 0 && weakenTurntrue == 0){
                        ra_Attack = ra_Attack - ra_Attack * (orStrip_SK1_Weaken / 100);
                        weakenTurn--;
                        weakenTurntrue = 1;
                    }
                    else if(weakenTurn > 0 && weakenTurntrue == 1){
                        ra_Attack = ra_Attack - ra_Attack * (orStrip_SK1_Weaken / 100);
                        weakenTurn--;
                       weakenTurntrue = 1;
                    }
                    else if(weakenTurn == 0 && weakenTurntrue == 1){
                        ra_Attack = ra_Attack + ra_Attack * (orStrip_SK1_Weaken / 100);
                        weakenTurntrue = 0;
                    }
                    /*
                    if(weakenTurn > 0){
                        weakenTurn--;
                    }
                    else if(weakenTurn == 0){
                        ra_Attack = ra_Attack_temp;
                    }
                    */

                    if(whCircle_HP_now > 0){
                        whCircle_HP_now = whCircle_HP_now - ra_Attack;
                    }

                    if(whCircle_HP_now <= 0){
                        whCircle_HP_now = 0;
                    }
                    if(whCarton_HP_now > 0){
                        whCarton_HP_now = whCarton_HP_now - ra_Attack;
                    }

                    if(whCarton_HP_now <= 0){
                        whCarton_HP_now = 0;
                    }
                    if(orStrip_HP_now > 0){
                        orStrip_HP_now = orStrip_HP_now - ra_Attack;
                    }
                    if(orStrip_HP_now <= 0){
                        orStrip_HP_now = 0;
                    }
                    whiteCircle_HP.setText(whCircle_HP_now + "\n/" + whCircle_HP);
                    whiteCarton_HP.setText(whCarton_HP_now + "\n/" + whCarton_HP);
                    orangeStrip_HP.setText(orStrip_HP_now + "\n/" + orStrip_HP);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);

                    if(whCircle_HP_now <= 0){
                        whiteCircle_HP.setText(0 + "\n/" + whCircle_HP);
                        whiteCircle_battle.setImageResource(R.drawable.background_white);
                    }

                    if(whCarton_HP_now <= 0){
                        whiteCarton_HP.setText(0 + "\n/" + whCarton_HP);
                        whiteCarton_battle.setImageResource(R.drawable.background_white);
                    }

                    if(orStrip_HP_now <= 0){
                        orangeStrip_HP.setText(0 + "\n/" + orStrip_HP);
                        orangeStrip_battle.setImageResource(R.drawable.background_white);
                    }
                    if(whCircle_HP_now <= 0 || whCarton_HP_now <= 0 || orStrip_HP_now <= 0){
                        initPopupWindow_show_state_fail();
                        state.showAtLocation(popup , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }
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
                if(whCircle_HP_now > 0){
                    ra_HP_now = ra_HP_now - (whCircle_Attack * whCircle_SK1_Attack / 100);
                    ra_HP_now = ra_HP_now - (whCircle_Attack * whCircle_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteCircle_battle.setImageResource(R.drawable.white_circle);

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }
                    if(whCircle_SK2_cooltime_now > 0 && whCircle_SK2_cooltime_now <= whCircle_SK2_cooltime){
                        whCircle_SK2_cooltime_now--;
                    }
                    if(whCircle_SK3_cooltime_now > 0 && whCircle_SK3_cooltime_now <= whCircle_SK3_cooltime){
                        whCircle_SK3_cooltime_now--;
                    }
                    if(whCircle_strengthen_Turn > 0){
                        whCircle_strengthen_Turn--;
                    }
                    else if(whCircle_strengthen_Turn == 0){
                        whCircle_Attack = whCircle_Attack - ((100 + whCarton_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(whCarton_HP_now > 0){
                    ra_HP_now = ra_HP_now - (whCarton_Attack * whCarton_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteCarton_battle.setImageResource(R.drawable.white_carton);

                    if(whCarton_SK2_cooltime_now > 0 && whCarton_SK2_cooltime_now <= whCarton_SK2_cooltime){
                        whCarton_SK2_cooltime_now--;
                    }

                    if(whCarton_SK3_cooltime_now > 0 && whCarton_SK3_cooltime_now <= whCarton_SK3_cooltime){
                        whCarton_SK3_cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(whCarton_strengthen_Turn > 0){
                        whCarton_strengthen_Turn--;
                    }
                    else if(whCarton_strengthen_Turn == 0){
                        whCarton_Attack = whCarton_Attack - ((100 + whCarton_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 3){
                if(orStrip_HP_now > 0){
                    for(int i = 0; i < orStrip_SK3_WeakenPercent; i++){
                        percent[i] = 2;
                    }
                    if(orStrip_SK3_WeakenPercent < 100){
                        for(int i = orStrip_SK3_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    weakenTurn = weakenTurn + percent[randomNumber];
                    if(weakenTurn > 0){
                        ra_Attack = ra_Attack * (orStrip_SK1_Weaken / 100);
                    }

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeStrip_battle.setImageResource(R.drawable.orange_strip);

                    if(orStrip_SK3_cooltime_now > 0 && orStrip_SK3_cooltime_now <= orStrip_SK3_cooltime){
                        orStrip_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(orStrip_strengthen_Turn > 0){
                        orStrip_strengthen_Turn--;
                    }
                    else if(orStrip_strengthen_Turn == 0){
                        orStrip_Attack = orStrip_Attack - ((100 + whCarton_SK2_strengthen) / 100);
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
                skill1Text = "對敵人造成" + whCircle_SK1_Attack + "%威力的2回攻擊";
            }
            else if(turnNumber == 2){
                skill1Text = "對敵人造成" + whCarton_SK1_Attack + "%威力的攻擊";
            }
            else if(turnNumber == 3){
                skill1Text = "對敵人造成" + orStrip_SK1_Attack + "%威力的攻擊，" + orStrip_SK1_WeakenPercent + "%的機率讓敵人攻擊減少50%2回合";
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
                if(whCircle_HP_now > 0){

                    if(whCircle_HP_now > 0 && whCircle_HP_now <= whCircle_HP){
                        whCircle_HP_now = whCircle_HP_now + whCircle_HP * whCircle_SK2_Heal / 100;
                    }
                    if(whCarton_HP_now > 0 && whCarton_HP_now <= whCarton_HP){
                        whCarton_HP_now = whCarton_HP_now + whCarton_HP * whCircle_SK2_Heal / 100;
                    }
                    if(orStrip_HP_now > 0 && orStrip_HP_now <= orStrip_HP){
                        orStrip_HP_now = orStrip_HP_now + orStrip_HP * whCircle_SK2_Heal / 100;
                    }


                    if(whCircle_HP_now > whCircle_HP){
                        whCircle_HP_now = whCircle_HP;
                    }
                    if(whCarton_HP_now > whCarton_HP){
                        whCarton_HP_now = whCarton_HP;
                    }
                    if(orStrip_HP_now > orStrip_HP){
                        orStrip_HP_now = orStrip_HP;
                    }
                    whiteCircle_HP.setText(whCircle_HP_now + "\n/" + whCircle_HP);
                    whiteCarton_HP.setText(whCarton_HP_now + "\n/" + whCarton_HP);
                    orangeStrip_HP.setText(orStrip_HP_now + "\n/" + orStrip_HP);

                    whCircle_SK2_cooltime_now = whCircle_SK2_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteCircle_battle.setImageResource(R.drawable.white_circle);

                    if(whCircle_SK2_cooltime_now > 0 && whCircle_SK2_cooltime_now < whCircle_SK2_cooltime){
                        whCircle_SK2_cooltime_now--;
                    }
                    if(whCircle_SK3_cooltime_now > 0 && whCircle_SK3_cooltime_now <= whCircle_SK3_cooltime){
                        whCircle_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(whCircle_strengthen_Turn > 0){
                        whCircle_strengthen_Turn--;
                    }
                    else if(whCircle_strengthen_Turn == 0){
                        whCircle_Attack = whCircle_Attack - ((100 + whCarton_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(whCarton_HP_now > 0){
                    whCircle_Attack = whCircle_Attack * ((100 + whCarton_SK2_strengthen) / 100);
                    whCarton_Attack = whCarton_Attack * ((100 + whCarton_SK2_strengthen) / 100);
                    orStrip_Attack = orStrip_Attack * ((100 + whCarton_SK2_strengthen) / 100);

                    whCircle_strengthen_Turn = 1;
                    whCarton_strengthen_Turn = 1;
                    orStrip_strengthen_Turn = 1;

                    whCarton_SK2_cooltime_now = whCarton_SK2_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteCarton_battle.setImageResource(R.drawable.white_carton);

                    if(whCarton_SK2_cooltime_now > 0 && whCarton_SK2_cooltime_now < whCarton_SK2_cooltime){
                        whCarton_SK2_cooltime_now--;
                    }
                    if(whCarton_SK3_cooltime_now > 0 && whCarton_SK3_cooltime_now <= whCarton_SK3_cooltime){
                        whCarton_SK3_cooltime_now--;
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
                skill2Text = "對我方全體回復" + whCircle_SK2_Heal + "%HP\ncool time:" + whCircle_SK2_cooltime + "回";
            }
            else if(turnNumber == 2){
                skill2Text = "對我方全員攻擊增加" + whCarton_SK2_strengthen + "%\ncool time:" + whCarton_SK2_cooltime + "回";
            }
            else if(turnNumber == 3){
                skill2Text = "[自動發動]回合開始時，我方全體100%的機率回復最大HP的" + orStrip_SK2_Heal + "%";
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
                if(whCircle_HP_now > 0){
                    ra_HP_now = ra_HP_now - whCircle_Attack * whCircle_SK3_Attack / 100;

                    whCircle_SK3_cooltime_now = whCircle_SK3_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteCircle_battle.setImageResource(R.drawable.white_circle);
                    if(whCircle_SK2_cooltime_now > 0 && whCircle_SK2_cooltime_now <= whCircle_SK2_cooltime){
                        whCircle_SK2_cooltime_now--;
                    }
                    if(whCircle_SK3_cooltime_now > 0 && whCircle_SK3_cooltime_now < whCircle_SK3_cooltime){
                        whCircle_SK3_cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(whCircle_strengthen_Turn > 0){
                        whCircle_strengthen_Turn--;
                    }
                    else if(whCircle_strengthen_Turn == 0){
                        whCircle_Attack = whCircle_Attack - ((100 + whCarton_SK2_strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(whCarton_HP_now > 0){
                    ra_HP_now = ra_HP_now - (whCarton_Attack * whCarton_SK3_Attack / 100);
                    ra_HP_now = ra_HP_now - (whCarton_Attack * whCarton_SK3_Attack / 100);
                    ra_HP_now = ra_HP_now - (whCarton_Attack * whCarton_SK3_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    whiteCarton_battle.setImageResource(R.drawable.white_carton);

                    for(int i = 0; i < whCarton_SK3_WeakenPercent; i++){
                        percent[i] = 2;
                    }
                    if(whCarton_SK3_WeakenPercent < 100){
                        for(int i = whCarton_SK3_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    cantAction = cantAction + percent[randomNumber];

                    whCarton_SK3_cooltime_now = whCarton_SK3_cooltime;

                    if(whCarton_SK2_cooltime_now > 0 && whCarton_SK2_cooltime_now <= whCarton_SK2_cooltime){
                        whCarton_SK2_cooltime_now--;
                    }

                    if(whCarton_SK3_cooltime_now > 0 && whCarton_SK3_cooltime_now < whCarton_SK3_cooltime){
                        whCarton_SK3_cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(whCarton_strengthen_Turn > 0){
                        whCarton_strengthen_Turn--;
                    }
                    else if(whCarton_strengthen_Turn == 0){
                        whCarton_Attack = whCarton_Attack - ((100 + whCarton_SK2_strengthen) / 100);
                    }
                    turnNumber++;
                    start();
                }
            }
            else if(turnNumber == 3){
                if(orStrip_HP_now > 0){
                    for(int i = 0; i < orStrip_SK3_WeakenPercent; i++){
                        percent[i] = 2;
                    }
                    if(orStrip_SK3_WeakenPercent < 100){
                        for(int i = orStrip_SK3_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    cantHeal = cantHeal + percent[randomNumber];
                    cantAction = cantAction + percent[randomNumber];

                    ra_HP_now = ra_HP_now - (orStrip_Attack * orStrip_SK3_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeStrip_battle.setImageResource(R.drawable.orange_strip);

                    orStrip_SK3_cooltime_now = orStrip_SK3_cooltime;

                    if(orStrip_SK3_cooltime_now > 0 && orStrip_SK3_cooltime_now <= orStrip_SK3_cooltime){
                        orStrip_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(orStrip_strengthen_Turn > 0){
                        orStrip_strengthen_Turn--;
                    }
                    else if(orStrip_strengthen_Turn == 0){
                        orStrip_Attack = orStrip_Attack - ((100 + whCarton_SK2_strengthen) / 100);
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
                skill3Text = "對敵人造成" + whCircle_SK3_Attack + "%威力的攻擊\ncool time:" + whCircle_SK3_cooltime;
            }
            else if(turnNumber == 2){
                skill3Text = "對敵人造成" + whCarton_SK3_Attack + "%威力的3回傷害，" + whCarton_SK3_WeakenPercent + "%的機率讓敵人行動不能2回合\ncool time:" + whCarton_SK3_cooltime;
            }
            else if(turnNumber == 3){
                skill3Text = "對敵人造成" + orStrip_SK3_Attack + "%威力的傷害，" + orStrip_SK3_WeakenPercent + "%的機率讓敵人2回合扣除最大HP的5%且行動不能2回合\ncool time:" + orStrip_SK3_cooltime;
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
        View view = LayoutInflater.from(context).inflate(R.layout.activity_hard_skill , null);
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
        money = money + 80000;
        editor.putInt("writeMoney" , money);
        editor.commit();

        TextView hard_state;
        TextView hard_money;
        Button hard_check;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_hard_state , null);
        state = new PopupWindow(view);
        state.setWidth(width * 4/5);
        state.setHeight(height * 3/7);
        state.setFocusable(false);

        hard_state = (TextView)view.findViewById(R.id.hard_state);
        hard_money = (TextView)view.findViewById(R.id.hard_money);
        hard_check = (Button)view.findViewById(R.id.hard_check);

        skill1.setVisibility(View.INVISIBLE);
        skill2.setVisibility(View.INVISIBLE);
        skill3.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

        hard_check.setOnClickListener(close);

        hard_state.setText("勝利");
        hard_money.setText("獲得80000G");
    }

    private void initPopupWindow_show_state_fail(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        TextView hard_state;
        TextView hard_money;
        Button hard_check;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_hard_state , null);
        state = new PopupWindow(view);
        state.setWidth(width * 4/5);
        state.setHeight(height * 3/7);
        state.setFocusable(false);

        hard_state = (TextView)view.findViewById(R.id.hard_state);
        hard_money = (TextView)view.findViewById(R.id.hard_money);
        hard_check = (Button)view.findViewById(R.id.hard_check);

        skill1.setVisibility(View.INVISIBLE);
        skill2.setVisibility(View.INVISIBLE);
        skill3.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

        hard_check.setOnClickListener(close);

        hard_state.setText("失敗");
        hard_money.setText("再提升喵咪的等級與技能吧");
    }

    private View.OnClickListener close = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            state.dismiss();
            Intent intent = new Intent();
            intent.setClass(hard.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        whCircle_HP = sharedPref.getInt("writeCharacter1HP" , 0);
        whCircle_HP_now = whCircle_HP;
        whCircle_Attack = sharedPref.getInt("writeCharacter1Attack" , 0);
        whCircle_SK1_Attack = sharedPref.getInt("writeCharacter1Skill1_attack" , 0);
        whCircle_SK2_Heal = sharedPref.getInt("writeCharacter1Skill2_heal" , 0);
        whCircle_SK2_cooltime = sharedPref.getInt("writeCharacter1Skill2_cooltime" , 0);
        whCircle_SK2_cooltime_now = 0;
        whCircle_SK3_Attack = sharedPref.getInt("writeCharacter1Skill3_attack" , 0);
        whCircle_SK3_cooltime = sharedPref.getInt("writeCharacter1Skill3_cooltime" , 0);
        whCircle_SK3_cooltime_now = 0;

        whCarton_HP = sharedPref.getInt("writeCharacter7HP" , 0);
        whCarton_HP_now = whCarton_HP;
        whCarton_Attack = sharedPref.getInt("writeCharacter7Attack" , 0);
        whCarton_SK1_Attack = sharedPref.getInt("writeCharacter7Skill1_attack" , 0);
        whCarton_SK2_strengthen = sharedPref.getInt("writeCharacter7Skill2_strengthen" , 0);
        whCarton_SK2_cooltime = sharedPref.getInt("writeCharacter7Skill2_cooltime" , 0);
        whCarton_SK2_cooltime_now = 0;
        whCarton_SK3_Attack = sharedPref.getInt("writeCharacter7Skill3_attack" , 0);
        whCarton_SK3_WeakenPercent = sharedPref.getInt("writeCharacter7Skill3_weakenPercent" , 0);
        whCarton_SK3_cooltime = sharedPref.getInt("writeCharacter7Skill3_cooltime" , 0);
        whCarton_SK3_cooltime_now = 0;

        orStrip_HP = sharedPref.getInt("writeCharacter12HP" , 0);
        orStrip_HP_now = orStrip_HP;
        orStrip_Attack = sharedPref.getInt("writeCharacter12Attack" , 0);
        orStrip_SK1_Attack = sharedPref.getInt("writeCharacter12Skill1_attack" , 0);
        orStrip_SK1_WeakenPercent = sharedPref.getInt("writeCharacter12Skill1_weakenPercent" , 0);
        orStrip_SK1_Weaken = sharedPref.getInt("writeCharacter12Skill1_weaken" , 0);
        orStrip_SK2_Heal = sharedPref.getInt("writeCharacter12Skill2_heal" , 0);
        orStrip_SK3_Attack = sharedPref.getInt("writeCharacter12Skill3_attack" , 0);
        orStrip_SK3_WeakenPercent = sharedPref.getInt("writeCharacter12Skill3_weakenPercent" , 0);
        orStrip_SK3_WeakenTurn = sharedPref.getInt("writeCharacter12Skill3_weakenTurn" , 0);
        orStrip_SK3_cooltime = sharedPref.getInt("writeCharacter12Skill3_cooltime" , 0);
        orStrip_SK3_cooltime_now = 0;
        ra_HP = sharedPref.getInt("writeRabbit3HP" , 0);
        ra_HP_now = ra_HP;
        ra_Attack = sharedPref.getInt("writeRabbit3Attack" , 0);
        ra_Attack_temp = ra_Attack;
        whiteCircle_HP.setText(whCircle_HP_now + "\n/" + whCircle_HP);
        whiteCarton_HP.setText(whCarton_HP_now + "\n/" + whCarton_HP);
        orangeStrip_HP.setText(orStrip_HP_now + "\n/" + orStrip_HP);
        rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
    }
}