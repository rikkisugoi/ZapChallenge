package com.example.ricardo.zapchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private int teste;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        teste = intent.getIntExtra("codImovel", 0);
        textView = (TextView) findViewById(R.id.testeTexto);
        textView.setText(String.valueOf(teste));
    }
}
