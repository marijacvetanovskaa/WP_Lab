package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.repository.novo.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
        // prv pat kolku da se popolni bazata
//        albumRepository.saveAll(List.of(new Album("Abbey Road", "Rock", "1969"),
//                new Album("Thriller", "Pop", "1982"),
//                new Album("The Dark Side of the Moon", "Progressive Rock", "1973"),
//                new Album("Back in Black", "Hard Rock", "1980"),
//                new Album("Rumours", "Soft Rock", "1977")));
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }
}
