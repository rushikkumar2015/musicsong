
package com.example.song;

import com.example.song.service;
import java.util.*;
import com.example.song.model.Song;
import com.example.song.repository.songRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;import org.springframework.web.server.Respons
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;

@Service
public class SongH2Service implements SongRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    ArrayList<Song> getAllSongs() {
        return (ArrayList<Song>) db.query("select * from playlist", new songRowMapper());
    }

    Song getSongById(int songId) {
        try {
            return db.queryForObject("select * from playlist where songId=?", new songRowMapper(), songId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    Song addSong(Song song) {
        db.update("insert into playlist(songName,lirycist,singer,musicdirector) vlaues(?,?,?,?)", song.getsongName(),
                song.getLirycist(), song.getSinger(), song.getMusicDirector());
        return db.queryForObject("select * from PlayList where songName=?,lyricist=?", new songRowMapper(),
                song.getsongName(),
                song.getLyricist());
    }

    void deleteSong(int songId) {
        db.update("delete from playlist where songId=?", songId);
    }

    Song updateSong(int songId, Song song) {
        if (song.getsongName() != null) {
            db.update("update playlist set songName=? where songId=?", song.getsongName(), songId);
        }
        if (song.getLyricist() != null) {
            db.update("update playlist set lyricist=? where songId=?", song.getLyricist(), songId);
        }
        if (song.getSinger() != null) {
            db.update("update set singer=? where songId=?", song.getSinger(), songId);
        }
        if (song.getMusicDirector() != null) {
            db.update("update playlist set musicdirecter=? where songId=?", song.getMusicDirector(), songId);
        }
        return getSongById(songId);

    }
}
