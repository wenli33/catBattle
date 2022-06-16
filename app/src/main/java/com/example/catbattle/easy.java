package com.example.catbattle;

import androidx.appcompat.app.AppCompatActivity;

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

import org.w3c.dom.Text;

import java.util.Random;

public class easy extends AppCompatActivity {
    private Context context;
    private Button stop;
    private RelativeLayout popup;
    private ImageView blackCircle_battle;
    private ImageView blackCarton_battle;
    private ImageView orangeCarton_battle;
    private ImageView rabbit;
    private TextView blackCircle_HP;
    private TextView blackCarton_HP;
    private TextView orangeCarton_HP;
    private TextView rabbit_HP;
    private TextView turn;
    private ImageButton skill1;
    private ImageButton skill2;
    private ImageButton skill3;
    private int turnNumber = 1;
    private int blCircle_HP;
    private int blCircle_HP_now;
    private int blCircle_Attack;
    private int blCircle_SK1_Attack;
    private int blCircle_SK2_Attack;
    private int blCircle_SK2_Heal;
    private int blCircle_SK2_Cooltime;
    private int blCircle_SK2_Cooltime_now;
    private int blCircle_SK3_Strengthen;
    private int blCircle_SK3_cooltime;
    private int blCircle_SK3_cooltime_now;
    private int blCircle_strengthen_turn;
    private int blCarton_strengthen_turn;
    private int orCarton_strengthen_turn;
    private int blCarton_HP;
    private int blCarton_HP_now;
    private int blCarton_Attack;
    private int blCarton_SK1_Attack;
    private int blCarton_SK1_WeakenPercent;
    private int blCarton_SK2_Heal;
    private int blCarton_SK3_Attack;
    private int blCarton_SK3_WeakenPercent;
    private int blCarton_SK3_Weaken;
    private int blCarton_SK3_WeakenTurn;
    private int blCarton_SK3_Cooltime;
    private int blCarton_SK3_Cooltime_now;
    private int orCarton_HP;
    private int orCarton_HP_now;
    private int orCarton_Attack;
    private int orCarton_SK1_Attack;
    private int orCarton_SK1_WeakenPercent;
    private int orCarton_SK2_Heal;
    private int orCarton_SK2_Cooltime;
    private int orCarton_SK2_cooltime_now;
    private int orCarton_SK3_Attack;
    private int orCarton_SK3_WeakenPercent;
    private int orCarton_SK3_Weaken;
    private int orCarton_SK3_WeakenTurn;
    private int orCarton_SK3_Cooltime;
    private int orCarton_SK3_Cooltime_now;
    private int ra_HP;
    private int ra_HP_now;
    private int ra_Attack;
    private int ra_Attack_temp;
    private int cantHeal;
    private int weakenTurn;
    private int weakenTurntrue;

    private int randomNumber;
    private int[] percent = new int[100];
    private boolean isSkill1LongPressed = false;
    private PopupWindow skill_Content = null;
    private PopupWindow state = null;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        getSupportActionBar().hide();

