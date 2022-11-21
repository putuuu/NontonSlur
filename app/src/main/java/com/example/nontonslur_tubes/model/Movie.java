package com.example.nontonslur_tubes.model;

public class Movie {
    private String title;
    private String description;
    private int thumbnail;
    private String streamLink;
    private int coverPhoto;

    public Movie(String title, int thumbnail, int coverPhoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Movie(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Movie(String title, String description, int thumbnail, String streamLink, int coverPhoto) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.streamLink = streamLink;
        this.coverPhoto = coverPhoto;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }


    public String getStreamLink() {
        return streamLink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setStreamLink(String streamLink) {
        this.streamLink = streamLink;
    }
}
