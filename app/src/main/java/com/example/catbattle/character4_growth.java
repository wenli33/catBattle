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

public class character4_growth extends AppCompatActivity {
    private Context context;
    private ImageButton character4_skill_1;
    private ImageButton character4_skill_2;
    private ImageButton character4_skill_3;
    private PopupWindow character4_skill_1_popupWindow = null;
    private PopupWindow character4_skill_2_popupWindow = null;
    private PopupWindow character4_skill_3_popupWindow = null;
    private PopupWindow character4_rankup_pupupWindow = null;
    private PopupWindow character4_skill1_rankup_popupWindow = null;
    private PopupWindow character4_skill2_rankup_popupWindow = null;
    private PopupWindow character4_skill3_rankup_popupWindow = null;
    private Button character4_skill1_exit;
    private Button character4_skill1_level_up;
    private Button character4_skill2_exit;
    private Button character4_skill2_level_up;
    private Button character4_skill3_exit;
    private Button character4_skill3_level_up;
    private Button character4_rankup;
    private Button character4_rankup_yes;
    private Button character4_rankup_no;
    private Button character4_skill1_rankup_yes;
    private Button character4_skill1_rankup_no;
    private Button character4_skill2_rankup_yes;
    private Button character4_skill2_rankup_no;
    private Button character4_skill3_rankup_yes;
    private Button character4_skill3_rankup_no;
    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private String stringmoneymoney;
    private String stringRank;
    private String stringrank4;
    private String stringhp4;
    private String stringattack4;
    private String stringskill1Rank;
    private String stringskill2Rank;
    private String stringskill3Rank;
    private TextView money_money;
    private TextView rank_rank;
    private TextView rank_4;
    private TextView attack_attack_4;
    private TextView hp_hp_4;
    private TextView character4_rankup_checkText;
    private TextView character4_skill1_rankup_checkText;
    private TextView character4_skill2_rankup_checkText;
    private TextView character4_skill3_rankup_checkText;
    private TextView character4_skill_1_level;
    private TextView character4_skill_2_level;
    private TextView character4_skill_3_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character4_growth);
        getSupportActionBar().hide();

        context = this;
        character4_skill_1 = (ImageButton)findViewById(R.id.character4_skill_1);
        character4_skill_2 = (ImageButton)findViewById(R.id.character4_skill_2);
        character4_skill_3 = (ImageButton)findViewById(R.id.character4_skill_3);
        character4_rankup = (Button)findViewById(R.id.character4_rankup);
        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);
        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);
        rank_4 = (TextView)findViewById(R.id.rank_4);
        attack_attack_4 = (TextView)findViewById(R.id.attack_attack_4);
        hp_hp_4 = (TextView)findViewById(R.id.hp_hp_4);
        character4_skill_1_level = (TextView)findViewById(R.id.character4_skill_1_level);
        character4_skill_2_level = (TextView)findViewById(R.id.character4_skill_2_level);
        character4_skill_3_level = (TextView)findViewById(R.id.character4_skill_3_level);

        character4_rankup.setOnClickListener(goToRankup);
        character4_skill_1.setOnClickListener(goTocharacter4_skill_1);
        character4_skill_2.setOnClickListener(goTocharacter4_skill_2);
        character4_skill_3.setOnClickListener(goTocharacter4_skill_3);
        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);

        onLoad();
    }

    private View.OnClickListener goToRankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character4_rankup();
            character4_rankup_pupupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character4_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();
        View view = LayoutInflater.from(context).inflate(R.layout.activity_character4_rankup , null);
        character4_rankup_pupupWindow = new PopupWindow(view);
        character4_rankup_pupupWindow.setWidth(width * 8/9);
        character4_rankup_pupupWindow.setHeight(height * 2/7);
        character4_rankup_pupupWindow.setFocusable(false);

        character4_rankup_checkText = (TextView)view.findViewById(R.id.character4_rankup_checkText);
        character4_rankup_yes = (Button)view.findViewById(R.id.character4_rankup_yes);
        character4_rankup_no = (Button)view.findViewById(R.id.character4_rankup_no);
        character4_rankup_no.setOnClickListener(closeCharacter4_rankup);
        character4_rankup_yes.setOnClickListener(let_character4_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter4Rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character4_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character4_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character4_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank =sharedPref.getInt("writeCharacter4Rank" , 0);
            int money =sharedPref.getInt("writeMoney" , 0);
            int attack = sharedPref.getInt("writeCharacter4Attack" , 0);
            int hp = sharedPref.getInt("writeCharacter4HP" , 0);

            hp = hp + 1000;
            attack = attack + 100;
            money = money - (rank * 1000);
            rank = rank + 1;

            editor.putInt("writeCharacter4Rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter4Attack" , attack);
            editor.putInt("writeCharacter4HP" , hp);
            editor.commit();

            int saveRank4 = sharedPref.getInt("writeCharacter4Rank" , 0);
            int saveHP4 = sharedPref.getInt("writeCharacter4HP" , 0);
            int saveAttack4 = sharedPref.getInt("writeCharacter4Attack" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character4_rankup_pupupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter4_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_rankup_pupupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter4_skill_1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character4_skill_1();
            character4_skill_1_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character4_skill_1(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();
        int attack = sharedPref.getInt("writeCharacter4Skill1_attack" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter4Skill1_rank" , 0);

        TextView character4_skill1_content;
        TextView character4_skill1_lv2;
        TextView character4_skill1_lv3;
        TextView character4_skill1_lv4;
        TextView character4_skill1_lv5;
        TextView character4_skill1_lv6;
        TextView character4_skill1_lv7;
        TextView character4_skill1_lv8;
        TextView character4_skill1_lv9;
        TextView character4_skill1_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character4_skill1 , null);
        character4_skill_1_popupWindow = new PopupWindow(view);
        character4_skill_1_popupWindow.setWidth(width * 4/5);
        character4_skill_1_popupWindow.setHeight(height * 5/6);
        character4_skill_1_popupWindow.setFocusable(false);
        character4_skill1_exit = (Button)view.findViewById(R.id.character4_skill1_exit);
        character4_skill1_level_up = (Button)view.findViewById(R.id.character4_skill1_level_up);
        character4_skill1_content = (TextView)view.findViewById(R.id.character4_skill1_content);
        character4_skill1_lv2 = (TextView)view.findViewById(R.id.character4_skill1_lv2);
        character4_skill1_lv3 = (TextView)view.findViewById(R.id.character4_skill1_lv3);
        character4_skill1_lv4 = (TextView)view.findViewById(R.id.character4_skill1_lv4);
        character4_skill1_lv5 = (TextView)view.findViewById(R.id.character4_skill1_lv5);
        character4_skill1_lv6 = (TextView)view.findViewById(R.id.character4_skill1_lv6);
        character4_skill1_lv7 = (TextView)view.findViewById(R.id.character4_skill1_lv7);
        character4_skill1_lv8 = (TextView)view.findViewById(R.id.character4_skill1_lv8);
        character4_skill1_lv9 = (TextView)view.findViewById(R.id.character4_skill1_lv9);
        character4_skill1_lv10 = (TextView)view.findViewById(R.id.character4_skill1_lv10);

        if(skill1Rank >= 10){
            character4_skill1_level_up.setEnabled(false);
        }

        character4_skill1_level_up.setOnClickListener(let_character4_skill1_level_up);
        character4_skill1_exit.setOnClickListener(closeCharacter4_skill1);

        character4_skill1_content.setText("對敵人造成" + attack + "%威力的攻擊");

        if(skill1Rank == 2){
            character4_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character4_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character4_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character4_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character4_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character4_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character4_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character4_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character4_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill1_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }

    }

    private View.OnClickListener let_character4_skill1_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_skill_1_popupWindow.dismiss();
            initPopupWindow_character4_skill_1_rankup();
            character4_skill1_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character4_skill_1_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character4_skill1_rankup , null);
        character4_skill1_rankup_popupWindow = new PopupWindow(view);
        character4_skill1_rankup_popupWindow.setWidth(width * 8/9);
        character4_skill1_rankup_popupWindow.setHeight(height * 2/7);
        character4_skill1_rankup_popupWindow.setFocusable(false);

        character4_skill1_rankup_checkText = (TextView)view.findViewById(R.id.character4_skill1_rankup_checkText);
        character4_skill1_rankup_yes = (Button)view.findViewById(R.id.character4_skill1_rankup_yes);
        character4_skill1_rankup_no = (Button)view.findViewById(R.id.character4_skill1_rankup_no);
        character4_skill1_rankup_no.setOnClickListener(closeCharacter4_skill1_rankup);
        character4_skill1_rankup_yes.setOnClickListener(let_character4_skill1_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter4Skill1_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character4_skill1_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character4_skill1_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character4_skill1_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank   = sharedPref.getInt("writeCharacter4Skill1_rank" , 0);
            int money  = sharedPref.getInt("writeMoney" , 0);
            int attack = sharedPref.getInt("writeCharacter4Skill1_attack" , 0);

            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                attack = attack + 22;
            }
            else if(rank == 3){
                attack = attack + 32;
            }
            else if(rank == 4){
                attack = attack + 33;
            }
            else if(rank == 5){
                attack = attack + 43;
            }
            else if(rank == 6){
                attack = attack + 44;
            }
            else if(rank == 7){
                attack = attack + 46;
            }
            else if(rank == 8){
                attack = attack + 46;
            }
            else if(rank == 9){
                attack = attack + 46;
            }
            else if(rank == 10){
                attack = attack + 54;
            }

            editor.putInt("writeCharacter4Skill1_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter4Skill1_attack" , attack);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter4Skill1_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character4_skill1_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter4_skill1_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_skill1_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter4_skill1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_skill_1_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter4_skill_2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character4_skill_2();
            character4_skill_2_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character4_skill_2(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height     = getWindowManager().getDefaultDisplay().getHeight();
        int width      = getWindowManager().getDefaultDisplay().getWidth();
        int strengthen = sharedPref.getInt("writeCharacter4Skill2_strengthen" , 0);
        int cooltime   = sharedPref.getInt("writeCharacter4Skill2_cooltime" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter4Skill2_rank" , 0);

        TextView character4_skill2_content;
        TextView character4_skill2_lv2;
        TextView character4_skill2_lv3;
        TextView character4_skill2_lv4;
        TextView character4_skill2_lv5;
        TextView character4_skill2_lv6;
        TextView character4_skill2_lv7;
        TextView character4_skill2_lv8;
        TextView character4_skill2_lv9;
        TextView character4_skill2_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character4_skill2 , null);
        character4_skill_2_popupWindow = new PopupWindow(view);
        character4_skill_2_popupWindow.setWidth(width * 4/5);
        character4_skill_2_popupWindow.setHeight(height * 5/6);
        character4_skill_2_popupWindow.setFocusable(false);
        character4_skill2_exit = (Button)view.findViewById(R.id.character4_skill2_exit);
        character4_skill2_level_up = (Button)view.findViewById(R.id.character4_skill2_level_up);
        character4_skill2_content = (TextView)view.findViewById(R.id.character4_skill2_content);
        character4_skill2_lv2 = (TextView)view.findViewById(R.id.character4_skill2_lv2);
        character4_skill2_lv3 = (TextView)view.findViewById(R.id.character4_skill2_lv3);
        character4_skill2_lv4 = (TextView)view.findViewById(R.id.character4_skill2_lv4);
        character4_skill2_lv5 = (TextView)view.findViewById(R.id.character4_skill2_lv5);
        character4_skill2_lv6 = (TextView)view.findViewById(R.id.character4_skill2_lv6);
        character4_skill2_lv7 = (TextView)view.findViewById(R.id.character4_skill2_lv7);
        character4_skill2_lv8 = (TextView)view.findViewById(R.id.character4_skill2_lv8);
        character4_skill2_lv9 = (TextView)view.findViewById(R.id.character4_skill2_lv9);
        character4_skill2_lv10 = (TextView)view.findViewById(R.id.character4_skill2_lv10);

        if(skill1Rank >= 10){
            character4_skill2_level_up.setEnabled(false);
        }

        character4_skill2_level_up.setOnClickListener(let_character4_skill2_level_up);
        character4_skill2_exit.setOnClickListener(closeCharacter4_skill2);

        character4_skill2_content.setText("對我方全體攻擊增加" + strengthen + "%2回合\ncool time:" + cooltime + "回");

        if(skill1Rank == 2){
            character4_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character4_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character4_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character4_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character4_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character4_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character4_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character4_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character4_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill2_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character4_skill2_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_skill_2_popupWindow.dismiss();
            initPopupWindow_character4_skill_2_rankup();
            character4_skill2_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character4_skill_2_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character4_skill2_rankup , null);
        character4_skill2_rankup_popupWindow = new PopupWindow(view);
        character4_skill2_rankup_popupWindow.setWidth(width * 8/9);
        character4_skill2_rankup_popupWindow.setHeight(height * 2/7);
        character4_skill2_rankup_popupWindow.setFocusable(false);

        character4_skill2_rankup_checkText = (TextView)view.findViewById(R.id.character4_skill2_rankup_checkText);
        character4_skill2_rankup_yes = (Button)view.findViewById(R.id.character4_skill2_rankup_yes);
        character4_skill2_rankup_no = (Button)view.findViewById(R.id.character4_skill2_rankup_no);
        character4_skill2_rankup_no.setOnClickListener(closeCharacter4_skill2_rankup);
        character4_skill2_rankup_yes.setOnClickListener(let_character4_skill2_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter4Skill2_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character4_skill2_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character4_skill2_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character4_skill2_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank       = sharedPref.getInt("writeCharacter4Skill2_rank" , 0);
            int money      = sharedPref.getInt("writeMoney" , 0);
            int strengthen = sharedPref.getInt("writeCharacter4Skill2_strengthen" , 0);
            int cooltime   = sharedPref.getInt("writeCharacter4Skill2_cooltime" , 0);
            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                strengthen = strengthen + 25;
            }
            else if(rank == 3){
                strengthen = strengthen + 25;
            }
            else if(rank == 4){
                cooltime = cooltime - 1;
            }
            else if(rank == 5){
                strengthen = strengthen + 25;
            }
            else if(rank == 6){
                strengthen = strengthen + 25;
            }
            else if(rank == 7){
                cooltime = cooltime - 1;
            }
            else if(rank == 8){
                strengthen = strengthen + 25;
            }
            else if(rank == 9){
                strengthen = strengthen + 25;
            }
            else if(rank == 10){
                cooltime = cooltime - 1;
            }

            editor.putInt("writeCharacter4Skill2_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter4Skill2_strengthen" , strengthen);
            editor.putInt("writeCharacter4Skill2_cooltime" , cooltime);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter4Skill2_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character4_skill2_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter4_skill2_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_skill2_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter4_skill2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_skill_2_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter4_skill_3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character4_skill_3();
            character4_skill_3_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character4_skill_3(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height        = getWindowManager().getDefaultDisplay().getHeight();
        int width         = getWindowManager().getDefaultDisplay().getWidth();
        int attack        = sharedPref.getInt("writeCharacter4Skill3_attack" , 0);
        int weakenPercent = sharedPref.getInt("writeCharacter4Skill3_weakenPercent" , 0);
        int cooltime      = sharedPref.getInt("writeCharacter4Skill3_cooltime" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter4Skill3_rank" , 0);

        TextView character4_skill3_content;
        TextView character4_skill3_lv2;
        TextView character4_skill3_lv3;
        TextView character4_skill3_lv4;
        TextView character4_skill3_lv5;
        TextView character4_skill3_lv6;
        TextView character4_skill3_lv7;
        TextView character4_skill3_lv8;
        TextView character4_skill3_lv9;
        TextView character4_skill3_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character4_skill3 , null);
        character4_skill_3_popupWindow = new PopupWindow(view);
        character4_skill_3_popupWindow.setWidth(width * 4/5);
        character4_skill_3_popupWindow.setHeight(height * 5/6);
        character4_skill_3_popupWindow.setFocusable(false);
        character4_skill3_exit = (Button)view.findViewById(R.id.character4_skill3_exit);
        character4_skill3_level_up = (Button)view.findViewById(R.id.character4_skill3_level_up);
        character4_skill3_content = (TextView)view.findViewById(R.id.character4_skill3_content);
        character4_skill3_lv2 = (TextView)view.findViewById(R.id.character4_skill3_lv2);
        character4_skill3_lv3 = (TextView)view.findViewById(R.id.character4_skill3_lv3);
        character4_skill3_lv4 = (TextView)view.findViewById(R.id.character4_skill3_lv4);
        character4_skill3_lv5 = (TextView)view.findViewById(R.id.character4_skill3_lv5);
        character4_skill3_lv6 = (TextView)view.findViewById(R.id.character4_skill3_lv6);
        character4_skill3_lv7 = (TextView)view.findViewById(R.id.character4_skill3_lv7);
        character4_skill3_lv8 = (TextView)view.findViewById(R.id.character4_skill3_lv8);
        character4_skill3_lv9 = (TextView)view.findViewById(R.id.character4_skill3_lv9);
        character4_skill3_lv10 = (TextView)view.findViewById(R.id.character4_skill3_lv10);

        if(skill1Rank >= 10){
            character4_skill2_level_up.setEnabled(false);
        }

        character4_skill3_level_up.setOnClickListener(let_character4_skill3_level_up);
        character4_skill3_exit.setOnClickListener(closeCharacter4_skill3);

        character4_skill3_content.setText("對敵人造成" + attack + "%威力的3回攻擊，" + weakenPercent + "%的機率讓其cool time增加1回合\ncool time:" + cooltime + "回");

        if(skill1Rank == 2){
            character4_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character4_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character4_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character4_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character4_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character4_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character4_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character4_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character4_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character4_skill3_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character4_skill3_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_skill_3_popupWindow.dismiss();
            initPopupWindow_character4_skill_3_rankup();
            character4_skill3_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character4_skill_3_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character4_skill3_rankup , null);
        character4_skill3_rankup_popupWindow = new PopupWindow(view);
        character4_skill3_rankup_popupWindow.setWidth(width * 8/9);
        character4_skill3_rankup_popupWindow.setHeight(height * 2/7);
        character4_skill3_rankup_popupWindow.setFocusable(false);

        character4_skill3_rankup_checkText = (TextView)view.findViewById(R.id.character4_skill3_rankup_checkText);
        character4_skill3_rankup_yes = (Button)view.findViewById(R.id.character4_skill3_rankup_yes);
        character4_skill3_rankup_no = (Button)view.findViewById(R.id.character4_skill3_rankup_no);
        character4_skill3_rankup_no.setOnClickListener(closeCharacter4_skill3_rankup);
        character4_skill3_rankup_yes.setOnClickListener(let_character4_skill3_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter4Skill3_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character4_skill3_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character4_skill3_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character4_skill3_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank          = sharedPref.getInt("writeCharacter4Skill3_rank" , 0);
            int money         = sharedPref.getInt("writeMoney" , 0);
            int weakenPercent = sharedPref.getInt("writeCharacter4Skill3_weakenPercent" , 0);
            int attack        = sharedPref.getInt("writeCharacter4Skill3_attack" , 0);
            int cooltime      = sharedPref.getInt("writeCharacter4Skill3_cooltime" , 0);

            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                weakenPercent = weakenPercent + 10;
            }
            else if(rank == 3){
                attack = attack + 10;
            }
            else if(rank == 4){
                cooltime = cooltime - 1;
            }
            else if(rank == 5){
                attack = attack + 27;
            }
            else if(rank == 6){
                weakenPercent = weakenPercent + 15;
            }
            else if(rank == 7){
                cooltime = cooltime - 1;
            }
            else if(rank == 8){
                attack = attack + 28;
            }
            else if(rank == 9){
                weakenPercent = weakenPercent + 25;
            }
            else if(rank == 10){
                attack = attack + 52;
            }

            editor.putInt("writeCharacter4Skill3_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter4Skill3_attack" , attack);
            editor.putInt("writeCharacter4Skill3_weakenPercent" , weakenPercent);
            editor.putInt("writeCharacter4Skill3_cooltime" , cooltime);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter4Skill3_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character4_skill3_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter4_skill3_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_skill3_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter4_skill3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character4_skill_3_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character4_growth.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character4_growth.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character4_growth.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character4_growth.this , gacha.class);
            startActivity(intent);
        }
    };

    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("writeCharacter4Skill1_rank" , 1);
        editor.putInt("writeCharacter4Skill1_attack" , 234);
        editor.putInt("writeCharacter4Skill2_rank" , 1);
        editor.putInt("writeCharacter4Skill2_strengthen" , 50);
        editor.putInt("writeCharacter4Skill2_turn" , 2);
        editor.putInt("writeCharacter4Skill2_cooltime" , 5);
        editor.putInt("writeCharacter4Skill3_rank" , 1);
        editor.putInt("writeCharacter4Skill3_attack" , 167);
        editor.putInt("writeCharacter4Skill3_turn" , 3);
        editor.putInt("writeCharacter4Skill3_weakenPercent" , 50);
        editor.putInt("writeCharacter4Skill3_weakenTurn" , 1);
        editor.putInt("writeCharacter4Skill3_cooltime" , 7);
        editor.putInt("writeCharacter4HP" , 2800);
        editor.putInt("writeCharacter4Attack" , 170);
        editor.putInt("writeCharacter4Rank" , 1);
        //editor.commit();

        int saveRank4 = sharedPref.getInt("writeCharacter4Rank" , 0);
        int saveHP4 = sharedPref.getInt("writeCharacter4HP" , 0);
        int saveAttack4 = sharedPref.getInt("writeCharacter4Attack" , 0);
        int saveMoney = sharedPref.getInt("writeMoney" , 0);
        int saveRank =  sharedPref.getInt("writeRank" , 0);
        int saveSkill1Rank = sharedPref.getInt("writeCharacter4Skill1_rank" , 0);
        int saveSkill2Rank = sharedPref.getInt("writeCharacter4Skill2_rank" , 0);
        int saveSkill3Rank = sharedPref.getInt("writeCharacter4Skill3_rank" , 0);

        stringattack4 = Integer.toString(saveAttack4);
        stringhp4 = Integer.toString(saveHP4);
        stringrank4 = Integer.toString(saveRank4);
        stringmoneymoney = Integer.toString(saveMoney);
        stringRank = Integer.toString(saveRank);
        stringskill1Rank = "Lv." + Integer.toString(saveSkill1Rank);
        stringskill2Rank = "Lv." + Integer.toString(saveSkill2Rank);
        stringskill3Rank = "Lv." + Integer.toString(saveSkill3Rank);

        attack_attack_4.setText(stringattack4);
        hp_hp_4.setText(stringhp4);
        rank_4.setText(stringrank4);
        money_money.setText(stringmoneymoney);
        rank_rank.setText(stringRank);
        character4_skill_1_level.setText(stringskill1Rank);
        character4_skill_2_level.setText(stringskill2Rank);
        character4_skill_3_level.setText(stringskill3Rank);

        if(saveRank4 == 99){
            character4_rankup.setEnabled(false);
        }
    }
}