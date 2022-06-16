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

public class character11_growth extends AppCompatActivity {
    private Context context;
    private ImageButton character11_skill_1;
    private ImageButton character11_skill_2;
    private ImageButton character11_skill_3;
    private PopupWindow character11_skill_1_popupWindow = null;
    private PopupWindow character11_skill_2_popupWindow = null;
    private PopupWindow character11_skill_3_popupWindow = null;
    private PopupWindow character11_rankup_pupupWindow = null;
    private PopupWindow character11_skill1_rankup_popupWindow = null;
    private PopupWindow character11_skill2_rankup_popupWindow = null;
    private PopupWindow character11_skill3_rankup_popupWindow = null;
    private Button character11_skill1_exit;
    private Button character11_skill1_level_up;
    private Button character11_skill2_exit;
    private Button character11_skill2_level_up;
    private Button character11_skill3_exit;
    private Button character11_skill3_level_up;
    private Button character11_rankup;
    private Button character11_rankup_yes;
    private Button character11_rankup_no;
    private Button character11_skill1_rankup_yes;
    private Button character11_skill1_rankup_no;
    private Button character11_skill2_rankup_yes;
    private Button character11_skill2_rankup_no;
    private Button character11_skill3_rankup_yes;
    private Button character11_skill3_rankup_no;
    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private String stringmoneymoney;
    private String stringRank;
    private String stringrank11;
    private String stringhp11;
    private String stringattack11;
    private String stringskill1Rank;
    private String stringskill2Rank;
    private String stringskill3Rank;
    private TextView money_money;
    private TextView rank_rank;
    private TextView rank_11;
    private TextView attack_attack_11;
    private TextView hp_hp_11;
    private TextView character11_rankup_checkText;
    private TextView character11_skill1_rankup_checkText;
    private TextView character11_skill2_rankup_checkText;
    private TextView character11_skill3_rankup_checkText;
    private TextView character11_skill_1_level;
    private TextView character11_skill_2_level;
    private TextView character11_skill_3_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character11_growth);
        getSupportActionBar().hide();

        context = this;
        character11_skill_1 = (ImageButton)findViewById(R.id.character11_skill_1);
        character11_skill_2 = (ImageButton)findViewById(R.id.character11_skill_2);
        character11_skill_3 = (ImageButton)findViewById(R.id.character11_skill_3);
        character11_rankup = (Button)findViewById(R.id.character11_rankup);
        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);
        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);
        rank_11 = (TextView)findViewById(R.id.rank_11);
        attack_attack_11 = (TextView)findViewById(R.id.attack_attack_11);
        hp_hp_11 = (TextView)findViewById(R.id.hp_hp_11);
        character11_skill_1_level = (TextView)findViewById(R.id.character11_skill_1_level);
        character11_skill_2_level = (TextView)findViewById(R.id.character11_skill_2_level);
        character11_skill_3_level = (TextView)findViewById(R.id.character11_skill_3_level);

        character11_rankup.setOnClickListener(goToRankup);
        character11_skill_1.setOnClickListener(goTocharacter11_skill_1);
        character11_skill_2.setOnClickListener(goTocharacter11_skill_2);
        character11_skill_3.setOnClickListener(goTocharacter11_skill_3);
        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);

        onLoad();
    }

    private View.OnClickListener goToRankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character11_rankup();
            character11_rankup_pupupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character11_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();
        View view = LayoutInflater.from(context).inflate(R.layout.activity_character11_rankup , null);
        character11_rankup_pupupWindow = new PopupWindow(view);
        character11_rankup_pupupWindow.setWidth(width * 8/9);
        character11_rankup_pupupWindow.setHeight(height * 2/7);
        character11_rankup_pupupWindow.setFocusable(false);

        character11_rankup_checkText = (TextView)view.findViewById(R.id.character11_rankup_checkText);
        character11_rankup_yes = (Button)view.findViewById(R.id.character11_rankup_yes);
        character11_rankup_no = (Button)view.findViewById(R.id.character11_rankup_no);
        character11_rankup_no.setOnClickListener(closeCharacter11_rankup);
        character11_rankup_yes.setOnClickListener(let_character11_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter11Rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character11_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character11_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character11_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank =sharedPref.getInt("writeCharacter11Rank" , 0);
            int money =sharedPref.getInt("writeMoney" , 0);
            int attack = sharedPref.getInt("writeCharacter11Attack" , 0);
            int hp = sharedPref.getInt("writeCharacter11HP" , 0);

            hp = hp + 1000;
            attack = attack + 100;
            money = money - (rank * 1000);
            rank = rank + 1;

            editor.putInt("writeCharacter11Rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter11Attack" , attack);
            editor.putInt("writeCharacter11HP" , hp);
            editor.commit();

            int saveRank11 = sharedPref.getInt("writeCharacter11Rank" , 0);
            int saveHP11 = sharedPref.getInt("writeCharacter11HP" , 0);
            int saveAttack11 = sharedPref.getInt("writeCharacter11Attack" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character11_rankup_pupupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter11_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_rankup_pupupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter11_skill_1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character11_skill_1();
            character11_skill_1_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character11_skill_1(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height        = getWindowManager().getDefaultDisplay().getHeight();
        int width         = getWindowManager().getDefaultDisplay().getWidth();
        int attack        = sharedPref.getInt("writeCharacter11Skill1_attack" , 0);
        int weakenPercent = sharedPref.getInt("writeCharacter11Skill1_weakenPercent" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter11Skill1_rank" , 0);

        TextView character11_skill1_content;
        TextView character11_skill1_lv2;
        TextView character11_skill1_lv3;
        TextView character11_skill1_lv4;
        TextView character11_skill1_lv5;
        TextView character11_skill1_lv6;
        TextView character11_skill1_lv7;
        TextView character11_skill1_lv8;
        TextView character11_skill1_lv9;
        TextView character11_skill1_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character11_skill1 , null);
        character11_skill_1_popupWindow = new PopupWindow(view);
        character11_skill_1_popupWindow.setWidth(width * 4/5);
        character11_skill_1_popupWindow.setHeight(height * 5/6);
        character11_skill_1_popupWindow.setFocusable(false);
        character11_skill1_exit = (Button)view.findViewById(R.id.character11_skill1_exit);
        character11_skill1_level_up = (Button)view.findViewById(R.id.character11_skill1_level_up);
        character11_skill1_content = (TextView)view.findViewById(R.id.character11_skill1_content);
        character11_skill1_lv2 = (TextView)view.findViewById(R.id.character11_skill1_lv2);
        character11_skill1_lv3 = (TextView)view.findViewById(R.id.character11_skill1_lv3);
        character11_skill1_lv4 = (TextView)view.findViewById(R.id.character11_skill1_lv4);
        character11_skill1_lv5 = (TextView)view.findViewById(R.id.character11_skill1_lv5);
        character11_skill1_lv6 = (TextView)view.findViewById(R.id.character11_skill1_lv6);
        character11_skill1_lv7 = (TextView)view.findViewById(R.id.character11_skill1_lv7);
        character11_skill1_lv8 = (TextView)view.findViewById(R.id.character11_skill1_lv8);
        character11_skill1_lv9 = (TextView)view.findViewById(R.id.character11_skill1_lv9);
        character11_skill1_lv10 = (TextView)view.findViewById(R.id.character11_skill1_lv10);

        if(skill1Rank >= 10){
            character11_skill1_level_up.setEnabled(false);
        }

        character11_skill1_level_up.setOnClickListener(let_character11_skill1_level_up);
        character11_skill1_exit.setOnClickListener(closeCharacter11_skill1);

        character11_skill1_content.setText("對敵人造成" + attack + "%威力的攻擊，" + weakenPercent + "%的機率讓敵人行動不能一回合");

        if(skill1Rank == 2){
            character11_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character11_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character11_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character11_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character11_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character11_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character11_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character11_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character11_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill1_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character11_skill1_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_skill_1_popupWindow.dismiss();
            initPopupWindow_character11_skill_1_rankup();
            character11_skill1_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character11_skill_1_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character11_skill1_rankup , null);
        character11_skill1_rankup_popupWindow = new PopupWindow(view);
        character11_skill1_rankup_popupWindow.setWidth(width * 8/9);
        character11_skill1_rankup_popupWindow.setHeight(height * 2/7);
        character11_skill1_rankup_popupWindow.setFocusable(false);

        character11_skill1_rankup_checkText = (TextView)view.findViewById(R.id.character11_skill1_rankup_checkText);
        character11_skill1_rankup_yes = (Button)view.findViewById(R.id.character11_skill1_rankup_yes);
        character11_skill1_rankup_no = (Button)view.findViewById(R.id.character11_skill1_rankup_no);
        character11_skill1_rankup_no.setOnClickListener(closeCharacter11_skill1_rankup);
        character11_skill1_rankup_yes.setOnClickListener(let_character11_skill1_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter11Skill1_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character11_skill1_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character11_skill1_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character11_skill1_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank          = sharedPref.getInt("writeCharacter11Skill1_rank" , 0);
            int money         = sharedPref.getInt("writeMoney" , 0);
            int attack        = sharedPref.getInt("writeCharacter11Skill1_attack" , 0);
            int weakenPercent = sharedPref.getInt("writeCharacter11Skill1_weakenPercent" , 0);

            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                attack = attack + 13;
            }
            else if(rank == 3){
                weakenPercent = weakenPercent + 10;
            }
            else if(rank == 4){
                attack = attack + 14;
            }
            else if(rank == 5){
                weakenPercent = weakenPercent + 10;
            }
            else if(rank == 6){
                attack = attack + 26;
            }
            else if(rank == 7){
                weakenPercent = weakenPercent + 10;
            }
            else if(rank == 8){
                attack = attack + 28;
            }
            else if(rank == 9){
                weakenPercent = weakenPercent + 20;
            }
            else if(rank == 10){
                attack = attack + 53;
            }

            editor.putInt("writeCharacter11Skill1_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter11Skill1_attack" , attack);
            editor.putInt("writeCharacter11Skill1_weakenPercent" , weakenPercent);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter11Skill1_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character11_skill1_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter11_skill1_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_skill1_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter11_skill1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_skill_1_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter11_skill_2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character11_skill_2();
            character11_skill_2_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character11_skill_2(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height            = getWindowManager().getDefaultDisplay().getHeight();
        int width             = getWindowManager().getDefaultDisplay().getWidth();
        int heal              = sharedPref.getInt("writeCharacter11Skill2_heal" , 0);
        int cooltime          = sharedPref.getInt("writeCharacter11Skill2_cooltime" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter11Skill2_rank" , 0);

        TextView character11_skill2_content;
        TextView character11_skill2_lv2;
        TextView character11_skill2_lv3;
        TextView character11_skill2_lv4;
        TextView character11_skill2_lv5;
        TextView character11_skill2_lv6;
        TextView character11_skill2_lv7;
        TextView character11_skill2_lv8;
        TextView character11_skill2_lv9;
        TextView character11_skill2_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character11_skill2 , null);
        character11_skill_2_popupWindow = new PopupWindow(view);
        character11_skill_2_popupWindow.setWidth(width * 4/5);
        character11_skill_2_popupWindow.setHeight(height * 5/6);
        character11_skill_2_popupWindow.setFocusable(false);
        character11_skill2_exit = (Button)view.findViewById(R.id.character11_skill2_exit);
        character11_skill2_level_up = (Button)view.findViewById(R.id.character11_skill2_level_up);
        character11_skill2_content = (TextView)view.findViewById(R.id.character11_skill2_content);
        character11_skill2_lv2 = (TextView)view.findViewById(R.id.character11_skill2_lv2);
        character11_skill2_lv3 = (TextView)view.findViewById(R.id.character11_skill2_lv3);
        character11_skill2_lv4 = (TextView)view.findViewById(R.id.character11_skill2_lv4);
        character11_skill2_lv5 = (TextView)view.findViewById(R.id.character11_skill2_lv5);
        character11_skill2_lv6 = (TextView)view.findViewById(R.id.character11_skill2_lv6);
        character11_skill2_lv7 = (TextView)view.findViewById(R.id.character11_skill2_lv7);
        character11_skill2_lv8 = (TextView)view.findViewById(R.id.character11_skill2_lv8);
        character11_skill2_lv9 = (TextView)view.findViewById(R.id.character11_skill2_lv9);
        character11_skill2_lv10 = (TextView)view.findViewById(R.id.character11_skill2_lv10);

        if(skill1Rank >= 10){
            character11_skill2_level_up.setEnabled(false);
        }

        character11_skill2_level_up.setOnClickListener(let_character11_skill2_level_up);
        character11_skill2_exit.setOnClickListener(closeCharacter11_skill2);

        character11_skill2_content.setText("回復我方全體最大HP的" + heal + "%，且100%機率減少我方cool time一回合\ncool time:" + cooltime + "回");

        if(skill1Rank == 2){
            character11_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character11_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character11_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character11_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character11_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character11_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character11_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character11_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character11_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill2_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character11_skill2_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_skill_2_popupWindow.dismiss();
            initPopupWindow_character11_skill_2_rankup();
            character11_skill2_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character11_skill_2_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character11_skill2_rankup , null);
        character11_skill2_rankup_popupWindow = new PopupWindow(view);
        character11_skill2_rankup_popupWindow.setWidth(width * 8/9);
        character11_skill2_rankup_popupWindow.setHeight(height * 2/7);
        character11_skill2_rankup_popupWindow.setFocusable(false);

        character11_skill2_rankup_checkText = (TextView)view.findViewById(R.id.character11_skill2_rankup_checkText);
        character11_skill2_rankup_yes = (Button)view.findViewById(R.id.character11_skill2_rankup_yes);
        character11_skill2_rankup_no = (Button)view.findViewById(R.id.character11_skill2_rankup_no);
        character11_skill2_rankup_no.setOnClickListener(closeCharacter11_skill2_rankup);
        character11_skill2_rankup_yes.setOnClickListener(let_character11_skill2_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter11Skill2_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character11_skill2_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character11_skill2_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character11_skill2_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank     = sharedPref.getInt("writeCharacter11Skill2_rank" , 0);
            int money    = sharedPref.getInt("writeMoney" , 0);
            int heal     = sharedPref.getInt("writeCharacter11Skill2_heal" , 0);
            int cooltime = sharedPref.getInt("writeCharacter11Skill2_cooltime" , 0);

            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                heal = heal + 1;
            }
            else if(rank == 3){
                heal = heal + 1;
            }
            else if(rank == 4){
                cooltime = cooltime - 1;
            }
            else if(rank == 5){
                heal = heal + 1;
            }
            else if(rank == 6){
                heal = heal + 1;
            }
            else if(rank == 7){
                cooltime = cooltime - 1;
            }
            else if(rank == 8){
                heal = heal + 1;
            }
            else if(rank == 9){
                heal = heal + 2;
            }
            else if(rank == 10){
                heal = heal + 3;
            }

            editor.putInt("writeCharacter11Skill2_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter11Skill2_heal" , heal);
            editor.putInt("writeCharacter11Skill2_cooltime" , cooltime);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter11Skill2_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character11_skill2_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter11_skill2_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_skill2_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter11_skill2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_skill_2_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter11_skill_3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character11_skill_3();
            character11_skill_3_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character11_skill_3(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height        = getWindowManager().getDefaultDisplay().getHeight();
        int width         = getWindowManager().getDefaultDisplay().getWidth();
        int attack        = sharedPref.getInt("writeCharacter11Skill3_attack" , 0);
        int weakenPercent = sharedPref.getInt("writeCharacter11Skill3_weakenPercent" , 0);
        int cooltime      = sharedPref.getInt("writeCharacter11Skill3_cooltime" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter11Skill3_rank" , 0);

        TextView character11_skill3_content;
        TextView character11_skill3_lv2;
        TextView character11_skill3_lv3;
        TextView character11_skill3_lv4;
        TextView character11_skill3_lv5;
        TextView character11_skill3_lv6;
        TextView character11_skill3_lv7;
        TextView character11_skill3_lv8;
        TextView character11_skill3_lv9;
        TextView character11_skill3_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character11_skill3 , null);
        character11_skill_3_popupWindow = new PopupWindow(view);
        character11_skill_3_popupWindow.setWidth(width * 4/5);
        character11_skill_3_popupWindow.setHeight(height * 5/6);
        character11_skill_3_popupWindow.setFocusable(false);
        character11_skill3_exit = (Button)view.findViewById(R.id.character11_skill3_exit);
        character11_skill3_level_up = (Button)view.findViewById(R.id.character11_skill3_level_up);
        character11_skill3_content = (TextView)view.findViewById(R.id.character11_skill3_content);
        character11_skill3_lv2 = (TextView)view.findViewById(R.id.character11_skill3_lv2);
        character11_skill3_lv3 = (TextView)view.findViewById(R.id.character11_skill3_lv3);
        character11_skill3_lv4 = (TextView)view.findViewById(R.id.character11_skill3_lv4);
        character11_skill3_lv5 = (TextView)view.findViewById(R.id.character11_skill3_lv5);
        character11_skill3_lv6 = (TextView)view.findViewById(R.id.character11_skill3_lv6);
        character11_skill3_lv7 = (TextView)view.findViewById(R.id.character11_skill3_lv7);
        character11_skill3_lv8 = (TextView)view.findViewById(R.id.character11_skill3_lv8);
        character11_skill3_lv9 = (TextView)view.findViewById(R.id.character11_skill3_lv9);
        character11_skill3_lv10 = (TextView)view.findViewById(R.id.character11_skill3_lv10);

        if(skill1Rank >= 10){
            character11_skill3_level_up.setEnabled(false);
        }

        character11_skill3_level_up.setOnClickListener(let_character11_skill3_level_up);
        character11_skill3_exit.setOnClickListener(closeCharacter11_skill3);

        character11_skill3_content.setText("對敵人造成" + attack + "%威力的2回攻擊，" + weakenPercent + "%的機率讓敵人回復不能2回合且cool time 增加2回合\ncool time:" + cooltime + "回");

        if(skill1Rank == 2){
            character11_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character11_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character11_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character11_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character11_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character11_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character11_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character11_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character11_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character11_skill3_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character11_skill3_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_skill_3_popupWindow.dismiss();
            initPopupWindow_character11_skill_3_rankup();
            character11_skill3_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character11_skill_3_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character11_skill3_rankup , null);
        character11_skill3_rankup_popupWindow = new PopupWindow(view);
        character11_skill3_rankup_popupWindow.setWidth(width * 8/9);
        character11_skill3_rankup_popupWindow.setHeight(height * 2/7);
        character11_skill3_rankup_popupWindow.setFocusable(false);

        character11_skill3_rankup_checkText = (TextView)view.findViewById(R.id.character11_skill3_rankup_checkText);
        character11_skill3_rankup_yes = (Button)view.findViewById(R.id.character11_skill3_rankup_yes);
        character11_skill3_rankup_no = (Button)view.findViewById(R.id.character11_skill3_rankup_no);
        character11_skill3_rankup_no.setOnClickListener(closeCharacter11_skill3_rankup);
        character11_skill3_rankup_yes.setOnClickListener(let_character11_skill3_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter11Skill3_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character11_skill3_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character11_skill3_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character11_skill3_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank          = sharedPref.getInt("writeCharacter11Skill3_rank" , 0);
            int money         = sharedPref.getInt("writeMoney" , 0);
            int attack        = sharedPref.getInt("writeCharacter11Skill3_attack" , 0);
            int weakenPercent = sharedPref.getInt("writeCharacter11Skill3_weakenPercent" , 0);
            int cooltime      = sharedPref.getInt("writeCharacter11Skill3_cooltime" , 0);
            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                attack = attack + 26;
            }
            else if(rank == 3){
                weakenPercent = weakenPercent + 10;
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
                attack = attack + 53;
            }

            editor.putInt("writeCharacter11Skill3_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter11Skill3_attack" , attack);
            editor.putInt("writeCharacter11Skill3_weakenPercent" , weakenPercent);
            editor.putInt("writeCharacter11Skill3_cooltime" , cooltime);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter11Skill3_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character11_skill3_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter11_skill3_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_skill3_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter11_skill3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character11_skill_3_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character11_growth.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character11_growth.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character11_growth.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character11_growth.this , gacha.class);
            startActivity(intent);
        }
    };


    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("writeCharacter11Skill1_rank" , 1);
        editor.putInt("writeCharacter11Skill1_attack" , 466);
        editor.putInt("writeCharacter11Skill1_weakenPercent" , 50);
        editor.putInt("writeCharacter11Skill1_weakenTurn" , 1);
        editor.putInt("writeCharacter11Skill2_rank" , 1);
        editor.putInt("writeCharacter11Skill2_heal" , 30);
        editor.putInt("writeCharacter11Skill2_strengthenPercent" , 100);
        editor.putInt("writeCharacter11Skill2_strengthenTurn" , 1);
        editor.putInt("writeCharacter11Skill2_cooltime" , 7);
        editor.putInt("writeCharacter11Skill3_rank" , 1);
        editor.putInt("writeCharacter11Skill3_attack" , 366);
        editor.putInt("writeCharacter11Skill3_attackTurn" , 2 );
        editor.putInt("writeCharacter11Skill3_weakenPercent" , 50);
        editor.putInt("writeCharacter11Skill3_weakenTurn" , 2);
        editor.putInt("writeCharacter11Skill3_cooltime" , 6);
        editor.putInt("writeCharacter11HP" , 4000);
        editor.putInt("writeCharacter11Attack" , 330);
        editor.putInt("writeCharacter11Rank" , 1);
        //editor.commit();

        int saveRank11 = sharedPref.getInt("writeCharacter11Rank" , 0);
        int saveHP11 = sharedPref.getInt("writeCharacter11HP" , 0);
        int saveAttack11 = sharedPref.getInt("writeCharacter11Attack" , 0);
        int saveMoney = sharedPref.getInt("writeMoney" , 0);
        int saveRank =  sharedPref.getInt("writeRank" , 0);
        int saveSkill1Rank = sharedPref.getInt("writeCharacter11Skill1_rank" , 0);
        int saveSkill2Rank = sharedPref.getInt("writeCharacter11Skill2_rank" , 0);
        int saveSkill3Rank = sharedPref.getInt("writeCharacter11Skill3_rank" , 0);

        stringattack11 = Integer.toString(saveAttack11);
        stringhp11 = Integer.toString(saveHP11);
        stringrank11 = Integer.toString(saveRank11);
        stringmoneymoney = Integer.toString(saveMoney);
        stringRank = Integer.toString(saveRank);
        stringskill1Rank = "Lv." + Integer.toString(saveSkill1Rank);
        stringskill2Rank = "Lv." + Integer.toString(saveSkill2Rank);
        stringskill3Rank = "Lv." + Integer.toString(saveSkill3Rank);

        attack_attack_11.setText(stringattack11);
        hp_hp_11.setText(stringhp11);
        rank_11.setText(stringrank11);
        money_money.setText(stringmoneymoney);
        rank_rank.setText(stringRank);
        character11_skill_1_level.setText(stringskill1Rank);
        character11_skill_2_level.setText(stringskill2Rank);
        character11_skill_3_level.setText(stringskill3Rank);

        if(saveRank11 == 99){
            character11_rankup.setEnabled(false);
        }
    }
}