package mk.finki.ukim.mk.lab.repository;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    List<Song> songList = new ArrayList<>(List.of (
            new Song("001", "Bohemian Rhapsody", "Rock", 1975, new ArrayList<>(), new Album("A Night at the Opera", "Rock", "1975")),
            new Song("002", "Thriller", "Pop", 1982, new ArrayList<>(), new Album("Thriller", "Pop", "1982")),
            new Song("003", "Rolling in the Deep", "Soul", 2010, new ArrayList<>(), new Album("21", "Soul", "2011")),
            new Song("004", "Purple Rain", "Rock", 1984, new ArrayList<>(), new Album("Purple Rain", "Rock", "1984")),
            new Song("005", "Shape of You", "Pop", 2017, new ArrayList<>(),  new Album("Divide", "Pop", "2017"))));
    public List<Song> findAll()
    {
        return songList;
    }
    public Song findByTrackId(String trackId)
    {
        return songList.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song)
    {
        findByTrackId(song.getTrackId()).getPerformers().add(artist);
        return artist;
    }

    public Song findById(Long id) {
        return songList.stream()
                .filter(song -> song.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteById(Long id) {
        songList.removeIf(song -> song.getId().equals(id));
    }

    public Song addSong(String title, String trackId, String genre, int releaseYear, Album album) {
        Song song = new Song(trackId, title, genre, releaseYear, new ArrayList<>(), album);
        songList.add(song);
        return song;
    }

    public Song editSong(Long id, String title, String trackId, String genre, int releaseYear, Album album) {
        songList.removeIf(song -> song.getId().equals(id));
        Song song = new Song(id, trackId, title, genre, releaseYear, new ArrayList<>(), album);
        songList.add(song);
        return song;
    }
}
