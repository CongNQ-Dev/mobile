package com.example.facebookapplication;

public class featureModel {

    String name;
    int image;

    String phoneNumber;

    public featureModel(String name, int image, String phoneNumber) {
        this.name = name;
        this.image = image;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
