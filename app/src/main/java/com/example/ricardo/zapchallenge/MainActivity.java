package com.example.ricardo.zapchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

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
    private RecyclerView.Adapter recyclerAdapter;
    private ArrayList<Imovel> imoveis;

//    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = (ListView) findViewById(R.id.listViewImoveis);
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
//                ImageView imagemImovel = (ImageView) findViewById(R.id.imovel_imagem);
//                imagemImovel = imoveis.get(0).getUrlImagem();
//                for(int i = 0; i<imoveis.size(); i++) {
//                    setCardLayout(imoveis.get(i));
//                }
//                String[] imoveisNome = new String[imoveis.size()];
//
//                for(int i = 0; i<imoveis.size(); i++){
//                    imoveisNome[i] = imoveis.get(i).getTipoImovel();
//                }

//                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, imoveisNome));
            }

            @Override
            public void onFailure(Call<Imoveis> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setCardLayout(Imovel imovel) {
        imageView = (ImageView) findViewById(R.id.imovel_imagem);
//        Picasso.with(this)
//                .load(imovel.getUrlImagem())
//                .error(R.mipmap.ic_launcher)
//                .into(imageView, new com.squareup.picasso.Callback() {
//
//            @Override
//            public void onSuccess() {
//                Log.i("ricardo ", "teste OK");
//            }
//
//            @Override
//            public void onError() {
//                Log.i("ricardo ", "teste NOK");
//            }
//        });

        precoVendaView = (TextView) findViewById(R.id.imovel_preco);
        double precoVenda = imovel.getPrecoVenda();
        precoVendaView.setText(NumberFormat.getCurrencyInstance().format(precoVenda));

        imovelLocalView = (TextView) findViewById(R.id.imovel_local);
        String imovelLocal = imovel.getEndereco().getBairro();
        imovelLocal += ", ";
        imovelLocal += imovel.getEndereco().getCidade();
        imovelLocalView.setText(imovelLocal);

        imovelAreaView = (TextView) findViewById(R.id.imovel_area);
        String imovelArea = String.valueOf(imovel.getDormitorios());
        imovelArea += " dorms, ";
        imovelArea += imovel.getVagas();
        if(imovel.getVagas() > 1){
            imovelArea += " vagas, ";
        } else {
            imovelArea += " vaga, ";
        }
        imovelArea += String.format("%.1f", imovel.getAreaTotal());
        imovelArea += " m²";
        imovelAreaView.setText(imovelArea);
    }
}
