package com.hfad.bitsandpizzas.menu;

import com.hfad.bitsandpizzas.R;

public class Pizza {
    private String name;
    private int imageResourceId;
    public static final Pizza[] pizzas = {
            new Pizza("Diazvolo", R.drawable.diavolo),
            new Pizza("Funghi", R.drawable.funghi)
    };

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public Pizza(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
}
