package com.example.catbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class gacha10 extends AppCompatActivity {
    private int[] member = new int[10];
    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private Button define;
    private String stringmoneymoney;
    private String stringRank;
    private TextView money_money;
    private TextView rank_rank;
    private ImageButton gacha1;
    private ImageButton gacha2;
    private ImageButton gacha3;
    private ImageButton gacha4;
    private ImageButton gacha5;
    private ImageButton gacha6;
    private ImageButton gacha7;
    private ImageButton gacha8;
    private ImageButton gacha9;
    private ImageButton gacha10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha10);
        getSupportActionBar().hide();

        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);
        define = (Button)findViewById(R.id.define);
        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);

        gacha1 = (ImageButton)findViewById(R.id.gacha1);
        gacha2 = (ImageButton)findViewById(R.id.gacha2);
        gacha3 = (ImageButton)findViewById(R.id.gacha3);
        gacha4 = (ImageButton)findViewById(R.id.gacha4);
        gacha5 = (ImageButton)findViewById(R.id.gacha5);
        gacha6 = (ImageButton)findViewById(R.id.gacha6);
        gacha7 = (ImageButton)findViewById(R.id.gacha7);
        gacha8 = (ImageButton)findViewById(R.id.gacha8);
        gacha9 = (ImageButton)findViewById(R.id.gacha9);
        gacha10 = (ImageButton)findViewById(R.id.gacha10);

        gacha1.setOnClickListener(gotocharacter1);
        gacha2.setOnClickListener(gotocharacter2);
        gacha3.setOnClickListener(gotocharacter3);
        gacha4.setOnClickListener(gotocharacter4);
        gacha5.setOnClickListener(gotocharacter5);
        gacha6.setOnClickListener(gotocharacter6);
        gacha7.setOnClickListener(gotocharacter7);
        gacha8.setOnClickListener(gotocharacter8);
        gacha9.setOnClickListener(gotocharacter9);
        gacha10.setOnClickListener(gotocharacter10);
        define.setOnClickListener(goToGacha);
        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);
        onLoad();
        random();
        member();
    }

    private View.OnClickListener gotocharacter1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[0]);
        }
    };



    private View.OnClickListener gotocharacter2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[1]);
        }
    };
    private View.OnClickListener gotocharacter3 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[2]);
        }
    };
    private View.OnClickListener gotocharacter4 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[3]);
        }
    };
    private View.OnClickListener gotocharacter5 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[4]);
        }
    };
    private View.OnClickListener gotocharacter6 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[5]);
        }
    };
    private View.OnClickListener gotocharacter7 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[6]);
        }
    };
    private View.OnClickListener gotocharacter8 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[7]);
        }
    };
    private View.OnClickListener gotocharacter9 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[8]);
        }
    };
    private View.OnClickListener gotocharacter10 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            checkCharacter(gacha1 , member[9]);
        }
    };

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(gacha10.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(gacha10.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(gacha10.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(gacha10.this , gacha.class);
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
    private void random(){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            member[i] = random.nextInt(12) + 1;
        }
    }

    private void member(){
        setPicture(gacha1 , member[0]);
        setPicture(gacha2 , member[1]);
        setPicture(gacha3 , member[2]);
        setPicture(gacha4 , member[3]);
        setPicture(gacha5 , member[4]);
        setPicture(gacha6 , member[5]);
        setPicture(gacha7 , member[6]);
        setPicture(gacha8 , member[7]);
        setPicture(gacha9 , member[8]);
        setPicture(gacha10 , member[9]);
    }

    private void setPicture(ImageButton ib , int number){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        int rank;
        int attack;
        int hp;
        int money = sharedPref.getInt("writeMoney" , 0);
        switch(number){
            case 1:
                ib.setBackgroundResource(R.drawable.white_circle);
                rank = sharedPref.getInt("writeCharacter1Rank" , 0);
                attack = sharedPref.getInt("writeCharacter1Attack" , 0);
                hp = sharedPref.getInt("writeCharacter1HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.white_circle_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter1Rank" , rank);
                    editor.putInt("writeCharacter1Attack" , attack);
                    editor.putInt("writeCharacter1HP" , hp);
                    editor.commit();
                }
                break;
            case 2:
                ib.setBackgroundResource(R.drawable.black_circle);
                rank = sharedPref.getInt("writeCharacter2Rank" , 0);
                attack = sharedPref.getInt("writeCharacter2Attack" , 0);
                hp = sharedPref.getInt("writeCharacter2HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.black_circle_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter2Rank" , rank);
                    editor.putInt("writeCharacter2Attack" , attack);
                    editor.putInt("writeCharacter2HP" , hp);
                    editor.commit();
                }
                break;
            case 3:
                ib.setBackgroundResource(R.drawable.orange_circle);
                rank = sharedPref.getInt("writeCharacter3Rank" , 0);
                attack = sharedPref.getInt("writeCharacter3Attack" , 0);
                hp = sharedPref.getInt("writeCharacter3HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.orange_circle_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter3Rank" , rank);
                    editor.putInt("writeCharacter3Attack" , attack);
                    editor.putInt("writeCharacter3HP" , hp);
                    editor.commit();
                }
                break;
            case 4:
                ib.setBackgroundResource(R.drawable.white_triangle);
                rank = sharedPref.getInt("writeCharacter4Rank" , 0);
                attack = sharedPref.getInt("writeCharacter4Attack" , 0);
                hp = sharedPref.getInt("writeCharacter4HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.white_triangle_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter4Rank" , rank);
                    editor.putInt("writeCharacter4Attack" , attack);
                    editor.putInt("writeCharacter4HP" , hp);
                    editor.commit();
                }
                break;
            case 5:
                ib.setBackgroundResource(R.drawable.black_triangle);
                rank = sharedPref.getInt("writeCharacter5Rank" , 0);
                attack = sharedPref.getInt("writeCharacter5Attack" , 0);
                hp = sharedPref.getInt("writeCharacter5HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.black_triangle_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter5Rank" , rank);
                    editor.putInt("writeCharacter5Attack" , attack);
                    editor.putInt("writeCharacter5HP" , hp);
                    editor.commit();
                }
                break;
            case 6:
                ib.setBackgroundResource(R.drawable.orange_triangle);
                rank = sharedPref.getInt("writeCharacter6Rank" , 0);
                attack = sharedPref.getInt("writeCharacter6Attack" , 0);
                hp = sharedPref.getInt("writeCharacter6HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.orange_triangle_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter6Rank" , rank);
                    editor.putInt("writeCharacter6Attack" , attack);
                    editor.putInt("writeCharacter6HP" , hp);
                    editor.commit();
                }
                break;
            case 7:
                ib.setBackgroundResource(R.drawable.white_carton);
                rank = sharedPref.getInt("writeCharacter7Rank" , 0);
                attack = sharedPref.getInt("writeCharacter7Attack" , 0);
                hp = sharedPref.getInt("writeCharacter7HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.white_carton_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter7Rank" , rank);
                    editor.putInt("writeCharacter7Attack" , attack);
                    editor.putInt("writeCharacter7HP" , hp);
                    editor.commit();
                }
                break;
            case 8:
                ib.setBackgroundResource(R.drawable.black_carton);
                rank = sharedPref.getInt("writeCharacter8Rank" , 0);
                attack = sharedPref.getInt("writeCharacter8Attack" , 0);
                hp = sharedPref.getInt("writeCharacter8HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.black_carton_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter8Rank" , rank);
                    editor.putInt("writeCharacter8Attack" , attack);
                    editor.putInt("writeCharacter8HP" , hp);
                    editor.commit();
                }
                break;
            case 9:
                ib.setBackgroundResource(R.drawable.orange_carton);
                rank = sharedPref.getInt("writeCharacter9Rank" , 0);
                attack = sharedPref.getInt("writeCharacter9Attack" , 0);
                hp = sharedPref.getInt("writeCharacter9HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.orange_carton_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter9Rank" , rank);
                    editor.putInt("writeCharacter9Attack" , attack);
                    editor.putInt("writeCharacter9HP" , hp);
                    editor.commit();
                }
                break;
            case 10:
                ib.setBackgroundResource(R.drawable.white_strip);
                rank = sharedPref.getInt("writeCharacter10Rank" , 0);
                attack = sharedPref.getInt("writeCharacter10Attack" , 0);
                hp = sharedPref.getInt("writeCharacter10HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.white_strip_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter10Rank" , rank);
                    editor.putInt("writeCharacter10Attack" , attack);
                    editor.putInt("writeCharacter10HP" , hp);
                    editor.commit();
                }
                break;
            case 11:
                ib.setBackgroundResource(R.drawable.black_strip);
                rank = sharedPref.getInt("writeCharacter11Rank" , 0);
                attack = sharedPref.getInt("writeCharacter11Attack" , 0);
                hp = sharedPref.getInt("writeCharacter11HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.black_strip_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter11Rank" , rank);
                    editor.putInt("writeCharacter11Attack" , attack);
                    editor.putInt("writeCharacter11HP" , hp);
                    editor.commit();
                }
                break;
            case 12:
                ib.setBackgroundResource(R.drawable.orange_strip);
                rank = sharedPref.getInt("writeCharacter12Rank" , 0);
                attack = sharedPref.getInt("writeCharacter12Attack" , 0);
                hp = sharedPref.getInt("writeCharacter12HP" , 0);
                if(rank == 99){
                    ib.setBackgroundResource(R.drawable.orange_strip_1000);
                    money = money + 1000;
                    editor.putInt("writeMoney" , money);
                    editor.commit();
                    stringmoneymoney = Integer.toString(money);
                    money_money.setText(stringmoneymoney);
                }
                else{
                    rank = rank + 1;
                    attack = attack + 100;
                    hp = hp + 1000;
                    editor.putInt("writeCharacter12Rank" , rank);
                    editor.putInt("writeCharacter12Attack" , attack);
                    editor.putInt("writeCharacter12HP" , hp);
                    editor.commit();
                }
                break;
        }
    }

    private void checkCharacter(ImageButton ib , int number){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Intent intent = new Intent();
        int rank;
        int attack;
        int hp;
        switch(number){
            case 1:
                intent.setClass(gacha10.this , character1_growth.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(gacha10.this , character2_growth.class);
                startActivity(intent);
                break;
            case 3:
                intent.setClass(gacha10.this , character3_growth.class);
                startActivity(intent);
                break;
            case 4:
                intent.setClass(gacha10.this , character4_growth.class);
                startActivity(intent);
                break;
            case 5:
                intent.setClass(gacha10.this , character5_growth.class);
                startActivity(intent);
                break;
            case 6:
                intent.setClass(gacha10.this , character6_growth.class);
                startActivity(intent);
                break;
            case 7:
                intent.setClass(gacha10.this , character7_growth.class);
                startActivity(intent);
                break;
            case 8:
                intent.setClass(gacha10.this , character8_growth.class);
                startActivity(intent);
                break;
            case 9:
                intent.setClass(gacha10.this , character9_growth.class);
                startActivity(intent);
                break;
            case 10:
                intent.setClass(gacha10.this , character10_growth.class);
                startActivity(intent);
                break;
            case 11:
                intent.setClass(gacha10.this , character11_growth.class);
                startActivity(intent);
                break;
            case 12:
                intent.setClass(gacha10.this , character12_growth.class);
                startActivity(intent);
                break;
        }
    }
}