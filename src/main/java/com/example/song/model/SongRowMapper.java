
package com.example.song;

import com.example.song.model.Song;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SongRowMapper implements RowMapper<Song> {
  public Song mapRow(ResultSet rs,int rownum) throws SQL Exception{
    return new Song(
      rs.getInt("songId"),
      rs.getString("songName"),
      rs.getString("lyricist"),
      rs.getString("singer"),
      rs.getString("musicdirector")
    )
  }

}
