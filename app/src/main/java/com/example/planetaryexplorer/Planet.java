package com.example.planetaryexplorer;

import com.google.gson.annotations.SerializedName;

public class Planet {
    @SerializedName("ID")
    public String id;
    public String name;
    public int size;
    @SerializedName("cost")
    public int age;
    @SerializedName("auxdata")
    public String imageUrl;
}
