package com.example.ricardo.zapchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView tipoImovelView;
    private TextView precoVendaView;
    private TextView imovelLocalView;
    private TextView imovelAreaView;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CardAdapter recyclerAdapter;
    private ArrayList<Imovel> imoveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getImoveis();
    }

    private void getImoveis(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiImoveis.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiImoveis apiImoveis = retrofit.create(ApiImoveis.class);

        Call<Imoveis> call = apiImoveis.getImoveis();

        call.enqueue(new Callback<Imoveis>() {

            @Override
            public void onResponse(Call<Imoveis> call, Response<Imoveis> response) {
                imoveis = response.body().getImoveis();

                recyclerAdapter = new CardAdapter(getApplicationContext(), imoveis);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.setOnClickListener(new CardAdapter.ClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                        intent.putExtra("codImovel", imoveis.get(position).getCodImovel());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Imoveis> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
