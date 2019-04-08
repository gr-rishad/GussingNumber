package com.example.rishad.gussingnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    EditText guessEditText;
    public void makeToast(String string){
        Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();
    }
    public void guess(){

        guessEditText = (EditText) findViewById(R.id.editText);
        int guessInt = Integer.parseInt(guessEditText.getText().toString());

        if(guessInt > randomNumber){
            makeToast("Lower !!");
        }else if(guessInt < randomNumber){
            makeToast("Higher !!");
        }else {
            makeToast("That's Right !! Again Try.");

            Random random = new Random();
            randomNumber = random.nextInt(20)+1;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        randomNumber = random.nextInt(20)+1;

        Button checkButton = (Button) findViewById(R.id.buttonId);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess();
            }
        });

    }
}
