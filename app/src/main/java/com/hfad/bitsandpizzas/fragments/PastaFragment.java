package com.hfad.bitsandpizzas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.bitsandpizzas.activities.PastaDetailActivity;
import com.hfad.bitsandpizzas.activities.PizzaDetailActivity;
import com.hfad.bitsandpizzas.adapters.CaptionedImagesAdapter;
import com.hfad.bitsandpizzas.listener.Listener;
import com.hfad.bitsandpizzas.menu.Pasta;
import com.hfad.bitsandpizzas.R;


public class PastaFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pastaImages = new int[Pasta.pastas.length];
        for (int i = 0; i < pastaImages.length; i++) {
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        RecyclerView pastaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pasta, container, false);
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames, pastaImages);
        pastaRecycler.setAdapter(adapter);
        adapter.setListener(new Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
                intent.putExtra(PastaDetailActivity.EXTRA_PASTA_ID, position);
                getActivity().startActivity(intent);

            }
        });


        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pastaRecycler.setLayoutManager(layoutManager);

        return pastaRecycler;
    }
}