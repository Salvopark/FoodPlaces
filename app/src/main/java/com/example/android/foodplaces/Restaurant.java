package com.example.android.foodplaces;



public final class Restaurant{

    private String name;
    private String price;
    private String attr;



    public Restaurant(String name, String cost, String attr) {
        this.name = name;
        this.price = cost;
        this.attr = attr;
    }



    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getAttr() {
        return attr;
    }


}


