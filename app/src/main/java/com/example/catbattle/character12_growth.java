package com.example.catbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

public class character12_growth extends AppCompatActivity {
    private Context context;
    private ImageButton character12_skill_1;
    private ImageButton character12_skill_2;
    private ImageButton character12_skill_3;
    private PopupWindow character12_skill_1_popupWindow = null;
    private PopupWindow character12_skill_2_popupWindow = null;
    private PopupWindow character12_skill_3_popupWindow = null;
    private PopupWindow character12_rankup_pupupWindow = null;
    private PopupWindow character12_skill1_rankup_popupWindow = null;
    private PopupWindow character12_skill2_rankup_popupWindow = null;
    private PopupWindow character12_skill3_rankup_popupWindow = null;
    private Button character12_skill1_exit;
    private Button character12_skill1_level_up;
    private Button character12_skill2_exit;
    private Button character12_skill2_level_up;
    private Button character12_skill3_exit;
    private Button character12_skill3_level_up;
    private Button character12_rankup;
    private Button character12_rankup_yes;
    private Button character12_rankup_no;
    private Button character12_skill1_rankup_yes;
    private Button character12_skill1_rankup_no;
    private Button character12_skill2_rankup_yes;
    private Button character12_skill2_rankup_no;
    private Button character12_skill3_rankup_yes;
    private Button character12_skill3_rankup_no;
    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private String stringmoneymoney;
    private String stringRank;
    private String stringrank12;
    private String stringhp12;
    private String stringattack12;
    private String stringskill1Rank;
    private String stringskill2Rank;
    private String stringskill3Rank;
    private TextView money_money;
    private TextView rank_rank;
    private TextView rank_12;
    private TextView attack_attack_12;
    private TextView hp_hp_12;
    private TextView character12_rankup_checkText;
    private TextView character12_skill1_rankup_checkText;
    private TextView character12_skill2_rankup_checkText;
    private TextView character12_skill3_rankup_checkText;
    private TextView character12_skill_1_level;
    private TextView character12_skill_2_level;
    private TextView character12_skill_3_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character12_growth);
        getSupportActionBar().hide();

        context = this;
        character12_skill_1 = (ImageButton)findViewById(R.id.character12_skill_1);
        character12_skill_2 = (ImageButton)findViewById(R.id.character12_skill_2);
        character12_skill_3 = (ImageButton)findViewById(R.id.character12_skill_3);
        character12_rankup = (Button)findViewById(R.id.character12_rankup);
        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);
        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);
        rank_12 = (TextView)findViewById(R.id.rank_12);
        attack_attack_12 = (TextView)findViewById(R.id.attack_attack_12);
        hp_hp_12 = (TextView)findViewById(R.id.hp_hp_12);
        character12_skill_1_level = (TextView)findViewById(R.id.character12_skill_1_level);
        character12_skill_2_level = (TextView)findViewById(R.id.character12_skill_2_level);
        character12_skill_3_level = (TextView)findViewById(R.id.character12_skill_3_level);

        character12_rankup.setOnClickListener(goToRankup);
        character12_skill_1.setOnClickListener(goTocharacter12_skill_1);
        character12_skill_2.setOnClickListener(goTocharacter12_skill_2);
        character12_skill_3.setOnClickListener(goTocharacter12_skill_3);
        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);

        onLoad();
    }

    private View.OnClickListener goToRankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character12_rankup();
            character12_rankup_pupupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character12_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();
        View view = LayoutInflater.from(context).inflate(R.layout.activity_character12_rankup , null);
        character12_rankup_pupupWindow = new PopupWindow(view);
        character12_rankup_pupupWindow.setWidth(width * 8/9);
        character12_rankup_pupupWindow.setHeight(height * 2/7);
        character12_rankup_pupupWindow.setFocusable(false);

        character12_rankup_checkText = (TextView)view.findViewById(R.id.character12_rankup_checkText);
        character12_rankup_yes = (Button)view.findViewById(R.id.character12_rankup_yes);
        character12_rankup_no = (Button)view.findViewById(R.id.character12_rankup_no);
        character12_rankup_no.setOnClickListener(closeCharacter12_rankup);
        character12_rankup_yes.setOnClickListener(let_character12_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter12Rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character12_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character12_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character12_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank =sharedPref.getInt("writeCharacter12Rank" , 0);
            int money =sharedPref.getInt("writeMoney" , 0);
            int attack = sharedPref.getInt("writeCharacter12Attack" , 0);
            int hp = sharedPref.getInt("writeCharacter12HP" , 0);

            hp = hp + 1000;
            attack = attack + 100;
            money = money - (rank * 1000);
            rank = rank + 1;

            editor.putInt("writeCharacter12Rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter12Attack" , attack);
            editor.putInt("writeCharacter12HP" , hp);
            editor.commit();

            int saveRank12 = sharedPref.getInt("writeCharacter12Rank" , 0);
            int saveHP12 = sharedPref.getInt("writeCharacter12HP" , 0);
            int saveAttack12 = sharedPref.getInt("writeCharacter12Attack" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character12_rankup_pupupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter12_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_rankup_pupupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter12_skill_1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character12_skill_1();
            character12_skill_1_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character12_skill_1(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height        = getWindowManager().getDefaultDisplay().getHeight();
        int width         = getWindowManager().getDefaultDisplay().getWidth();
        int attack        = sharedPref.getInt("writeCharacter12Skill1_attack" , 0);
        int weakenPercent = sharedPref.getInt("writeCharacter12Skill1_weakenPercent" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter12Skill1_rank" , 0);

        TextView character12_skill1_content;
        TextView character12_skill1_lv2;
        TextView character12_skill1_lv3;
        TextView character12_skill1_lv4;
        TextView character12_skill1_lv5;
        TextView character12_skill1_lv6;
        TextView character12_skill1_lv7;
        TextView character12_skill1_lv8;
        TextView character12_skill1_lv9;
        TextView character12_skill1_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character12_skill1 , null);
        character12_skill_1_popupWindow = new PopupWindow(view);
        character12_skill_1_popupWindow.setWidth(width * 4/5);
        character12_skill_1_popupWindow.setHeight(height * 5/6);
        character12_skill_1_popupWindow.setFocusable(false);
        character12_skill1_exit = (Button)view.findViewById(R.id.character12_skill1_exit);
        character12_skill1_level_up = (Button)view.findViewById(R.id.character12_skill1_level_up);
        character12_skill1_content = (TextView)view.findViewById(R.id.character12_skill1_content);
        character12_skill1_lv2 = (TextView)view.findViewById(R.id.character12_skill1_lv2);
        character12_skill1_lv3 = (TextView)view.findViewById(R.id.character12_skill1_lv3);
        character12_skill1_lv4 = (TextView)view.findViewById(R.id.character12_skill1_lv4);
        character12_skill1_lv5 = (TextView)view.findViewById(R.id.character12_skill1_lv5);
        character12_skill1_lv6 = (TextView)view.findViewById(R.id.character12_skill1_lv6);
        character12_skill1_lv7 = (TextView)view.findViewById(R.id.character12_skill1_lv7);
        character12_skill1_lv8 = (TextView)view.findViewById(R.id.character12_skill1_lv8);
        character12_skill1_lv9 = (TextView)view.findViewById(R.id.character12_skill1_lv9);
        character12_skill1_lv10 = (TextView)view.findViewById(R.id.character12_skill1_lv10);

        if(skill1Rank >= 10){
            character12_skill1_level_up.setEnabled(false);
        }

        character12_skill1_level_up.setOnClickListener(let_character12_skill1_level_up);
        character12_skill1_exit.setOnClickListener(closeCharacter12_skill1);

        character12_skill1_content.setText("對敵人造成" + attack + "%威力攻擊，" + weakenPercent + "%的機率讓敵人攻擊減少50%2回合");

        if(skill1Rank == 2){
            character12_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character12_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character12_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character12_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character12_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character12_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character12_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character12_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character12_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill1_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character12_skill1_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_skill_1_popupWindow.dismiss();
            initPopupWindow_character12_skill_1_rankup();
            character12_skill1_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character12_skill_1_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character12_skill1_rankup , null);
        character12_skill1_rankup_popupWindow = new PopupWindow(view);
        character12_skill1_rankup_popupWindow.setWidth(width * 8/9);
        character12_skill1_rankup_popupWindow.setHeight(height * 2/7);
        character12_skill1_rankup_popupWindow.setFocusable(false);

        character12_skill1_rankup_checkText = (TextView)view.findViewById(R.id.character12_skill1_rankup_checkText);
        character12_skill1_rankup_yes = (Button)view.findViewById(R.id.character12_skill1_rankup_yes);
        character12_skill1_rankup_no = (Button)view.findViewById(R.id.character12_skill1_rankup_no);
        character12_skill1_rankup_no.setOnClickListener(closeCharacter12_skill1_rankup);
        character12_skill1_rankup_yes.setOnClickListener(let_character12_skill1_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter12Skill1_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character12_skill1_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character12_skill1_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character12_skill1_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank          = sharedPref.getInt("writeCharacter12Skill1_rank" , 0);
            int money         = sharedPref.getInt("writeMoney" , 0);
            int attack        = sharedPref.getInt("writeCharacter12Skill1_attack" , 0);
            int weakenPercent = sharedPref.getInt("writeCharacter12Skill1_weakenPercent" , 0);

            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                attack = attack + 23;
            }
            else if(rank == 3){
                weakenPercent = weakenPercent + 10;
            }
            else if(rank == 4){
                attack = attack + 24;
            }
            else if(rank == 5){
                weakenPercent = weakenPercent + 10;
            }
            else if(rank == 6){
                attack = attack + 48;
            }
            else if(rank == 7){
                weakenPercent = weakenPercent + 10;
            }
            else if(rank == 8){
                attack = attack + 52;
            }
            else if(rank == 9){
                weakenPercent = weakenPercent + 20;
            }
            else if(rank == 10){
                attack = attack + 53;
            }

            editor.putInt("writeCharacter12Skill1_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter12Skill1_attack" , attack);
            editor.putInt("writeCharacter12Skill1_weakenPercent" , weakenPercent);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter12Skill1_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character12_skill1_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter12_skill1_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_skill1_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter12_skill1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_skill_1_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter12_skill_2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character12_skill_2();
            character12_skill_2_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character12_skill_2(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();
        int heal   = sharedPref.getInt("writeCharacter12Skill2_heal" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter12Skill2_rank" , 0);

        TextView character12_skill2_content;
        TextView character12_skill2_lv2;
        TextView character12_skill2_lv3;
        TextView character12_skill2_lv4;
        TextView character12_skill2_lv5;
        TextView character12_skill2_lv6;
        TextView character12_skill2_lv7;
        TextView character12_skill2_lv8;
        TextView character12_skill2_lv9;
        TextView character12_skill2_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character12_skill2 , null);
        character12_skill_2_popupWindow = new PopupWindow(view);
        character12_skill_2_popupWindow.setWidth(width * 4/5);
        character12_skill_2_popupWindow.setHeight(height * 5/6);
        character12_skill_2_popupWindow.setFocusable(false);
        character12_skill2_exit = (Button)view.findViewById(R.id.character12_skill2_exit);
        character12_skill2_level_up = (Button)view.findViewById(R.id.character12_skill2_level_up);
        character12_skill2_content = (TextView)view.findViewById(R.id.character12_skill2_content);
        character12_skill2_lv2 = (TextView)view.findViewById(R.id.character12_skill2_lv2);
        character12_skill2_lv3 = (TextView)view.findViewById(R.id.character12_skill2_lv3);
        character12_skill2_lv4 = (TextView)view.findViewById(R.id.character12_skill2_lv4);
        character12_skill2_lv5 = (TextView)view.findViewById(R.id.character12_skill2_lv5);
        character12_skill2_lv6 = (TextView)view.findViewById(R.id.character12_skill2_lv6);
        character12_skill2_lv7 = (TextView)view.findViewById(R.id.character12_skill2_lv7);
        character12_skill2_lv8 = (TextView)view.findViewById(R.id.character12_skill2_lv8);
        character12_skill2_lv9 = (TextView)view.findViewById(R.id.character12_skill2_lv9);
        character12_skill2_lv10 = (TextView)view.findViewById(R.id.character12_skill2_lv10);

        if(skill1Rank >= 10){
            character12_skill2_level_up.setEnabled(false);
        }

        character12_skill2_level_up.setOnClickListener(let_character12_skill2_level_up);
        character12_skill2_exit.setOnClickListener(closeCharacter12_skill2);

        character12_skill2_content.setText("[自動發動]回合開始時，我方全體100%機率回復最大HP的" + heal + "%");

        if(skill1Rank == 2){
            character12_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character12_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character12_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character12_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character12_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character12_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character12_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character12_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character12_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill2_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character12_skill2_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_skill_2_popupWindow.dismiss();
            initPopupWindow_character12_skill_2_rankup();
            character12_skill2_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character12_skill_2_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character12_skill2_rankup , null);
        character12_skill2_rankup_popupWindow = new PopupWindow(view);
        character12_skill2_rankup_popupWindow.setWidth(width * 8/9);
        character12_skill2_rankup_popupWindow.setHeight(height * 2/7);
        character12_skill2_rankup_popupWindow.setFocusable(false);

        character12_skill2_rankup_checkText = (TextView)view.findViewById(R.id.character12_skill2_rankup_checkText);
        character12_skill2_rankup_yes = (Button)view.findViewById(R.id.character12_skill2_rankup_yes);
        character12_skill2_rankup_no = (Button)view.findViewById(R.id.character12_skill2_rankup_no);
        character12_skill2_rankup_no.setOnClickListener(closeCharacter12_skill2_rankup);
        character12_skill2_rankup_yes.setOnClickListener(let_character12_skill2_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter12Skill2_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character12_skill2_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character12_skill2_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character12_skill2_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank  = sharedPref.getInt("writeCharacter12Skill2_rank" , 0);
            int money = sharedPref.getInt("writeMoney" , 0);
            int heal  = sharedPref.getInt("writeCharacter12Skill2_heal" , 0);

            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                heal = heal + 1;
            }
            else if(rank == 3){
                heal = heal + 1;
            }
            else if(rank == 4){
                heal = heal + 1;
            }
            else if(rank == 5){
                heal = heal + 1;
            }
            else if(rank == 6){
                heal = heal + 1;
            }
            else if(rank == 7){
                heal = heal + 1;
            }
            else if(rank == 8){
                heal = heal + 1;
            }
            else if(rank == 9){
                heal = heal + 1;
            }
            else if(rank == 10){
                heal = heal + 1;
            }

            editor.putInt("writeCharacter12Skill2_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter12Skill2_heal" , heal);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter12Skill2_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character12_skill2_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter12_skill2_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_skill2_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter12_skill2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_skill_2_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter12_skill_3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character12_skill_3();
            character12_skill_3_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character12_skill_3(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height        = getWindowManager().getDefaultDisplay().getHeight();
        int width         = getWindowManager().getDefaultDisplay().getWidth();
        int attack        = sharedPref.getInt("writeCharacter12Skill3_attack" , 0);
        int weakenPercent = sharedPref.getInt("writeCharacter12Skill3_weakenPercent" , 0);
        int cooltime      = sharedPref.getInt("writeCharacter12Skill3_cooltime" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter12Skill3_rank" , 0);

        TextView character12_skill3_content;
        TextView character12_skill3_lv2;
        TextView character12_skill3_lv3;
        TextView character12_skill3_lv4;
        TextView character12_skill3_lv5;
        TextView character12_skill3_lv6;
        TextView character12_skill3_lv7;
        TextView character12_skill3_lv8;
        TextView character12_skill3_lv9;
        TextView character12_skill3_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character12_skill3 , null);
        character12_skill_3_popupWindow = new PopupWindow(view);
        character12_skill_3_popupWindow.setWidth(width * 4/5);
        character12_skill_3_popupWindow.setHeight(height * 5/6);
        character12_skill_3_popupWindow.setFocusable(false);
        character12_skill3_exit = (Button)view.findViewById(R.id.character12_skill3_exit);
        character12_skill3_level_up = (Button)view.findViewById(R.id.character12_skill3_level_up);
        character12_skill3_content = (TextView)view.findViewById(R.id.character12_skill3_content);
        character12_skill3_lv2 = (TextView)view.findViewById(R.id.character12_skill3_lv2);
        character12_skill3_lv3 = (TextView)view.findViewById(R.id.character12_skill3_lv3);
        character12_skill3_lv4 = (TextView)view.findViewById(R.id.character12_skill3_lv4);
        character12_skill3_lv5 = (TextView)view.findViewById(R.id.character12_skill3_lv5);
        character12_skill3_lv6 = (TextView)view.findViewById(R.id.character12_skill3_lv6);
        character12_skill3_lv7 = (TextView)view.findViewById(R.id.character12_skill3_lv7);
        character12_skill3_lv8 = (TextView)view.findViewById(R.id.character12_skill3_lv8);
        character12_skill3_lv9 = (TextView)view.findViewById(R.id.character12_skill3_lv9);
        character12_skill3_lv10 = (TextView)view.findViewById(R.id.character12_skill3_lv10);

        if(skill1Rank >= 10){
            character12_skill3_level_up.setEnabled(false);
        }

        character12_skill3_level_up.setOnClickListener(let_character12_skill3_level_up);
        character12_skill3_exit.setOnClickListener(closeCharacter12_skill3);

        character12_skill3_content.setText("對敵人造成" + attack + "%威力的傷害，" + weakenPercent + "%的機率讓敵人2回合扣除最大HP的5%且行動不能1回合\n cool time" + cooltime + "回");

        if(skill1Rank == 2){
            character12_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character12_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character12_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character12_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character12_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character12_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character12_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character12_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character12_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character12_skill3_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character12_skill3_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_skill_3_popupWindow.dismiss();
            initPopupWindow_character12_skill_3_rankup();
            character12_skill3_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character12_skill_3_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character12_skill3_rankup , null);
        character12_skill3_rankup_popupWindow = new PopupWindow(view);
        character12_skill3_rankup_popupWindow.setWidth(width * 8/9);
        character12_skill3_rankup_popupWindow.setHeight(height * 2/7);
        character12_skill3_rankup_popupWindow.setFocusable(false);

        character12_skill3_rankup_checkText = (TextView)view.findViewById(R.id.character12_skill3_rankup_checkText);
        character12_skill3_rankup_yes = (Button)view.findViewById(R.id.character12_skill3_rankup_yes);
        character12_skill3_rankup_no = (Button)view.findViewById(R.id.character12_skill3_rankup_no);
        character12_skill3_rankup_no.setOnClickListener(closeCharacter12_skill3_rankup);
        character12_skill3_rankup_yes.setOnClickListener(let_character12_skill3_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter12Skill3_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character12_skill3_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character12_skill3_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character12_skill3_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank          = sharedPref.getInt("writeCharacter12Skill3_rank" , 0);
            int money         = sharedPref.getInt("writeMoney" , 0);
            int attack        = sharedPref.getInt("writeCharacter12Skill3_attack" , 0);
            int weakenPercent = sharedPref.getInt("writeCharacter12Skill3_weakenPercent" , 0);
            int cooltime      = sharedPref.getInt("writeCharacter12Skill3_cooltime" , 0);

            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                attack = attack + 67;
            }
            else if(rank == 3){
                weakenPercent = weakenPercent + 10;
            }
            else if(rank == 4){
                cooltime = cooltime - 1;
            }
            else if(rank == 5){
                attack = attack + 67;
            }
            else if(rank == 6){
                weakenPercent = weakenPercent + 15;
            }
            else if(rank == 7){
                cooltime = cooltime - 1;
            }
            else if(rank == 8){
                attack = attack + 67;
            }
            else if(rank == 9){
                weakenPercent = weakenPercent + 25;
            }
            else if(rank == 10){
                attack = attack + 132;
            }

            editor.putInt("writeCharacter12Skill3_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter12Skill3_attack" , attack);
            editor.putInt("writeCharacter12Skill3_weakenPercent" , weakenPercent);
            editor.putInt("writeCharacter12Skill3_cooltime" , cooltime);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter12Skill3_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character12_skill3_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter12_skill3_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_skill3_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter12_skill3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character12_skill_3_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character12_growth.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character12_growth.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character12_growth.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character12_growth.this , gacha.class);
            startActivity(intent);
        }
    };


    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("writeCharacter12Skill1_rank" , 1);
        editor.putInt("writeCharacter12Skill1_attack" , 400);
        editor.putInt("writeCharacter12Skill1_weakenPercent" , 50);
        editor.putInt("writeCharacter12Skill1_weaken" , 50);
        editor.putInt("writeCharacter12Skill1_weakenTurn" , 2);
        editor.putInt("writeCharacter12Skill2_rank" , 1);
        editor.putInt("writeCharacter12Skill2_heal" , 1);
        editor.putInt("writeCharacter12Skill3_rank" , 1);
        editor.putInt("writeCharacter12Skill3_attack" , 667);
        editor.putInt("writeCharacter12Skill3_weakenPercent" , 50);
        editor.putInt("writeCharacter12Skill3_weakenTurn" , 2);
        editor.putInt("writeCharacter12Skill3_weakenDamage" , 5);
        editor.putInt("writeCharacter12Skill3_weakenturn" , 1);
        editor.putInt("writeCharacter12Skill3_cooltime" , 7);
        editor.putInt("writeCharacter12HP" , 3900);
        editor.putInt("writeCharacter12Attack" , 350);
        editor.putInt("writeCharacter12Rank" , 1);
        //editor.commit();

        int saveRank12 = sharedPref.getInt("writeCharacter12Rank" , 0);
        int saveHP12 = sharedPref.getInt("writeCharacter12HP" , 0);
        int saveAttack12 = sharedPref.getInt("writeCharacter12Attack" , 0);
        int saveMoney = sharedPref.getInt("writeMoney" , 0);
        int saveRank =  sharedPref.getInt("writeRank" , 0);
        int saveSkill1Rank = sharedPref.getInt("writeCharacter12Skill1_rank" , 0);
        int saveSkill2Rank = sharedPref.getInt("writeCharacter12Skill2_rank" , 0);
        int saveSkill3Rank = sharedPref.getInt("writeCharacter12Skill3_rank" , 0);

        stringattack12 = Integer.toString(saveAttack12);
        stringhp12 = Integer.toString(saveHP12);
        stringrank12 = Integer.toString(saveRank12);
        stringmoneymoney = Integer.toString(saveMoney);
        stringRank = Integer.toString(saveRank);
        stringskill1Rank = "Lv." + Integer.toString(saveSkill1Rank);
        stringskill2Rank = "Lv." + Integer.toString(saveSkill2Rank);
        stringskill3Rank = "Lv." + Integer.toString(saveSkill3Rank);

        attack_attack_12.setText(stringattack12);
        hp_hp_12.setText(stringhp12);
        rank_12.setText(stringrank12);
        money_money.setText(stringmoneymoney);
        rank_rank.setText(stringRank);
        character12_skill_1_level.setText(stringskill1Rank);
        character12_skill_2_level.setText(stringskill2Rank);
        character12_skill_3_level.setText(stringskill3Rank);

        if(saveRank12 == 99){
            character12_rankup.setEnabled(false);
        }
    }
}