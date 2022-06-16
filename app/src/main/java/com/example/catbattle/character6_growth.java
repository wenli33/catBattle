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

public class character6_growth extends AppCompatActivity {
    private Context context;
    private ImageButton character6_skill_1;
    private ImageButton character6_skill_2;
    private ImageButton character6_skill_3;
    private PopupWindow character6_skill_1_popupWindow = null;
    private PopupWindow character6_skill_2_popupWindow = null;
    private PopupWindow character6_skill_3_popupWindow = null;
    private PopupWindow character6_rankup_pupupWindow = null;
    private PopupWindow character6_skill1_rankup_popupWindow = null;
    private PopupWindow character6_skill2_rankup_popupWindow = null;
    private PopupWindow character6_skill3_rankup_popupWindow = null;
    private Button character6_skill1_exit;
    private Button character6_skill1_level_up;
    private Button character6_skill2_exit;
    private Button character6_skill2_level_up;
    private Button character6_skill3_exit;
    private Button character6_skill3_level_up;
    private Button character6_rankup;
    private Button character6_rankup_yes;
    private Button character6_rankup_no;
    private Button character6_skill1_rankup_yes;
    private Button character6_skill1_rankup_no;
    private Button character6_skill2_rankup_yes;
    private Button character6_skill2_rankup_no;
    private Button character6_skill3_rankup_yes;
    private Button character6_skill3_rankup_no;
    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private String stringmoneymoney;
    private String stringRank;
    private String stringrank6;
    private String stringhp6;
    private String stringattack6;
    private String stringskill1Rank;
    private String stringskill2Rank;
    private String stringskill3Rank;
    private TextView money_money;
    private TextView rank_rank;
    private TextView rank_6;
    private TextView attack_attack_6;
    private TextView hp_hp_6;
    private TextView character6_rankup_checkText;
    private TextView character6_skill1_rankup_checkText;
    private TextView character6_skill2_rankup_checkText;
    private TextView character6_skill3_rankup_checkText;
    private TextView character6_skill_1_level;
    private TextView character6_skill_2_level;
    private TextView character6_skill_3_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character6_growth);
        getSupportActionBar().hide();

        context = this;
        character6_skill_1 = (ImageButton)findViewById(R.id.character6_skill_1);
        character6_skill_2 = (ImageButton)findViewById(R.id.character6_skill_2);
        character6_skill_3 = (ImageButton)findViewById(R.id.character6_skill_3);
        character6_rankup = (Button)findViewById(R.id.character6_rankup);
        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);
        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);
        rank_6 = (TextView)findViewById(R.id.rank_6);
        attack_attack_6 = (TextView)findViewById(R.id.attack_attack_6);
        hp_hp_6 = (TextView)findViewById(R.id.hp_hp_6);
        character6_skill_1_level = (TextView)findViewById(R.id.character6_skill_1_level);
        character6_skill_2_level = (TextView)findViewById(R.id.character6_skill_2_level);
        character6_skill_3_level = (TextView)findViewById(R.id.character6_skill_3_level);

        character6_rankup.setOnClickListener(goToRankup);
        character6_skill_1.setOnClickListener(goTocharacter6_skill_1);
        character6_skill_2.setOnClickListener(goTocharacter6_skill_2);
        character6_skill_3.setOnClickListener(goTocharacter6_skill_3);
        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);

        onLoad();
    }

    private View.OnClickListener goToRankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character6_rankup();
            character6_rankup_pupupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character6_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();
        View view = LayoutInflater.from(context).inflate(R.layout.activity_character6_rankup , null);
        character6_rankup_pupupWindow = new PopupWindow(view);
        character6_rankup_pupupWindow.setWidth(width * 8/9);
        character6_rankup_pupupWindow.setHeight(height * 2/7);
        character6_rankup_pupupWindow.setFocusable(false);

        character6_rankup_checkText = (TextView)view.findViewById(R.id.character6_rankup_checkText);
        character6_rankup_yes = (Button)view.findViewById(R.id.character6_rankup_yes);
        character6_rankup_no = (Button)view.findViewById(R.id.character6_rankup_no);
        character6_rankup_no.setOnClickListener(closeCharacter6_rankup);
        character6_rankup_yes.setOnClickListener(let_character6_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter6Rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character6_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character6_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character6_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank =sharedPref.getInt("writeCharacter6Rank" , 0);
            int money =sharedPref.getInt("writeMoney" , 0);
            int attack = sharedPref.getInt("writeCharacter6Attack" , 0);
            int hp = sharedPref.getInt("writeCharacter6HP" , 0);

            hp = hp + 1000;
            attack = attack + 100;
            money = money - (rank * 1000);
            rank = rank + 1;

            editor.putInt("writeCharacter6Rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter6Attack" , attack);
            editor.putInt("writeCharacter6HP" , hp);
            editor.commit();

            int saveRank6 = sharedPref.getInt("writeCharacter6Rank" , 0);
            int saveHP6 = sharedPref.getInt("writeCharacter6HP" , 0);
            int saveAttack6 = sharedPref.getInt("writeCharacter6Attack" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character6_rankup_pupupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter6_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_rankup_pupupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter6_skill_1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character6_skill_1();
            character6_skill_1_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character6_skill_1(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height     = getWindowManager().getDefaultDisplay().getHeight();
        int width      = getWindowManager().getDefaultDisplay().getWidth();
        int attack     = sharedPref.getInt("writeCharacter6Skill1_attack" , 0);
        int strengthen = sharedPref.getInt("writeCharacter6Skill1_strengthen" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter6Skill1_rank" , 0);

        TextView character6_skill1_content;
        TextView character6_skill1_lv2;
        TextView character6_skill1_lv3;
        TextView character6_skill1_lv4;
        TextView character6_skill1_lv5;
        TextView character6_skill1_lv6;
        TextView character6_skill1_lv7;
        TextView character6_skill1_lv8;
        TextView character6_skill1_lv9;
        TextView character6_skill1_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character6_skill1 , null);
        character6_skill_1_popupWindow = new PopupWindow(view);
        character6_skill_1_popupWindow.setWidth(width * 4/5);
        character6_skill_1_popupWindow.setHeight(height * 5/6);
        character6_skill_1_popupWindow.setFocusable(false);
        character6_skill1_exit = (Button)view.findViewById(R.id.character6_skill1_exit);
        character6_skill1_level_up = (Button)view.findViewById(R.id.character6_skill1_level_up);
        character6_skill1_content = (TextView)view.findViewById(R.id.character6_skill1_content);
        character6_skill1_lv2 = (TextView)view.findViewById(R.id.character6_skill1_lv2);
        character6_skill1_lv3 = (TextView)view.findViewById(R.id.character6_skill1_lv3);
        character6_skill1_lv4 = (TextView)view.findViewById(R.id.character6_skill1_lv4);
        character6_skill1_lv5 = (TextView)view.findViewById(R.id.character6_skill1_lv5);
        character6_skill1_lv6 = (TextView)view.findViewById(R.id.character6_skill1_lv6);
        character6_skill1_lv7 = (TextView)view.findViewById(R.id.character6_skill1_lv7);
        character6_skill1_lv8 = (TextView)view.findViewById(R.id.character6_skill1_lv8);
        character6_skill1_lv9 = (TextView)view.findViewById(R.id.character6_skill1_lv9);
        character6_skill1_lv10 = (TextView)view.findViewById(R.id.character6_skill1_lv10);

        if(skill1Rank >= 10){
            character6_skill1_level_up.setEnabled(false);
        }

        character6_skill1_level_up.setOnClickListener(let_character6_skill1_level_up);
        character6_skill1_exit.setOnClickListener(closeCharacter6_skill1);

        character6_skill1_content.setText("對敵人造成" + attack + "%威力的2回攻擊，對我方全員攻擊增加" + strengthen + "%一回合");

        if(skill1Rank == 2){
            character6_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character6_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character6_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character6_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character6_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character6_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character6_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character6_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character6_skill1_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill1_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character6_skill1_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_skill_1_popupWindow.dismiss();
            initPopupWindow_character6_skill_1_rankup();
            character6_skill1_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character6_skill_1_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character6_skill1_rankup , null);
        character6_skill1_rankup_popupWindow = new PopupWindow(view);
        character6_skill1_rankup_popupWindow.setWidth(width * 8/9);
        character6_skill1_rankup_popupWindow.setHeight(height * 2/7);
        character6_skill1_rankup_popupWindow.setFocusable(false);

        character6_skill1_rankup_checkText = (TextView)view.findViewById(R.id.character6_skill1_rankup_checkText);
        character6_skill1_rankup_yes = (Button)view.findViewById(R.id.character6_skill1_rankup_yes);
        character6_skill1_rankup_no = (Button)view.findViewById(R.id.character6_skill1_rankup_no);
        character6_skill1_rankup_no.setOnClickListener(closeCharacter6_skill1_rankup);
        character6_skill1_rankup_yes.setOnClickListener(let_character6_skill1_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter6Skill1_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character6_skill1_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character6_skill1_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character6_skill1_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank       = sharedPref.getInt("writeCharacter6Skill1_rank" , 0);
            int money      = sharedPref.getInt("writeMoney" , 0);
            int attack     = sharedPref.getInt("writeCharacter6Skill1_attack" , 0);
            int strengthen = sharedPref.getInt("writeCharacter6Skill1_strengthen" , 0);

            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                attack = attack + 13;
            }
            else if(rank == 3){
                strengthen = strengthen + 25;
            }
            else if(rank == 4){
                attack = attack + 15;
            }
            else if(rank == 5){
                attack = attack + 17;
            }
            else if(rank == 6){
                strengthen = strengthen + 25;
            }
            else if(rank == 7){
                attack = attack + 22;
            }
            else if(rank == 8){
                attack = attack + 24;
            }
            else if(rank == 9){
                strengthen = strengthen + 25;
            }
            else if(rank == 10){
                attack = attack + 42;
            }

            editor.putInt("writeCharacter6Skill1_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter6Skill1_attack" , attack);
            editor.putInt("writeCharacter6Skill1_strengthen" , strengthen);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter6Skill1_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character6_skill1_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter6_skill1_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_skill1_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter6_skill1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_skill_1_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter6_skill_2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character6_skill_2();
            character6_skill_2_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character6_skill_2(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height     = getWindowManager().getDefaultDisplay().getHeight();
        int width      = getWindowManager().getDefaultDisplay().getWidth();
        int strengthen = sharedPref.getInt("writeCharacter6Skill2_strengthen" , 0);
        int heal       = sharedPref.getInt("writeCharacter6Skill2_heal" , 0);
        int cooltime   = sharedPref.getInt("writeCharacter6Skill2_cooltime" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter6Skill2_rank" , 0);

        TextView character6_skill2_content;
        TextView character6_skill2_lv2;
        TextView character6_skill2_lv3;
        TextView character6_skill2_lv4;
        TextView character6_skill2_lv5;
        TextView character6_skill2_lv6;
        TextView character6_skill2_lv7;
        TextView character6_skill2_lv8;
        TextView character6_skill2_lv9;
        TextView character6_skill2_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character6_skill2 , null);
        character6_skill_2_popupWindow = new PopupWindow(view);
        character6_skill_2_popupWindow.setWidth(width * 4/5);
        character6_skill_2_popupWindow.setHeight(height * 5/6);
        character6_skill_2_popupWindow.setFocusable(false);
        character6_skill2_exit = (Button)view.findViewById(R.id.character6_skill2_exit);
        character6_skill2_level_up = (Button)view.findViewById(R.id.character6_skill2_level_up);
        character6_skill2_content = (TextView)view.findViewById(R.id.character6_skill2_content);
        character6_skill2_lv2 = (TextView)view.findViewById(R.id.character6_skill2_lv2);
        character6_skill2_lv3 = (TextView)view.findViewById(R.id.character6_skill2_lv3);
        character6_skill2_lv4 = (TextView)view.findViewById(R.id.character6_skill2_lv4);
        character6_skill2_lv5 = (TextView)view.findViewById(R.id.character6_skill2_lv5);
        character6_skill2_lv6 = (TextView)view.findViewById(R.id.character6_skill2_lv6);
        character6_skill2_lv7 = (TextView)view.findViewById(R.id.character6_skill2_lv7);
        character6_skill2_lv8 = (TextView)view.findViewById(R.id.character6_skill2_lv8);
        character6_skill2_lv9 = (TextView)view.findViewById(R.id.character6_skill2_lv9);
        character6_skill2_lv10 = (TextView)view.findViewById(R.id.character6_skill2_lv10);

        if(skill1Rank >= 10){
            character6_skill2_level_up.setEnabled(false);
        }

        character6_skill2_level_up.setOnClickListener(let_character6_skill2_level_up);
        character6_skill2_exit.setOnClickListener(closeCharacter6_skill2);

        character6_skill2_content.setText("對我方全員攻擊增加" + strengthen + "%一回合，且回復HP" + heal + "%\ncool time:" + cooltime + "回");

        if(skill1Rank == 2){
            character6_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character6_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character6_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character6_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character6_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character6_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character6_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character6_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character6_skill2_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill2_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character6_skill2_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_skill_2_popupWindow.dismiss();
            initPopupWindow_character6_skill_2_rankup();
            character6_skill2_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character6_skill_2_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character6_skill2_rankup , null);
        character6_skill2_rankup_popupWindow = new PopupWindow(view);
        character6_skill2_rankup_popupWindow.setWidth(width * 8/9);
        character6_skill2_rankup_popupWindow.setHeight(height * 2/7);
        character6_skill2_rankup_popupWindow.setFocusable(false);

        character6_skill2_rankup_checkText = (TextView)view.findViewById(R.id.character6_skill2_rankup_checkText);
        character6_skill2_rankup_yes = (Button)view.findViewById(R.id.character6_skill2_rankup_yes);
        character6_skill2_rankup_no = (Button)view.findViewById(R.id.character6_skill2_rankup_no);
        character6_skill2_rankup_no.setOnClickListener(closeCharacter6_skill2_rankup);
        character6_skill2_rankup_yes.setOnClickListener(let_character6_skill2_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter6Skill2_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character6_skill2_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character6_skill2_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character6_skill2_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank       = sharedPref.getInt("writeCharacter6Skill2_rank" , 0);
            int money      = sharedPref.getInt("writeMoney" , 0);
            int strengthen = sharedPref.getInt("writeCharacter6Skill2_strengthen" ,  0);
            int heal       = sharedPref.getInt("writeCharacter6Skill2_heal" , 0);
            int cooltime   = sharedPref.getInt("writeCharacter6Skill2_cooltime" , 0);

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
                heal = heal + 5;
            }
            else if(rank == 9){
                heal = heal + 5;
            }
            else if(rank == 10){
                heal = heal + 10;
            }

            editor.putInt("writeCharacter6Skill2_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter6Skill2_strengthen" , strengthen);
            editor.putInt("writeCharacter6Skill2_heal" , heal);
            editor.putInt("writeCharacter6Skill2_cooltime" , cooltime);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter6Skill2_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character6_skill2_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter6_skill2_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_skill2_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter6_skill2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_skill_2_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goTocharacter6_skill_3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_character6_skill_3();
            character6_skill_3_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character6_skill_3(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int height            = getWindowManager().getDefaultDisplay().getHeight();
        int width             = getWindowManager().getDefaultDisplay().getWidth();
        int attack            = sharedPref.getInt("writeCharacter6Skill3_attack" , 0);
        int strengthenPercent = sharedPref.getInt("writeCharacter6Skill3_strengthenPercent" , 0);
        int heal              = sharedPref.getInt("writeCharacter6Skill3_heal" , 0);
        int cooltime          = sharedPref.getInt("writeCharacter6Skill3_cooltime" , 0);
        int skill1Rank = sharedPref.getInt("writeCharacter6Skill3_rank" , 0);

        TextView character6_skill3_content;
        TextView character6_skill3_lv2;
        TextView character6_skill3_lv3;
        TextView character6_skill3_lv4;
        TextView character6_skill3_lv5;
        TextView character6_skill3_lv6;
        TextView character6_skill3_lv7;
        TextView character6_skill3_lv8;
        TextView character6_skill3_lv9;
        TextView character6_skill3_lv10;

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character6_skill3 , null);
        character6_skill_3_popupWindow = new PopupWindow(view);
        character6_skill_3_popupWindow.setWidth(width * 4/5);
        character6_skill_3_popupWindow.setHeight(height * 5/6);
        character6_skill_3_popupWindow.setFocusable(false);
        character6_skill3_exit = (Button)view.findViewById(R.id.character6_skill3_exit);
        character6_skill3_level_up = (Button)view.findViewById(R.id.character6_skill3_level_up);
        character6_skill3_content = (TextView)view.findViewById(R.id.character6_skill3_content);
        character6_skill3_lv2 = (TextView)view.findViewById(R.id.character6_skill3_lv2);
        character6_skill3_lv3 = (TextView)view.findViewById(R.id.character6_skill3_lv3);
        character6_skill3_lv4 = (TextView)view.findViewById(R.id.character6_skill3_lv4);
        character6_skill3_lv5 = (TextView)view.findViewById(R.id.character6_skill3_lv5);
        character6_skill3_lv6 = (TextView)view.findViewById(R.id.character6_skill3_lv6);
        character6_skill3_lv7 = (TextView)view.findViewById(R.id.character6_skill3_lv7);
        character6_skill3_lv8 = (TextView)view.findViewById(R.id.character6_skill3_lv8);
        character6_skill3_lv9 = (TextView)view.findViewById(R.id.character6_skill3_lv9);
        character6_skill3_lv10 = (TextView)view.findViewById(R.id.character6_skill3_lv10);

        if(skill1Rank >= 10){
            character6_skill3_level_up.setEnabled(false);
        }

        character6_skill3_level_up.setOnClickListener(let_character6_skill3_level_up);
        character6_skill3_exit.setOnClickListener(closeCharacter6_skill3);

        character6_skill3_content.setText("對敵人造成" + attack + "%威力的傷害，" + strengthenPercent + "%的機率回復我方全員HP" + heal + "%\ncool time:" +cooltime + "回");

        if(skill1Rank == 2){
            character6_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 3){
            character6_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 4){
            character6_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 5){
            character6_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 6){
            character6_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 7){
            character6_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 8){
            character6_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 9){
            character6_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv9.setTextColor(Color.rgb(0 , 102 , 255));
        }
        else if(skill1Rank == 10){
            character6_skill3_lv2.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv3.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv4.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv5.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv6.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv7.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv8.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv9.setTextColor(Color.rgb(0 , 102 , 255));
            character6_skill3_lv10.setTextColor(Color.rgb(0 , 102 , 255));
        }
    }

    private View.OnClickListener let_character6_skill3_level_up = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_skill_3_popupWindow.dismiss();
            initPopupWindow_character6_skill_3_rankup();
            character6_skill3_rankup_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_character6_skill_3_rankup(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();

        View view = LayoutInflater.from(context).inflate(R.layout.activity_character6_skill3_rankup , null);
        character6_skill3_rankup_popupWindow = new PopupWindow(view);
        character6_skill3_rankup_popupWindow.setWidth(width * 8/9);
        character6_skill3_rankup_popupWindow.setHeight(height * 2/7);
        character6_skill3_rankup_popupWindow.setFocusable(false);

        character6_skill3_rankup_checkText = (TextView)view.findViewById(R.id.character6_skill3_rankup_checkText);
        character6_skill3_rankup_yes = (Button)view.findViewById(R.id.character6_skill3_rankup_yes);
        character6_skill3_rankup_no = (Button)view.findViewById(R.id.character6_skill3_rankup_no);
        character6_skill3_rankup_no.setOnClickListener(closeCharacter6_skill3_rankup);
        character6_skill3_rankup_yes.setOnClickListener(let_character6_skill3_rankup);

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        int rankupMoney =sharedPref.getInt("writeCharacter6Skill3_rank" , 0) * 1000;

        int money =sharedPref.getInt("writeMoney" , 0);

        String checkText = "升級需要" + rankupMoney + "G，確定要升級嗎？";
        System.out.println("rankupMoey = " + rankupMoney);
        System.out.println("money = " + money);
        character6_skill3_rankup_checkText.setText(checkText);

        if(money < rankupMoney){
            character6_skill3_rankup_yes.setEnabled(false);
        }
    }

    private View.OnClickListener let_character6_skill3_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int rank              = sharedPref.getInt("writeCharacter6Skill3_rank" , 0);
            int money             = sharedPref.getInt("writeMoney" , 0);
            int attack            = sharedPref.getInt("writeCharacter6Skill3_attack" , 0);
            int strengthenPercent = sharedPref.getInt("writeCharacter6Skill3_strengthenPercent" , 0);
            int heal              = sharedPref.getInt("writeCharacter6Skill3_heal" , 0);
            int cooltime          = sharedPref.getInt("writeCharacter6Skill3_cooltime" , 0);
            money = money - (rank * 1000);
            rank = rank + 1;

            if(rank == 2){
                attack = attack + 25;
            }
            else if(rank == 3){
                strengthenPercent = strengthenPercent + 10;
            }
            else if(rank == 4){
                cooltime = cooltime - 1;
            }
            else if(rank == 5){
                attack = attack + 25;
            }
            else if(rank == 6){
                strengthenPercent = strengthenPercent + 15;
            }
            else if(rank == 7){
                cooltime = cooltime - 1;
            }
            else if(rank == 8){
                attack = attack + 100;
            }
            else if(rank == 9){
                strengthenPercent = strengthenPercent + 25;
            }
            else if(rank == 10){
                attack = attack + 100;
            }

            editor.putInt("writeCharacter6Skill3_rank" , rank);
            editor.putInt("writeMoney" , money);
            editor.putInt("writeCharacter6Skill3_attack" , attack);
            editor.putInt("writeCharacter6Skill3_strengthenPercent" , strengthenPercent);
            editor.putInt("writeCharacter6Skill3_heal" , heal);
            editor.putInt("writeCharacter6Skill3_cooltime" , cooltime);
            editor.commit();

            int saveRank1 = sharedPref.getInt("writeCharacter6Skill3_rank" , 0);
            int saveMoney = sharedPref.getInt("writeMoney" , 0);
            int saveRank =  sharedPref.getInt("writeRank" , 0);

            character6_skill3_rankup_popupWindow.dismiss();
            onLoad();
        }
    };

    private View.OnClickListener closeCharacter6_skill3_rankup = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_skill3_rankup_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeCharacter6_skill3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            character6_skill_3_popupWindow.dismiss();
        }
    };

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character6_growth.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character6_growth.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character6_growth.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character6_growth.this , gacha.class);
            startActivity(intent);
        }
    };


    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("writeCharacter6Skill1_rank" , 1);
        editor.putInt("writeCharacter6Skill1_attack" , 117);
        editor.putInt("writeCharacter6Skill1_turn" , 2);
        editor.putInt("writeCharacter6Skill1_strengthen" , 25);
        editor.putInt("writeCharacter6Skill2_rank" , 1);
        editor.putInt("writeCharacter6Skill2_strengthen" , 100);
        editor.putInt("writeCharacter6Skill2_heal" , 10);
        editor.putInt("writeCharacter6Skill2_cooltime" , 5);
        editor.putInt("writeCharacter6Skill3_rank" , 1);
        editor.putInt("writeCharacter6Skill3_attack" , 400);
        editor.putInt("writeCharacter6Skill3_strengthenPercent" , 50);
        editor.putInt("writeCharacter6Skill3_heal" , 10);
        editor.putInt("writeCharacter6Skill3_cooltime" , 5);
        editor.putInt("writeCharacter6HP" , 3000);
        editor.putInt("writeCharacter6Attack" , 190);
        editor.putInt("writeCharacter6Rank" , 1);
        //editor.commit();

        int saveRank6 = sharedPref.getInt("writeCharacter6Rank" , 0);
        int saveHP6 = sharedPref.getInt("writeCharacter6HP" , 0);
        int saveAttack6 = sharedPref.getInt("writeCharacter6Attack" , 0);
        int saveMoney = sharedPref.getInt("writeMoney" , 0);
        int saveRank =  sharedPref.getInt("writeRank" , 0);
        int saveSkill1Rank = sharedPref.getInt("writeCharacter6Skill1_rank" , 0);
        int saveSkill2Rank = sharedPref.getInt("writeCharacter6Skill2_rank" , 0);
        int saveSkill3Rank = sharedPref.getInt("writeCharacter6Skill3_rank" , 0);

        stringattack6 = Integer.toString(saveAttack6);
        stringhp6 = Integer.toString(saveHP6);
        stringrank6 = Integer.toString(saveRank6);
        stringmoneymoney = Integer.toString(saveMoney);
        stringRank = Integer.toString(saveRank);
        stringskill1Rank = "Lv." + Integer.toString(saveSkill1Rank);
        stringskill2Rank = "Lv." + Integer.toString(saveSkill2Rank);
        stringskill3Rank = "Lv." + Integer.toString(saveSkill3Rank);

        attack_attack_6.setText(stringattack6);
        hp_hp_6.setText(stringhp6);
        rank_6.setText(stringrank6);
        money_money.setText(stringmoneymoney);
        rank_rank.setText(stringRank);
        character6_skill_1_level.setText(stringskill1Rank);
        character6_skill_2_level.setText(stringskill2Rank);
        character6_skill_3_level.setText(stringskill3Rank);

        if(saveRank6 == 99){
            character6_rankup.setEnabled(false);
        }
    }
}