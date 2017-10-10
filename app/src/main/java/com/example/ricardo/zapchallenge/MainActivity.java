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
    private RecyclerView rv;
    private LinearLayoutManager llm;

//    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = (ListView) findViewById(R.id.listViewImoveis);
        rv = (RecyclerView)findViewById(R.id.rv);
        llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);


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
            public TextView imovelAreaView;

            @Override
            public void onResponse(Call<Imoveis> call, Response<Imoveis> response) {
                ArrayList<Imovel> imoveis = response.body().getImoveis();

//                ImageView imagemImovel = (ImageView) findViewById(R.id.imovel_imagem);
//                imagemImovel = imoveis.get(0).getUrlImagem();

                precoVendaView = (TextView) findViewById(R.id.imovel_preco);
                double precoVenda = imoveis.get(0).getPrecoVenda();
                precoVendaView.setText(NumberFormat.getCurrencyInstance().format(precoVenda));

                imovelLocalView = (TextView) findViewById(R.id.imovel_local);
                String imovelLocal = imoveis.get(0).getEndereco().getBairro();
                imovelLocal += ", ";
                imovelLocal += imoveis.get(0).getEndereco().getCidade();
                imovelLocalView.setText(imovelLocal);

                imovelAreaView = (TextView) findViewById(R.id.imovel_area);
                String imovelArea = String.valueOf(imoveis.get(0).getDormitorios());
                imovelArea += " dorms, ";
                imovelArea += imoveis.get(0).getVagas();
                if(imoveis.get(0).getVagas() > 1){
                    imovelArea += " vagas, ";
                } else {
                    imovelArea += " vaga, ";
                }
                imovelArea += String.format("%.1f", imoveis.get(0).getAreaTotal());
                imovelArea += " m²";
                imovelAreaView.setText(imovelArea);




                String[] imoveisNome = new String[imoveis.size()];

                for(int i = 0; i<imoveis.size(); i++){
                    imoveisNome[i] = imoveis.get(i).getTipoImovel();
                }

//                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, imoveisNome));
            }

            @Override
            public void onFailure(Call<Imoveis> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
