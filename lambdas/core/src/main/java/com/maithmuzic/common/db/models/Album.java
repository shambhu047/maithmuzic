package com.maithmuzic.common.db.models;

import java.util.List;

public class Album {
    private String id;

    private String name;

    private Language language;

    // alpha2Code of the country
    private String country;

    // list of songs' id
    private List<String> songs;

    private List<String> musicians;

    private List<String> singers;

    private List<String> lyricists;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public List<String> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<String> musicians) {
        this.musicians = musicians;
    }

    public List<String> getSingers() {
        return singers;
    }

    public void setSingers(List<String> singers) {
        this.singers = singers;
    }

    public List<String> getLyricists() {
        return lyricists;
    }

    public void setLyricists(List<String> lyricists) {
        this.lyricists = lyricists;
    }
}
