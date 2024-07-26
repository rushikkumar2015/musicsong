
package com.example.song;

import com.example.song.model.Song;
import com.example.song.service.SongH2Service;

import org.springframework.web.bind.annotation.*;
import java.util.*;

public class songController {
    @Autowired
    private SongH2Service songservice;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return songservice.getAllSongs();
    }

    @GetMapping("/songs/{songId}")

    public Song getSongById(@PathVariable("songId") int songId) {
        return songservice.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return songservice.addSong(song);
    }

    @PutMapping("/songs/songId")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song) {
        return songservice.updateSong(song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId) {
        songservice.deleteSong(songId);
    }
}
