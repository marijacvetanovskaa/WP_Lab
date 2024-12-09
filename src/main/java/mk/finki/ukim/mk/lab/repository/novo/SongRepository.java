package mk.finki.ukim.mk.lab.repository.novo;


import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findAllByAlbum_Id(Long albumId);
    Song findByTrackId(String trackId);
}