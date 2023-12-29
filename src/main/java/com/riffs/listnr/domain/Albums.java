package com.riffs.listnr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Albums {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, artist, artworkUrl;
    private int releaseYear;

    public Albums(){
    };
    
    public Albums(String name, String artist, String artworkUrl, int releaseYear) {
        this.name = name;
        this.artist = artist;
        this.artworkUrl = artworkUrl;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setArtworkUrl(String artworkUrl) {
        this.artworkUrl = artworkUrl;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

}
