package com.example.ricardo.zapchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {

    private int teste;
    private TextView textView;
    private DetalhesImovel imovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        teste = intent.getIntExtra("codImovel", 0);

        getDetalhesImovel();
    }

    private void getDetalhesImovel() {
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiImoveis.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiImoveis apiImoveis = retrofit.create(ApiImoveis.class);

            Call<Imovel> call = apiImoveis.getImovel(teste);

            call.enqueue(new Callback<Imovel>() {

                @Override
                public void onResponse(Call<Imovel> call, Response<Imovel> response) {
                    imovel = response.body().getImovel();


                }

                @Override
                public void onFailure(Call<Imovel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
