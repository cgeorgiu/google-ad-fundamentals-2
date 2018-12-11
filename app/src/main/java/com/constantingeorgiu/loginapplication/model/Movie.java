package com.constantingeorgiu.loginapplication.model;

import java.util.ArrayList;

public class Movie {
    private String name;
    private String shortDescription;
    private String genre;
    private String actors;
    private int year;
    private String imdbURL;
    private float rating;
    private String photoBase64;
    private ArrayList<RelatedMovie> relatedMovieArrayList;

    public Movie(String name, String shortDescription, String genre, String actors, int year, String imdbURL, float rating, String photoBase64, ArrayList<RelatedMovie> relatedMovieArrayList) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.genre = genre;
        this.actors = actors;
        this.year = year;
        this.imdbURL = imdbURL;
        this.rating = rating;
        this.photoBase64 = photoBase64;
        this.relatedMovieArrayList = relatedMovieArrayList;
    }

    public Movie(String name, String shortDescription, String genre, String actors, int year, String imdbURL, float rating, String photoBase64) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.genre = genre;
        this.actors = actors;
        this.year = year;
        this.imdbURL = imdbURL;
        this.rating = rating;
        this.photoBase64 = photoBase64;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImdbURL() {
        return imdbURL;
    }

    public void setImdbURL(String imdbURL) {
        this.imdbURL = imdbURL;
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

    public ArrayList<RelatedMovie> getRelatedMovieArrayList() {
        return relatedMovieArrayList;
    }

    public void setRelatedMovieArrayList(ArrayList<RelatedMovie> relatedMovieArrayList) {
        this.relatedMovieArrayList = relatedMovieArrayList;
    }
}
