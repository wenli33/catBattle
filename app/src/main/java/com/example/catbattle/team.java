package com.example.catbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class team extends AppCompatActivity {

    private Button home;
    private Button character;
    private Button team;
    private Button gacha;
    private String stringmoneymoney;
    private String stringRank;
    private String stringpower1;
    private String stringpower2;
    private String stringpower3;
    private String stringpower4;
    private TextView money_money;
    private TextView rank_rank;
    private TextView power_power_1;
    private TextView power_power_2;
    private TextView power_power_3;
    private TextView power_power_4;
    private ImageButton team1Leader;
    private ImageButton team1member1;
    private ImageButton team1member2;
    private ImageButton team2Leader;
    private ImageButton team2member1;
    private ImageButton team2member2;
    private ImageButton team3Leader;
    private ImageButton team3member1;
    private ImageButton team3member2;
    private ImageButton team4Leader;
    private ImageButton team4member1;
    private ImageButton team4member2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        getSupportActionBar().hide();

        home = (Button)findViewById(R.id.home);
        character = (Button)findViewById(R.id.character);
        team = (Button)findViewById(R.id.team);
        gacha = (Button)findViewById(R.id.gacha);
        money_money = (TextView)findViewById(R.id.money_money);
        rank_rank = (TextView)findViewById(R.id.rank_rank);
        power_power_1 = (TextView)findViewById(R.id.power_power_1);
        power_power_2 = (TextView)findViewById(R.id.power_power_2);
        power_power_3 = (TextView)findViewById(R.id.power_power_3);
        power_power_4 = (TextView)findViewById(R.id.power_power_4);
        team1Leader = (ImageButton)findViewById(R.id.team1Leader);
        team2Leader = (ImageButton)findViewById(R.id.team2Leader);
        team3Leader = (ImageButton)findViewById(R.id.team3Leader);
        team4Leader = (ImageButton)findViewById(R.id.team4Leader);
        team1member1 = (ImageButton)findViewById(R.id.team1member1);
        team1member2 = (ImageButton)findViewById(R.id.team1member2);
        team2member1 = (ImageButton)findViewById(R.id.team2member1);
        team2member2 = (ImageButton)findViewById(R.id.team2member2);
        team3member1 = (ImageButton)findViewById(R.id.team3member1);
        team3member2 = (ImageButton)findViewById(R.id.team3member2);
        team4member1 = (ImageButton)findViewById(R.id.team4member1);
        team4member2 = (ImageButton)findViewById(R.id.team4member2);

        team1Leader.setOnClickListener(gototeam1Leader);
        team1member1.setOnClickListener(gototeam1member1);
        team1member2.setOnClickListener(gototeam1member2);
        team2Leader.setOnClickListener(gototeam2Leader);
        team2member1.setOnClickListener(gototeam2member1);
        team2member2.setOnClickListener(gototeam2member2);
        team3Leader.setOnClickListener(gototeam3Leader);
        team3member1.setOnClickListener(gototeam3member1);
        team3member2.setOnClickListener(gototeam3member2);
        team4Leader.setOnClickListener(gototeam4Leader);
        team4member1.setOnClickListener(gototeam4member1);
        team4member2.setOnClickListener(gototeam4member2);
        home.setOnClickListener(goToHome);
        character.setOnClickListener(goToCharacter);
        team.setOnClickListener(goToTeam);
        gacha.setOnClickListener(goToGacha);
        onLoad();
    }

    private View.OnClickListener goToHome = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , MainActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToCharacter = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToTeam = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , team.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener goToGacha = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , gacha.class);
            startActivity(intent);
        }
    };


    private View.OnClickListener gototeam1Leader = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character2_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam1member1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character8_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam1member2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character9_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam2Leader = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character3_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam2member1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character5_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam2member2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character11_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam3Leader = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character1_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam3member1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character7_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam3member2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character12_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam4Leader = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character4_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam4member1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character6_growth.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener gototeam4member2 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(team.this , character10_growth.class);
            startActivity(intent);
        }
    };

    private void onLoad(){
        SharedPreferences sharedPref = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        //editor.commit();

        int team1Power =
                        sharedPref.getInt("writeCharacter2HP" , 0) +
                        sharedPref.getInt("writeCharacter2Attack" , 0) +
                        sharedPref.getInt("writeCharacter8HP" , 0) +
                        sharedPref.getInt("writeCharacter8Attack" , 0) +
                        sharedPref.getInt("writeCharacter9HP" , 0) +
                        sharedPref.getInt("writeCharacter9Attack" , 0);

        int team2Power =
                        sharedPref.getInt("writeCharacter3HP" , 0) +
                        sharedPref.getInt("writeCharacter3Attack" , 0) +
                        sharedPref.getInt("writeCharacter5HP" , 0) +
                        sharedPref.getInt("writeCharacter5Attack" , 0) +
                        sharedPref.getInt("writeCharacter11HP" , 0)  +
                        sharedPref.getInt("writeCharacter11Attack" , 0);

        int team3Power =
                        sharedPref.getInt("writeCharacter1HP" , 0) +
                        sharedPref.getInt("writeCharacter1Attack" , 0) +
                        sharedPref.getInt("writeCharacter7HP" , 0) +
                        sharedPref.getInt("writeCharacter7Attack" , 0) +
                        sharedPref.getInt("writeCharacter12HP" , 0) +
                        sharedPref.getInt("writeCharacter12Attack" , 0);

        int team4Power =
                        sharedPref.getInt("writeCharacter4HP" , 0) +
                        sharedPref.getInt("writeCharacter4Attack" , 0) +
                        sharedPref.getInt("writeCharacter6HP" , 0) +
                        sharedPref.getInt("writeCharacter6Attack" , 0) +
                        sharedPref.getInt("writeCharacter10HP" , 0) +
                        sharedPref.getInt("writeCharacter10Attack" , 0);

        int saveMoney = sharedPref.getInt("writeMoney" , 0);
        int saveRank =  sharedPref.getInt("writeRank" , 0);

        stringmoneymoney = Integer.toString(saveMoney);
        stringRank = Integer.toString(saveRank);
        stringpower1 = Integer.toString(team1Power);
        stringpower2 = Integer.toString(team2Power);
        stringpower3 = Integer.toString(team3Power);
        stringpower4 = Integer.toString(team4Power);

        money_money.setText(stringmoneymoney);
        rank_rank.setText(stringRank);
        power_power_1.setText(stringpower1);
        power_power_2.setText(stringpower2);
        power_power_3.setText(stringpower3);
        power_power_4.setText(stringpower4);
    }
}