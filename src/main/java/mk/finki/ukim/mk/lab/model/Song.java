package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Data
public class Song {

    private Long id;
    String trackId;
    String title;
    String genre;
    int releaseYear;
    List<Artist> performers;
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.id = (long) (Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public Song(Long id, String trackId, String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.id = id;
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }
}