        context = this;
        popup = (RelativeLayout)findViewById(R.id.popup);
        stop = (Button)findViewById(R.id.stop);
        blackCircle_battle = (ImageView)findViewById(R.id.blackCircle_battle);
        blackCarton_battle = (ImageView)findViewById(R.id.blackCarton_battle);
        orangeCarton_battle = (ImageView)findViewById(R.id.orangeCarton_battle);
        rabbit = (ImageView)findViewById(R.id.rabbit);
        blackCircle_HP = (TextView)findViewById(R.id.blackCircle_HP);
        blackCarton_HP = (TextView)findViewById(R.id.blackCarton_HP);
        orangeCarton_HP = (TextView)findViewById(R.id.orangeCarton_HP);
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
            intent.setClass(easy.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private void start(){
        if(turnNumber == 1){
            if(blCircle_HP_now > 0) {
                turn.setText("現在是黑色圓型喵咪的回合:" + turnNumber);
                blackCircle_battle.setImageResource(R.drawable.black_circle_battle);
                skill1.setBackgroundResource(R.drawable.attack1);
                skill2.setBackgroundResource(R.drawable.attack2);
                skill3.setBackgroundResource(R.drawable.strengthen);
                skill1.setOnClickListener(useSkill1);
                skill1.setOnLongClickListener(setSkill1Text);
                skill1.setOnTouchListener(closeSkill1Text);
                skill2.setOnClickListener(useSkill2);
                skill2.setOnLongClickListener(setSkill2Text);
                skill2.setOnTouchListener(closeSkill2Text);
                skill3.setOnClickListener(useSkill3);
                skill3.setOnLongClickListener(setSkill3Text);
                skill3.setOnTouchListener(closeSkill3Text);
                if(blCircle_SK2_Cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.attack2_10);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.attack2_9);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.attack2_8);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.attack2_7);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.attack2_6);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.attack2_5);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.attack2_4);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.attack2_3);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.attack2_2);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.attack2_1);
                    skill2.setEnabled(false);
                }
                else if(blCircle_SK2_Cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.attack2);
                    skill2.setEnabled(true);
                }
                if(blCircle_SK3_cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.strengthen_10);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.strengthen_9);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.strengthen_8);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.strengthen_7);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.strengthen_6);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.strengthen_5);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.strengthen_4);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.strengthen_3);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.strengthen_2);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.strengthen_1);
                    skill3.setEnabled(false);
                }
                else if(blCircle_SK3_cooltime_now == 0){
                    skill3.setBackgroundResource(R.drawable.strengthen);
                    skill3.setEnabled(true);
                }
            }
            else{
                turnNumber = 2;
                start();
            }
        }
        else if(turnNumber == 2){
            if(blCarton_HP_now > 0){
                turn.setText("現在是黑色紙箱喵咪的回合:" + turnNumber);
                blackCarton_battle.setImageResource(R.drawable.black_carton_battle);
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
                if(blCarton_SK3_Cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(blCarton_SK3_Cooltime_now == 0){
                    skill3.setBackgroundResource(R.drawable.attack3);
                    skill3.setEnabled(true);
                }
            }
            else{
                turnNumber = 3;
                start();
            }
        }
        else if(turnNumber == 3){
            if(orCarton_HP_now > 0){
                turn.setText("現在是橘色紙箱喵咪的回合:" + turnNumber);
                orangeCarton_battle.setImageResource(R.drawable.orange_carton_battle);
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
                if(orCarton_SK2_cooltime_now == 10){
                    skill2.setBackgroundResource(R.drawable.auto_10);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 9){
                    skill2.setBackgroundResource(R.drawable.auto_9);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 8){
                    skill2.setBackgroundResource(R.drawable.auto_8);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 7){
                    skill2.setBackgroundResource(R.drawable.auto_7);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 6){
                    skill2.setBackgroundResource(R.drawable.auto_6);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 5){
                    skill2.setBackgroundResource(R.drawable.auto_5);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 4){
                    skill2.setBackgroundResource(R.drawable.auto_4);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 3){
                    skill2.setBackgroundResource(R.drawable.auto_3);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 2){
                    skill2.setBackgroundResource(R.drawable.auto_2);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 1){
                    skill2.setBackgroundResource(R.drawable.auto_1);
                    skill2.setEnabled(false);
                }
                else if(orCarton_SK2_cooltime_now == 0){
                    skill2.setBackgroundResource(R.drawable.auto);
                    skill2.setEnabled(true);
                }
                if(orCarton_SK3_Cooltime_now == 10){
                    skill3.setBackgroundResource(R.drawable.attack3_10);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 9){
                    skill3.setBackgroundResource(R.drawable.attack3_9);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 8){
                    skill3.setBackgroundResource(R.drawable.attack3_8);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 7){
                    skill3.setBackgroundResource(R.drawable.attack3_7);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 6){
                    skill3.setBackgroundResource(R.drawable.attack3_6);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 5){
                    skill3.setBackgroundResource(R.drawable.attack3_5);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 4){
                    skill3.setBackgroundResource(R.drawable.attack3_4);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 3){
                    skill3.setBackgroundResource(R.drawable.attack3_3);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 2){
                    skill3.setBackgroundResource(R.drawable.attack3_2);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 1){
                    skill3.setBackgroundResource(R.drawable.attack3_1);
                    skill3.setEnabled(false);
                }
                else if(orCarton_SK3_Cooltime_now == 0){
                    skill3.setBackgroundResource(R.drawable.attack3);
                    skill3.setEnabled(true);
                }
            }
            else{
                turnNumber = 4;
                start();
            }
        }
        else if(turnNumber == 4){
            if(ra_HP_now > 0){
                if(cantHeal == 0){
                    ra_HP_now = ra_HP_now + ra_HP * 10 / 100;
                    if(ra_HP_now > ra_HP){
                        ra_HP_now = ra_HP;
                    }
                }
                else{
                    cantHeal--;
                }
                ra_Attack = ra_Attack_temp;
                if(weakenTurn > 0 && weakenTurntrue == 0){
                    ra_Attack = ra_Attack - ra_Attack * (blCarton_SK3_Weaken / 100);
                    weakenTurn--;
                    weakenTurntrue = 1;
                }
                else if(weakenTurn > 0 && weakenTurntrue == 1){
                    weakenTurn--;
                    weakenTurntrue = 1;
                }
                else if(weakenTurn == 0 && weakenTurntrue == 1){
                    ra_Attack = ra_Attack + ra_Attack * (blCarton_SK3_Weaken / 100);
                    weakenTurn--;
                    weakenTurntrue = 0;
                }


                blCircle_HP_now = blCircle_HP_now - ra_Attack;
                blCarton_HP_now = blCarton_HP_now - ra_Attack;
                orCarton_HP_now = orCarton_HP_now - ra_Attack;
                blackCircle_HP.setText(blCircle_HP_now + "\n/" + blCircle_HP);
                blackCarton_HP.setText(blCarton_HP_now + "\n/" + blCarton_HP);
                orangeCarton_HP.setText(orCarton_HP_now + "\n/" + orCarton_HP);
                rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                if(blCircle_HP_now <= 0){
                    blackCircle_HP.setText(0 + "\n/" + blCircle_HP);
                    blackCircle_battle.setImageResource(R.drawable.background_white);
                }
                if(blCarton_HP_now <= 0){
                    blackCarton_HP.setText(0 + "\n/" + blCarton_HP);
                    blackCarton_battle.setImageResource(R.drawable.background_white);
                }
                else{
                    blCarton_HP_now = blCarton_HP_now + (blCarton_HP * blCarton_SK2_Heal / 100);
                    blackCarton_HP.setText(blCarton_HP_now + "\n/" + blCarton_HP);
                }
                if(orCarton_HP_now <= 0 && orCarton_SK2_cooltime_now == 0){
                    orCarton_HP_now = orCarton_HP * orCarton_SK2_Heal / 100;
                    orCarton_SK2_cooltime_now = orCarton_SK2_Cooltime;
                    orangeCarton_HP.setText(orCarton_HP + "\n/" + orCarton_HP);
                }
                if(orCarton_HP_now <= 0 && orCarton_SK2_cooltime_now > 0){
                    orangeCarton_HP.setText(0 + "\n/" + orCarton_HP);
                    orangeCarton_battle.setImageResource(R.drawable.background_white);
                }
                if(blCircle_HP_now <= 0 || blCarton_HP_now <= 0 || blCarton_HP_now <= 0){
                    initPopupWindow_show_state_fail();
                    state.showAtLocation(popup , Gravity.CENTER_HORIZONTAL , 0 , 0);
                }
            }
            turnNumber = 1;
            start();
        }
    }

    private View.OnClickListener useSkill1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(turnNumber == 1){
                if(blCircle_HP_now > 0){
                    ra_HP_now = ra_HP_now - (blCircle_Attack * blCircle_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackCircle_battle.setImageResource(R.drawable.black_circle);
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }
                    if(blCircle_SK2_Cooltime_now > 0 && blCircle_SK2_Cooltime_now <= blCircle_SK2_Cooltime){
                        blCircle_SK2_Cooltime_now--;
                    }
                    if(blCircle_SK3_cooltime_now > 0 && blCircle_SK3_cooltime_now <= blCircle_SK3_cooltime){
                        blCircle_SK3_cooltime_now--;
                    }
                    if(blCircle_strengthen_turn > 0){
                        blCircle_strengthen_turn--;
                    }
                    else if(blCircle_strengthen_turn == 0){
                        blCircle_Attack = blCircle_Attack - ((100 + blCircle_SK3_Strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 2){
                if(blCarton_HP_now > 0){
                    for(int i = 0; i < blCarton_SK1_WeakenPercent; i++){
                        percent[i] = 1;
                    }
                    if(blCarton_SK1_WeakenPercent < 100){
                        for(int i = blCarton_SK1_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }


                    cantHeal = percent[randomNumber];

                    ra_HP_now = ra_HP_now - (blCarton_Attack * blCarton_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackCarton_battle.setImageResource(R.drawable.black_carton);

                    if(blCarton_SK3_Cooltime_now > 0 && blCarton_SK3_Cooltime_now <= blCarton_SK3_Cooltime){
                        blCarton_SK3_Cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(blCarton_strengthen_turn > 0){
                        blCarton_strengthen_turn--;
                    }
                    else if(blCarton_strengthen_turn == 0){
                        blCarton_Attack = blCarton_Attack - ((100 + blCircle_SK3_Strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 3){
                if(orCarton_HP_now > 0){
                    for(int i = 0; i < orCarton_SK1_WeakenPercent; i++){
                        percent[i] = 1;
                    }
                    if(orCarton_SK1_WeakenPercent < 100){
                        for(int i = orCarton_SK1_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    cantHeal = percent[randomNumber];

                    ra_HP_now = ra_HP_now - (orCarton_Attack * orCarton_SK1_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeCarton_battle.setImageResource(R.drawable.orange_carton);

                    if(orCarton_SK2_cooltime_now > 0 && orCarton_SK2_cooltime_now <= orCarton_SK2_Cooltime){
                        orCarton_SK2_cooltime_now--;
                    }
                    if(orCarton_SK3_Cooltime_now > 0 && orCarton_SK3_Cooltime_now <= orCarton_SK3_Cooltime){
                        orCarton_SK3_Cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(orCarton_strengthen_turn > 0){
                        orCarton_strengthen_turn--;
                    }
                    else if(orCarton_strengthen_turn == 0){
                        orCarton_Attack = blCircle_Attack - ((100 + blCircle_SK3_Strengthen) / 100);
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
                skill1Text = "對敵人造成" + blCircle_SK1_Attack + "%威力的攻擊";
            }
            else if(turnNumber == 2){
                skill1Text = "對敵人造成" + blCarton_SK1_Attack + "%威力的攻擊，" + blCarton_SK1_WeakenPercent + "%的機率讓敵人回復不能";
            }
            else if(turnNumber == 3){
                skill1Text = "對敵人造成" + orCarton_SK1_Attack + "%威力的攻擊，" + orCarton_SK1_WeakenPercent + "%的機率讓敵人回復不能";
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
                if(blCircle_HP_now > 0){
                    ra_HP_now = ra_HP_now - (blCircle_Attack * blCircle_SK2_Attack / 100);
                    if(blCircle_HP_now > 0){
                        blCircle_HP_now = blCircle_HP_now + blCircle_HP * blCircle_SK2_Heal / 100;
                    }
                    if(blCarton_HP_now > 0){
                        blCarton_HP_now = blCarton_HP_now + blCarton_HP * blCircle_SK2_Heal / 100;
                    }
                    if(orCarton_HP_now > 0){
                        orCarton_HP_now = orCarton_HP_now + orCarton_HP * blCarton_SK2_Heal / 100;
                    }

                    if(blCircle_HP_now > blCircle_HP){
                        blCircle_HP_now = blCircle_HP;
                    }
                    if(blCarton_HP_now > blCarton_HP){
                        blCarton_HP_now = blCarton_HP;
                    }
                    if(orCarton_HP_now > orCarton_HP){
                        orCarton_HP_now = orCarton_HP;
                    }
                    blackCircle_HP.setText(blCircle_HP_now + "\n/" + blCircle_HP);
                    blackCarton_HP.setText(blCarton_HP_now + "\n/" + blCarton_HP);
                    orangeCarton_HP.setText(orCarton_HP_now + "\n/" + orCarton_HP);

                    blCircle_SK2_Cooltime_now = blCircle_SK2_Cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackCircle_battle.setImageResource(R.drawable.black_circle);

                    if(blCircle_SK2_Cooltime_now > 0 && blCircle_SK2_Cooltime_now < blCircle_SK2_Cooltime){
                        blCircle_SK2_Cooltime_now--;
                    }
                    if(blCircle_SK3_cooltime_now > 0 && blCircle_SK3_cooltime_now <= blCircle_SK3_cooltime){
                        blCircle_SK3_cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(blCircle_strengthen_turn > 0){
                        blCircle_strengthen_turn--;
                    }
                    else if(blCircle_strengthen_turn == 0){
                        blCircle_Attack = blCircle_Attack - ((100 + blCircle_SK3_Strengthen) / 100);
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
                skill2Text = "對敵人造成" + blCircle_SK2_Attack + "%傷害，且對我方全員回復" + blCircle_SK2_Heal + "%HP\ncool time:" + blCircle_SK2_Cooltime;
            }
            else if(turnNumber == 2){
                skill2Text = "[自動發動]被攻擊時，自身100%的機率回復最大HP的:" + blCarton_SK2_Heal +"%";
            }
            else if(turnNumber == 3){
                skill2Text = "[自動發動]死亡時，自己最大HP" + orCarton_SK2_Heal + "%的狀態復活\ncool time:" + orCarton_SK2_Cooltime;
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
                if(blCircle_HP_now > 0){
                    blCircle_Attack = blCircle_Attack * ((100 + blCircle_SK3_Strengthen) / 100);
                    blCarton_Attack = blCircle_Attack * ((100 + blCircle_SK3_Strengthen) / 100);
                    orCarton_Attack = blCircle_Attack * ((100 + blCircle_SK3_Strengthen) / 100);

                    blCircle_strengthen_turn = 1;
                    blCarton_strengthen_turn = 1;
                    orCarton_strengthen_turn = 1;

                    blCircle_SK3_cooltime_now = blCircle_SK3_cooltime;

                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackCircle_battle.setImageResource(R.drawable.black_circle);
                    if(blCircle_SK2_Cooltime_now > 0 && blCircle_SK2_Cooltime_now <= blCircle_SK2_Cooltime){
                        blCircle_SK2_Cooltime_now--;
                    }
                    if(blCircle_SK3_cooltime_now > 0 && blCircle_SK3_cooltime_now < blCircle_SK3_cooltime){
                        blCircle_SK3_cooltime_now--;
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
                if(blCarton_HP_now > 0){
                    for(int i = 0; i < blCarton_SK3_WeakenPercent; i++){
                        percent[i] = 2;
                    }
                    if(blCarton_SK3_Cooltime < 100){
                        for(int i = blCarton_SK3_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }
                    randomNumber = random.nextInt(100);

                    weakenTurn = weakenTurn + percent[randomNumber];

                    ra_HP_now = ra_HP_now - (blCarton_Attack * blCarton_SK3_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    blackCarton_battle.setImageResource(R.drawable.black_carton);

                    blCarton_SK3_Cooltime_now = blCarton_SK3_Cooltime;
                    if(blCarton_SK3_Cooltime_now > 0 && blCarton_SK3_Cooltime_now < blCarton_SK3_Cooltime){
                        blCarton_SK3_Cooltime_now--;
                    }

                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(blCarton_strengthen_turn > 0){
                        blCarton_strengthen_turn--;
                    }
                    else if(blCarton_strengthen_turn == 0){
                        blCarton_Attack = blCarton_Attack - ((100 + blCircle_SK3_Strengthen) / 100);
                    }
                }
                turnNumber++;
                start();
            }
            else if(turnNumber == 3){
                if(orCarton_HP_now > 0){
                    for(int i = 0; i < orCarton_SK3_WeakenPercent; i++){
                        percent[i] = 2;
                    }
                    if(orCarton_SK3_WeakenPercent < 100){
                        for(int i = orCarton_SK1_WeakenPercent; i < percent.length; i++){
                            percent[i] = 0;
                        }
                    }

                    randomNumber = random.nextInt(100);

                    weakenTurn = weakenTurn + percent[randomNumber];

                    ra_HP_now = ra_HP_now - (orCarton_Attack * orCarton_SK3_Attack / 100);
                    rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
                    orangeCarton_battle.setImageResource(R.drawable.orange_carton);

                    orCarton_SK3_Cooltime_now = orCarton_SK3_Cooltime;
                    if(orCarton_SK2_cooltime_now > 0 && orCarton_SK3_Cooltime_now <= orCarton_SK3_Cooltime){
                        orCarton_SK2_cooltime_now--;
                    }
                    if(orCarton_SK3_Cooltime_now > 0 && orCarton_SK3_Cooltime_now <= orCarton_SK3_Cooltime){
                        orCarton_SK3_Cooltime_now--;
                    }
                    if(ra_HP_now <= 0){
                        rabbit_HP.setText(0 + "\n/" + ra_HP);
                        rabbit.setImageResource(R.drawable.background_white);
                        initPopupWindow_show_state();
                        state.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
                    }

                    if(orCarton_strengthen_turn > 0){
                        orCarton_strengthen_turn--;
                    }
                    else if(orCarton_strengthen_turn == 0){
                        orCarton_Attack = orCarton_Attack - ((100 + blCircle_SK3_Strengthen) / 100);
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
                skill3Text = "我方全體攻擊增加" + blCircle_SK3_Strengthen + "%1回合\ncool time:" + blCircle_SK3_cooltime;
            }
            else if(turnNumber == 2){
                skill3Text = "對敵人造成" + blCarton_SK3_Attack + "%威力的傷害，" + blCarton_SK3_WeakenPercent + "%的機率讓敵人攻擊減少" + blCarton_SK3_Weaken + "%" + blCarton_SK3_WeakenTurn + "回合\ncool time:" + blCarton_SK3_Cooltime;
            }
            else if(turnNumber == 3){
                skill3Text = "對敵人造成" + orCarton_SK3_Attack + "%威力的傷害，" + orCarton_SK3_WeakenPercent + "%的機率讓敵人攻擊減少" + orCarton_SK3_Weaken + "%、回復不能" + orCarton_SK3_WeakenTurn + "回合\ncool time:" + orCarton_SK3_Cooltime;
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
        View view = LayoutInflater.from(context).inflate(R.layout.activity_easy_skill , null);
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
        money = money + 30000;
        editor.putInt("writeMoney" , money);
        editor.commit();

        TextView easy_state;
        TextView easy_money;
        Button easy_check;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_easy_state , null);
        state = new PopupWindow(view);
        state.setWidth(width * 4/5);
        state.setHeight(height * 3/7);
        state.setFocusable(false);

        easy_state = (TextView)view.findViewById(R.id.easy_state);
        easy_money = (TextView)view.findViewById(R.id.easy_money);
        easy_check = (Button)view.findViewById(R.id.easy_check);

        skill1.setVisibility(View.INVISIBLE);
        skill2.setVisibility(View.INVISIBLE);
        skill3.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

        easy_check.setOnClickListener(close);

        easy_state.setText("勝利");
        easy_money.setText("獲得30000G");
    }

    private void initPopupWindow_show_state_fail(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        TextView easy_state;
        TextView easy_money;
        Button easy_check;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_easy_state , null);
        state = new PopupWindow(view);
        state.setWidth(width * 4/5);
        state.setHeight(height * 3/7);
        state.setFocusable(false);

        easy_state = (TextView)view.findViewById(R.id.easy_state);
        easy_money = (TextView)view.findViewById(R.id.easy_money);
        easy_check = (Button)view.findViewById(R.id.easy_check);

        skill1.setVisibility(View.INVISIBLE);
        skill2.setVisibility(View.INVISIBLE);
        skill3.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

        easy_check.setOnClickListener(close);

        easy_state.setText("失敗");
        easy_money.setText("再提升喵咪的等級與技能吧");
    }

    private View.OnClickListener close = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            state.dismiss();
            Intent intent = new Intent();
            intent.setClass(easy.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        blCircle_HP = sharedPref.getInt("writeCharacter2HP" , 0);
        blCircle_HP_now = blCircle_HP;
        blCircle_Attack = sharedPref.getInt("writeCharacter2Attack" , 0);
        blCircle_SK1_Attack = sharedPref.getInt("writeCharacter2Skill1_attack" , 0);
        blCircle_SK2_Attack = sharedPref.getInt("writeCharacter2Skill2_attack" , 0);
        blCircle_SK2_Heal = sharedPref.getInt("writeCharacter2Skill2_heal" , 0);
        blCircle_SK2_Cooltime = sharedPref.getInt("writeCharacter2Skill2_cooltime" , 0);
        blCircle_SK2_Cooltime_now = 0;
        blCircle_SK3_Strengthen = sharedPref.getInt("writeCharacter2Skill3_strengthen" , 0);
        blCircle_SK3_cooltime = sharedPref.getInt("writeCharacter2Skill3_cooltime" , 0);
        blCircle_SK3_cooltime_now = 0;

        blCarton_HP = sharedPref.getInt("writeCharacter8HP" , 0);
        blCarton_HP_now = blCarton_HP;
        blCarton_Attack = sharedPref.getInt("writeCharacter8Attack" , 0);
        blCarton_SK1_Attack = sharedPref.getInt("writeCharacter8Skill1_attack" , 0);
        blCarton_SK1_WeakenPercent = sharedPref.getInt("writeCharacter8Skill1_weakenPercent" , 0);
        blCarton_SK2_Heal = sharedPref.getInt("writeCharacter8Skill2_heal" , 0);
        blCarton_SK3_Attack = sharedPref.getInt("writeCharacte8Skill3_attack" , 0);
        blCarton_SK3_WeakenPercent = sharedPref.getInt("writeCharacter8Skill3_weakenPercent" , 0);
        blCarton_SK3_Weaken = sharedPref.getInt("writeCharacter8Skill3_weaken" , 0);
        blCarton_SK3_WeakenTurn = sharedPref.getInt("writeCharacter8Skill3_weakenTurn" , 0);
        blCarton_SK3_Cooltime = sharedPref.getInt("writeCharacte8Skill3_cooltime" , 0);
        blCarton_SK3_Cooltime_now = 0;

        orCarton_HP = sharedPref.getInt("writeCharacter9HP" , 0);
        orCarton_HP_now = orCarton_HP;
        orCarton_Attack = sharedPref.getInt("writeCharacter9HP" , 0);
        orCarton_SK1_Attack = sharedPref.getInt("writeCharacter9Skilll_attack" , 0);
        orCarton_SK1_WeakenPercent = sharedPref.getInt("writeCharacter9Skill1_weakenPercent" , 0);
        orCarton_SK2_Heal = sharedPref.getInt("writeCharacter9Skill2_heal" , 0);
        orCarton_SK2_Cooltime = sharedPref.getInt("writeCharacter9Skill2_cooltime" , 0);
        orCarton_SK2_cooltime_now = 0;
        orCarton_SK3_Attack = sharedPref.getInt("writeCharacter9Skill3_attack" , 0);
        orCarton_SK3_WeakenPercent = sharedPref.getInt("writeCharacter9Skill3_weakenPercent" , 0);
        orCarton_SK3_Weaken = sharedPref.getInt("writeCharacter9Skill3_weaken" , 0);
        orCarton_SK3_WeakenTurn = sharedPref.getInt("writeCharacter9Skill3_weakenTurn" , 0);
        orCarton_SK3_Cooltime = sharedPref.getInt("wruteCharacter9Skill3_cooltime" , 0);
        orCarton_SK3_Cooltime_now = 0;
        ra_HP = sharedPref.getInt("writeRabbit1HP" , 0);
        ra_HP_now = ra_HP;
        ra_Attack = sharedPref.getInt("writeRabbit1Attck" , 0);
        ra_Attack_temp = ra_Attack;
        blackCircle_HP.setText(blCircle_HP_now + "\n/" + blCircle_HP);
        blackCarton_HP.setText(blCarton_HP_now + "\n/" + blCarton_HP);
        orangeCarton_HP.setText(orCarton_HP_now + "\n/" + orCarton_HP);
        rabbit_HP.setText(ra_HP_now + "\n/" + ra_HP);
    }
}