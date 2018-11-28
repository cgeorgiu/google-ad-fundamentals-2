package com.constantingeorgiu.loginapplication.model;

class RelatedMovie {
    private String name;
    private float rating;
    private String photoBase64;

    public RelatedMovie(String name, float rating, String photoBase64) {
        this.name = name;
        this.rating = rating;
        this.photoBase64 = photoBase64;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }
}
