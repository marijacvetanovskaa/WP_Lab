package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;

public interface SongService  {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);
    public Song findById(Long id);
    void deleteById(Long id);
    Song addSong(String title, String trackId, String genre, int releaseYear, Long albumId);
    Song editSong(Long id, String title, String trackId, String genre, int releaseYear, Long albumId);
}
