package com.example.catbattle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class battle_main extends AppCompatActivity {
    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private String stringmoneymoney;
    private String stringRank;
    private TextView money_money;
    private TextView rank_rank;
    private ImageButton easy;
    private ImageButton normal;
    private ImageButton hard;
    private ImageButton master;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_main);
        getSupportActionBar().hide();

        easy = (ImageButton)findViewById(R.id.easy);
        normal = (ImageButton)findViewById(R.id.normal);
        hard = (ImageButton)findViewById(R.id.hard);
        master = (ImageButton)findViewById(R.id.master);
        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);
        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);

        easy.setOnClickListener(gotoeasy);
        normal.setOnClickListener(gotonormal);
        hard.setOnClickListener(gotohard);
        master.setOnClickListener(gotomaster);
        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);
        onLoad();
    }

    private View.OnClickListener gotoeasy = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(battle_main.this , easy.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gotonormal = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(battle_main.this , normal.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gotohard = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(battle_main.this , hard.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gotomaster = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(battle_main.this , master.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(battle_main.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(battle_main.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(battle_main.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(battle_main.this , gacha.class);
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