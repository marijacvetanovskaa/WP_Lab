package mk.finki.ukim.mk.lab.repository.old;

import mk.finki.ukim.mk.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public class ArtistRepository {
    List <Artist> artists = List.of(
            new Artist(1L, "Freddie", "Mercury", "The legendary lead vocalist of the rock band Queen, known for his powerful voice and flamboyant stage presence."),
            new Artist(2L, "Whitney", "Houston", "An American singer with a powerful voice, known for hit songs like 'I Will Always Love You' and 'Greatest Love of All.'"),
            new Artist(3L, "Elvis", "Presley", "The 'King of Rock and Roll,' known for his deep, smooth voice and hit songs like 'Jailhouse Rock' and 'Can't Help Falling in Love.'"),
            new Artist(4L, "Aretha", "Franklin", "The 'Queen of Soul,' famous for her powerful vocals and songs like 'Respect' and 'Natural Woman.'"),
            new Artist(5L, "Michael", "Jackson", "The 'King of Pop,' known for his unique dance moves, groundbreaking music videos, and hit songs like 'Thriller' and 'Billie Jean.'")
    );
    public List<Artist> findAll(){
        return artists;
    }

    public Optional<Artist> findById(Long id)
    {
        return artists.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }
}
