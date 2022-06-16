package com.example.catbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gacha extends AppCompatActivity {

    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private Button scout1;
    private Button scout10;
    private String stringmoneymoney;
    private String stringRank;
    private TextView money_money;
    private TextView rank_rank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha);
        getSupportActionBar().hide();

        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);

        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);
        scout1 = (Button)findViewById(R.id.scout1);
        scout10 = (Button)findViewById(R.id.scout10);
        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);

        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);
        scout1.setOnClickListener(gotoScout1);
        scout10.setOnClickListener(gotoScout10);

        int money = sharedPref.getInt("writeMoney" , 0);

        if(money < 10000){
            scout10.setEnabled(false);
        }

        if(money < 1000){
            scout1.setEnabled(false);
        }

        onLoad();
    }

    private View.OnClickListener gotoScout1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int money = sharedPref.getInt("writeMoney" , 0);
            money = money - 1000;
            //editor.putInt("writeRank" , 1);
            editor.putInt("writeMoney" , money);
            editor.commit();

            Intent intent = new Intent();
            intent.setClass(gacha.this , gacha1.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gotoScout10 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            int money = sharedPref.getInt("writeMoney" , 0);
            money = money - 10000;
            //editor.putInt("writeRank" , 1);
            editor.putInt("writeMoney" , money);
            editor.commit();

            Intent intent = new Intent();
            intent.setClass(gacha.this , gacha10.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(gacha.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(gacha.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(gacha.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(gacha.this , gacha.class);
            startActivity(intent);
        }
    };

    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putInt("writeRank" , 1);
        //editor.putInt("writeMoney" , 1000);
        //editor.commit();

        int saveMoney = sharedPref.getInt("writeMoney" , 0);
        int saveRank =  sharedPref.getInt("writeRank" , 0);
        stringmoneymoney = Integer.toString(saveMoney);
        stringRank = Integer.toString(saveRank);
        money_money.setText(stringmoneymoney);
        rank_rank.setText(stringRank);
    }
}