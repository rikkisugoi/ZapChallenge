package com.example.ricardo.zapchallenge;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.text.NumberFormat;
import java.util.ArrayList;

import static android.R.attr.path;

/**
 * Created by Ricardo on 12/10/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private static ClickListener clickListener;
    private Context context;
    private ArrayList<DetalhesImovel> imoveis;
    private Bitmap bitmap;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView precoVendaView, imovelLocalView, imovelAreaView;
        private ImageView imageView;
        private CardView cardView;

        public ViewHolder(View v) {
            super(v);
            precoVendaView = (TextView) v.findViewById(R.id.imovel_preco);
            imovelLocalView = (TextView) v.findViewById(R.id.imovel_local);
            imovelAreaView = (TextView) v.findViewById(R.id.imovel_area);
            imageView = (ImageView) v.findViewById(R.id.imovel_imagem);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnClickListener(ClickListener clickListener) {
        CardAdapter.clickListener = clickListener;
    }

    public CardAdapter(Context context, ArrayList<DetalhesImovel> imoveis) {
        this.context = context;
        this.imoveis = imoveis;
    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.imovel_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DetalhesImovel imovel = imoveis.get(position);

        Glide.with(context)
                .load(imovel.getUrlImagem())
                .placeholder(R.drawable.zap_logo)
                .error(R.drawable.image_not_found)
                .centerCrop()
                .override(500, 300)
                .animate(android.R.anim.fade_in)
                .into(holder.imageView);

//        Glide.with(context)
//                .load(imovel.getUrlImagem())
//                .asBitmap()
//                .placeholder(R.drawable.zap_logo)
//                .error(R.drawable.image_not_found)
//                .centerCrop()
//                .override(150, 100)
//                .animate(android.R.anim.fade_in)
//                .into(new SimpleTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        bitmap = resource;
//                    }
//                });

//        Drawable drawable = new BitmapDrawable(Resources.getSystem(), bitmap);
//        holder.mView.setBackground(drawable);

        double precoVenda = imovel.getPrecoVenda();
        holder.precoVendaView.setText(NumberFormat.getCurrencyInstance().format(precoVenda));

        String imovelLocal = imovel.getEndereco().getBairro();
        imovelLocal += ", ";
        imovelLocal += imovel.getEndereco().getCidade();
        holder.imovelLocalView.setText(imovelLocal);

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
        holder.imovelLocalView.setText(imovelArea);



//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailsActivity.class);
//                intent.putExtra("codImovel", imovel.getCodImovel());
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return imoveis.size();
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
