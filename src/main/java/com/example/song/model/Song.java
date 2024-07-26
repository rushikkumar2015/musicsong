package com.example.song;

import com.example.song.model;
import java.util.*;

public class Song {
    private int songId;
    private String songName;
    private String lyricist;
    private String singer;
    private String musicDirector;

    public Song(int songId, String songName, String lyricist, String singer, String musicDirector) {
        this.songId = songId;
        this.songName = songName;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;
    }

    public int getsongId() {
        return songId;
    }

    public void setsongId(int songId) {
        this.songId = songId;
    }

    public String getsongName() {
        return sonName;
    }

    public void setsongName(String songName) {
        this.songName = songName;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger() {
        this.singer = singer;
    }

    public String getMusicDirector() {
        return musicdirector;
    }

    public void setMusicDirector() {
        this.musicdirector = musicdirector;
    }
}
