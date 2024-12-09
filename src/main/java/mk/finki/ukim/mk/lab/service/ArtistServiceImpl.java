package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.repository.novo.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {


    private final ArtistRepository artistRepository;
//using dependency injection by constructor!!!!
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
        // samo prv pat kolku da se popolni tabelata
//        artistRepository.saveAll(List.of(
//                new Artist(1L, "Freddie", "Mercury", "The legendary lead vocalist of the rock band Queen, known for his powerful voice and flamboyant stage presence."),
//                new Artist(2L, "Whitney", "Houston", "An American singer with a powerful voice, known for hit songs like 'I Will Always Love You' and 'Greatest Love of All.'"),
//                new Artist(3L, "Elvis", "Presley", "The 'King of Rock and Roll,' known for his deep, smooth voice and hit songs like 'Jailhouse Rock' and 'Can't Help Falling in Love.'"),
//                new Artist(4L, "Aretha", "Franklin", "The 'Queen of Soul,' famous for her powerful vocals and songs like 'Respect' and 'Natural Woman.'"),
//                new Artist(5L, "Michael", "Jackson", "The 'King of Pop,' known for his unique dance moves, groundbreaking music videos, and hit songs like 'Thriller' and 'Billie Jean.'")
//        ));
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).get();
    }

}
