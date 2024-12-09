package mk.finki.ukim.mk.lab.repository.old;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class AlbumRepository {

    List<Album> albumsList = List.of(new Album("Abbey Road", "Rock", "1969"),
            new Album("Thriller", "Pop", "1982"),
            new Album("The Dark Side of the Moon", "Progressive Rock", "1973"),
            new Album("Back in Black", "Hard Rock", "1980"),
            new Album("Rumours", "Soft Rock", "1977"));
    public List<Album> findAll()
    {
        return albumsList;
    }

    public Album getById(Long id) {
        return albumsList.stream().filter(album -> album.getId().equals(id)).findFirst().orElse(null);
    }
}
