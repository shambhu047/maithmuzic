package com.maithmuzic.common.db.models;

import java.util.List;

public class Song {
    private String id;

    private String title;

    private String albumId;

    // list of singers' id
    private List<String> singers;

    private List<String> musicians;

    private String lyricist;

    private List<String> geners;

    private List<String> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public List<String> getSingers() {
        return singers;
    }

    public void setSingers(List<String> singers) {
        this.singers = singers;
    }

    public List<String> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<String> musicians) {
        this.musicians = musicians;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public List<String> getGeners() {
        return geners;
    }

    public void setGeners(List<String> geners) {
        this.geners = geners;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", albumId='" + albumId + '\'' +
                ", singers=" + singers +
                ", musicians=" + musicians +
                ", lyricist='" + lyricist + '\'' +
                ", geners=" + geners +
                ", tags=" + tags +
                '}';
    }
}
