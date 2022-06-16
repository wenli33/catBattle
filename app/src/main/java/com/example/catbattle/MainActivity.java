package com.example.catbattle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Button battle;
    private Button play;
    private Button changeCharacter;
    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private String stringmoneymoney;
    private String stringRank;
    private TextView money_money;
    private TextView rank_rank;
    private ImageView homeCharacter;
    private PopupWindow changeCharacter_popupWindow = null;
    private PopupWindow getMoney_popWindow = null;
    private LinearLayout getMoney;
    private int writeFirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        context = this;
        getMoney = (LinearLayout)findViewById(R.id.getMoney);
        homeCharacter = (ImageView)findViewById(R.id.homeCharacter);
        battle = (Button)findViewById(R.id.battle);
        play = (Button)findViewById(R.id.play);
        changeCharacter = (Button)findViewById(R.id.changeCharacter);
        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);
        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);

        battle.setOnClickListener(gotoBattle);
        play.setOnClickListener(gotoGetMoney);
        changeCharacter.setOnClickListener(gotoChange);
        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);
        onLoad();
        setCharacter();
    }

    private View.OnClickListener gotoBattle = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this , battle_main.class);
            startActivity(intent);
        }
    };


    private View.OnClickListener gotoChange = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_changeCharacter();
            changeCharacter_popupWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private View.OnClickListener gotoGetMoney = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            initPopupWindow_getMoney();
            getMoney_popWindow.showAtLocation(v , Gravity.CENTER_HORIZONTAL , 0 , 0);
        }
    };

    private void initPopupWindow_getMoney(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        int money = sharedPref.getInt("writeMoney" , 0);
        money = money + 10000;
        editor.putInt("writeMoney" , money);
        editor.commit();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();
        View view = LayoutInflater.from(context).inflate(R.layout.activity_get_money , null);
        getMoney_popWindow = new PopupWindow(view);
        getMoney_popWindow.setWidth(width * 7/8);
        getMoney_popWindow.setHeight(height * 1/4);
        getMoney_popWindow.setFocusable(false);

        Button check;
        check = (Button)view.findViewById(R.id.check);
        check.setOnClickListener(closeMoney);
        onLoad();
    }

    private void initPopupWindow_changeCharacter(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int width  = getWindowManager().getDefaultDisplay().getWidth();
        View view = LayoutInflater.from(context).inflate(R.layout.activity_change_character , null);
        changeCharacter_popupWindow = new PopupWindow(view);
        changeCharacter_popupWindow.setWidth(width * 7/8);
        changeCharacter_popupWindow.setHeight(height * 4/5);
        changeCharacter_popupWindow.setFocusable(false);

        ImageButton character1;
        ImageButton character2;
        ImageButton character3;
        ImageButton character4;
        ImageButton character5;
        ImageButton character6;
        ImageButton character7;
        ImageButton character8;
        ImageButton character9;
        ImageButton character10;
        ImageButton character11;
        ImageButton character12;
        Button      cancel;

        character1 = (ImageButton)view.findViewById(R.id.character1);
        character2 = (ImageButton)view.findViewById(R.id.character2);
        character3 = (ImageButton)view.findViewById(R.id.character3);
        character4 = (ImageButton)view.findViewById(R.id.character4);
        character5 = (ImageButton)view.findViewById(R.id.character5);
        character6 = (ImageButton)view.findViewById(R.id.character6);
        character7 = (ImageButton)view.findViewById(R.id.character7);
        character8 = (ImageButton)view.findViewById(R.id.character8);
        character9 = (ImageButton)view.findViewById(R.id.character9);
        character10 = (ImageButton)view.findViewById(R.id.character10);
        character11 = (ImageButton)view.findViewById(R.id.character11);
        character12 = (ImageButton)view.findViewById(R.id.character12);
        cancel = (Button)view.findViewById(R.id.cancel);

        character1.setOnClickListener(setMainCharacter1);
        character2.setOnClickListener(setMainCharacter2);
        character3.setOnClickListener(setMainCharacter3);
        character4.setOnClickListener(setMainCharacter4);
        character5.setOnClickListener(setMainCharacter5);
        character6.setOnClickListener(setMainCharacter6);
        character7.setOnClickListener(setMainCharacter7);
        character8.setOnClickListener(setMainCharacter8);
        character9.setOnClickListener(setMainCharacter9);
        character10.setOnClickListener(setMainCharacter10);
        character11.setOnClickListener(setMainCharacter11);
        character12.setOnClickListener(setMainCharacter12);
        cancel.setOnClickListener(closeChange);
    }

    private View.OnClickListener setMainCharacter1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 1);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 2);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 3);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter4 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 4);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter5 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 5);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter6 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 6);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter7 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 7);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter8 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 8);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter9 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 9);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter10 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 10);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter11 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 11);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener setMainCharacter12 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("writeMainCharacter" , 12);
            editor.commit();
            changeCharacter_popupWindow.dismiss();
            setCharacter();
        }
    };

    private View.OnClickListener closeChange = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            changeCharacter_popupWindow.dismiss();
        }
    };

    private View.OnClickListener closeMoney = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            getMoney_popWindow.dismiss();
        }
    };

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this , gacha.class);
            startActivity(intent);
        }
    };

    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        writeFirst = sharedPref.getInt("writeFirst" , 0);
        if(writeFirst == 0){
            editor.putInt("writeRank" , 1);
            editor.putInt("writeMoney" , 1000000);

            editor.putInt("writeMainCharacter" , 1);

            editor.putInt("writeCharacter1Skill1_rank" , 1);
            editor.putInt("writeCharacter1Skill1_attack" , 100);
            editor.putInt("writeCharacter1Skill2_rank" , 1);
            editor.putInt("writeCharacter1Skill2_heal" , 20);
            editor.putInt("writeCharacter1Skill2_cooltime" , 4);
            editor.putInt("writeCharacter1Skill3_rank" , 1);
            editor.putInt("writeCharacter1Skill3_attack" , 467);
            editor.putInt("writeCharacter1Skill3_cooltime" , 6);
            editor.putInt("writeCharacter1HP" , 2500);
            editor.putInt("writeCharacter1Attack" , 150);
            editor.putInt("writeCharacter1Rank" , 1);

            editor.putInt("writeCharacter2Skill1_rank" , 1);
            editor.putInt("writeCharacter2Skill1_attack" , 100);
            editor.putInt("writeCharacter2Skill2_rank" , 1);
            editor.putInt("writeCharacter2Skill2_attack" , 200);
            editor.putInt("writeCharacter2Skill2_heal" , 10);
            editor.putInt("writeCharacter2Skill2_cooltime" , 5);
            editor.putInt("writeCharacter2Skill3_rank" , 1);
            editor.putInt("writeCharacter2Skill3_strengthen" , 50);
            editor.putInt("writeCharacter2Skill3_cooltime" , 6);
            editor.putInt("writeCharacter2HP" , 2500);
            editor.putInt("writeCharacter2Attack" , 150);
            editor.putInt("writeCharacter2Rank" , 1);

            editor.putInt("writeCharacter3Skill1_rank" , 1);
            editor.putInt("writeCharacter3Skill1_attack" , 200);
            editor.putInt("writeCharacter3Skill2_rank" , 1);
            editor.putInt("writeCharacter3Skill2_heal" , 30);
            editor.putInt("writeCharacter3Skill2_cooltime" , 5);
            editor.putInt("writeCharacter3Skill3_rank" , 1);
            editor.putInt("writeCharacter3Skill3_attack" , 467);
            editor.putInt("writeCharacter3Skill3_weakenPercent" , 25);
            editor.putInt("writeCharacter3Skill3_weaken" , 50);
            editor.putInt("writeCharacter3Skill3_cooltime" , 7);
            editor.putInt("writeCharacter3HP" , 2400);
            editor.putInt("writeCharacter3Attack" , 160);
            editor.putInt("writeCharacter3Rank" , 1);

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

            editor.putInt("writeCharacter5Skill1_rank" , 1);
            editor.putInt("writeCharacter5Skill1_attack" , 117);
            editor.putInt("writeCharacter5Skill1_turn" , 2);
            editor.putInt("writeCharacter5Skill2_rank" , 1);
            editor.putInt("writeCharacter5Skill2_strengthen" , 50);
            editor.putInt("writeCharacter5Skill2_heal" , 20);
            editor.putInt("writeCharacter5Skill2_cooltime" , 6);
            editor.putInt("writeCharacter5Skill3_rank" , 1);
            editor.putInt("writeCharacter5Skill3_attack" , 500);
            editor.putInt("writeCharacter5Skill3_cooltime" , 4);
            editor.putInt("writeCharacter5HP" , 2900);
            editor.putInt("writeCharacter5Attack" , 170);
            editor.putInt("writeCharacter5Rank" , 1);

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

            editor.putInt("writeCharacter7Skill1_rank" , 1);
            editor.putInt("writeCharacter7Skill1_attack" , 276);
            editor.putInt("writeCharacter7Skill2_rank" , 1);
            editor.putInt("writeCharacter7Skill2_strengthen" , 100);
            editor.putInt("writeCharacter7Skill2_cooltime" , 6);
            editor.putInt("writeCharacter7Skill3_rank" , 1);
            editor.putInt("writeCharacter7Skill3_attack" , 222);
            editor.putInt("writeCharacter7Skill3_attackTurn" , 3);
            editor.putInt("writeCharacter7Skill3_weakenPercent" , 50);
            editor.putInt("writeCharacter7Skill3_weakenCooltime" , 2);
            editor.putInt("writeCharacter7Skill3_cooltime" , 6);
            editor.putInt("writeCharacter7HP" , 3300);
            editor.putInt("writeCharacter7Attack" , 210);
            editor.putInt("writeCharacter7Rank" , 1);

             editor.putInt("writeCharacter8Skill1_rank" , 1);
            editor.putInt("writeCharacter8Skill1_attack" , 366);
            editor.putInt("writeCharacter8Skill1_weakenPercent" , 50);
            editor.putInt("writeCharacter8Skill2_rank" , 1);
            editor.putInt("writeCharacter8Skill2_heal" , 1);
            editor.putInt("writeCharacter8Skill3_rank" , 1);
            editor.putInt("writeCharacte8Skill3_attack" , 667);
            editor.putInt("writeCharacter8Skill3_weakenPercent" , 50);
            editor.putInt("writeCharacter8Skill3_weaken" , 25);
            editor.putInt("writeCharacter8Skill3_weakenTurn" , 2);
            editor.putInt("writeCharacte8Skill3_cooltime" , 7);
            editor.putInt("writeCharacter8HP" , 3500);
            editor.putInt("writeCharacter8Attack" , 250);
            editor.putInt("writeCharacter8Rank" , 1);

            editor.putInt("writeCharacter9Skill1_rank" , 1);
            editor.putInt("writeCharacter9Skilll_attack" , 466);
            editor.putInt("writeCharacter9Skill1_weakenPercent" , 50);
            editor.putInt("writeCharacter9Skill2_rank" , 1);
            editor.putInt("writeCharacter9Skill2_heal" , 50);
            editor.putInt("writeCharacter9Skill2_cooltime" , 10);
            editor.putInt("writeCharacter9Skill3_rank" , 1);
            editor.putInt("writeCharacter9Skill3_attack" , 534);
            editor.putInt("writeCharacter9Skill3_weakenPercent" , 50);
            editor.putInt("writeCharacter9Skill3_weaken" , 25);
            editor.putInt("writeCharacter9Skill3_weakenTurn" , 2);
            editor.putInt("wruteCharacter9Skill3_cooltime" , 5);
            editor.putInt("writeCharacter9HP" , 3600);
            editor.putInt("writeCharacter9Attack" , 270);
            editor.putInt("writeCharacter9Rank" , 1);

             editor.putInt("writeCharacter10Skill1_rank" , 1);
            editor.putInt("writeCharacter10Skill1_attack" , 400);
            editor.putInt("writeCharacter10Skill1_strengthenPercent" , 50);
            editor.putInt("writeCharacter10Skill1_strengthenTurn" , 1);
            editor.putInt("writeCharacter10Skill2_rank" , 1);
            editor.putInt("writeCharacter10Skill2_attack" , 769);
            editor.putInt("writeCharacter10Skill2_cooltime" , 3);
            editor.putInt("writeCharacter10Skill3_rank" , 1);
            editor.putInt("writeCharacter10Skill3_attack" , 120);
            editor.putInt("writeCharacter10Skill3_attackTurn" , 10);
            editor.putInt("writeCharacter10Skill3_weakenPercent" , 50);
            editor.putInt("writeCharacter10Skill3_weakenTurn" , 2);
            editor.putInt("writeCharacter10Skill3_cooltime" , 8);
            editor.putInt("writeCharacter10HP" , 3800);
            editor.putInt("writeCharacter10Attack" , 330);
            editor.putInt("writeCharacter10Rank" , 1);

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

            editor.putInt("writeRabbit1HP" , 100000);
            editor.putInt("writeRabbit1Attck" , 500);
            editor.putInt("writeRabbit2HP" , 200000);
            editor.putInt("writeRabbkt2Attack" , 600);
            editor.putInt("writeRabbit3HP" , 300000);
            editor.putInt("writeRabbit3Attack" , 850);
            editor.putInt("writeRabbit4HP" , 1000000);
            editor.putInt("writeRabbit4Attack" , 1000);
            editor.putInt("writeFirst" , 1);
            editor.commit();
        }

        int saveMoney = sharedPref.getInt("writeMoney" , 0);
        int saveRank =  sharedPref.getInt("writeRank" , 0);

        stringmoneymoney = Integer.toString(saveMoney);
        stringRank = Integer.toString(saveRank);
        money_money.setText(stringmoneymoney);
        rank_rank.setText(stringRank);
    }

    private void setCharacter(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        int character = sharedPref.getInt("writeMainCharacter" , 0);

        if(character == 1){
            homeCharacter.setImageResource(R.drawable.white_circle);
        }
        else if(character == 2){
            homeCharacter.setImageResource(R.drawable.black_circle);
        }
        else if(character == 3){
            homeCharacter.setImageResource(R.drawable.orange_circle);
        }
        else if(character == 4){
            homeCharacter.setImageResource(R.drawable.white_triangle);
        }
        else if(character == 5){
            homeCharacter.setImageResource(R.drawable.black_triangle);
        }
        else if(character == 6){
            homeCharacter.setImageResource(R.drawable.orange_triangle);
        }
        else if(character == 7){
            homeCharacter.setImageResource(R.drawable.white_carton);
        }
        else if(character == 8){
            homeCharacter.setImageResource(R.drawable.black_carton);
        }
        else if(character == 9){
            homeCharacter.setImageResource(R.drawable.orange_carton);
        }
        else if(character == 10){
            homeCharacter.setImageResource(R.drawable.white_strip);
        }
        else if(character == 11){
            homeCharacter.setImageResource(R.drawable.black_strip);
        }
        else if(character == 12){
            homeCharacter.setImageResource(R.drawable.orange_strip);
        }
    }
}