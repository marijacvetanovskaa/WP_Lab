package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.novo.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.novo.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.novo.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Long artistId, Long songId) {
        Song song = songRepository.findById(songId).orElseThrow();
        Artist artist = artistRepository.findById(artistId).orElseThrow();
        song.getPerformers().add(artist);
        songRepository.save(song);
        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public Song addSong(String title, String trackId, String genre, int releaseYear, Long albumId) {
        Song song = new Song(trackId, title, genre, releaseYear, new ArrayList<>(), albumRepository.findById(albumId).orElseThrow());
        return songRepository.save(song);
    }

    @Override
    public Song editSong(Long id, String title, String trackId, String genre, int releaseYear, Long albumId) {
        Song song = songRepository.findById(id).orElseThrow();
        song.setAlbum(albumRepository.findById(id).orElseThrow());
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        return songRepository.save(song);
    }

    @Override
    public List<Song> getSongsByAlbumId(Long albumId) {
        return songRepository.findAllByAlbum_Id(albumId);
    }
}
