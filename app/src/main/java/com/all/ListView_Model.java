package com.all;

public class ListView_Model {
    int image;
    String image_path;
    String name;

    public ListView_Model(int image2, String name2) {
        this.image = image2;
        this.name = name2;
    }

    public ListView_Model(int image2, String image_path2, String name2) {
        this.image = image2;
        this.name = name2;
        this.image_path = image_path2;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image2) {
        this.image = image2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getImage_path() {
        return this.image_path;
    }

    public void setImage_path(String image_path2) {
        this.image_path = image_path2;
    }
}
