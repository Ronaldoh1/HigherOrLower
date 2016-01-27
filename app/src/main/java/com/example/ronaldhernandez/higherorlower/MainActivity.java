package com.example.ronaldhernandez.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mInputText;
    Button mGuessButton;
    int randomNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputText = (EditText)findViewById(R.id.inputText);

        final Random random = new Random();
        try {
            randomNumber = random.nextInt(21);

        } catch (Exception e) {
            e.printStackTrace();
        }

        mGuessButton = (Button)findViewById(R.id.guessButton);
        mGuessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(randomNumber);
                int number = Integer.valueOf(mInputText.getText().toString());
                if (number == randomNumber){

                    Toast.makeText(getApplicationContext(),"Correct! the number is "+ randomNumber, Toast.LENGTH_LONG).show();
                    randomNumber = random.nextInt(21);

                } else if (number >= randomNumber) {

                    Toast.makeText(getApplicationContext(), "The number is less than what you entered", Toast.LENGTH_LONG).show();

                } else if (number <= randomNumber) {

                    Toast.makeText(getApplicationContext(), "The number is greater than what you entered", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
