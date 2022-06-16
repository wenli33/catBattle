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

public class character extends AppCompatActivity {
    private ImageButton character1;
    private ImageButton character2;
    private ImageButton character3;
    private ImageButton character4;
    private ImageButton character5;
    private ImageButton character6;
    private ImageButton character7;
    private ImageButton character8;
    private ImageButton character9;
    private ImageButton character10;
    private ImageButton character11;
    private ImageButton character12;
    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private String stringmoneymoney;
    private String stringRank;
    private TextView money_money;
    private TextView rank_rank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        getSupportActionBar().hide();

        character1 = (ImageButton) findViewById(R.id.character1);
        character2 = (ImageButton) findViewById(R.id.character2);
        character3 = (ImageButton) findViewById(R.id.character3);

        character4 = (ImageButton) findViewById(R.id.character4);
        character5 = (ImageButton) findViewById(R.id.character5);
        character6 = (ImageButton) findViewById(R.id.character6);

        character7 = (ImageButton) findViewById(R.id.character7);
        character8 = (ImageButton) findViewById(R.id.character8);
        character9 = (ImageButton) findViewById(R.id.character9);

        character10 = (ImageButton) findViewById(R.id.character10);
        character11 = (ImageButton) findViewById(R.id.character11);
        character12 = (ImageButton) findViewById(R.id.character12);

        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);
        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);

        character1.setOnClickListener(goTocharacter1_growth);
        character2.setOnClickListener(goTocharacter2_growth);
        character3.setOnClickListener(goTocharacter3_growth);

        character4.setOnClickListener(goTocharacter4_growth);
        character5.setOnClickListener(goTocharacter5_growth);
        character6.setOnClickListener(goTocharacter6_growth);

        character7.setOnClickListener(goTocharacter7_growth);
        character8.setOnClickListener(goTocharacter8_growth);
        character9.setOnClickListener(goTocharacter9_growth);

        character10.setOnClickListener(goTocharacter10_growth);
        character11.setOnClickListener(goTocharacter11_growth);
        character12.setOnClickListener(goTocharacter12_growth);
        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);
        onLoad();
    }

    private View.OnClickListener goTocharacter1_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character1_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter2_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character2_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter3_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character3_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter4_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character4_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter5_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character5_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter6_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character6_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter7_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character7_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter8_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character8_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter9_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character9_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter10_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character10_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter11_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character11_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goTocharacter12_growth = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character12_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(character.this , gacha.class);
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